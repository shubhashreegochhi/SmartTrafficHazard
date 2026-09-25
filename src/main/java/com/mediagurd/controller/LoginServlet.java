package com.mediagurd.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/hello")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Smart Traffic</title>");
        out.println("</head>");

        out.println("<body>");
        out.println("<h1>Hello from Java Servlet!</h1>");
        out.println("<p>Smart Traffic & Road Hazard Reporter is working.</p>");
        out.println("</body>");

        out.println("</html>");
    }
}