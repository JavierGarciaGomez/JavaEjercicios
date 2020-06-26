package S10EstructurasDinamicas;

/*
    Crea una clase Avion con los siguientes atributos:
        - Modelo
        - Numero de asientos
        - Velocidad maxima
    Dos constructores:
        - Constructor vacio
        - Constructor completo
    Métodos o propiedades:
        - Getter y setter
        - toString()
 */

public class Avion implements Activable {
    private String modelo;
    private int nAsientos;
    private double velocidadMaxina;
    private boolean isActivado;

    public Avion() {
    }

    public Avion(String modelo, int nAsientos, double velocidadMaxina) {
        this.modelo = modelo;
        this.nAsientos = nAsientos;
        this.velocidadMaxina = velocidadMaxina;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getnAsientos() {
        return nAsientos;
    }

    public void setnAsientos(int nAsientos) {
        this.nAsientos = nAsientos;
    }

    public double getVelocidadMaxina() {
        return velocidadMaxina;
    }

    public void setVelocidadMaxina(double velocidadMaxina) {
        this.velocidadMaxina = velocidadMaxina;
    }

    @Override
    public String toString() {
        return "Avion{" +
                "modelo='" + modelo + '\'' +
                ", nAsientos=" + nAsientos +
                ", velocidadMaxina=" + velocidadMaxina +
                '}';
    }

    @Override
    public boolean isActivado() {
        return this.isActivado;
    }

    @Override
    public void setActivado(boolean value) {
        this.isActivado= value;
    }
}
