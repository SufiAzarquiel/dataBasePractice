package org.sufiAzarquiel.verduleros.dao;

import org.sufiAzarquiel.verduleros.connection.DBConnection;
import org.sufiAzarquiel.verduleros.entities.Producto;

import java.sql.*;
import java.util.ArrayList;

public class DAOProducto {
    public static void main(String[] args) {

    }
    public static ArrayList<Producto> get() {
        // Create ArrayList
        ArrayList<Producto> productos = new ArrayList<>();

        // Get connection
        Connection conn = new DBConnection().getConnection();

        try {
            // Prepare select statement
            String selectSql = "SELECT * FROM productos";

            // Create a statement object
            Statement selectStatement = conn.createStatement();

            // Execute select statement and store it in a ResultSet object
            ResultSet rs = selectStatement.executeQuery(selectSql);

            // Extract data from ResultSet object
            while (rs.next()) {
                // Retrieve by column name
                int idProducto = rs.getInt("idProducto");
                String nomProducto = rs.getString("nomProducto");
                int idGrupo = rs.getInt("idGrupo");
                float precio = rs.getFloat("precio");

                // Create Producto object
                Producto producto = new Producto(idProducto, nomProducto, idGrupo, precio);

                // Add Producto object to ArrayList
                productos.add(producto);
            }

            // Close connection
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productos;
    }

    public static void updateProducto(int idProducto, String nomProducto, int idGrupo, float precio) {
        // Get connection
        Connection conn = new DBConnection().getConnection();

        try {
            // Prepare update statement
            String updateSql = "UPDATE productos set nomProducto = ?, idGrupo = ?, precio = ? WHERE idProducto = ?";

            // Create a statement object
            PreparedStatement updateStatement = conn.prepareStatement(updateSql);
            updateStatement.setInt(4, idProducto);
            updateStatement.setString(1, nomProducto);
            updateStatement.setInt(2, idGrupo);
            updateStatement.setFloat(3, precio);

            // Execute update statement
            updateStatement.executeUpdate(updateSql);

            // Close connection
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
