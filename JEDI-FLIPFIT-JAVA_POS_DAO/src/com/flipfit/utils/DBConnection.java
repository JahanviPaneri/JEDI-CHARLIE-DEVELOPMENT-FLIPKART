package com.flipfit.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// TODO: Auto-generated Javadoc
/**
 * The Class DBConnection.
 * Utility class for managing database connections in the FlipFit application.
 * Provides centralized connection management using MySQL JDBC driver.
 *
 * @author FlipFit Development Team
 * @version 1.0
 */
public class DBConnection {

    /** The database URL. */
    private static final String DB_URL = "jdbc:mysql://localhost:3306/flipfit_schema";
    
    /** The database username. */
    private static final String USER = "root";
    
    /** The database password. */
    private static final String PASS = "admin123";

    /**
     * Gets the database connection.
     * Loads the MySQL JDBC driver and establishes a connection to the database.
     *
     * @return the connection object
     * @throws SQLException if a database access error occurs
     */
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC Driver not found: " + e.getMessage());
            throw new SQLException("Failed to load JDBC driver", e);
        }
        return DriverManager.getConnection(DB_URL, USER, PASS);
    }
}
