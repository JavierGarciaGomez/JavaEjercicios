package S09POO;



public class Main {
    public static void main(String[] args) {
        // 53
        System.out.println("***********53***************");
        Avion avion = new Avion();
        Avion avion1 = new Avion("Boeing", 100, 200.25);
        System.out.println(avion);
        System.out.println(avion1);

        //54
        System.out.println("***********54***************");
        AeropuertoOld aeropuertoOld = new AeropuertoOld("AICM", "México", "Aviación", "SN",
                "Ciudad de México", 1970, 30000);
        System.out.println(aeropuertoOld);
        System.out.println("El aeropuertoOld "+aeropuertoOld.getNombre()+" lleva "+aeropuertoOld.getYearsOpen()+" años abierto.");
        //55
        System.out.println("***********55***************");
        Aeropuerto aeropuerto = new AeropuertoPrivado("AICM", new Direccion("México", "Aviación", "SN",
                "Ciudad de México"), 1970, 30000,12);
        System.out.println(aeropuerto);

        /*56. Asocia el aeropuerto con el avión mediante una asociación.
        Un aeropuerto tiene uno o varios aviones.
        Añadiremos también una función:
        - aniadirAvion(Avion a)
        Te recomiendo crear un atributo más llamado numero de aviones.
         */
        System.out.println("***********56***************");
        aeropuerto.addAvion(avion);
        aeropuerto.addAvion(avion1);
        aeropuerto.addAvion(new Avion("Modelo 2", 2000, 3000));
        aeropuerto.addAvion(new Avion("Modelo 3", 2000, 3000));
        System.out.println("El aeropuerto "+aeropuerto.getNombre()+" tiene "+aeropuerto.getNumAviones()+
                ", enlistados a continuación:");
        aeropuerto.printAviones();


        /*
            57
            Añade al aeropuerto un atributo estático llamado id_autonumerado, cada vez que
            creamos un objeto aumentaremos en uno ese id.
         */
        System.out.println("***********57***************");
        Aeropuerto aeropuerto1 = new AeropuertoPrivado("aeropuerto 1", null, 2000, 0,10);
        Aeropuerto aeropuerto2 = new AeropuertoPrivado("aeropuerto 2", null, 1940, 0,12);
        Aeropuerto aeropuerto3 = new AeropuertoPrivado("aeropuerto 3", null, 2020, 0,2);
        System.out.println("El número de aeropuertos instanciados es de: "+Aeropuerto.getNumAeropuertos());
        System.out.println("El id del aeropuerto 2 es "+aeropuerto2.getId());

        /*
        58
        Añade las funciones equals y compareTo en aeropuerto.
        Dos aeropuertos son iguales cuando el id es igual.
        Un aeropuerto es mayor que otro cuanto más actual es.
        Es decir, si el aeropuerto 1 tiene el año de inauguración 2000 y
        el aeropuerto 2 tiene el año de inauguración 1940, el mayor es el
        primer aeropuerto.*/
        System.out.println("***********58***************");
        if(aeropuerto.equals(aeropuerto2)) System.out.println("Es el mismo aeropuerto");
        else System.out.println("No es el mismo aeropuerto");

        Aeropuerto aeropuerto4 = aeropuerto;

        if(aeropuerto.equals(aeropuerto4)) System.out.println("Es el mismo aeropuerto");
        else System.out.println("No es el mismo aeropuerto");

        comparaAeropuertos(aeropuerto, aeropuerto1);
        comparaAeropuertos(aeropuerto, aeropuerto2);
        comparaAeropuertos(aeropuerto, aeropuerto3);

        /*59 mejora constructores*/

        /*60 Herencia: aeropuerto público*/
        System.out.println("***********60***************");
        AeropuertoPublico aeropuertoPublico = new AeropuertoPublico("Aeropuerto Público 1",
                null, 1950, 1000, 2400000, 49);
        System.out.println(aeropuertoPublico);
        comparaAeropuertos(aeropuerto, aeropuertoPublico);

        /*61 Herencia: aeropuerto privado*/
        System.out.println("***********61***************");
        AeropuertoPrivado aeropuertoPrivado = new AeropuertoPrivado("Aeropuerto Privado 1", null,
                1950, 1000, 20);
        System.out.println(aeropuertoPrivado);

        /*62 Polimorfismo*/
        /* 63
            Haremos la clase Aeropuerto abstracta.
            Crearemos un método abstracto llamado gananciasTotales, pasandole
            la cantidad ganada.
            Según la clase, hará una accion u otra:
                - AeropuertoPublico: se le suma la financiacion y una bonificación
                de 100 por cada trabajador discapacitado. Muestra el total ganado.
                - AeropuertoPrivado: se divide la ganancia entre el número de socios.
                Muestra lo que gana cada socio.
        */
        System.out.println("***********63***************");
        aeropuerto.calculaGananciaTotal(10000);
        aeropuertoPublico.calculaGananciaTotal(10000);

        /* 64 Final para métodos y clases. */
        /* 65 Interfaces
            Crea la interfaz Activable para la clase Avion, que nos indique si
            esta preparado para volar o no.

            Tendrá los siguientes métodos:
               - isActivado()
               - setActivado(boolean value)

            Añade un atributo a la clase Avion llamado activado y modifica el método
            mostrar aviones para que solo se muestren aquellos que están activos.
         */
        avion.isActivado();

        /* 66 Agrega JAvadoc al proyecto*/

        /* 67 Gestion Aeropuertos*/



    }

    private static void comparaAeropuertos(Aeropuerto aeropuerto, Aeropuerto aeropuerto1) {
        String cadena;
        cadena=aeropuerto.compareTo(aeropuerto1)==1?" es más MODERNO":" es más ANTIGUO";

        System.out.println("El aeropuerto "+aeropuerto.getNombre()+" de "+aeropuerto.getAnoInauguracion()+
                cadena+" que el aeropuerto "+aeropuerto1.getNombre()+" de "+aeropuerto1.getAnoInauguracion());
    }
}
