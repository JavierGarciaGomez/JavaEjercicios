package S17JavaFX.ejer114_116.Model;

import S17JavaFX.ejer114_116.Utilities.ConnectionDB;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Clase Usuario, representa a un usuario
 *
 * @author Discoduroderoer
 */
public class Usuario {

    private String usuario;
    private String password;

    public Usuario(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean login() throws SQLException {

        ConnectionDB connectionDB = new ConnectionDB();

        String SQL = "";
        SQL += "SELECT * ";
        SQL += "FROM usuarios ";
        SQL += "WHERE lower(usuario) = '" + usuario.toLowerCase() + "' and password = '" + password + "'";
        
        ResultSet rs = connectionDB.ejecutarConsulta(SQL);
        
        boolean isUser = rs.next();
        
        connectionDB.cerrarConexion();

        return isUser;
        
    }

}
