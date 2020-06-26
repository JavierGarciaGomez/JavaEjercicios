package S10EstructurasDinamicas;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
    Llegamos al ejercicio final de esta sección
    Crearemos un menú con las siguientes opciones:
       - Añadir Aeropuerto: nos pedira los datos de un aeropuerto.
            También si es privado o publico, pidiendo los datos concretos de cada uno.
       - Añadir Avion: pide los datos para añadir un avion.
            Pide a que aeropuerto que pertence
       - Mostrar info de Aeropuerto: pide un aeropuerto y muestra su info.
       - Mostrar años que lleva abierto un aeropuerto: pide un aeropuerto
            y muestra los años que lleva abierto
       - Mostrar ganancias de un aeropuerto: pide un aeropuerto y una cantidad
            y muestra sus ganancias finales.
       - Salir: Sale del programa
*/
public class GestionAeropuertos {

    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Aeropuerto> aeropuertos = new ArrayList<>();

    public static void main(String[] args) {
        AeropuertoPrivado aeropuertoPrivado = new AeropuertoPrivado("AICM",
                new Direccion("México", "Avenida Aviación", "23", "Ciudad de México"),
                1959, 10000, 10);
        aeropuertos.add(aeropuertoPrivado);

        boolean exit = false;

        while (!exit) {
            printOptciones();
            int option=validaNumero("Selecciona una opción");
            option = Integer.parseInt(scanner.nextLine());
            switch (option) {
                case 1:
                    anadirAeropuerto();
                    break;
                case 2:
                    anadirAvion();
                    break;
                case 3:
                    infoAirport();
                    break;
                case 4:
                    mostrarAniosAbierto();
                    break;
                case 5:
                    mostrarGanancias();
                    break;
                case 6:
                    System.out.println("\n Gracias. Hasta luego");
                    exit = true;
                    break;
                default:
                    System.out.println("Solo se aceptan números del 1 al 6");
                    break;
            }

        }
    }

    public static void printOptciones() {
        System.out.println("1. Añadir Aeropuerto");
        System.out.println("2. Añadir Avion");
        System.out.println("3. Mostrar info de Aeropuerto");
        System.out.println("4. Mostrar años que lleva abierto un aeropuerto");
        System.out.println("5. Mostrar ganancias de un aeropuerto");
        System.out.println("6. Salir");
    }

    private static void anadirAeropuerto() {
        String nombre, naturaleza;
        int anoInauguracion, capacidad, numTrabajadoresDiscapacitados, numSocios;
        double financiacionAnual;

        System.out.println("Teclea el nombre del aeropuerto");
        nombre = scanner.nextLine();
        while (true) {
            System.out.println("¿Es un aeropuerto público (pub) o privado (pri)");
            naturaleza = scanner.nextLine();
            if (naturaleza.equals("pub") | naturaleza.equals("pri")) break;
            else System.out.println("Solo es válido pub o pri");
        }
        anoInauguracion = validaNumero("¿En qué año fue inaugurado?");
        capacidad = validaNumero("¿Qué capacidad tiene?");

        if (naturaleza.equals("pub")) {
            System.out.println("¿Cuál es la financiación anual recibida?");
            financiacionAnual = Double.parseDouble(scanner.nextLine());

            numTrabajadoresDiscapacitados = validaNumero("¿Cuál es el número de trabajadores discapacitados?");

            AeropuertoPublico aeropuertoPublico = new AeropuertoPublico(nombre, null, anoInauguracion,
                    capacidad, financiacionAnual, numTrabajadoresDiscapacitados);
            System.out.println("Has creado un aeropuerto con los siguientes datos: " + aeropuertoPublico);
            aeropuertos.add(aeropuertoPublico);
        } else {
            numSocios = validaNumero("¿Cuál es el número de socios?");

            AeropuertoPrivado aeropuertoPrivado = new AeropuertoPrivado(nombre, null, anoInauguracion,
                    capacidad, numSocios);
            System.out.println("Has creado un aeropuerto con los siguientes datos: " + aeropuertoPrivado);
            aeropuertos.add(aeropuertoPrivado);
        }
    }


    private static void anadirAvion() {
        String modelo, nombreAeropuerto;
        int numAsientos, velocidadMaxima;
        System.out.println("Modelo del avión");
        modelo = scanner.nextLine();
        numAsientos=validaNumero("Número de asientos del avión");
        velocidadMaxima=validaNumero("Velocidad máxima del avión");
        Avion avion = new Avion(modelo, numAsientos, velocidadMaxima);
        System.out.println("Se ha creado un avión con los siguientes datos " + avion.toString());

        Aeropuerto aeropuerto = askForAnAirport("¿A qué aeropuerto quieres agregar este avión?");
        aeropuerto.addAvion(avion);
    }

    private static void infoAirport() {
        Aeropuerto aeropuerto = askForAnAirport("De qué aeropuerto deseas conocer su información");
        System.out.println(aeropuerto);
    }

    private static void mostrarAniosAbierto() {
        Aeropuerto aeropuerto = askForAnAirport("De qué aeropuerto deseas conocer los años que lleva abierto");
        System.out.println(aeropuerto.calculaAnosApertura());
    }

    private static void mostrarGanancias() {
        Aeropuerto aeropuerto = askForAnAirport("De qué aeropuerto deseas conocer su información");
        System.out.println("Cuáles son sus ganancias anuales");
        double ganancias = Double.parseDouble(scanner.nextLine());
        aeropuerto.calculaGananciaTotal(ganancias);
    }


    private static void printAirports() {
        for (Aeropuerto aeropuerto : aeropuertos) System.out.println(aeropuerto.getNombre());
    }

    private static Aeropuerto askForAnAirport(String pregunta) {
        String nombreAeropuerto;
        boolean existAirport = false;
        Aeropuerto aeropuerto = null;
        while (!existAirport) {
            System.out.println(pregunta);
            printAirports();
            nombreAeropuerto = scanner.nextLine();
            for (Aeropuerto a : aeropuertos) {
                if (a.getNombre().equals(nombreAeropuerto)) {
                    aeropuerto = a;
                    existAirport = true;
                    break;
                } else System.out.println("Lo lamento ese aeropuerto no está registrado");
            }
        }
        return aeropuerto;
    }

    public static int validaNumero(String pregunta) {
        int numero = 0;
        while (true) {
            System.out.println(pregunta);
            String texto = scanner.nextLine();
            try {
                numero = Integer.parseInt(texto);
                break;
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Solo se aceptan números");
            }
        }
        return numero;
    }

}