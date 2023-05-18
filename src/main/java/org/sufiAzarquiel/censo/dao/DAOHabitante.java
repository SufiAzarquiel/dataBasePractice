package org.sufiAzarquiel.censo.dao;

import org.sufiAzarquiel.censo.connection.DBConnection;
import org.sufiAzarquiel.censo.entities.Habitante;

import java.sql.*;
import java.util.ArrayList;

public class DAOHabitante {
    /**
     * ---------- CRUD ----------
     * Generate objects from rows and vice-versa
     */

    public DAOHabitante() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Save an object to 'habitante' table
     * Parameters: Object habitante
     */
    public void addHabitante(Habitante habitante) {
        // Get connection
        Connection conn = new DBConnection().getConnection();

        try {
            // Prepare insert statement
            String insertSql = "INSERT INTO habitantes VALUES (?, ?, ?, ?)";

            // Create a statement object (this time a prepared statement)
            PreparedStatement updateStatement = conn.prepareStatement(insertSql);

            // Set values to statement object
            updateStatement.setString(1, habitante.getNombre());
            updateStatement.setString(2, habitante.getEmail());
            updateStatement.setInt(3, habitante.getEdad());
            updateStatement.setString(4, habitante.getPoblacion());

            // Execute insert statement
            updateStatement.executeUpdate();

            // Close connection
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Delete an object from 'habitante' table
     * Parameters: Object habitante
     */
    public void deleteHabitante(Habitante habitante) {
        // Get connection
        Connection conn = new DBConnection().getConnection();

        try {
            // Prepare delete statement
            String deleteSql = "DELETE FROM habitantes WHERE nombre = ?";

            // Create a statement object and set values to statement object
            PreparedStatement updateStatement = conn.prepareStatement(deleteSql);
            updateStatement.setString(1, habitante.getNombre());

            // Execute delete statement and close connection
            updateStatement.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Update an object from 'habitante' table. The primary key cannot be updated, since it is used to identify the row
     * Parameters: Object habitante
     */
    public void updateHabitante(Habitante habitante) {
        // Get connection
        Connection conn = new DBConnection().getConnection();

        try {
            // Prepare update statement
            String updateSql = "UPDATE habitante SET edad = ?, email = ?, poblacion = ?, WHERE nombre = ?";

            // Create a statement object and set values to statement object
            PreparedStatement updateStatement = conn.prepareStatement(updateSql);
            updateStatement.setInt(1, habitante.getEdad());
            updateStatement.setString(2, habitante.getEmail());
            updateStatement.setString(3, habitante.getPoblacion());
            updateStatement.setString(4, habitante.getNombre());

            // Execute delete statement and close connection
            updateStatement.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get all objects from 'habitante' table
     * Parameters: None
     * Return: ArrayList<Habitante>
     */
    public ArrayList<Habitante> get() {
        // Create ArrayList
        ArrayList<Habitante> habitantes = new ArrayList<>();

        // Get connection
        Connection conn = new DBConnection().getConnection();

        try {
            // Prepare select statement
            String selectSql = "SELECT * FROM habitante";

            // Create a statement object
            Statement selectStatement = conn.createStatement();

            // Execute select statement and store it in a ResultSet object
            ResultSet rs = selectStatement.executeQuery(selectSql);

            // Extract data from ResultSet object
            while (rs.next()) {
                // Retrieve by column name
                String nombre = rs.getString("nombre");
                String email = rs.getString("email");
                int edad = rs.getInt("edad");
                String poblacion = rs.getString("poblacion");

                // Create Habitante object
                Habitante habitante = new Habitante(nombre, email, edad, poblacion);

                // Add Habitante object to ArrayList
                habitantes.add(habitante);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Return ArrayList
        return habitantes;
    }

    /**
     * Get all objects from 'habitante' table with a given 'poblacion'
     * Parameters: None
     * Return: ArrayList<Habitante>
     */
    public ArrayList<Habitante> getHabitantesDeUnaPoblacion(String poblacion) {
        // Create ArrayList
        ArrayList<Habitante> habitantes = new ArrayList<>();

        // Get connection
        Connection conn = new DBConnection().getConnection();

        try {
            // Prepare select statement
            String selectSql = "SELECT * FROM habitante WHERE poblacion = ?";

            // Create a statement object
            PreparedStatement selectStatement = conn.prepareStatement(selectSql);
            selectStatement.setString(1, poblacion);

            // Execute select statement and store it in a ResultSet object
            ResultSet rs = selectStatement.executeQuery();

            // Extract data from ResultSet object
            while (rs.next()) {
                // Retrieve by column name
                String nombre = rs.getString("nombre");
                String email = rs.getString("email");
                int edad = rs.getInt("edad");

                // Create Habitante object
                Habitante habitante = new Habitante(nombre, email, edad, poblacion);

                // Add Habitante object to ArrayList
                habitantes.add(habitante);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Return ArrayList
        return habitantes;
    }

    /**
     * Get an object from 'contactos' table given its primary key
     * Parameters: String dni
     * Return: Habitante
     */
    /*
    public Contacto getContacto(String dni) {
        // Create Habitante object
        Contacto contacto = null;

        // Get connection
        Connection conn = new DBConnection().getConnection();

        try {
            // Prepare select statement
            String selectSql = "SELECT * FROM contactos WHERE dni = ?";

            // Create a statement object
            PreparedStatement selectStatement = conn.prepareStatement(selectSql);
            selectStatement.setString(1, dni);

            // Execute select statement and store it in a ResultSet object
            ResultSet rs = selectStatement.executeQuery();

            // Extract data from ResultSet object
            while (rs.next()) {
                // Retrieve by column name
                String nombre = rs.getString("nombre");
                long telefono = rs.getLong("telefono");

                // Create Habitante object
                contacto = new Contacto(dni, nombre, telefono);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Return Habitante object if found, print error otherwise
        if (contacto != null) {
            return contacto;
        } else {
            System.out.println("Habitante not found");
            return null;
        }
    }
    */
}
