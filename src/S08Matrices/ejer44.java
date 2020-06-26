package S08Matrices;

import java.util.Scanner;

public class ejer44 {

    /*
        Crea una matriz de números de 3x3 tu mismo.
        Crea una función que pasandole una matriz y una fila(número)
        muestre solo esa fila.
     */
    public static void main(String[] args) {

        int[][] matriz=
                {
                        {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}
                };

        muestraFilaMatriz(matriz,1);

    }

    public static void muestraFilaMatriz(int[][] matriz, int fila) {

        if (fila >= 0 && fila < matriz.length) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.println(matriz[fila][j]);
            }
        } else {
            System.out.println("La fila no es correcta");
        }
    }
}
