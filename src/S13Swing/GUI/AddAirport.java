package S13Swing.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddAirport extends JFrame {
    JRadioButton rbtnPublic, rbtnPrivate;
    JTextField txtName, txtPais, txtCalle, txtNum, txtCiudad, txtAnoInaug, txtCapacidad, txtFinanciacion, txtDiscapacitados, txtNumSocios;

    public AddAirport() {
        JPanel mainPanel = new JPanel(new GridLayout(0, 2));

        mainPanel.add(new JLabel("Nombre"));
        txtName = new JTextField();
        mainPanel.add(txtName);

        mainPanel.add(new JLabel("País"));
        txtPais = new JTextField();
        mainPanel.add(txtPais);

        mainPanel.add(new JLabel("Calle"));
        txtCalle = new JTextField();
        mainPanel.add(txtCalle);

        mainPanel.add(new JLabel("Número"));
        txtNum = new JTextField();
        mainPanel.add(txtNum);

        mainPanel.add(new JLabel("Ciudad"));
        txtCiudad = new JTextField();
        mainPanel.add(txtCiudad);

        mainPanel.add(new JLabel("Año de inauguración"));
        txtAnoInaug = new JTextField();
        mainPanel.add(txtAnoInaug);

        mainPanel.add(new JLabel("Capacidad"));
        txtCapacidad = new JTextField();
        mainPanel.add(txtCapacidad);

        rbtnPublic = new JRadioButton("Público");
        rbtnPrivate = new JRadioButton("Privado");

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(rbtnPublic);
        buttonGroup.add(rbtnPrivate);

        mainPanel.add(rbtnPublic);
        mainPanel.add(rbtnPrivate);

        mainPanel.add(new JLabel("Financiación"));
        txtFinanciacion = new JTextField();
        mainPanel.add(txtFinanciacion);

        mainPanel.add(new JLabel("Discpacitados"));
        txtDiscapacitados = new JTextField();
        mainPanel.add(txtDiscapacitados);

        mainPanel.add(new JLabel("Número de socios"));
        txtNumSocios = new JTextField();
        mainPanel.add(txtNumSocios);

        JButton btnSave = new JButton("Guardar");
        JButton btnCancel = new JButton("Cancelar");

        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveData(e);
            }
        });
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        mainPanel.add(btnSave);
        mainPanel.add(btnCancel);

        rbtnPublic.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                enableTextFields();
            }
        });

        rbtnPrivate.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                enableTextFields();
            }
        });


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setContentPane(mainPanel);
        this.setTitle("Main Frame");
        this.pack();
        this.setVisible(true);


    }

    private void saveData(ActionEvent e) {
        String errores ="";

        String nombre = this.txtName.getText();
        String pais = this.txtPais.getText();
        String calle = this.txtCalle.getText();
        String numero = this.txtNum.getText();
        String ciudad = this.txtCiudad.getText();
        String anoInaug = this.txtAnoInaug.getText();
        String capacidad = this.txtCapacidad.getText();
        String financiacion = "", discapacidad="", numSocios="";

        if(nombre.isEmpty()) errores+=" - El nombre no puede estar vacío \n";
        if(pais.isEmpty()) errores+=" - El país no puede estar vacío \n";
        if(calle.isEmpty()) errores+=" - La calle no puede estar vacío \n";
        if(numero.isEmpty()) errores+=" - El número no puede estar vacío \n";
        if(ciudad.isEmpty()) errores+=" - La ciudad no puede estar vacío \n";
        if(anoInaug.isEmpty()) errores+=" - El año de inauguración no puede estar vacío \n";
        if(capacidad.isEmpty()) errores+=" - La capacidad no puede estar vacío \n";
        if(financiacion.isEmpty()) errores+=" - La financiación no puede estar vacío \n";
    }

    private void enableTextFields() {
        boolean isPublic;
        if (rbtnPublic.isSelected()) isPublic = true;
        else isPublic = false;

        txtFinanciacion.setEnabled(isPublic);
        txtDiscapacitados.setEnabled(isPublic);
        txtNumSocios.setEnabled(!isPublic);

        if(isPublic){
            txtNumSocios.setText("");
        } else{
            txtFinanciacion.setText("");
            txtDiscapacitados.setText("");
        }
    }

}
