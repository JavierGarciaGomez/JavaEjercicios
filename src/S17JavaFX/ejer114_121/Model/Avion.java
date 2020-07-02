package S17JavaFX.ejer114_121.Model;

import S17JavaFX.ejer114_121.Utilities.ConnectionDB;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

/**
 * Clase Avion, representa un avion
 * 
 * @author DiscoDurodeRoer
 */
public class Avion implements Activable, Serializable {

    private static final long serialVersionUID = 1L;
    // Atributos
    private int id;
    private String modelo;
    private int nAsientos;
    private double velocidadMaxima;
    private boolean activado;
    private int idAeropuerto;

    /**
     * Constructor vacio
     */
    public Avion() {
        this("", 0, 0,0);
    }

    /**
     * Constructor completo
     * @param modelo model del avion
     * @param nAsientos numero de asientos del avion
     * @param velocidadMaxima  velocidad maxima del avion
     */

    public Avion(String modelo, int nAsientos, double velocidadMaxima, int idAeropuerto) {
        this.modelo = modelo;
        this.nAsientos = nAsientos;
        this.velocidadMaxima = velocidadMaxima;
        this.activado = false;
        this.idAeropuerto = idAeropuerto;
    }

    
    /**
     * Constructor completo
     * @param id id del avion
     * @param modelo model del avion
     * @param nAsientos numero de asientos del avion
     * @param velocidadMaxima  velocidad maxima del avion
     */
    public Avion(int id, String modelo, int nAsientos, double velocidadMaxima, int idAeropuerto) {
        this.id = id;
        this.modelo = modelo;
        this.nAsientos = nAsientos;
        this.velocidadMaxima = velocidadMaxima;
        this.activado = false;
        this.idAeropuerto = idAeropuerto;
    }

    /**
     * Devuelve el id del avion
     * @return id del avion
     */
    public int getId() {
        return id;
    }
    

    /**
     * Devuelve el modelo del avion
     * @return model del avion
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Modifica el modelo del avion
     * @param modelo nuevo modelo
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * Devuelve el numero de asientos
     * @return numero de asientos
     */
    public int getnAsientos() {
        return nAsientos;
    }

    /**
     * Modifica el numero de asientos
     * @param nAsientos nuevo numero de asientos
     */
    public void setnAsientos(int nAsientos) {
        this.nAsientos = nAsientos;
    }

    /**
     * Devuelve la velocidad maxima
     * @return velocidad maxima
     */
    public double getVelocidadMaxima() {
        return velocidadMaxima;
    }

    /**
     * Modifica la velocidad maxima
     * @param velocidadMaxima nueva velocidad maxima
     */
    public void setVelocidadMaxima(double velocidadMaxima) {
        this.velocidadMaxima = velocidadMaxima;
    }

    /**
     * Indica si el avion esta activado
     * @return a true si esta activado, false si no lo esta
     */
    @Override
    public boolean isActivado() {
        return activado;
    }

    /**
     * Modifca si esta activado o no
     * @param value nueva
     */
    @Override
    public void setActivado(boolean value) {
        this.activado = value;
    }

    public boolean insertar() throws SQLException {
        ConnectionDB conexion = new ConnectionDB();
        int act = 0;

        if (this.activado) {
            act = 1;
        }

        String SQL = "";
        SQL += "INSERT INTO aviones VALUES(null, ";
        SQL += "'" + this.modelo + "', " + this.nAsientos + ", ";
        SQL += this.velocidadMaxima + ", " + act + ", " + this.idAeropuerto + ") ";

        int filas = conexion.ejecutarInstruccion(SQL);

        this.id = conexion.ultimoID();

        conexion.cerrarConexion();
        return filas > 0;
    }

    public boolean actualizar() throws SQLException {
        ConnectionDB conexion = new ConnectionDB();
        int act = 0;

        if (this.activado) {
            act = 1;
        }
        String SQL = "UPDATE aviones SET activado =  " + act + " WHERE id = " + this.id;
        int filas = conexion.ejecutarInstruccion(SQL);
        conexion.cerrarConexion();
        return filas > 0;

    }

    public boolean borrar() throws SQLException {
        ConnectionDB conexion = new ConnectionDB();
        String SQL = "DELETE FROM aviones WHERE id = " + this.id;
        int filas = conexion.ejecutarInstruccion(SQL);
        conexion.cerrarConexion();
        return filas > 0;
    }

    public ObservableList<Avion> getAviones() throws SQLException {

        ConnectionDB conexion = new ConnectionDB();
        ObservableList<Avion> aviones = FXCollections.observableArrayList();

        String SQL = "";
        SQL += "SELECT *";
        SQL += "FROM aviones ";
        SQL += "WHERE id_aeropuerto = " + this.idAeropuerto;

        ResultSet rs = conexion.ejecutarConsulta(SQL);

        while (rs.next()) {
            int idAvion = rs.getInt("id");
            String modelo = rs.getString("modelo");
            int numeroAsientos = rs.getInt("numero_asientos");
            int velMax = rs.getInt("velocidad_maxima");
            int activado = rs.getInt("activado");

            Avion a = new Avion(idAvion, modelo, numeroAsientos, velMax, this.idAeropuerto);
            if (activado == 1) {
                a.setActivado(true);
            }
            aviones.add(a);
        }
        conexion.cerrarConexion();
        return aviones;
    }




    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Avion other = (Avion) obj;
        if (!Objects.equals(this.modelo, other.modelo)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "Avion{" + "modelo=" + modelo + ", nAsientos=" + nAsientos + ", velocidadMaxima=" + velocidadMaxima + '}';
    }

    public void setIdAeropuerto(int id) {
        this.idAeropuerto=id;
    }
}
