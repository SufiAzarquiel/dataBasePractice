package org.sufiAzarquiel.censo.dao;

import org.sufiAzarquiel.agendaWithDB.connection.DBConnection;
import org.sufiAzarquiel.agendaWithDB.entities.Contacto;

import java.sql.*;
import java.util.ArrayList;

public class DAOPoblacion {
    /**
     * ---------- CRUD ----------
     * Generate objects from rows and vice-versa
     */

    public DAOPoblacion() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Save an object to 'contactos' table
     * Parameters: Object contacto
     */
    public void addContacto(Contacto contacto) {
        // Get connection
        Connection conn = new DBConnection().getConnection();

        try {
            // Prepare insert statement
            String insertSql = "INSERT INTO contactos VALUES (?, ?, ?)";

            // Create a statement object (this time a prepared statement)
            PreparedStatement updatestatement = conn.prepareStatement(insertSql);

            // Set values to statement object
            updatestatement.setString(1, contacto.getDni());
            updatestatement.setString(2, contacto.getNombre());
            updatestatement.setLong(3, contacto.getTelefono());

            // Execute insert statement
            updatestatement.executeUpdate();

            // Close connection
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Delete an object from 'contactos' table
     * Parameters: Object contacto
     */
    public void deleteContacto(Contacto contacto) {
        // Get connection
        Connection conn = new DBConnection().getConnection();

        try {
            // Prepare delete statement
            String deleteSql = "DELETE FROM contactos WHERE dni = ?";

            // Create a statement object and set values to statement object
            PreparedStatement updateStatement = conn.prepareStatement(deleteSql);
            updateStatement.setString(1, contacto.getDni());

            // Execute delete statement and close connection
            updateStatement.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Update an object from 'contactos' table. The primary key cannot be updated, since it is used to identify the row
     * Parameters: Object contacto
     */
    public void updateContacto(Contacto contacto) {
        // Get connection
        Connection conn = new DBConnection().getConnection();

        try {
            // Prepare update statement
            String updateSql = "UPDATE contactos SET nombre = ?, telefono = ? WHERE dni = ?";

            // Create a statement object and set values to statement object
            PreparedStatement updateStatement = conn.prepareStatement(updateSql);
            updateStatement.setString(1, contacto.getNombre());
            updateStatement.setLong(2, contacto.getTelefono());
            updateStatement.setString(3, contacto.getDni());

            // Execute delete statement and close connection
            updateStatement.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get all objects from 'contactos' table
     * Parameters: None
     * Return: ArrayList<Habitante>
     */
    public ArrayList<Contacto> getContactos() {
        // Create ArrayList
        ArrayList<Contacto> contactos = new ArrayList<>();

        // Get connection
        Connection conn = new DBConnection().getConnection();

        try {
            // Prepare select statement
            String selectSql = "SELECT * FROM contactos";

            // Create a statement object
            Statement selectStatement = conn.createStatement();

            // Execute select statement and store it in a ResultSet object
            ResultSet rs = selectStatement.executeQuery(selectSql);

            // Extract data from ResultSet object
            while (rs.next()) {
                // Retrieve by column name
                String dni = rs.getString("dni");
                String nombre = rs.getString("nombre");
                long telefono = rs.getLong("telefono");

                // Create Habitante object
                Contacto contacto = new Contacto(dni, nombre, telefono);

                // Add Habitante object to ArrayList
                contactos.add(contacto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Return ArrayList
        return contactos;
    }

    /**
     * Get an object from 'contactos' table given its primary key
     * Parameters: String dni
     * Return: Habitante
     */
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
}
