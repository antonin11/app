package com.g4.app.controllers;

import com.g4.app.models.FicheEleve;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/remarque_eleve")
public class RemarqueController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/remarque_eleve.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id_eleve = req.getParameter("id_eleve");
        int id = Integer.parseInt(id_eleve);
        List<FicheEleve> eleves = FicheEleve.findById(id);
        FicheEleve eleve = eleves.get(0);
        req.setAttribute("eleve", eleve);
        this.getServletContext().getRequestDispatcher("/remarque_eleve.jsp").forward(req, resp);
    }
}