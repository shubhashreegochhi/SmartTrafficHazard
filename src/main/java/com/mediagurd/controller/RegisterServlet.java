
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

    private UserService userService = new UserService();

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String fullName = request.getParameter("fullName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");

        User user = new User(
                fullName,
                email,
                password,
                phone,
                "CITIZEN"
        );

        try {
            String result = userService.registerUser(user);

            if (result.equals("Registration successful")) {
                response.sendRedirect(
                        request.getContextPath() + "/login.jsp?registered=true"
                );
            } else {
                request.setAttribute("error", result);
                request.getRequestDispatcher("/register.jsp")
                        .forward(request, response);
            }

        } catch (SQLException e) {
            throw new ServletException("Registration failed", e);
        }
    }
}
