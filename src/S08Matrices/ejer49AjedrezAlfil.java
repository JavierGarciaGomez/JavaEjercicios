package S08Matrices;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ejer49AjedrezAlfil {
    static char[][] matriz = new char[8][8];



    /*
        Teniendo una matriz de char de 8x8 simular el movimiento de una un
        rey de ajedrez.
        Pudiendose moverse una posicion dentro del tablero.
        Deberas mostrar donde se encuentra en cada momento.
        Mi consejo es que uses un menú.
     */
    public static void main(String[] args) {

        final char VACIO = 'X';
        final char REY = 'O';

        rellenarMatriz(VACIO);

        int posActualReyX = 0, posAntiguaReyX = 0; // fila
        int posActualReyY = 0, posAntiguaReyY = 0; // columna

        matriz[posActualReyX][posActualReyY] = REY;

        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario

        while (!salir) {

            mostrarMatriz();

            System.out.println("¿Donde quieres moverte?");
            System.out.println("1. Mover arriba");
            System.out.println("2. Mover arriba-derecha");
            System.out.println("3. Mover derecha");
            System.out.println("4. Mover abajo-derecha");
            System.out.println("5. Mover abajo");
            System.out.println("6. Mover abajo-izquierda");
            System.out.println("7. Mover izquierda");
            System.out.println("8. Mover arriba-izquierda");
            System.out.println("9. Salir");

            try {

                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();

                // Se guarda la posición antigua
                posAntiguaReyX = posActualReyX;
                posAntiguaReyY = posActualReyY;

                switch (opcion) {
                    case 1:
                        posActualReyX--;
                        break;
                    case 2:
                        posActualReyX--;
                        posActualReyY++;
                        break;
                    case 3:
                        posActualReyY++;
                        break;
                    case 4:
                        posActualReyX++;
                        posActualReyY++;
                        break;
                    case 5:
                        posActualReyX++;
                        break;
                    case 6:
                        posActualReyX++;
                        posActualReyY--;
                        break;
                    case 7:
                        posActualReyY--;
                        break;
                    case 8:
                        posActualReyX--;
                        posActualReyY--;
                        break;
                    case 9:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 9");
                }

                // Si está dentro, rellena y cambia la antigua a vacío
                if (estaDentroMatriz(posActualReyX, posActualReyY)) {
                    matriz[posActualReyX][posActualReyY] = REY;
                    matriz[posAntiguaReyX][posAntiguaReyY] = VACIO;
                } else {
                    // si es fuera lo mantiene
                    System.out.println("Te sales de la matriz");
                    posActualReyX = posAntiguaReyX;
                    posActualReyY = posAntiguaReyY;
                }

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

    public static boolean estaDentroMatriz(int x, int y) {
        return x >= 0 && x < matriz.length && y >= 0 && y < matriz[0].length;

    }
}