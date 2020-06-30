package S16BBDD.e105.main;

import S16BBDD.e105.Clases.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ejer106 {
    public static void main(String[] args) {
        ArrayList<Aeropuerto> aeropuertos = new ArrayList<>();

        try {
            Connection connection;

            String host = "localhost";
            String baseDatos = "aeropuertos";
            String usuario = "root";
            String password = "secret";

            String cadenaConexion = "jdbc:mysql://" + host + "/" + baseDatos;
            connection = DriverManager.getConnection(cadenaConexion, usuario, password);
            connection.setAutoCommit(true);

            Statement statement = connection.createStatement();

            Scanner scanner = new Scanner(System.in);
            scanner.useDelimiter("\n");
            System.out.println("Escribe el id del aeropuerto");
            int idAeropuerto =scanner.nextInt();

            String SQL = "";
            SQL += "SELECT * ";
            SQL += "FROM aviones a ";
            SQL += "WHERE a.activado = 1 and ap.id_aeropuerto = "+idAeropuerto;

            ResultSet rs = statement.executeQuery(SQL);

            // Recorro los datos
            while (rs.next()) {

                int idAvion = rs.getInt("id");
                String modelo = rs.getString("modelo");
                int numAsientos = rs.getInt("numero_asientos");
                int velMax = rs.getInt("velocidad_maxima");
                int activado = rs.getInt("activado");

                // Crea un avion
                Avion a = new Avion(idAvion, modelo, numAsientos, velMax);

                // Si es un 1, ponemos el activado a 1
                if (activado == 1) {
                    a.setActivado(true);
                }

                // Muestro el avion
                System.out.println(a);

            }
            rs.close();
            statement.close();

            connection.close();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
}

