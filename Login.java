package travel.management.system;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.event.*;
import java.sql.*;
import java.io.File;
import java.net.URL;

public class Login extends JFrame implements ActionListener {

    private JPanel panel;
    private JTextField textField;
    private JPasswordField passwordField;
    private JButton b1, b2, b3;

    public Login() {

        setBackground(Color.WHITE);
        setBounds(550, 250, 500, 400);

        panel = new JPanel();
        panel.setBackground(Color.WHITE);
        setContentPane(panel);
        panel.setLayout(null);

        JLabel l1 = new JLabel("Username : ");
        l1.setFont(new Font("Tahoma", Font.PLAIN, 15));

        l1.setBounds(100, 99, 100, 40);
        panel.add(l1);

        JLabel l2 = new JLabel("Password : ");
        l2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        l2.setBounds(100, 134, 100, 30);
        panel.add(l2);

        textField = new JTextField();
        textField.setBounds(236, 98, 157, 26);
        panel.add(textField);

        passwordField = new JPasswordField();

        passwordField.setBounds(236, 140, 157, 26);
        panel.add(passwordField);

        JLabel l3 = new JLabel("");
        l3.setBounds(377, 79, 46, 34);
        panel.add(l3);

        JLabel l4 = new JLabel("");
        l4.setBounds(377, 124, 46, 34);
        panel.add(l3);



        b1 = new JButton("Login");
        b1.addActionListener(this);

        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(139, 190, 113, 25);
        panel.add(b1);
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                new Home("").setVisible(true);
            }
        });


        b2 = new JButton("SignUp");
        b2.addActionListener(this);

        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(269, 190, 113, 25);
        panel.add(b2);

        b3 = new JButton("Forgot Password");
        b3.addActionListener(this);

        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.setBounds(170, 240, 179, 25);
        panel.add(b3);

        JPanel panel = new JPanel();
        panel.setForeground(new Color(34, 139, 34));
        panel.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 0), 2), "log-in",
                TitledBorder.LEADING, TitledBorder.TOP, null, new Color(34, 139, 34)));
        panel.setBounds(31, 30, 440, 310);
        panel.setBackground(Color.WHITE);
        add(panel);

        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.WHITE);
        panel2.setBounds(24, 40, 434, 263);
        panel.add(panel2);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            Boolean status = false;
            try {
                Conn con = new Conn();
                String sql = "select * from users where Username=? and Password=?";
                PreparedStatement st = con.c.prepareStatement(sql);

                st.setString(1, textField.getText());
                st.setString(2, passwordField.getText());



            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if (ae.getSource() == b2) {
            setVisible(false);
            Signup su = new Signup();
            su.setVisible(true);
        }
        if (ae.getSource() == b3) {
            setVisible(false);
            ForgotPassword forgot = new ForgotPassword();
            forgot.setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Login().setVisible(true);
    }
}
