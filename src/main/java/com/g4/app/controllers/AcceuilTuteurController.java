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

@WebServlet("/acceuil_tuteur")
public class AcceuilTuteurController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<FicheEleve> ficheEleveList = FicheEleve.findAll();
        req.setAttribute("ficheEleveList", ficheEleveList);

        for (int i = 0; i<ficheEleveList.size(); i++){
            System.out.println(ficheEleveList.get(i).getPrenom());
        }

        this.getServletContext().getRequestDispatcher("/acceuiltuteur.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //String id_eleve = req.getParameter("id_eleve");
        //this.getServletContext().getRequestDispatcher("/fiche_eleve").forward(req, resp);
    }
}