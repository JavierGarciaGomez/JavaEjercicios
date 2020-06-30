package S16BBDD;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        Connection connection;

        String host = "localhost";
        String baseDatos = "aeropuertos";
        String usuario = "root";
        String password = "secret";

        String cadenaConexion = "jdbc:mysql://"+host+"/"+baseDatos;
        connection = DriverManager.getConnection(cadenaConexion, usuario, password);
        connection.setAutoCommit(true);

        Statement statement = connection.createStatement();
        statement.executeQuery("SELECT *FROM AEROPUERTOS");

        statement.close();
        connection.close();

    }
}
