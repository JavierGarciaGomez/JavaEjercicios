package S17JavaFX.ejer111.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
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

    public void checkLogin(ActionEvent event) {
    }
}
