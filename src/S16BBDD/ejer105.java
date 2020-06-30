package S16BBDD;

import java.sql.*;

public class ejer105 {
    public static void main(String[] args) {
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
            SQL += "SELECT a.nombre, a.anio_inauguracion, a.capacidad, ";
            SQL += "d.pais, d.ciudad, d.calle, d.numero, ap.financiacion, ap.num_trab_discapacitados ";
            SQL += "FROM aeropuertos a, direcciones d, aeropuertos_publicos ap ";
            SQL += "WHERE a.id_direccion = d.id and ap.id_aeropuerto = a.id";


            ResultSet resultSet = statement.executeQuery(SQL);
            System.out.println("Aeropuertos públicos");
            while(resultSet.next()){
                System.out.println("Nombre: "+resultSet.getString("nombre"));
                System.out.println("Año de inauguración: "+resultSet.getInt("anio_inauguracion"));
                System.out.println("Capacidad: "+resultSet.getInt(2));
                System.out.println("País: "+resultSet.getString(4));
                System.out.println("Ciudad: "+resultSet.getString(5));
                System.out.println("Calle: "+resultSet.getString(6));
                System.out.println("Número: "+resultSet.getInt(7));
                System.out.println("Financiación: "+resultSet.getString(8));
                System.out.println("Trabajadores con discapacidad: "+resultSet.getInt(9));
                System.out.println("\n");
            }
            resultSet.close();
            statement.close();

            // Privados
            statement=connection.createStatement();


            SQL = "";
            SQL += "SELECT a.nombre, a.anio_inauguracion, a.capacidad, ";
            SQL += "d.pais, d.ciudad, d.calle, d.numero, ap.numero_socios ";
            SQL += "FROM aeropuertos a, direcciones d, aeropuertos_privados ap ";
            SQL += "WHERE a.id_direccion = d.id and ap.id_aeropuerto = a.id";

            resultSet = statement.executeQuery(SQL);

            System.out.println("Aeropuertos privados");
            while(resultSet.next()){
                System.out.println("Nombre: "+resultSet.getString("nombre"));
                System.out.println("Año de inauguración: "+resultSet.getInt("anio_inauguracion"));
                System.out.println("Capacidad: "+resultSet.getInt(2));
                System.out.println("País: "+resultSet.getString(4));
                System.out.println("Ciudad: "+resultSet.getString(5));
                System.out.println("Calle: "+resultSet.getString(6));
                System.out.println("Número: "+resultSet.getInt(7));
                System.out.println("Número de socios: "+resultSet.getString(8));
                System.out.println("\n");
            }
            resultSet.close();
            statement.close();




            connection.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
}

