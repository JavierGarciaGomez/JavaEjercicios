package S16BBDD.e105_110.main;

import S16BBDD.e105_110.Clases.Aeropuerto;
import S16BBDD.e105_110.Clases.Avion;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ejer107 {
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


            Scanner scanner = new Scanner(System.in);
            scanner.useDelimiter("\n");
            System.out.println("Escribe el id del aeropuerto");
            int idAeropuerto =scanner.nextInt();

            String SQL = "";
            SQL += "SELECT * ";
            SQL += "FROM aviones a ";
            SQL += "WHERE a.activado = ? and a.id_aeropuerto = ?";


            PreparedStatement statement = connection.prepareStatement(SQL);
            statement.setInt(1,1);
            statement.setInt(2,idAeropuerto);


            ResultSet rs = statement.executeQuery();

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

