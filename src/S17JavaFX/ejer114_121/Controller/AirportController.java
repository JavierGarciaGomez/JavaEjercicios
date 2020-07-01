package S17JavaFX.ejer114_121.Controller;

import S17JavaFX.ejer114_121.Model.Aeropuerto;
import S17JavaFX.ejer114_121.Model.AeropuertoPrivado;
import S17JavaFX.ejer114_121.Model.AeropuertoPublico;
import S17JavaFX.ejer114_121.Model.Direccion;
import S17JavaFX.ejer114_121.Utilities.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AirportController implements Initializable {

    @FXML
    TextField txtName, txtCountry, txtCity, txtStreet, txtNumber, txtYear, txtCapacity, txtFinancing, txtDisabled, txtPartners;

    @FXML
    RadioButton rbtPublic, rbtPrivate;

    @FXML
    Button btnRegister, btnCancel;

    private Aeropuerto aeropuerto;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ToggleGroup group = new ToggleGroup();
        rbtPublic.setToggleGroup(group);
        rbtPrivate.setToggleGroup(group);
        changeToPublic(null);
    }

    @FXML
    public void changeToPublic(ActionEvent event) {
        if(rbtPublic.isSelected()){
            txtFinancing.setDisable(false);
            txtDisabled.setDisable(false);
            txtPartners.setDisable(true);
        } else{
            txtFinancing.setDisable(true);
            txtDisabled.setDisable(true);
            txtPartners.setDisable(false);
        }
    }

    @FXML
    public void changeToPrivate(ActionEvent event) {
        changeToPublic(event);
    }

    @FXML
    public void register(ActionEvent event) {

        // Indico los errores que tengamos
        String errores = "";

        // Obtengo los datos
        String nombre = this.txtName.getText();
        String pais = this.txtCountry.getText();
        String ciudad = this.txtCity.getText();
        String calle = this.txtStreet.getText();

        // Valido los numeros
        if (!MetodosSueltos.validaNumeroEntero_Exp(this.txtNumber.getText())) errores += "- El numero de la calle debe ser un numero. \n";
        if (!MetodosSueltos.validaNumeroEntero_Exp(this.txtCapacity.getText())) errores += "- La capacidad debe ser un numero. \n";
        if (!MetodosSueltos.validaNumeroEntero_Exp(this.txtYear.getText())) errores += "- El año debe ser un numero. \n";
        if(this.rbtPublic.isSelected()&&!MetodosSueltos.validaNumeroReal_Exp(this.txtFinancing.getText())) errores+= "-La financiación debe ser un número. \n";
        if(this.rbtPublic.isSelected()&&!MetodosSueltos.validaNumeroEntero_Exp(this.txtDisabled.getText())) errores+= "-El número de discapacitados debe ser un número. \n";
        if(this.rbtPrivate.isSelected()&&!MetodosSueltos.validaNumeroEntero_Exp(this.txtPartners.getText())) errores+= "-El número de socios debe ser un número. \n";

        // Si no hay errores, continuamos
        if (errores.isEmpty()) {
            try {
                // Parseamos los valores
                int numero = Integer.parseInt(this.txtNumber.getText());
                int capacidad = Integer.parseInt(this.txtCapacity.getText());
                int anioInauguracion = Integer.parseInt(this.txtYear.getText());

                // si no hay aeropuerto inserat, en caso contrario actualiza
                if(this.aeropuerto==null){
                    Aeropuerto aux;

                    // Creo la direccion
                    Direccion dir = new Direccion(pais, calle, numero, ciudad);

                    // Inserto la direccion
                    if (dir.insertar()) {

                        // Si elegimos publico
                        if (this.rbtPublic.isSelected()) {

                            // Obtenemos los datos del aeropuerto publico
                            double financiacion = Double.parseDouble(this.txtFinancing.getText());
                            int discapacitados = Integer.parseInt(this.txtDisabled.getText());

                            aux = new AeropuertoPublico(financiacion, discapacitados, nombre, dir, anioInauguracion, capacidad);

                        } else {

                            // Obtenemos los datos del aeropuerto pricado
                            int socios = Integer.parseInt(this.txtPartners.getText());

                            aux = new AeropuertoPrivado(socios, nombre, dir, anioInauguracion, capacidad);

                        }

                        // Seteamos de nuevo la direccion
                        // Esto es porque cuando creamos el objeto del aeropuerto, este no le metemos el id directamente
                        aux.setDireccion(dir);

                        // Inserto el aeropuerto
                        if (aux.insertar()) {
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setHeaderText(null);
                            alert.setTitle("Exito");
                            alert.setContentText("El aeropuerto se ha insertado");
                            alert.showAndWait();
                        } else {
                            Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.setHeaderText(null);
                            alert.setTitle("Error");
                            alert.setContentText("El aeropuerto no se ha insertado");
                            alert.showAndWait();
                        }

                    }

                }else { // en caso de actualizar
                    this.aeropuerto.setNombre(nombre);
                    this.aeropuerto.setCapacidad(capacidad);
                    this.aeropuerto.setAnioInauguracion(anioInauguracion);

                    Direccion dir = this.aeropuerto.getDireccion();

                    dir.setPais(pais);
                    dir.setCalle(calle);
                    dir.setCiudad(ciudad);
                    dir.setNumero(numero);

                    if (dir.actualizar()) {

                        if (this.rbtPublic.isSelected()) {

                            double financiacion = Double.parseDouble(this.txtFinancing.getText());
                            int discapacitados = Integer.parseInt(this.txtDisabled.getText());

                            AeropuertoPublico ap = (AeropuertoPublico) this.aeropuerto;
                            ap.setFinanciacion(financiacion);
                            ap.setNumTrabajadoresDiscapacitados(discapacitados);

                        } else {

                            int socios = Integer.parseInt(this.txtPartners.getText());
                            AeropuertoPrivado ap = (AeropuertoPrivado) this.aeropuerto;

                            ap.setNumSocios(socios);

                        }

                        // Actualizamos el aeropuerto
                        if (this.aeropuerto.actualizar()) {
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setHeaderText(null);
                            alert.setTitle("Exito");
                            alert.setContentText("El aeropuerto se ha actualizado");
                            alert.showAndWait();
                        } else {
                            Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.setHeaderText(null);
                            alert.setTitle("Error");
                            alert.setContentText("El aeropuerto no se ha actualizado");
                            alert.showAndWait();
                        }

                    }

                }

            } catch (SQLException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText(ex.getMessage());
                alert.showAndWait();
            }

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText(errores);
            alert.showAndWait();
        }

    }


    @FXML
    public void cancel(ActionEvent event) {
        Stage myStage = (Stage) this.btnRegister.getScene().getWindow();
        myStage.close();
    }

    public void initAttributes(Aeropuerto aeropuerto){
        this.aeropuerto=aeropuerto;
        this.txtName.setText(aeropuerto.getNombre());
        this.txtCountry.setText(aeropuerto.getPais());
        this.txtCity.setText(aeropuerto.getCiudad());
        this.txtStreet.setText(aeropuerto.getCalle());
        this.txtNumber.setText(aeropuerto.getNumero()+"");
        this.txtCapacity.setText(aeropuerto.getCapacidad()+"");
        this.txtYear.setText(aeropuerto.getAnioInauguracion()+"");
        if(aeropuerto instanceof AeropuertoPublico){
            this.rbtPublic.setSelected(true);

            this.txtFinancing.setText(((AeropuertoPublico) aeropuerto).getFinanciacion()+"");
            this.txtDisabled.setText(((AeropuertoPublico) aeropuerto).getNumTrabajadoresDiscapacitados()+"");
        } else{
            this.rbtPrivate.setSelected(true);

            this.txtPartners.setText(((AeropuertoPrivado) aeropuerto).getNumSocios()+"");
        }
        this.rbtPrivate.setDisable(true);
        this.rbtPublic.setDisable(true);



    }


}
