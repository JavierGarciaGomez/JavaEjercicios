package S05Basicos;

public class ejer05 {
    /*Mostrar los números pares que hay entre 1 y 10 con while y for*/
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            if(i%2==0){
                System.out.println(i+" es un número par");
            }
        }

        int i=0;
        while(i<=10){
            i++;
            if(i%2==0){
                System.out.println(i+" es un número par");
            }
        }
    }

}
