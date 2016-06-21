package com.g4.app.controllers;

import com.g4.app.models.Deadlines;
import jdk.nashorn.internal.objects.NativeDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by antoninpedotti on 25/05/2016.
 */
@WebServlet("/deadlines")
public class DeadlineController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Deadlines> deadlinesList = Deadlines.findAll();
        req.setAttribute("deadlinesList", deadlinesList);
        for (int i = 0; i<deadlinesList.size(); i++){
            System.out.println(deadlinesList.get(i));
        }
        this.getServletContext().getRequestDispatcher("/deadlines.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        java.util.Date date = new java.util.Date();
        java.sql.Date milestone = new java.sql.Date(date.getTime());

        String nom = req.getParameter("nom");
        String description = req.getParameter("description");

        Deadlines newdeadlines = Deadlines.addDeadline(nom, milestone, description, 1);
        List<Deadlines> deadlinesList = Deadlines.findAll();

        req.setAttribute("deadlinesList", deadlinesList);
        req.setAttribute("newdeadlines", newdeadlines);
        this.getServletContext().getRequestDispatcher("/deadlines.jsp").forward(req, resp);
    }
}
