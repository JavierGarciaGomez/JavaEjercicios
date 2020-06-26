package S10EstructurasDinamicas;

/**
 * @author Javier García
 * Clase Aeropuerto
 */

import java.util.ArrayList;
import java.util.Calendar;

public abstract class Aeropuerto implements Comparable<Aeropuerto>{
    private String nombre;
    private Direccion direccion;
    private int anoInauguracion;
    private int capacidad;
    private ArrayList <Avion> aviones;
    private static int numAeropuertos =0;
    private int id;

    /**
     * Constructor vacío
     */

    public Aeropuerto() {
        id=numAeropuertos;
        numAeropuertos++;
    }

    /**
     * Constructor completo
     * @param nombre
     * @param direccion
     * @param anoInauguracion
     * @param capacidad
     */

    public Aeropuerto(String nombre, Direccion direccion, int anoInauguracion, int capacidad) {
        this();
        this.nombre = nombre;
        this.direccion = direccion;
        this.anoInauguracion = anoInauguracion;
        this.capacidad = capacidad;
        this.aviones=new ArrayList<>();
    }

    /**
     * getter
     * @return
     */
    public int getNumAviones(){
        return aviones.size();
    }

    public int getId() {
        return id;
    }


    public String getNombre() {
        return nombre;
    }


    /**
     * Agrega un avion
     * @param avion
     */
    public void addAvion(Avion avion){
        this.aviones.add(avion);
    }

    /**
     * Imprime la lista de aviones
     */
    public void printAviones (){
        for (Avion a: aviones) {
            System.out.println("Avión modelo "+a.getModelo());
        }
    }



    public int getAnoInauguracion() {
        return anoInauguracion;
    }

    public final int calculaAnosApertura(){
        return Calendar.getInstance().get(Calendar.YEAR)-this.getAnoInauguracion();
    }

    public static int getNumAeropuertos() {
        return numAeropuertos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Aeropuerto that = (Aeropuerto) o;

        return id == that.id;
    }

    public abstract void calculaGananciaTotal(double cantidadGanada);


    @Override
    public int compareTo(Aeropuerto o) {
        if(this.anoInauguracion>o.getAnoInauguracion()) return 1;
        else if(this.anoInauguracion<o.getAnoInauguracion()) return -1;
        else return 0;

    }

    @Override
    public String toString() {
        return "Aeropuerto{" +
                "nombre='" + nombre + '\'' +
                ", direccion=" + direccion +
                ", anoInauguracion=" + anoInauguracion +
                ", capacidad=" + capacidad +
                ", aviones=" + aviones +
                ", id=" + id +
                '}';
    }
}
