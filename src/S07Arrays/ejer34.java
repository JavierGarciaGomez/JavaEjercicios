package S07Arrays;

import java.util.Arrays;

public class ejer34 {
    public static void main(String[] args) {
        int [] numeros1 = {5,2,3,4};
        int [] numeros2 = {2,3,4};
        int [] numeros3={5,2,3,4};

        comparaArrays(numeros1, numeros2);
        comparaArrays(numeros1, numeros3);

        // otro mecanismo
        if(Arrays.equals(numeros1,numeros2));

    }

    private static void comparaArrays(int[] numeros1, int[] numeros2) {
        boolean sonIguales = true;
        if(numeros1.length!=numeros2.length){
            sonIguales=false;
        } else{
            for (int i = 0; i < numeros1.length; i++) {
                if (numeros1[i]!=numeros2[i]){
                    sonIguales=false;
                    break;
                }
            }
        }

        if(sonIguales) System.out.println("Son iguales");
        else System.out.println("No son iguales");
    }
}
