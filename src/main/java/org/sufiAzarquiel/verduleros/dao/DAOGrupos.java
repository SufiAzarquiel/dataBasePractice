package org.sufiAzarquiel.verduleros.dao;

import org.sufiAzarquiel.verduleros.connection.DBConnection;
import org.sufiAzarquiel.verduleros.entities.Grupo;
import org.sufiAzarquiel.verduleros.entities.Producto;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DAOGrupos {
    public static void main(String[] args) {

    }

    public static ArrayList<Grupo> get() {
        // Create ArrayList
        ArrayList<Grupo> grupos = new ArrayList<>();

        // Get connection
        Connection conn = new DBConnection().getConnection();

        try {
            // Prepare select statement
            String selectSql = "SELECT * FROM grupos";

            // Create a statement object
            Statement selectStatement = conn.createStatement();

            // Execute select statement and store it in a ResultSet object
            ResultSet rs = selectStatement.executeQuery(selectSql);

            // Extract data from ResultSet object
            while (rs.next()) {
                // Retrieve by column name
                int idGrupo = rs.getInt("idGrupo");
                String nomGrupo = rs.getString("nomGrupo");

                // Create Grupo object
                Grupo grupo = new Grupo(idGrupo, nomGrupo);

                // Add Grupo object to ArrayList
                grupos.add(grupo);
            }

            // Close connection
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return grupos;
    }
}
