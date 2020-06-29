package S13Swing.secondTry.utilidades;

import S13Swing.secondTry.clases.Aeropuerto;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MetodosSueltos {

    /**
     * Rellena los aeropuertos del fichero de datos en la lista
     */
    public static void leerAeropuertos() {

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(VariablesGlobales.FICHERO_AEROPUERTOS))) {

            while (true) {
                Aeropuerto a = (Aeropuerto) ois.readObject();
                VariablesGlobales.aeropuertos.add(a);
            }

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (EOFException e) {
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Escribe un aeropuerto en la lista y en el fichero
     *
     * @param a
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static void escribirAeropuerto(Aeropuerto a) throws FileNotFoundException, IOException {

        File f = new File(VariablesGlobales.FICHERO_AEROPUERTOS);

        if (f.exists()) {
            MiObjectOutputStream oos = new MiObjectOutputStream(new FileOutputStream(VariablesGlobales.FICHERO_AEROPUERTOS,true));
            oos.writeObject(a);
            oos.close();
        } else {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(VariablesGlobales.FICHERO_AEROPUERTOS));
            oos.writeObject(a);
            oos.close();
        }

        VariablesGlobales.aeropuertos.add(a);

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
