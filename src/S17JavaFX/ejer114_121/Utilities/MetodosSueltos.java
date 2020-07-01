package S17JavaFX.ejer114_121.Utilities;

import S17JavaFX.ejer114_121.Model.Aeropuerto;
import S17JavaFX.ejer114_121.Model.AeropuertoPrivado;
import S17JavaFX.ejer114_121.Model.AeropuertoPublico;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public class MetodosSueltos {

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

    public static ObservableList<Aeropuerto> loadAirports() throws SQLException {
        ObservableList<Aeropuerto> aeropuertos = FXCollections.observableArrayList();
        AeropuertoPublico aeropuertoPublico = new AeropuertoPublico();
        AeropuertoPrivado aeropuertoPrivado = new AeropuertoPrivado();

        ObservableList<AeropuertoPublico> aeropuertosPublicos = aeropuertoPublico.getAeropuertos("");
        ObservableList<AeropuertoPrivado> aeropuertoPrivados = aeropuertoPrivado.getAeropuertos("");

        for(Aeropuerto a: aeropuertoPrivados){
            aeropuertos.add(a);
        }

        for(Aeropuerto a: aeropuertosPublicos){
            aeropuertos.add(a);
        }

        return aeropuertos;
    }

}
