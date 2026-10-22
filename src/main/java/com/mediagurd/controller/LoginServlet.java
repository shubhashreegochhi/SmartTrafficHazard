
package com.mediagurd.controller;

import com.mediagurd.dao.UserDao;
import com.mediagurd.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        UserDao userDao = new UserDao();

        try {
            User user = userDao.getUserByEmail(email);

            if (user != null &&
                    user.getPasswordHash().equals(password)) {

                response.getWriter().println("Login Successful!");

            } else {
                response.getWriter().println("Login Failed!");
            }

        } catch (SQLException e) {
            throw new ServletException("Login failed", e);
        }
    }
}
