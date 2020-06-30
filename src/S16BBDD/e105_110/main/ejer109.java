package S16BBDD.e105_110.main;

import java.sql.*;
import java.util.Scanner;

public class ejer109 {
    /**
     * Inserta un aeropuerto
     */
    public static void main(String[] args) {

        try {
            Connection conexion;

            // Adaptalos a tu conexion
            String host = "localhost";
            String baseDatos = "aeropuertos";
            String usuario = "root";
            String password = "secret";

            String cadenaConexion = "jdbc:mysql://" + host + "/" + baseDatos;
            conexion = DriverManager.getConnection(cadenaConexion, usuario, password);
            conexion.setAutoCommit(true);

            Scanner sc = new Scanner(System.in);
            sc.useDelimiter("\n");

            System.out.println("Escribe el id del aeropuerto a actualizar");
            int idAeropuerto = sc.nextInt();

            System.out.println("Escribe la nueva capacidad");
            int nuevaCapacidad = sc.nextInt();

            String SQL = "UPDATE aeropuertos SET capacidad = " + nuevaCapacidad + " WHERE id = " + idAeropuerto;
            Statement statement = conexion.createStatement();
            statement.executeUpdate(SQL);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
