package S17JavaFX.ejer114_121.Controller;

import S17JavaFX.ejer114_121.Model.*;
import S17JavaFX.ejer114_121.Utilities.*;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class ActivateAirplaneController implements Initializable {

    @FXML
    private ComboBox<Aeropuerto> cmbAeropuertos;
    @FXML
    private ComboBox<Avion> cmbAviones;
    @FXML
    private Button btnActualizar, btnCancelar;
    @FXML
    private RadioButton rdbActivado, rdbDesactivado;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {
            ToggleGroup toggle = new ToggleGroup();
            this.rdbActivado.setToggleGroup(toggle);
            this.rdbDesactivado.setToggleGroup(toggle);
            ObservableList<Aeropuerto> obs = MetodosSueltos.loadAirports();
            this.cmbAeropuertos.setItems(obs);
        } catch (SQLException ex) {
            showAlert(Alert.AlertType.ERROR, "Error", ex.getMessage());
        }
    }

    @FXML
    private void cargarAviones(ActionEvent event) {
        Aeropuerto a = this.cmbAeropuertos.getValue();
        if (a != null) {
            try {
                Avion avion = new Avion();
                avion.setIdAeropuerto(a.getId());
                ObservableList<Avion> obs = avion.getAviones();
                this.cmbAviones.setItems(obs);
            } catch (SQLException ex) {
                showAlert(Alert.AlertType.ERROR, "Error", ex.getMessage());
            }
        }
    }

    @FXML
    private void seleccionarActivado(ActionEvent event) {

        // Cojo el avion
        Avion a = this.cmbAviones.getValue();

        // Indico visualmente si esta o no activado
        if (a.isActivado()) {
            this.rdbActivado.setSelected(true);
        } else {
            this.rdbDesactivado.setSelected(true);
        }
    }

    @FXML
    private void actualizarAvion(ActionEvent event) {
        Avion a = this.cmbAviones.getValue();
        if (a == null) {
            showAlert(Alert.AlertType.ERROR, "Error", "Debes seleccionar un avión");
        } else {
            try {
                a.setActivado(this.rdbActivado.isSelected());
                if (a.actualizar()) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setTitle("Exito");
                    alert.setContentText("Se ha actualizado el avion");
                    alert.showAndWait();
                } else {
                    showAlert(Alert.AlertType.ERROR, "Error", "No se ha actualizado el avión");
                }
            } catch (SQLException ex) {
                showAlert(Alert.AlertType.ERROR, "Error", "Debes seleccionar un avión");
            }
        }
    }

    @FXML
    private void cancelar(ActionEvent event) {
        Stage myStage = (Stage) this.btnActualizar.getScene().getWindow();
        myStage.close();
    }

    public void showAlert(Alert.AlertType alertType, String title, String contentText) {
        Alert alert = new Alert(alertType);
        alert.setHeaderText(null);
        alert.setTitle(title);
        alert.setContentText(contentText);
        alert.showAndWait();
    }


}
