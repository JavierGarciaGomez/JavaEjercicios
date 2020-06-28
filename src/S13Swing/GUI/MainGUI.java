package S13Swing.GUI;

import S13Swing.Utilidades.MetodosSueltos;
import S13Swing.Utilidades.VariablesGlobales;
import S13Swing.clases.AeropuertoPrivado;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGUI extends JFrame {
    private JPanel mainFramePanel;

    public MainGUI() {
        MetodosSueltos.leerAeropuertos();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setContentPane(mainFramePanel);
        this.setTitle("Main Frame");
        this.setVisible(true);
        this.pack();

    }
}