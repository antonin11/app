package com.g4.app.controllers;

import com.g4.app.models.Deadlines;

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
        Date milestone = new Date();
        milestone.getTime();
        Deadlines newdeadlines = Deadlines.addDeadline("Gauthier", milestone, "blablabla description", 1);
        req.setAttribute("newdeadlines", newdeadlines);

        List<Deadlines> deadlinesList = Deadlines.findAll();
        req.setAttribute("deadlinesList", deadlinesList);
        this.getServletContext().getRequestDispatcher("/deadlines.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Date milestone = new Date(2015-07-06);
        Deadlines newdeadlines = Deadlines.addDeadline("Gauthier", milestone, "blablabla description", 1);
        req.setAttribute("newdeadlines", newdeadlines);
        System.out.println(newdeadlines);
    }
}
