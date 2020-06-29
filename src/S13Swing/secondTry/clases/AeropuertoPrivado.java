package S13Swing.secondTry.clases;

import java.io.Serializable;

/**
 * Clase AeropuertoPrivado, heredada de Aeropuerto
 *
 * @author DiscoDurodeRoer
 */
public class AeropuertoPrivado extends Aeropuerto implements Serializable {

    private int numSocios;

    /**
     * Constructor vacio
     */
    public AeropuertoPrivado() {
        super();
    }

    /**
     * Constructor con direccion
     *
     * @param numSocios
     * @param nombre
     * @param direccion
     * @param anioInauguracion
     * @param capacidad
     */
    public AeropuertoPrivado(int numSocios, String nombre, Direccion direccion, int anioInauguracion, int capacidad) {
        super(nombre, direccion, anioInauguracion, capacidad);
        this.numSocios = numSocios;
    }

    /**
     * Constructor completo
     *
     * @param numSocios
     * @param nombre
     * @param pais
     * @param calle
     * @param numero
     * @param ciudad
     * @param anioInauguracion
     * @param capacidad
     */
    public AeropuertoPrivado(int numSocios, String nombre, String pais, String calle, int numero, String ciudad, int anioInauguracion, int capacidad) {
        super(nombre, pais, calle, numero, ciudad, anioInauguracion, capacidad);
        this.numSocios = numSocios;
    }

    /**
     * Devuelve el numero de socios
     *
     * @return numero de socios
     */
    public int getNumSocios() {
        return numSocios;
    }

    /**
     * Modifica el numero de socios
     *
     * @param numSocios nuevo numero de socios
     */
    public void setNumSocios(int numSocios) {
        this.numSocios = numSocios;
    }

    /**
     * Indica las ganancias totales. Muestra lo ganado por cada socio
     *
     * @param cantidad
     */
    @Override
    public void gananciasTotales(double cantidad) {

        double ganancia = cantidad / this.numSocios;

        System.out.println("La cantidad ganada por cada socio es de " + ganancia);

    }

    /**
     * Muestra la informacion del objeto
     *
     * @return info
     */
    @Override
    public String toString() {
        return super.toString() + " Es privado y tiene " + numSocios + " socios";
    }

}
