package S17JavaFX.ejer114_121.Model;

import S17JavaFX.ejer114_121.Utilities.ConnectionDB;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Clase Aeropuerto publico, heredad de Aeropuerto
 *
 * @author DiscoDurodeRoer
 */
public class AeropuertoPublico extends Aeropuerto implements Serializable {

    private double financiacion;
    private int numTrabajadoresDiscapacitados;

    /**
     * Constructor vacio
     */
    public AeropuertoPublico() {
        super();
    }

    /**
     * Constructor con direccion
     *
     * @param financiacion
     * @param numTrabajadoresDiscapacitados
     * @param nombre
     * @param direccion
     * @param anioInauguracion
     * @param capacidad
     */
    public AeropuertoPublico(double financiacion, int numTrabajadoresDiscapacitados, String nombre, Direccion direccion, int anioInauguracion, int capacidad) {
        super(nombre, direccion, anioInauguracion, capacidad);
        this.financiacion = financiacion;
        this.numTrabajadoresDiscapacitados = numTrabajadoresDiscapacitados;
    }

    /**
     * Constructor con direccion
     *
     * @param financiacion
     * @param numTrabajadoresDiscapacitados
     * @param id
     * @param nombre
     * @param direccion
     * @param anioInauguracion
     * @param capacidad
     */
    public AeropuertoPublico(double financiacion, int numTrabajadoresDiscapacitados, int id, String nombre, Direccion direccion, int anioInauguracion, int capacidad) {
        super(id, nombre, direccion, anioInauguracion, capacidad);
        this.financiacion = financiacion;
        this.numTrabajadoresDiscapacitados = numTrabajadoresDiscapacitados;
    }

    /**
     * Constructor completo
     *
     * @param financiacion
     * @param numTrabajadoresDiscapacitados
     * @param nombre
     * @param pais
     * @param calle
     * @param numero
     * @param ciudad
     * @param anioInauguracion
     * @param capacidad
     */
    public AeropuertoPublico(double financiacion, int numTrabajadoresDiscapacitados, String nombre, String pais, String calle, int numero, String ciudad, int anioInauguracion, int capacidad) {
        super(nombre, pais, calle, numero, ciudad, anioInauguracion, capacidad);
        this.financiacion = financiacion;
        this.numTrabajadoresDiscapacitados = numTrabajadoresDiscapacitados;
    }

    /**
     * Constructor completo
     *
     * @param financiacion
     * @param numTrabajadoresDiscapacitados
     * @param id
     * @param nombre
     * @param pais
     * @param calle
     * @param numero
     * @param ciudad
     * @param anioInauguracion
     * @param capacidad
     */
    public AeropuertoPublico(double financiacion, int numTrabajadoresDiscapacitados, int id, String nombre, String pais, String calle, int numero, String ciudad, int anioInauguracion, int capacidad) {
        super(id, nombre, pais, calle, numero, ciudad, anioInauguracion, capacidad);
        this.financiacion = financiacion;
        this.numTrabajadoresDiscapacitados = numTrabajadoresDiscapacitados;
    }

    /**
     * Devuelve la financiacion del aeropuerto
     *
     * @return financiacion del aeropuerto
     */
    public double getFinanciacion() {
        return financiacion;
    }

    /**
     * Modifica la financiacion del aeropuerto
     *
     * @param financiacion nueva financiacion
     */
    public void setFinanciacion(double financiacion) {
        this.financiacion = financiacion;
    }

    /**
     * Devuelve el numero de trabajadores discapacitados
     *
     * @return numero de trabajadores discapacitados
     */
    public int getNumTrabajadoresDiscapacitados() {
        return numTrabajadoresDiscapacitados;
    }

    /**
     * Modifica el numero de trabajadores discapacitados
     *
     * @param numTrabajadoresDiscapacitados nuevo numero de trabajadores
     * discapacitados
     */
    public void setNumTrabajadoresDiscapacitados(int numTrabajadoresDiscapacitados) {
        this.numTrabajadoresDiscapacitados = numTrabajadoresDiscapacitados;
    }

    /**
     * Muestra las ganancias totoales del aeropuerto Cantidad ganada +
     * financiacion + (numero de trabajadores discapacitados * 100)
     *
     * @param cantidad
     * @return
     */
    @Override
    public String gananciasTotales(double cantidad) {

        double ganacias = cantidad + financiacion + (numTrabajadoresDiscapacitados * 100);

        return "La ganancia ha sido de " + ganacias;

    }

    /**
     * Devuelve la informacion mas detallada del objeto
     *
     * @return info
     */
    @Override
    public String mostrarInformacion() {
        return super.mostrarInformacion() + "El aeropuerto es publico y su financiacion por parte del estado es de " + financiacion + " y hay " + numTrabajadoresDiscapacitados + " trabajadores discapacitados";
    }

    @Override
    public ObservableList<AeropuertoPublico> getAeropuertos(String busqueda) throws SQLException {
        ObservableList<AeropuertoPublico> aeropuertos = FXCollections.observableArrayList();
        ConnectionDB connectionDB = new ConnectionDB();

        String SQL = "";
        SQL += "SELECT a.id, a.nombre, a.anio_inauguracion, a.capacidad, ";
        SQL += "d.pais, d.ciudad, d.calle, d.numero, ap.financiacion, ap.num_trab_discapacitados ";
        SQL += "FROM aeropuertos a, direcciones d, aeropuertos_publicos ap ";
        SQL += "WHERE a.id_direccion = d.id and ap.id_aeropuerto = a.id";

        if(busqueda!=null && !busqueda.isEmpty()){
            SQL += " and trim(lower(a.nombre)) Like '%"+busqueda.toLowerCase().trim()+"%'";
        }

        ResultSet rs = connectionDB.ejecutarConsulta(SQL);

        while (rs.next()) {
            int id = rs.getInt("id");
            String nombre = rs.getString("nombre");
            int anio = rs.getInt("anio_inauguracion");
            int capacidad = rs.getInt("capacidad");
            String pais = rs.getString("pais");
            String ciudad = rs.getString("ciudad");
            String calle = rs.getString("calle");
            int numero = rs.getInt("numero");
            double financiacion = rs.getDouble("financiacion");
            int discapacitados = rs.getInt("num_trab_discapacitados");

            Direccion dir = new Direccion(pais, calle, numero, ciudad);

            AeropuertoPublico a = new AeropuertoPublico(financiacion, discapacitados, id, nombre, dir, anio, capacidad);

            aeropuertos.add(a);
        }

        rs.close();
        connectionDB.cerrarConexion();
        return aeropuertos;
    }

    @Override
    public boolean insertar() throws SQLException {

        // Llamo al padre para insertar el aeropuerto
        boolean exito = super.insertar();

        // Si se insertó el aeropuerto
        if (exito) {

            // Abro la conexion
            ConnectionDB conexion = new ConnectionDB();

            // Formo el SQL
            String SQL = "";
            SQL += "INSERT INTO aeropuertos_publicos VALUES (" + super.getId() + ", ";
            SQL += this.financiacion + ", " + this.numTrabajadoresDiscapacitados + ")";

            // Ejecuto la instruccion
            int filas = conexion.ejecutarInstruccion(SQL);

            // cierro la conexion
            conexion.cerrarConexion();

            // Indico si se ha insertado o no
            if (filas > 0) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }

    }

}
