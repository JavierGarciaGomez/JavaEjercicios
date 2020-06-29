package S13Swing.secondTry.formularios;

import java.awt.*;
import java.io.IOException;
import javax.swing.JOptionPane;

import S13Swing.secondTry.clases.*;
import S13Swing.secondTry.utilidades.*;

public class AniadirAeropuerto extends javax.swing.JDialog {

    public AniadirAeropuerto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        this.buttonGroup1.add(this.rdbPrivado);
        this.buttonGroup1.add(this.rdbPublico);

        this.setLocationRelativeTo(null);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        txtCalle = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        txtNumSocios = new javax.swing.JTextField();
        txtAnioInauguracion = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtCiudad = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        txtCapacidad = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        rdbPublico = new javax.swing.JRadioButton();
        rdbPrivado = new javax.swing.JRadioButton();
        txtNombre = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtFinanciacion = new javax.swing.JTextField();
        txtPais = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtDiscapacitados = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new GridLayout(0,2));

        jLabel1.setText("Nombre");
        getContentPane().add(jLabel1);
        getContentPane().add(txtNombre);

        jLabel4.setText("País");
        getContentPane().add(jLabel4);
        getContentPane().add(txtPais);

        jLabel6.setText("Número");
        getContentPane().add(jLabel6);
        getContentPane().add(txtNumero);

        jLabel5.setText("Calle");
        getContentPane().add(jLabel5);
        getContentPane().add(txtCalle);

        jLabel7.setText("Ciudad");
        getContentPane().add(jLabel7);
        getContentPane().add(txtCiudad);

        jLabel2.setText("Año inauguración");
        getContentPane().add(jLabel2);
        getContentPane().add(txtAnioInauguracion);

        jLabel3.setText("Capacidad");
        getContentPane().add(jLabel3);
        getContentPane().add(txtCapacidad);

        rdbPublico.setSelected(true);
        rdbPublico.setText("Público");
        rdbPublico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbPublicoActionPerformed(evt);
            }
        });
        getContentPane().add(rdbPublico);

        rdbPrivado.setText("Privado");
        rdbPrivado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbPrivadoActionPerformed(evt);
            }
        });
        getContentPane().add(rdbPrivado);


        jLabel8.setText("Financiación");
        getContentPane().add(jLabel8);
        getContentPane().add(txtFinanciacion);

        jLabel9.setText("Discapacitados");
        getContentPane().add(jLabel9);
        getContentPane().add(txtDiscapacitados);

        jLabel10.setText("Numero de socios");
        getContentPane().add(jLabel10);
        txtNumSocios.setEnabled(false);
        getContentPane().add(txtNumSocios);

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(btnGuardar);


        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelar);






        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        String errores = "";

        String nombre = this.txtNombre.getText();
        String pais = this.txtPais.getText();
        String calle = this.txtCalle.getText();
        String numero = this.txtNumero.getText();
        String ciudad = this.txtCiudad.getText();
        String anioInauguracion = this.txtAnioInauguracion.getText();
        String capacidad = this.txtCapacidad.getText();

        String financiacion = "", discapacitados = "", numSocios = "";

        if (nombre.isEmpty()) {
            errores += " - El nombre no puede estar vacio \n";
        }

        if (pais.isEmpty()) {
            errores += " - El pais no puede estar vacio \n";
        }

        if (calle.isEmpty()) {
            errores += " - La calle no puede estar vacia \n";
        }

        if (numero.isEmpty()) {
            errores += " - El numero no puede estar vacia \n";
        } else {
            if (!MetodosSueltos.validaNumeroEntero_Exp(numero)) {
                errores += " - El numero no tiene el formato correcto \n";
            }
        }

        if (ciudad.isEmpty()) {
            errores += " - La ciudad no puede estar vacia \n";
        }

        if (anioInauguracion.isEmpty()) {
            errores += " - El año de inauguracion puede estar vacia \n";
        } else {
            if (!MetodosSueltos.validaNumeroEntero_Exp(anioInauguracion)) {
                errores += " - El año de inauguracion no tiene el formato correcto \n";
            }
        }

        if (capacidad.isEmpty()) {
            errores += " - La capacidad no puede estar vacia \n";
        } else {
            if (!MetodosSueltos.validaNumeroEntero_Exp(capacidad)) {
                errores += " - La capacidad no tiene el formato correcto \n";
            }
        }

        if (this.rdbPublico.isSelected()) {

            financiacion = this.txtFinanciacion.getText();
            discapacitados = this.txtDiscapacitados.getText();

            if (financiacion.isEmpty()) {
                errores += " - La financiacion no puede estar vacia \n";
            } else {
                if (!MetodosSueltos.validaNumeroReal_Exp(financiacion)) {
                    errores += " - La financiacion no tiene el formato correcto \n";
                }
            }

            if (discapacitados.isEmpty()) {
                errores += " - El numero de discapacitados no puede estar vacio \n";
            } else {
                if (!MetodosSueltos.validaNumeroEntero_Exp(discapacitados)) {
                    errores += " - El numero de discapacitados no tiene el formato correcto \n";
                }
            }
        } else {

            numSocios = this.txtNumSocios.getText();

            if (numSocios.isEmpty()) {
                errores += " - El numero de socios no puede estar vacio \n";
            } else {
                if (!MetodosSueltos.validaNumeroEntero_Exp(numSocios)) {
                    errores += " - El numero de socios no tiene el formato correcto \n";
                }
            }
        }

        if (errores.isEmpty()) {

            int numeroAeropuerto = Integer.parseInt(numero);
            int anioInauguracioAeropuerto = Integer.parseInt(anioInauguracion);
            int capacidadAeropuerto = Integer.parseInt(capacidad);

            Aeropuerto aux;
            Direccion dir = new Direccion(pais, calle, numeroAeropuerto, ciudad);

            if (this.rdbPublico.isSelected()) {
                double financiacionAeropuerto = Double.parseDouble(financiacion);
                int discapacitadosAeropuerto = Integer.parseInt(discapacitados);

                aux = new AeropuertoPublico(financiacionAeropuerto,
                        discapacitadosAeropuerto,
                        nombre,
                        dir,
                        anioInauguracioAeropuerto,
                        capacidadAeropuerto);

            } else {
                int numSociosAeropuerto = Integer.parseInt(numSocios);
                aux = new AeropuertoPrivado(numSociosAeropuerto,
                        nombre,
                        dir,
                        anioInauguracioAeropuerto,
                        capacidadAeropuerto);
            }

            try {
                MetodosSueltos.escribirAeropuerto(aux);
                
                JOptionPane.showMessageDialog(this,
                        "Aeropuerto creado correctamente",
                        "Éxito",
                        JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this,
                        ex.getMessage(),
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(this,
                    errores,
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtCiudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCiudadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCiudadActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void rdbPublicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbPublicoActionPerformed
        this.txtFinanciacion.setEnabled(true);
        this.txtDiscapacitados.setEnabled(true);
        this.txtNumSocios.setEnabled(false);
    }//GEN-LAST:event_rdbPublicoActionPerformed

    private void rdbPrivadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbPrivadoActionPerformed
        this.txtFinanciacion.setEnabled(false);
        this.txtDiscapacitados.setEnabled(false);
        this.txtNumSocios.setEnabled(true);
    }//GEN-LAST:event_rdbPrivadoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButton rdbPrivado;
    private javax.swing.JRadioButton rdbPublico;
    private javax.swing.JTextField txtAnioInauguracion;
    private javax.swing.JTextField txtCalle;
    private javax.swing.JTextField txtCapacidad;
    private javax.swing.JTextField txtCiudad;
    private javax.swing.JTextField txtDiscapacitados;
    private javax.swing.JTextField txtFinanciacion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNumSocios;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtPais;
    // End of variables declaration//GEN-END:variables
}
