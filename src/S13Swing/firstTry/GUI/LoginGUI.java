package S13Swing.firstTry.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginGUI extends JFrame{
    private JButton btnLogin;
    private JButton btnExit;
    private JPanel loginPanel;
    private JTextField txtNombre;
    private JPasswordField txtPass;

    public LoginGUI() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(loginPanel);
        this.pack();
        txtNombre.setText("admin");
        txtPass.setText("admin");
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doLogin(e);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new LoginGUI();
        frame.setTitle("Login");
        frame.setBounds(300,300,500,300);
        frame.setVisible(true);
    }

    private void doLogin(ActionEvent e) {
        String nombre = txtNombre.getText();
        String pass = txtPass.getText();

        if(nombre.equals("admin") && pass.equals("admin")){
            MainGUI mainGUI = new MainGUI();
            this.dispose();
        }else{
            JOptionPane.showMessageDialog(this, "El usuario y contraseña no coinciden", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
