package S07Arrays;

import java.util.Arrays;

/*Dado un array de números indica el elemento más repetido*/

public class ejer39 {
    public static void main(String[] args) {
        int[] numeros = {5, 2, 3, 4, 7,5,2,2,2,2,2,1};

        int num=0;
        int numAux=0;
        int counter=0;
        int counterAux=0;

        for (int i = 0; i < numeros.length; i++) {
            numAux=numeros[i];
            counterAux=0;
            for (int j = 0; j < numeros.length; j++) {
                if(numAux==numeros[j]) counterAux++;
            }
            if(counterAux>counter) {
                num=numAux;
                counter=counterAux;
            }
        }
        System.out.println("El número con más repeticiones es: "+num+" con "+counter+" repeticiones.");


    }

}