package S09POO;

public class AeropuertoPrivado extends Aeropuerto{
    int numSocios;

    public AeropuertoPrivado(String nombre, Direccion direccion, int anoInauguracion, int capacidad, int numSocios) {
        super(nombre, direccion, anoInauguracion, capacidad);
        this.numSocios = numSocios;
    }

    @Override
    public String toString() {
        return "AeropuertoPrivado{" +
                "numSocios=" + numSocios +
                "} " + super.toString();
    }

    @Override
    public void calculaGananciaTotal(double cantidadGanada) {
        cantidadGanada+=cantidadGanada/numSocios;
        System.out.println("la cantidad ganada por cada socio del aeropuerto "+this.getNombre()+" es de "+cantidadGanada);
    }
}
