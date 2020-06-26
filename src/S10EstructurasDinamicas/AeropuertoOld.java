package S10EstructurasDinamicas;

/*
    Crea una clase Aeropuerto con los siguientes atributos:
        - Nombre
        - País
        - Calle
        - Numero
        - Ciudad
        - Año inauguración
        - Capacidad
    Dos constructores:
        - Constructor vacio
        - Constructor completo
    Métodos o propiedades:
        - Getter y setter
        - aniosAbierto(): devuelve el numero de años que ha estado abierto.
        - toString()
*/


import java.util.Calendar;

public class AeropuertoOld {
    private String nombre;
    private String pais;
    private String calle;
    private String numero;
    private String ciudad;
    private int anoInauguracion;
    private int capacidad;

    public AeropuertoOld() {
    }

    public AeropuertoOld(String nombre, String pais, String calle, String numero, String ciudad, int anoInauguracion, int capacidad) {
        this.nombre = nombre;
        this.pais = pais;
        this.calle = calle;
        this.numero = numero;
        this.ciudad = ciudad;
        this.anoInauguracion = anoInauguracion;
        this.capacidad = capacidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getAnoInauguracion() {
        return anoInauguracion;
    }

    public void setAnoInauguracion(int anoInauguracion) {
        this.anoInauguracion = anoInauguracion;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getYearsOpen (){
        return Calendar.getInstance().get(Calendar.YEAR) - anoInauguracion;
    }

    @Override
    public String toString() {
        return "Aeropuerto{" +
                "nombre='" + nombre + '\'' +
                ", pais='" + pais + '\'' +
                ", calle='" + calle + '\'' +
                ", numero='" + numero + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", anoInauguracion=" + anoInauguracion +
                ", capacidad=" + capacidad +
                '}';
    }
}
