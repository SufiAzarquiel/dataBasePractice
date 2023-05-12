package org.sufiAzarquiel.dao;

import org.sufiAzarquiel.connection.DBConnection;
import org.sufiAzarquiel.entities.Contacto;

import java.sql.Connection;

public class DaoContactos {
    /**
     * ---------- CRUD ----------
     * Generate objects from rows and viceversa
     */

    public DaoContactos() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Save an object to 'contactos' table
     * Parameters: Object contacto
     */
    public void addContacto(Contacto contacto) {
        // Get connection
        Connection conn = new DBConnection().getConnection();
        // Prepare insert statement
        String insertSql = "INSERT INTO contactos VALUES (";
        insertSql += "'" + contacto.getDni() + "', ";
        insertSql += "'" + contacto.getNombre() + "', ";
        insertSql += contacto.getTelefono() + ")";
        /* TODO delete this comment
        String insertSql_3 = "INSERT INTO contactos VALUES ('32145679Z', 'Maria', 644444444)";
        updateStatement.executeUpdate(insertSql);
         */
        // TODO Execute insert statement
    }
}
