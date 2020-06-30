package S16BBDD.e105_110.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ejer110 {
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

            // Pido el id del aeropuerto a borrar
            System.out.println("Escribe el id de un aeropuerto");
            int idAeropuerto = sc.nextInt();

            // Formo el SQL para borrar
            // Recuerda, borro una direccion para que se borre el aeropuerto asociado a esta
            String SQL = "DELETE FROM direcciones WHERE id = (select id_direccion FROM aeropuertos WHERE id = " + idAeropuerto + ")";

            // creo la sentencia
            Statement sentencia = conexion.createStatement();

            // Ejecuto la instruccion y guardo las filas afectadas
            int filas = sentencia.executeUpdate(SQL);

            // Si es mayor que cero, es que se ha borrado, sino no se borra
            if (filas > 0) {
                System.out.println("Aeropuerto borrado");
            } else {
                System.out.println("Aeropuerto no borrado");
            }

            // Cierro todo
            sentencia.close();
            conexion.close();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

}
