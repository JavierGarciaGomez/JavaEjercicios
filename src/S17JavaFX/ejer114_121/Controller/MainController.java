package S17JavaFX.ejer114_121.Controller;

import S17JavaFX.ejer114_121.Model.*;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    TableView tblAirports;

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

            } else{
                ObservableList<AeropuertoPublico> observableList = new AeropuertoPublico().getAeropuertos(busqueda);
                this.tblAirports.setItems(observableList);
                this.colFinancing.setVisible(true);
                this.colDisabled.setVisible(true);
                this.colPartners.setVisible(false);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
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
    }

    public void editAirport(ActionEvent event) {
    }

    public void deleteAirport(ActionEvent event) {
    }

    public void calculateEarnings(ActionEvent event) {
    }

    public void showAirportInfo(ActionEvent event) {
    }

    public void addAirplane(ActionEvent event) {
    }

    public void deleteAirplane(ActionEvent event) {
    }

    public void activateAirplane(ActionEvent event) {
    }


}
