
package com.mediagurd.controller;

import com.mediagurd.model.User;
import com.mediagurd.service.UserService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {

        req.getRequestDispatcher("/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp)
            throws ServletException, IOException {

        String fullName = req.getParameter("fullName");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String phone = req.getParameter("phone");

        User user = new User(
                fullName, email, password, phone, "CITIZEN"
        );

        UserService userService = new UserService();

        try {
            String result = userService.registerUser(user);

            resp.setContentType("text/plain;charset=UTF-8");
            resp.getWriter().println(result);

        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}
