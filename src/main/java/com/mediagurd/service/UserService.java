
package com.mediagurd.service;

import com.mediagurd.dao.UserDao;
import com.mediagurd.model.User;

import java.sql.SQLException;

public class UserService {

    private UserDao userDao = new UserDao();

    public String registerUser(User user) throws SQLException {

        if (user.getFullName() == null ||
                user.getFullName().trim().isEmpty()) {
            return "Name is required";
        }

        if (user.getEmail() == null ||
                user.getEmail().trim().isEmpty()) {
            return "Email is required";
        }

        if (user.getPasswordHash() == null ||
                user.getPasswordHash().length() < 8) {
            return "Password must be at least 8 characters";
        }

        if (userDao.getUserByEmail(user.getEmail()) != null) {
            return "Email already registered";
        }

        user.setRole("CITIZEN");

        boolean saved = userDao.registerUser(user);

        if (saved) {
            return "Registration successful";
        }

        return "Registration failed";
    }
}
