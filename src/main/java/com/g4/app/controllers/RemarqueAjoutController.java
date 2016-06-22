package com.g4.app.controllers;

import com.g4.app.models.FicheEleve;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ajout_remarque")
public class RemarqueAjoutController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/fiche_eleve.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id_eleve = req.getParameter("id_eleve");
        String remarque = req.getParameter("remarque");
        int id = Integer.parseInt(id_eleve);

        FicheEleve newremarque = FicheEleve.addRemarque(id,remarque);

        List<FicheEleve> eleves = FicheEleve.findById(id);
        FicheEleve eleve = eleves.get(0);


        req.setAttribute("eleve", eleve);
        req.setAttribute("newremarque", newremarque);
        this.getServletContext().getRequestDispatcher("/ficheeleve.jsp").forward(req, resp);
    }
}