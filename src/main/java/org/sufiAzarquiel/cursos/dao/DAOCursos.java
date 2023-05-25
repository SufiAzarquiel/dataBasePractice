package org.sufiAzarquiel.cursos.dao;

import org.sufiAzarquiel.cursos.connection.DBConnection;
import org.sufiAzarquiel.cursos.entities.Alumno;
import org.sufiAzarquiel.cursos.entities.Curso;

import java.sql.*;

public class DAOCursos {
    public DAOCursos() {
    }

    public static String getNombreFromId(int CodigoCurso) {
        // Get connection
        Connection conn = new DBConnection().getConnection();

        String Nombre = "";

        try {
            // Prepare select statement
            String selectSql = "SELECT * FROM cursos WHERE CodigoCurso = ?";

            // Create a statement object
            PreparedStatement selectStatement = conn.prepareStatement(selectSql);
            selectStatement.setInt(1, CodigoCurso);

            // Execute select statement and store it in a ResultSet object
            ResultSet rs = selectStatement.executeQuery(selectSql);

            // Extract data from ResultSet object
            while (rs.next()) {
                // Retrieve by column name
                Nombre = rs.getString("Nombre");
            }

            // Close connection
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Nombre;
    }
}
