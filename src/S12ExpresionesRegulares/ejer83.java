package S12ExpresionesRegulares;

public class ejer83 {
    /*
    Validar si una cadena es un numero entero.
 */
    public static void main(String[] args) {

        if(validaNumeroEntero_Exp("10")){
            System.out.println("correcto");
        }else{
            System.out.println("no correcto");
        }

    /*
        Validar si una cadena es un numero real.
     */
        if(validaNumeroReal_Exp("-10.55")){
            System.out.println("correcto");
        }else{
            System.out.println("no correcto");
        }


    }

    /**
     * Valida si una cadena es un numero entero
     *
     * @param texto String que contiene el valor a validar
     * @return True = es un numero entero
     */
    public static boolean validaNumeroEntero_Exp(String texto) {
        return texto.matches("^-?[0-9]+$");
    }

    /**
     * Valida si una cadena es un numero real (positivo o negativo)
     *
     * @param texto String que contiene el valor a validar
     * @return True = es un numero real
     */
    public static boolean validaNumeroReal_Exp(String texto) {
        return texto.matches("^-?[0-9]+([\\.,][0-9]+)?$");
    }
}