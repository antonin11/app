package com.g4.app.controllers;

import com.g4.app.models.Deadlines;
import com.g4.app.models.FicheEleve;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by HWoog on 17/06/2016.
 */

@WebServlet("/fiche_eleve")
public class FicheEleveController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id_eleve = 2;
        List<FicheEleve> eleves = FicheEleve.findById(id_eleve);
        FicheEleve eleve = eleves.get(0);
        req.setAttribute("eleve", eleve);
        //System.out.println(eleve.id);
        this.getServletContext().getRequestDispatcher("/ficheeleve.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id_eleve = req.getParameter("id_eleve");
        int id = Integer.parseInt(id_eleve);
        List<FicheEleve> eleves = FicheEleve.findById(id);
        FicheEleve eleve = eleves.get(0);
        req.setAttribute("eleve", eleve);

        List<Deadlines> deadlinesList = Deadlines.findAll();
        req.setAttribute("deadlinesList", deadlinesList);

        this.getServletContext().getRequestDispatcher("/ficheeleve.jsp").forward(req, resp);
    }
}
