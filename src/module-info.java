module JavaEjercicios.S17JavaFX {
    requires javafx.fxml;
    requires javafx.controls;
    requires java.desktop;
    requires java.logging;
    requires java.sql;

    opens S17JavaFX.ejer112.Controller;
    opens S17JavaFX.ejer114_121.Controller;
    opens S17JavaFX.ejer114_121.Model;
    opens S17JavaFX.ejer114_121.Utilities;




}
