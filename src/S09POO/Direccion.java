package S09POO;

public class Direccion {
    /*
    Mejoremos la clase Aeropuerto agrupando algunos de sus atributos en un objeto.
    Crea la clase Direccion, que tiene los siguientes atributos:
        - País
        - Calle
        - Numero
        - Ciudad
    Crea dos constructores:
        - Constructor vacio
        - Constructor completo
    Crea sus getters y setters.
    Crea también un toString
    Debes cambiar todos esos atributos de aeropuerto por direccion
 */


    private String pais;
    private String calle;
    private String numero;
    private String ciudad;

    public Direccion(String pais, String calle, String numero, String ciudad) {
        this.pais = pais;
        this.calle = calle;
        this.numero = numero;
        this.ciudad = ciudad;
    }

    @Override
    public String toString() {
        return "Direccion{" +
                "pais='" + pais + '\'' +
                ", calle='" + calle + '\'' +
                ", numero='" + numero + '\'' +
                ", ciudad='" + ciudad + '\'' +
                '}';
    }
}
