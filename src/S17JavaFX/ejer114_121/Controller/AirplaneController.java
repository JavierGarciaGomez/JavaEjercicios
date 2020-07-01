package S17JavaFX.ejer114_121.Controller;

import S17JavaFX.ejer114_121.Model.*;
import S17JavaFX.ejer114_121.Utilities.*;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AirplaneController implements Initializable {
    @FXML
    TextField txtModel, txtSeats, txtMaxSpeed;

    @FXML
    Button btnRegister, btnCancel;

    @FXML
    CheckBox chkActivated;

    @FXML
    ComboBox<Aeropuerto> cmbAirport;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            ObservableList<Aeropuerto> aeropuertos = null;
            aeropuertos = MetodosSueltos.loadAirports();
            this.cmbAirport.setItems(aeropuertos);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void register(ActionEvent event) {
        String errores = "";
        String modelo = this.txtModel.getText();
        boolean activado = this.chkActivated.isSelected();
        if (!MetodosSueltos.validaNumeroEntero_Exp(this.txtSeats.getText())) errores += "- Debes insertar un numero en los asientos\n";
        if (!MetodosSueltos.validaNumeroEntero_Exp(this.txtMaxSpeed.getText())) errores += "- Debes insertar un numero en la velocidad maxima\n";
        if (this.cmbAirport.getValue() == null) errores += "- Debes seleccionar un aeropuerto\n";

        if (errores.isEmpty()) {
            try {
                Aeropuerto a = this.cmbAirport.getValue();
                int nAsientos = Integer.parseInt(this.txtSeats.getText());
                int velMax = Integer.parseInt(this.txtMaxSpeed.getText());
                Avion avion = new Avion(modelo, nAsientos, velMax, a.getId());
                avion.setActivado(activado);
                if (avion.insertar()) {
                    showAlert(Alert.AlertType.INFORMATION, "Éxito", "Se ha insertado el avión");
                } else {
                    showAlert(Alert.AlertType.ERROR, "Error", "No se ha insertado el avión");
                }
            } catch (SQLException ex) {
                showAlert(Alert.AlertType.ERROR, "Error", ex.getMessage());            }

        } else {
            showAlert(Alert.AlertType.ERROR, "Error", errores);
        }

    }



    public void cancel(ActionEvent event) {
    }

    public void showAlert(Alert.AlertType alertType, String title, String contentText) {
        Alert alert = new Alert(alertType);
        alert.setHeaderText(null);
        alert.setTitle(title);
        alert.setContentText(contentText);
        alert.showAndWait();
    }
}


