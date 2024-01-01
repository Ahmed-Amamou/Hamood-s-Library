/*
 * Copyright (c) 2024. made by Ahmed AMAMOU.
 */

package com.example.bibliotheque_project.Connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {

    public static Connection getConnection() {
        Connection connection = null;
        try {
            // Register the JDBC driver (optional for newer versions)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Database URL, username, and password
            String url = "jdbc:mysql://localhost:3306/library";
            String username = "root";
            String password = "FuckTeemo3000";

            // Establish the connection
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to MySQL database!");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Connection failed!");
            e.printStackTrace();
        }
        return connection;
    }

    public static void main(String[] args) {
        Connection connection = getConnection();
        // Use the connection for database operations
        // Remember to close the connection when done
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Connection closed!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
