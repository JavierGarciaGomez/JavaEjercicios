package S13Swing.GUI;

import S13Swing.Utilidades.MetodosSueltos;
import S13Swing.Utilidades.VariablesGlobales;
import S13Swing.clases.AeropuertoPrivado;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainGUI extends JFrame {
    private JPanel mainFramePanel;

    public MainGUI() {
        //MetodosSueltos.leerAeropuertos();

        mainFramePanel.setLayout(new FlowLayout());
        JMenuBar jMenuBar = new JMenuBar();

        JMenu menuAeropuertos = new JMenu("Aeropuerto");
        JMenuItem addAirport = new JMenuItem("Añadir...");
        JMenuItem editAirport = new JMenuItem("Editar...");
        JMenuItem deleteAirport = new JMenuItem("Borrar");
        JMenuItem showAirportEarnings = new JMenuItem("Ganancias");
        JMenuItem showAirportInfo = new JMenuItem("MostrarInfo");

        addAirport.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddAirport addAirportGUI = new AddAirport();
            }
        });

        jMenuBar.add(menuAeropuertos);
        menuAeropuertos.add(addAirport);
        menuAeropuertos.add(editAirport);
        menuAeropuertos.add(deleteAirport);
        menuAeropuertos.add(showAirportEarnings);
        menuAeropuertos.add(showAirportInfo);

        JMenu menuAviones = new JMenu("Aviones");
        JMenuItem addAirplane = new JMenuItem("Añadir...");
        JMenuItem activateAirplane = new JMenuItem("Activar/Desactivar");
        JMenuItem deleteAirplane = new JMenuItem("Borrar");

        jMenuBar.add(menuAviones);
        menuAviones.add(addAirplane);
        menuAviones.add(activateAirplane);
        menuAviones.add(deleteAirplane);

        JMenu menuSalir = new JMenu("Salir");
        jMenuBar.add(menuSalir);

        menuSalir.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
        });

        mainFramePanel.add(jMenuBar);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setContentPane(mainFramePanel);
        this.setTitle("Main Frame");
        this.setPreferredSize(new Dimension(500,500));
        this.pack();
        this.setVisible(true);







    }
}