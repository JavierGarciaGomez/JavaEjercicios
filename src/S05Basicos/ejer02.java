package S05Basicos;

import java.util.Scanner;

public class ejer02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");

        System.out.println("Escribe tu nombre");
        String nombre = scanner.nextLine();
        System.out.println("Tu nombre es: "+nombre);
    }
}
