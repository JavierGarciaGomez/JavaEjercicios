package S17JavaFX.ejer112.Utilities;

import java.sql.*;

public class ConnectionDB {
    private Connection connection;


    public ConnectionDB() throws SQLException {

        String host = "localhost";
        String baseDatos = "aeropuertos";
        String usuario = "root";
        String password = "secret";

        String cadenaConexion = "jdbc:mysql://" + host + "/" + baseDatos;

        connection = DriverManager.getConnection(cadenaConexion, usuario, password);

        connection.setAutoCommit(true);

    }

    /**
     * Ejecuta una consulta
     * @param SQL Consulta a ejecutar
     * @return ResultSet con los datos de la consulta
     * @throws SQLException
     */
    public ResultSet ejecutarConsulta(String SQL) throws SQLException {
        Statement statement = this.connection.createStatement();
        return statement.executeQuery(SQL);
    }

    /**
     * Ejecuta una instrucción
     * @param SQL Instrucción a ejecutar
     * @return numero de filas afectadas
     * @throws SQLException
     */
    public int ejecutarInstruccion(String SQL) throws SQLException {
        Statement statement = this.connection.createStatement();
        return statement.executeUpdate(SQL);
    }

    /**
     * Devuelve el ultimo ID insertado
     * @return ultimo id
     * @throws SQLException
     */

    public int ultimoID() throws SQLException {
        ResultSet rs = this.ejecutarConsulta("SELECT last_insert_id() as last_id;");
        rs.next();
        return rs.getInt("last_id");
    }

    /**
     * Cierra la conexión
     * @throws SQLException
     */
    public void cerrarConexion() throws SQLException {
        this.connection.close();
    }

}
