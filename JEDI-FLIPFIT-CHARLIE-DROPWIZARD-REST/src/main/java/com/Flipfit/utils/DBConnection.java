package com.Flipfit.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private static Connection connection = null;

    public static Connection getConnection() {
        if (connection != null) return connection;
        try {
            // Replace with your local MySQL credentials
            String url = "jdbc:mysql://localhost:3306/flipfit_db";
            String user = "root";
            String password = "yourpassword";

            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Database connected successfully!");
        } catch (Exception e) {
            System.out.println("Database connection failed: " + e.getMessage());
        }
        return connection;
    }
}
