package org.sufiAzarquiel.basicSqlLearning;

import java.sql.*;

public class FirstDay {
    public static void main(String[] args) {
        try {
            Connection conn = connectToDatabase();

            // Create a statement object
            Statement updateStatement = conn.createStatement();

            // Table contactos has 3 columns: dni, nombre, telefono
            // Execute an insert statement
            // insertRows(updateStatement);
            // Execute an update statement
            // updateRows(updateStatement);
            // Execute a delete statement
            // deleteRows(updateStatement);
            // Commented out because it has already been executed

            // Execute a select statement
            selectRows(updateStatement);
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading jdbc driver");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error executing sql statement or connecting to database");
            e.printStackTrace();
        }
    }

    public static Connection connectToDatabase() throws ClassNotFoundException, SQLException {
        // Load the jdbc driver
        Class.forName("com.mysql.jdbc.Driver");

        // Create a connection to the database
        // Prepare connection strings: url, username, password
        String url = "jdbc:mysql://localhost/agenda";
        String username = "root";
        String password = "";

        // Create connection object
        System.out.println("Connecting to database...");
        Connection conn = DriverManager.getConnection(url, username, password);
        // Connection has been established. YOu can now execute sql statements
        System.out.println("Connection established");
        System.out.println();

        return conn;
    }

    public static void insertRows(Statement updateStatement) throws SQLException {
        String insertSql = "INSERT INTO contactos VALUES ('X9169830Y', 'Sufi', 611111111)";
        String insertSql_1 = "INSERT INTO contactos VALUES ('32145677Z', 'Pepe', 622222222)";
        String insertSql_2 = "INSERT INTO contactos VALUES ('32145678Z', 'Juan', 633333333)";
        String insertSql_3 = "INSERT INTO contactos VALUES ('32145679Z', 'Maria', 644444444)";
        updateStatement.executeUpdate(insertSql);
        updateStatement.executeUpdate(insertSql_1);
        updateStatement.executeUpdate(insertSql_2);
        updateStatement.executeUpdate(insertSql_3);
    }

    public static void updateRows(Statement updateStatement) throws SQLException {
        String updateSql = "UPDATE contactos SET telefono = 655555555 WHERE nombre = 'Pepe'";
        updateStatement.executeUpdate(updateSql);
    }

    public static void deleteRows(Statement updateStatement) throws SQLException {
        String deleteSql = "DELETE FROM contactos WHERE nombre = 'Pepe'";
        updateStatement.executeUpdate(deleteSql);
    }

    public static void selectRows(Statement updateStatement) throws SQLException {
        // Execute a select statement and store the result set
        System.out.println("Executing select statement...");
        String selectSql = "SELECT * FROM contactos";
        ResultSet queryResultSet = updateStatement.executeQuery(selectSql);

        // Extract data from result set
        while(queryResultSet.next()) {
            // Retrieve by column name
            String dni = queryResultSet.getString("dni");
            String nombre = queryResultSet.getString(2); // 2 is the column index
            long telefono = queryResultSet.getLong("telefono");

            // Display values
            System.out.print("DNI: " + dni);
            System.out.print(", Nombre: " + nombre);
            System.out.print(", Telefono: " + telefono);
            System.out.println();
        }

        queryResultSet.absolute(1); // Moves the cursor to the first row
        System.out.println("Row after 'absolute' method: " + queryResultSet.getRow());
    }
}
