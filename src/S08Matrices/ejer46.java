package S08Matrices;

public class ejer45 {

    /*
        Crea una matriz de números de 3x3 tu mismo y recorre su diagonal principal y su diagonal inversa.
     */
    public static void main(String[] args) {

        int[][] matriz=
                {
                        {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}
                };

        for(int i=0; i<matriz[0].length;i++){
            System.out.println(matriz[i][i]);
        }

        for(int i=matriz[0].length-1; i>=0;i--){
            System.out.println(matriz[i][i]);
        }

        for(int i=0, j=matriz[i].length-1; i<matriz.length; i++, j--){
            System.out.println(matriz[i][j]);
        }
    }
}
