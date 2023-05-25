package org.sufiAzarquiel.censo.dao;

import org.sufiAzarquiel.censo.connection.DBConnection;
import org.sufiAzarquiel.censo.entities.Poblacion;

import java.sql.*;
import java.util.ArrayList;

public class DAOPoblacion {
    /**
     * ---------- CRUD ----------
     * Generate objects from rows and vice-versa
     */

    public DAOPoblacion() {

    }

    /**
     * Save an object to 'poblacion' table
     * Parameters: Object poblacion
     */
    public void addPoblacion(Poblacion poblacion) {
        // Get connection
        Connection conn = new DBConnection().getConnection();

        try {
            // Prepare insert statement
            String insertSql = "INSERT INTO poblacion VALUES (?, ?)";

            // Create a statement object (this time a prepared statement)
            PreparedStatement updatestatement = conn.prepareStatement(insertSql);

            // Set values to statement object
            updatestatement.setString(1, poblacion.getNombre());
            updatestatement.setInt(2, poblacion.getNumeroDeHabitantes());

            // Execute insert statement
            updatestatement.executeUpdate();

            // Close connection
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     *  <pre>
     * Get all objects from 'poblacion' table
     * Parameters: None
     * Return: ArrayList<Poblacion>
     * </pre>
     */
    public ArrayList<Poblacion> get() {
        // Create ArrayList
        ArrayList<Poblacion> poblaciones = new ArrayList<>();

        // Get connection
        Connection conn = new DBConnection().getConnection();

        try {
            // Prepare select statement
            String selectSql = "SELECT * FROM poblacion";

            // Create a statement object
            Statement selectStatement = conn.createStatement();

            // Execute select statement and store it in a ResultSet object
            ResultSet rs = selectStatement.executeQuery(selectSql);

            // Extract data from ResultSet object
            while (rs.next()) {
                // Retrieve by column name
                String nombre = rs.getString("nombre");
                int numeroDeHabitantes = rs.getInt("numeroHabitantes");

                // Create Poblacion object
                Poblacion poblacion = new Poblacion(nombre, numeroDeHabitantes);

                // Add Poblacion object to ArrayList
                poblaciones.add(poblacion);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Return ArrayList
        return poblaciones;
    }

    /**
     * Get all objects from 'poblacion' table where 'numeroDeHabitantes' is 0
     * Parameters: None
     * Return: ArrayList<Poblacion>
     */
    public ArrayList<Poblacion> getVacios() {
        // Create ArrayList
        ArrayList<Poblacion> poblaciones = new ArrayList<>();

        // Get connection
        Connection conn = new DBConnection().getConnection();

        try {
            // Prepare select statement
            String selectSql = "SELECT * FROM poblacion WHERE numeroHabitantes = 0";

            // Create a statement object
            Statement selectStatement = conn.createStatement();

            // Execute select statement and store it in a ResultSet object
            ResultSet rs = selectStatement.executeQuery(selectSql);

            // Extract data from ResultSet object
            while (rs.next()) {
                // Retrieve by column name
                String nombre = rs.getString("nombre");
                int numeroDeHabitantes = rs.getInt("numeroHabitantes");

                // Create Poblacion object
                Poblacion poblacion = new Poblacion(nombre, numeroDeHabitantes);

                // Add Poblacion object to ArrayList
                poblaciones.add(poblacion);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Return ArrayList
        return poblaciones;
    }
}
