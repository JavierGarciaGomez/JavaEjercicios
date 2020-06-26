package S09POO;

public class AeropuertoPublico extends Aeropuerto{
    double financiacionAnual;
    int numTrabajadoresDiscapacitados;

    public AeropuertoPublico(String nombre, Direccion direccion, int anoInauguracion,
                             int capacidad, double financiacionAnual, int numTrabajadoresDiscapacitados) {
        super(nombre, direccion, anoInauguracion, capacidad);
        this.financiacionAnual = financiacionAnual;
        this.numTrabajadoresDiscapacitados = numTrabajadoresDiscapacitados;
    }

    public double getFinanciacionAnual() {
        return financiacionAnual;
    }

    public void setFinanciacionAnual(double financiacionAnual) {
        this.financiacionAnual = financiacionAnual;
    }

    public int getNumTrabajadoresDiscapacitados() {
        return numTrabajadoresDiscapacitados;
    }

    public void setNumTrabajadoresDiscapacitados(int numTrabajadoresDiscapacitados) {
        this.numTrabajadoresDiscapacitados = numTrabajadoresDiscapacitados;
    }



    @Override
    public String toString() {
        return "AeropuertoPublico{" +
                "financiacionAnual=" + financiacionAnual +
                ", numTrabajadoresDiscapacitados=" + numTrabajadoresDiscapacitados +
                "} " + super.toString();
    }

    @Override
    public void calculaGananciaTotal(double cantidadGanada) {
        cantidadGanada+=cantidadGanada+financiacionAnual+(100*numTrabajadoresDiscapacitados);
        System.out.println("la cantidad ganada del aeropuerto "+this.getNombre()+" es de "+cantidadGanada);
    }
}
