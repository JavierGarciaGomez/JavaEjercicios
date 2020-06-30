package S16BBDD;

import java.sql.*;

public class ejer102 {
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
            SQL += "Select a.nombre, a.anio_inauguracion, a.capacidad, d.pais, d.ciudad, d.calle, d.numero ";
            SQL += "FROM aeropuertos a, direcciones d ";
            SQL += "WHERE a.id_direccion = d.id";

            ResultSet resultSet = statement.executeQuery(SQL);
            while(resultSet.next()){
                System.out.println("Nombre: "+resultSet.getString("nombre"));
                System.out.println("Año de inauguración: "+resultSet.getInt("anio_inauguracion"));
                System.out.println("Capacidad: "+resultSet.getInt(2));
                System.out.println("País: "+resultSet.getString(4));
                System.out.println("Ciudad: "+resultSet.getString(5));
                System.out.println("Calle: "+resultSet.getString(6));
                System.out.println("Número: "+resultSet.getInt(7));
                System.out.println("\n");
            }


            statement.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
}

