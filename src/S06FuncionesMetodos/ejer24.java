package S06FuncionesMetodos;

import java.util.Scanner;

public class ejer24 {
    public static void main(String[] args) {
        System.out.println("Escribe el número que quieras pasar a octal");
        int num = new Scanner(System.in).nextInt();
        System.out.println(convertToOCtal(num));

    }

    private static int convertToOCtal(int num) {
        int octal = 0;
        int digito;

        final int DIVISOR = 8;

        for(int i=num, j=0; i>0; i/=DIVISOR,j++){
            digito= i% DIVISOR;
            octal += digito*Math.pow(10,j);
            System.out.println("valores de i, j, digito y octal " + i+" "+j+" "+digito+" "+octal);

        }
        return octal;
    }

}
