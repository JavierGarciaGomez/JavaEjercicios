package S17JavaFX.ejer114_121.Controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {

            // Cargo la ventana inicial
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("LoginView.fxml"));
            // Ventana a cargar
            Pane ventana = (Pane) loader.load();

            // Creo la escena
            Scene scene = new Scene(ventana);

            // Modifico el stage
            primaryStage.setScene(scene);
            primaryStage.setTitle("Login");
            primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("plane.png")));

            // Muestro la ventana
            primaryStage.show();


        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
