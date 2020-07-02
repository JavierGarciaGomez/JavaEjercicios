package S17JavaFX.ejer114_121.Controller;

import S17JavaFX.ejer114_121.Model.*;
import S17JavaFX.ejer114_121.Utilities.MetodosSueltos;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainController implements Initializable {

    @FXML
    private TableView tblAirports;

    @FXML
    TableColumn<Aeropuerto, Integer> colId, colNumber, colYear, colCapacity, colDisabled, colPartners;

    @FXML
    TableColumn<Aeropuerto, String> colName, colCountry, colCity, colStreet;

    @FXML
    TableColumn<Aeropuerto, Double> colFinancing;

    @FXML
    RadioButton rdbPrivate, rdbPublic;

    @FXML
    TextField txtFilterName;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ToggleGroup toggleGroup = new ToggleGroup();
        this.rdbPublic.setToggleGroup(toggleGroup);
        this.rdbPrivate.setToggleGroup(toggleGroup);

        this.colId.setCellValueFactory(new PropertyValueFactory("id")); // it needs a getID
        this.colName.setCellValueFactory(new PropertyValueFactory("nombre"));
        this.colCountry.setCellValueFactory(new PropertyValueFactory("pais"));
        this.colCity.setCellValueFactory(new PropertyValueFactory("ciudad"));
        this.colStreet.setCellValueFactory(new PropertyValueFactory("calle"));
        this.colNumber.setCellValueFactory(new PropertyValueFactory("numero"));
        this.colYear.setCellValueFactory(new PropertyValueFactory("anioInauguracion"));
        this.colCapacity.setCellValueFactory(new PropertyValueFactory("capacidad"));
        this.colPartners.setCellValueFactory(new PropertyValueFactory("numSocios"));
        this.colFinancing.setCellValueFactory(new PropertyValueFactory("financiacion"));
        this.colDisabled.setCellValueFactory(new PropertyValueFactory("numTrabajadoresDiscapacitados"));

        this.loadAirports();
    }

    private void loadAirports() {
        try {
            String busqueda = this.txtFilterName.getText();

            if (this.rdbPrivate.isSelected()) {
                ObservableList<AeropuertoPrivado> observableList = new AeropuertoPrivado().getAeropuertos(busqueda);
                this.tblAirports.setItems(observableList);
                this.colFinancing.setVisible(false);
                this.colDisabled.setVisible(false);
                this.colPartners.setVisible(true);

            } else {
                ObservableList<AeropuertoPublico> observableList = new AeropuertoPublico().getAeropuertos(busqueda);
                this.tblAirports.setItems(observableList);
                this.colFinancing.setVisible(true);
                this.colDisabled.setVisible(true);
                this.colPartners.setVisible(false);
            }

        } catch (SQLException e) {
            showAlert(Alert.AlertType.ERROR, "Error", e.getMessage());
        }

    }

    public void filterPrivate(ActionEvent event) {
        this.loadAirports();
    }

    public void filterPublic(ActionEvent event) {
        this.loadAirports();
    }

    public void filterByName(KeyEvent keyEvent) {
        this.loadAirports();
    }

    public void addAirport(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AirportView.fxml"));
            Parent root = null;
            root = fxmlLoader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();

            // Set up as a modal
            stage.initModality(Modality.APPLICATION_MODAL);

            stage.setScene(scene);
            stage.setTitle("Add Airport");
            stage.showAndWait();

            this.loadAirports();
            this.tblAirports.refresh();

        } catch (IOException e) {
            showAlert(Alert.AlertType.ERROR, "Error", e.getMessage());
        }
    }

    public void editAirport(ActionEvent event) {
        Aeropuerto aeropuerto = (Aeropuerto) this.tblAirports.getSelectionModel().getSelectedItem();
        if (aeropuerto == null) {
            showAlert(Alert.AlertType.ERROR, "Error", "Debes seleccionar un aeropuerto");
        } else {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AirportView.fxml"));
                Parent root = fxmlLoader.load();

                AirportController controller = fxmlLoader.getController();
                controller.initAttributes(aeropuerto);

                Scene scene = new Scene(root);
                Stage stage = new Stage();

                // Set up as a modal
                stage.initModality(Modality.APPLICATION_MODAL);

                stage.setScene(scene);
                stage.setTitle("Edit Airport");
                stage.showAndWait();

                this.loadAirports();
                this.tblAirports.refresh();

            } catch (IOException e) {
                showAlert(Alert.AlertType.ERROR, "Error", e.getMessage());
            }
        }
    }

    public void deleteAirport(ActionEvent event) {
        Aeropuerto a = (Aeropuerto) this.tblAirports.getSelectionModel().getSelectedItem();

        // Si es nulo, muestro error
        if (a == null) {
            showAlert(Alert.AlertType.ERROR, "Error", "Debes seleccionar un aeropuerto");
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText(null);
            alert.setTitle("Confirmation");
            alert.setContentText("¿Quieres borrar el aeropuerto?");

            // Cogemos el resultado del boton seleccionado
            Optional<ButtonType> action = alert.showAndWait();

            // Si hemos pulsado en aceptar
            if (action.get() == ButtonType.OK) {
                try {
                    if (a.borrarAeropuerto()) {
                        if (a.getDireccion().borrar()) {
                            showAlert(Alert.AlertType.INFORMATION, "Éxito", "Se ha borrado el aeropuerto y la dirección asociada");
                        } else {
                            showAlert(Alert.AlertType.INFORMATION, "Error", "No se ha borrado la dirección");
                        }
                    } else {
                        showAlert(Alert.AlertType.ERROR, "Error", "No se ha borrado el aeropuerto");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
                }
                this.loadAirports();
                this.tblAirports.refresh();
            }
        }
    }

    public void calculateEarnings(ActionEvent event) {
        Aeropuerto a = (Aeropuerto) this.tblAirports.getSelectionModel().getSelectedItem();

        // Si es nulo
        if (a == null) {
            showAlert(Alert.AlertType.ERROR, "Error", "Debes seleccionar un aeropuerto");
        } else {
            // TextInputDialog sirve parapedir valores
            TextInputDialog tid = new TextInputDialog();
            tid.setHeaderText(null);
            tid.setTitle("Error");
            tid.setContentText("Introduce una cantidad");
            Optional<String> texto = tid.showAndWait();

            // Valido si es un numero real
            if (!MetodosSueltos.validaNumeroReal_Exp(texto.get())) {
                showAlert(Alert.AlertType.ERROR, "Error", "El número debe ser una cantidad real");
            } else {
                double cantidad = Double.parseDouble(texto.get());
                showAlert(Alert.AlertType.INFORMATION, "Ganancias", a.gananciasTotales(cantidad));
            }

        }

    }

    public void showAirportInfo(ActionEvent event) {
        Aeropuerto a = (Aeropuerto) this.tblAirports.getSelectionModel().getSelectedItem();

        // Si es nulo, muestro error
        if (a == null) {
            showAlert(Alert.AlertType.ERROR, "Error", "Debes seleccionar un aeropuerto");
        } else {
            showAlert(Alert.AlertType.INFORMATION, "Éxito", a.mostrarInformacion());
        }

    }

    public void addAirplane(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AirplaneView.fxml"));
            Parent root = null;
            root = fxmlLoader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.initModality(Modality.APPLICATION_MODAL);

            stage.setScene(scene);
            stage.setTitle("Add Airplane");
            stage.showAndWait();
        } catch (IOException e) {
            showAlert(Alert.AlertType.ERROR, "Error", e.getMessage());
        }
    }

    public void deleteAirplane(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("DeleteAirplaneView.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.setTitle("Delete Airplane");
            stage.showAndWait();
        } catch (IOException e) {
            showAlert(Alert.AlertType.ERROR, "Error", e.getMessage());
        }
    }

    public void activateAirplane(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ActivateAirplaneView.fxml"));
            Parent root = fxmlLoader.load();

            Scene scene = new Scene(root);
            Stage stage = new Stage();

            // Set up as a modal
            stage.initModality(Modality.APPLICATION_MODAL);

            stage.setScene(scene);
            stage.setTitle("Activate/Deactivate Airport");
            stage.showAndWait();
        } catch (IOException e) {
            showAlert(Alert.AlertType.ERROR, "Error", e.getMessage());
        }
    }

    public void showAlert(Alert.AlertType alertType, String title, String contentText) {
        Alert alert = new Alert(alertType);
        alert.setHeaderText(null);
        alert.setTitle(title);
        alert.setContentText(contentText);
        alert.showAndWait();
    }
}
