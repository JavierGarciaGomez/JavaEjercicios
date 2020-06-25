package S05Basicos;

import java.util.Scanner;

public class ejer13 {
    /*Pide una frase o palabra por consola e inviértela*/
    public static void main(String[] args) {
        System.out.println("Escribe una frase o palabra");
        String cadena = new Scanner(System.in).nextLine();
        String newCadena ="";

        for (int i = cadena.length()-1; i >= 0 ; i--) {
            newCadena=newCadena.concat(String.valueOf(cadena.charAt(i)));
        }
        System.out.println("Esta es tu cadena invertida: "+newCadena);

    }
}
