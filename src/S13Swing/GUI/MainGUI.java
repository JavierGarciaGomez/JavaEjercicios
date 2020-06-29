package S13Swing.GUI;

import S13Swing.Utilidades.MetodosSueltos;
import S13Swing.Utilidades.VariablesGlobales;
import S13Swing.clases.Aeropuerto;
import S13Swing.clases.AeropuertoPrivado;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainGUI extends JFrame {
    private JPanel mainFramePanel;
    private DefaultTableModel modeloTabla;
    private JTable tablaAeropuertos;

    public MainGUI() {
        MetodosSueltos.leerAeropuertos();

        mainFramePanel.setLayout(new BorderLayout());
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
                AddAirport addAirportGUI = new AddAirport(MainGUI.this, true);
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

        mainFramePanel.add(jMenuBar, BorderLayout.NORTH);

        // CenterLayout
        JPanel tablePanel = new JPanel(new FlowLayout());

        tablaAeropuertos = new JTable(2,4);
        cargarTabla();
        tablePanel.add(tablaAeropuertos);





        mainFramePanel.add(tablePanel,BorderLayout.CENTER);



        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setContentPane(mainFramePanel);
        this.setTitle("Main Frame");
        this.setPreferredSize(new Dimension(500,500));
        this.pack();
        this.setVisible(true);


    }

    private void cargarTabla() {
        this.modeloTabla=new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return super.isCellEditable(row, column);
            }
        };
        this.tablaAeropuertos.setModel(modeloTabla);

        modeloTabla.addColumn("Id");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("País");
        modeloTabla.addColumn("Calle");
        modeloTabla.addColumn("Número");
        modeloTabla.addColumn("Ciudad");
        modeloTabla.addColumn("Año");
        modeloTabla.addColumn("Capacidad");


        Object[] fila;
        for(Aeropuerto aux:VariablesGlobales.aeropuertos){
            fila=new Object[8];
            fila[0] =aux.getId();
            fila[1] =aux.getNombre();
            fila[2] =aux.getDireccion().getPais();
            fila[3] =aux.getDireccion().getCalle();
            fila[4] =aux.getDireccion().getNumero();
            fila[5] =aux.getDireccion().getCiudad();
            fila[6] =aux.getAnioInauguracion();
            fila[7] =aux.getCapacidad();

            modeloTabla.addRow(fila);


        }



    }
}