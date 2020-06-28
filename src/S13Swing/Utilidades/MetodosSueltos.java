package S13Swing.Utilidades;

import S13Swing.clases.Aeropuerto;

import java.io.*;

public class MetodosSueltos {
    public static void leerAeropuertos(){
        try (ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream(VariablesGlobales.FICHERO_AEROPUERTS))){
            while(true){
                Aeropuerto aeropuerto = (Aeropuerto) objectInputStream.readObject();
                VariablesGlobales.aeropuertos.add(aeropuerto);
                System.out.println(aeropuerto);
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void escribirAeropuerto(Aeropuerto aeropuerto) throws IOException {
        File file = new File(VariablesGlobales.FICHERO_AEROPUERTS);
        if(file.exists()){
            MiObjectOutputStream miObjectOutputStream = new MiObjectOutputStream(new FileOutputStream(file));
            miObjectOutputStream.writeObject(aeropuerto);
            miObjectOutputStream.close();
        } else{
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
            objectOutputStream.writeObject(aeropuerto);
            objectOutputStream.close();
        }
        VariablesGlobales.aeropuertos.add(aeropuerto);
    }
}
