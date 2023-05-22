package org.sufiAzarquiel.verduleros.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private Connection conn;

    public DBConnection() {
        try {
            // Load the jdbc driver
            Class.forName("com.mysql.jdbc.Driver");

            // Create a connection to the database
            String url = "jdbc:mysql://localhost/verduleros";
            String username = "root";
            String password = "";

            this.conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading jdbc driver");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error executing sql statement or connecting to database");
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return this.conn;
    }
}
