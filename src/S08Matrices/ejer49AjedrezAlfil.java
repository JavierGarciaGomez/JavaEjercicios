package S08Matrices;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ejer49AjedrezAlfil {
    static char[][] matriz = new char[8][8];

    /*
        Teniendo una matriz de char de 8x8 simular el movimiento de una un
        alfil de ajedrez.
        Pudiendose moverse en diagonal dentro del tablero.
        Deberas mostrar donde se encuentra en cada momento.
        Su posicion inicial sera aleatoria.
        Mi consejo es que uses un menú.
     */
    public static void main(String[] args) {

        final char VACIO = 'X';
        final char ALFIL = 'O';

        int posActualAlfilX = generaPosicionAleatoria();
        int posActualAlfilY = generaPosicionAleatoria();
        int posAntiguaAlfilX = 0, posAntiguaAlfilY = 0;
        int dirX = 0, dirY = 0, numPosiciones;


        rellenarMatriz(VACIO);


        matriz[posActualAlfilX][posActualAlfilY] = ALFIL;

        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario

        while (!salir) {

            mostrarMatriz();

            System.out.println("¿Donde quieres moverte?");
            System.out.println("1. Mover arriba-derecha");
            System.out.println("2. Mover abajo-derecha");
            System.out.println("3. Mover abajo-izquierda");
            System.out.println("4. Mover arriba-izquierda");
            System.out.println("5. Salir");

            try {

                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();

                // Se guarda la posición antigua
                posAntiguaAlfilX = posActualAlfilX;
                posAntiguaAlfilY = posActualAlfilY;

                switch (opcion) {
                    case 1:
                        dirX = -1;
                        dirY = 1;
                        break;
                    case 2:
                        dirX = 1;
                        dirY = 1;
                        break;
                    case 3:
                        dirX = 1;
                        dirY = -1;
                        break;
                    case 4:
                        dirX = -1;
                        dirY = -1;
                        break;
                    case 5:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 5");
                }

                while (estaDentroMatriz(posActualAlfilX + dirX, posActualAlfilY + dirY)) {
                    posActualAlfilX += dirX;
                    posActualAlfilY += dirY;
                }

                matriz[posAntiguaAlfilX][posAntiguaAlfilY] = VACIO;
                matriz[posActualAlfilX][posActualAlfilY] = ALFIL;


            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }

    }

    public static void mostrarMatriz() {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static void rellenarMatriz(char simbolo) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                matriz[i][j] = simbolo;
            }
        }
    }

    private static int generaPosicionAleatoria() {
        return (int) (Math.random() * (matriz.length - 0 + 1));
    }


    public static boolean estaDentroMatriz(int x, int y) {
        return x >= 0 && x < matriz.length && y >= 0 && y < matriz[0].length;

    }
}