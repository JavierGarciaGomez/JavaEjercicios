package S13Swing.firstTry.GUI;

import S13Swing.firstTry.Utilidades.MetodosSueltos;
import S13Swing.firstTry.clases.Aeropuerto;
import S13Swing.firstTry.clases.AeropuertoPrivado;
import S13Swing.firstTry.clases.AeropuertoPublico;
import S13Swing.firstTry.clases.Direccion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class AddAirport extends JDialog {
    JRadioButton rbtnPublic, rbtnPrivate;
    JTextField txtName, txtPais, txtCalle, txtNum, txtCiudad, txtAnoInaug, txtCapacidad, txtFinanciacion, txtDiscapacitados, txtNumSocios;
    ButtonGroup buttonGroup;

    public AddAirport(Frame parent, boolean modal) {
        super(parent, modal);
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

        rbtnPublic.setSelected(true);

        buttonGroup = new ButtonGroup();
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


        enableTextFields();

        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setContentPane(mainPanel);
        this.setTitle("ejer101 Frame");
        this.pack();
        this.setVisible(true);


    }

    private void saveData(ActionEvent e) {
        String errores = "";

        String nombre = this.txtName.getText();
        String pais = this.txtPais.getText();
        String calle = this.txtCalle.getText();
        String numero = this.txtNum.getText();
        String ciudad = this.txtCiudad.getText();
        String anoInaug = this.txtAnoInaug.getText();
        String capacidad = this.txtCapacidad.getText();
        String financiacion = this.txtFinanciacion.getText();
        String discapacidad = this.txtDiscapacitados.getText();
        String numSocios = this.txtNumSocios.getText();

        if (nombre.isEmpty()) errores += " - El nombre no puede estar vacío \n";
        if (pais.isEmpty()) errores += " - El país no puede estar vacío \n";
        if (calle.isEmpty()) errores += " - La calle no puede estar vacío \n";
        if (numero.isEmpty()) errores += " - El número no puede estar vacío \n";
        else if (!MetodosSueltos.validaNumeroEntero_Exp(numero))
            errores += " - El número no tiene el formato correcto \n";
        if (ciudad.isEmpty()) errores += " - La ciudad no puede estar vacío \n";
        if (anoInaug.isEmpty()) errores += " - El año de inauguración no puede estar vacío \n";
        else if (!MetodosSueltos.validaNumeroEntero_Exp(anoInaug))
            errores += " - El año de inauguración no tiene el formato correcto \n";
        if (capacidad.isEmpty()) errores += " - La capacidad no puede estar vacío \n";
        else if (!MetodosSueltos.validaNumeroEntero_Exp(capacidad))
            errores += " - La capacidad no tiene el formato correcto \n";

        if (this.rbtnPublic.isSelected()) {
            if (financiacion.isEmpty()) errores += " - La financiación no puede estar vacío \n";
            else if (!MetodosSueltos.validaNumeroReal_Exp(financiacion))
                errores += " - La financiación no tiene el formato correcto \n";
            if (discapacidad.isEmpty()) errores += " - El número de discapacitados no puede estar vacío \n";
            else if (!MetodosSueltos.validaNumeroEntero_Exp(discapacidad))
                errores += " - El número de discapacitados no tiene el formato correcto \n";
        } else {
            if (numSocios.isEmpty()) errores += " - El número de socios no puede estar vacío \n";
            else if (!MetodosSueltos.validaNumeroEntero_Exp(numSocios))
                errores += " - El número de socios no tiene el formato correcto \n";
        }

        if (errores.isEmpty()) {
            int numCalle = Integer.parseInt(numero);
            int anoInauguracion = Integer.parseInt(anoInaug);
            int capacidadAeropureto = Integer.parseInt(capacidad);

            Aeropuerto auxAeropuerto;
            Direccion direccion = new Direccion(pais, calle, numCalle, ciudad);

            if (this.rbtnPublic.isSelected()) {
                double financiacionAeropuerto = Double.parseDouble(financiacion);
                int discapacitadosAeropuerto = Integer.parseInt(discapacidad);
                auxAeropuerto = new AeropuertoPublico(financiacionAeropuerto, discapacitadosAeropuerto, nombre, direccion, anoInauguracion, capacidadAeropureto);
            } else {
                int numSociosAeropuerto = Integer.parseInt(numSocios);
                auxAeropuerto = new AeropuertoPrivado(numSociosAeropuerto, nombre, direccion, anoInauguracion, capacidadAeropureto);
            }
            try {
                MetodosSueltos.escribirAeropuerto(auxAeropuerto);
                JOptionPane.showMessageDialog(null, "Aeropuerto creado correctamente");
                this.dispose();
            } catch (IOException exception) {
                exception.printStackTrace();
            }


        } else {
            JOptionPane.showMessageDialog(this, errores, "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void enableTextFields() {
        boolean isPublic;
        if (rbtnPublic.isSelected()) isPublic = true;
        else isPublic = false;

        txtFinanciacion.setEnabled(isPublic);
        txtDiscapacitados.setEnabled(isPublic);
        txtNumSocios.setEnabled(!isPublic);

        if (isPublic) {
            txtNumSocios.setText("");
        } else {
            txtFinanciacion.setText("");
            txtDiscapacitados.setText("");
        }
    }

}
