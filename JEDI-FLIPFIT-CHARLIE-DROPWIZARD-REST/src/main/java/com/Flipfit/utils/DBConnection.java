package com.Flipfit.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
//    private static Connection connection = null;

    public static Connection getConnection() {
        Connection conn = null;
        try {
            String url = "jdbc:mysql://localhost:3306/flipfit_db";
            String user = "root";
            String password = "lohdee4J!@#%";

            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            System.out.println("Database connection failed: " + e.getMessage());
        }
        return conn; // Return a fresh connection every time
    }
}
