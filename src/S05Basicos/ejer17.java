package S05Basicos;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ejer17 {

    /*
        Pide dos números por teclado y crea un pequeño menú con las
        siguientes opciones:

        1) Sumar
        2) Restar
        3) Multiplicar
        4) Dividir
        5) Módulo

        Al final debemos preguntar si queremos realizar otra operación
        más, en caso afirmativo, volveremos a empezar.
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean salir = false;
        int opcion, num1, num2, resultado = 0; //Guardaremos la opcion del usuario

        String respuesta;

        while (!salir) {

            System.out.println("Escribe un numero");
            num1 = sc.nextInt();

            System.out.println("Escribe un numero");
            num2 = sc.nextInt();

            System.out.println("1. Sumar");
            System.out.println("2. Restar");
            System.out.println("3. Multiplicar");
            System.out.println("4. Dividir");
            System.out.println("5. Módulo");

            try {

                System.out.println("Escribe una de las opciones");
                opcion = sc.nextInt();

                switch (opcion) {
                    case 1:

                        resultado = num1 + num2;

                        break;
                    case 2:

                        resultado = num1 - num2;

                        break;
                    case 3:

                        resultado = num1 * num2;

                        break;
                    case 4:

                        if (num2 == 0) {
                            System.out.println("No puedes dividir entre 0");
                        } else {

                            double div = (double) num1 / num2;
                            System.out.println("El resultado es " + div);

                        }

                        break;
                    case 5:

                        resultado = num1 % num2;

                        break;
                    default:
                        System.out.println("Solo números entre 1 y 5");
                }

                if (opcion != 4) {
                    System.out.println("El resultado es " + resultado);
                }

            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sc.next();
            }

            System.out.println("¿Quieres continuar? (S/N)");
            respuesta = sc.next().toLowerCase().trim();

            if (respuesta.charAt(0) == 'n') {
                salir = true;
            }

        }
    }

}

