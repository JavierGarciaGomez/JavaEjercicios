package S11Ficheros;

import java.io.*;
import java.util.Scanner;

public class ejer73_76 {
    private static Exception myException;

    public static void main(String[] args) {
        /*73 Pide un texto por consola y escribe un fichero de texto. Usa BufferedWriter*/
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("res\\texto.txt",true));
             BufferedReader bufferedReader = new BufferedReader(new FileReader("res\\texto.txt"));
        ){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Escribe un texto");
            bufferedWriter.write("\n"+scanner.nextLine());
            bufferedWriter.close();

            /*74 lee un fichero*/
            /*75 cuenta lineas*/
            System.out.println("******************74***************");
            String texto;
            int counter=0;
            while((texto=bufferedReader.readLine())!=null){
                counter++;
                System.out.println(texto);
            }
            System.out.println("******************75***************");
            System.out.println("El fichero tiene "+counter+" líneas");

            /*76 lee hasta una línea en específico*/
            System.out.println("******************76***************");
            System.out.println("Hasta que línea quieres leer?");
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader("res\\texto.txt"));
            int lineaMax = Integer.parseInt(scanner.nextLine());
            try{
                if(lineaMax<0||lineaMax>counter) throw myException;
                counter=0;
                texto="";
                while(counter<=lineaMax){
                    texto=bufferedReader2.readLine();
                    counter++;
                    System.out.println(texto);
                }
            }catch(Exception myException){
                System.out.println("Lanzada la excepción");
            }

            /*77 obtén el número mayor y menor*/
            System.out.println("******************77***************");
            int numMin=Integer.MAX_VALUE;
            int numMax=Integer.MIN_VALUE;

            bufferedReader2 = new BufferedReader(new FileReader("res\\num.txt"));
            int numAux;

            while((texto=bufferedReader2.readLine())!=null){
                numAux=Integer.parseInt(texto);
                numMax=numMax>numAux?numMax:numAux;
                numMin=numMin<numAux?numMin:numAux;
            }
            System.out.println("De la lista, el número mayor es: "+numMax+". Y el menor es: "+numMin);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
