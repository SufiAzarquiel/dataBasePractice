package org.sufiAzarquiel.cursos.dao;

import org.sufiAzarquiel.cursos.connection.DBConnection;
import org.sufiAzarquiel.cursos.entities.Alumno;

import java.sql.*;
import java.util.ArrayList;

public class DAOAlumnos {
    public DAOAlumnos() {
    }

    public static ArrayList<Alumno> get() {
        // Create ArrayList
        ArrayList<Alumno> alumnos = new ArrayList<>();

        // Get connection
        Connection conn = new DBConnection().getConnection();

        try {
            // Prepare select statement
            String selectSql = "SELECT * FROM alumnos";

            // Create a statement object
            Statement selectStatement = conn.createStatement();

            // Execute select statement and store it in a ResultSet object
            ResultSet rs = selectStatement.executeQuery(selectSql);

            // Extract data from ResultSet object
            while (rs.next()) {
                // Retrieve by column name
                int CodigoAlumno = rs.getInt("CodigoAlumno");
                String Nombre = rs.getString("Nombre");
                String Apellidos = rs.getString("Apellidos");
                String Telefono = rs.getString("Telefono");
                Date FechaNacimiento = rs.getDate("FechaNacimiento");


                // Create Alumno object
                Alumno alumno = new Alumno(CodigoAlumno, Nombre, Apellidos, Telefono, FechaNacimiento);

                // Add Alumno object to ArrayList
                alumnos.add(alumno);
            }

            // Close connection
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return alumnos;
    }
}
