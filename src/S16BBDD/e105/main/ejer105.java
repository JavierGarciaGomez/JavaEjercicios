package S16BBDD.e105.main;

import S16BBDD.e105.Clases.*;

import java.sql.*;
import java.util.ArrayList;

public class ejer105 {
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


            String SQL = "";
            SQL += "SELECT a.id, a.nombre, a.anio_inauguracion, a.capacidad, ";
            SQL += "d.pais, d.ciudad, d.calle, d.numero, ap.financiacion, ap.num_trab_discapacitados ";
            SQL += "FROM aeropuertos a, direcciones d, aeropuertos_publicos ap ";
            SQL += "WHERE a.id_direccion = d.id and ap.id_aeropuerto = a.id";


            ResultSet resultSet = statement.executeQuery(SQL);
            System.out.println("Aeropuertos públicos");
            while(resultSet.next()){

                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                int anio = resultSet.getInt("anio_inauguracion");
                int capacidad = resultSet.getInt("capacidad");
                String pais = resultSet.getString("pais");
                String ciudad = resultSet.getString("ciudad");
                String calle = resultSet.getString("calle");
                int numero = resultSet.getInt("numero");
                double financiacion = resultSet.getDouble("financiacion");
                int discapacitados = resultSet.getInt("num_trab_discapacitados");

                // creo la direccion
                Direccion dir = new Direccion(pais, calle, numero, ciudad);

                // Creo el aeropuertos
                AeropuertoPublico a = new AeropuertoPublico(financiacion, discapacitados, id, nombre, dir, anio, capacidad);

                // Añado el aeropuerto al array
                aeropuertos.add(a);

            }
            resultSet.close();
            statement.close();

            // Privados
            statement=connection.createStatement();


            SQL = "";
            SQL += "SELECT a.id, a.nombre, a.anio_inauguracion, a.capacidad, ";
            SQL += "d.pais, d.ciudad, d.calle, d.numero, ap.numero_socios ";
            SQL += "FROM aeropuertos a, direcciones d, aeropuertos_privados ap ";
            SQL += "WHERE a.id_direccion = d.id and ap.id_aeropuerto = a.id";

            resultSet = statement.executeQuery(SQL);

            System.out.println("Aeropuertos privados");
            while(resultSet.next()){

                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                int anio = resultSet.getInt("anio_inauguracion");
                int capacidad = resultSet.getInt("capacidad");
                String pais = resultSet.getString("pais");
                String ciudad = resultSet.getString("ciudad");
                String calle = resultSet.getString("calle");
                int numero = resultSet.getInt("numero");

                int numeroSocios = resultSet.getInt("numero_socios");

                // Creo la direccion
                Direccion dir = new Direccion(pais, calle, numero, ciudad);

                // Creo el aeropuerto
                AeropuertoPrivado a = new AeropuertoPrivado(numeroSocios, id, nombre, dir, anio, capacidad);

                // Añado el aeropuerto a la lista
                aeropuertos.add(a);

            }
            resultSet.close();
            statement.close();




            connection.close();


            // Mostrar la informacion de los aeropuertos
            for (Aeropuerto a : aeropuertos) {
                System.out.println(a.mostrarInformacion());
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
}

