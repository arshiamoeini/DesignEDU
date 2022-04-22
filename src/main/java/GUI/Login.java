package GUI;

import LOGIC.Command;
import MODELS.LoginDate;
import MODELS.LoginResult;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login {
    private static Login instance;

    private JPanel loginPane;
    private JTextField userIDField;
    private JPasswordField passwordField;
    private JCheckBox showPassword;
    private JButton loginButton;
    private JLabel userIDLabel;
    private JLabel PasswordLabel;

    static {
        instance = new Login();
    }

    public Login() {
        //setting
        setListener();
        loginPane.setBounds(0, 0, 30, 50);
    }

    public static Login getInstance() { return instance; }

    private void setListener() {
        showPassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                passwordField.setEchoChar(showPassword.isSelected() ? (char)0 : '*');
            }
        });
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginDate date = new LoginDate(userIDField.getText(), passwordField.getText());

                LoginResult result = Command.getInstance().canLogin(date);
                if (result == LoginResult.PASS) {

                } else {
                    JOptionPane.showMessageDialog(loginButton, result.getMassage());
                }
            }
        });
    }

    public JPanel getLoginPane() {
        return loginPane;
    }
}
