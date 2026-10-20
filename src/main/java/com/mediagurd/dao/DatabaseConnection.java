
package com.mediagurd.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL = System.getenv()
            .getOrDefault(
                    "DB_URL",
                    "jdbc:mysql://localhost:3306/smart_traffic_db"
            );

    private static final String USER = System.getenv()
            .getOrDefault("DB_USER", "root");

    private DatabaseConnection() {
        // Prevent unnecessary object creation.
    }

    public static Connection getConnection() throws SQLException {

        String password = System.getenv("DB_PASSWORD");

        if (password == null || password.isBlank()) {
            throw new SQLException(
                    "DB_PASSWORD environment variable is not configured."
            );
        }

        return DriverManager.getConnection(URL, USER, password);
    }
}
