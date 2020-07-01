package S17JavaFX.ejer114_121.Controller;

import S17JavaFX.ejer114_121.Model.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML
    private TextField txtUser;

    @FXML
    private TextField txtPass;

    @FXML
    private Button btnLogin;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }

    @FXML
    private void checkLogin(ActionEvent event) {
        try {
        String userName = this.txtUser.getText();
        String pass = this.txtPass.getText();

        Usuario user = new Usuario(userName, pass);

            if(user.login()){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setTitle("Éxito");
                alert.setContentText("Login correcto");
                alert.showAndWait();

                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainView.fxml"));
                Parent root = fxmlLoader.load();
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("Airports");
                stage.show();

                Stage myStage = (Stage)this.btnLogin.getScene().getWindow();
                myStage.close();


            } else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("Login incorrecto");
                alert.showAndWait();

            }
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
    }
}
