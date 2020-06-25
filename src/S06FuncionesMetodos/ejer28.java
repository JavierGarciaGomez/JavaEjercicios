package S06FuncionesMetodos;

import java.util.Scanner;
/*Crea una función que dado dos parámetros, siendo el primero un String y el segundo un boolean,
* cuente las letras en min o may, según el valor del segundo parámetro
* true=may; false=min
* */

public class ejer28 {
    public static void main(String[] args) {
        String string = "Hola, ¿Cómo estás?";
        System.out.println(string+" tiene "+cuentaLetras(string,true)+" mayúsculas, y "+
                cuentaLetras(string,false)+" minúsculas.");
    }

    private static int cuentaLetras (String string, boolean mayus) {
        int mayusc=0;
        int minusc=0;
        for (int i = 0; i <string.length() ; i++) {
            char c=string.charAt(i);
            if(c>=65&&c<=90) mayusc++;
            else if(c>=97&&c<=122) minusc++;
        }
        if(mayus) return mayusc;
        else return minusc;
    }

}
