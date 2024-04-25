
package travel.management.system;


import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.sql.*;
import java.awt.event.*;

public class ForgotPassword extends JFrame implements ActionListener{

    private JPanel contentPane;
    private JTextField t1,t2,t3,t4,t5;
    private JButton b1,b2,b3;

    public static void main(String[] args) {
        new ForgotPassword().setVisible(true);
    }

    public ForgotPassword() {

        setBounds(500, 200, 600, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setBackground(Color.WHITE);
        contentPane.setLayout(null);

        JLabel l1 = new JLabel("Username");
        l1.setFont(new Font("Tahoma", Font.BOLD, 13));
        l1.setBounds(109, 83, 87, 29);
        contentPane.add(l1);

        JLabel l2 = new JLabel("Name");
        l2.setFont(new Font("Tahoma", Font.BOLD, 13));
        l2.setBounds(109, 122, 75, 21);
        contentPane.add(l2);

        JLabel l3 = new JLabel("Your Security Question");
        l3.setFont(new Font("Tahoma", Font.BOLD, 13));
        l3.setBounds(109, 154, 156, 27);
        contentPane.add(l3);

        JLabel l4 = new JLabel("Answer");
        l4.setFont(new Font("Tahoma", Font.BOLD, 13));
        l4.setBounds(109, 192, 104, 21);
        contentPane.add(l4);

        JLabel l5 = new JLabel("Password");
        l5.setFont(new Font("Tahoma", Font.BOLD, 13));
        l5.setBounds(109, 224, 104, 21);
        contentPane.add(l5);

        t1 = new JTextField();
        t1.setFont(new Font("Tahoma", Font.BOLD, 13));
        t1.setForeground(Color.BLACK); // Set text color to black
        t1.setBackground(Color.WHITE);
        t1.setBounds(277, 88, 139, 20);
        contentPane.add(t1);
        t1.setColumns(10);

        t2 = new JTextField();
        t2.setEditable(false);
        t2.setFont(new Font("Tahoma", Font.BOLD, 13));
        // Change foreground (text) and background color of text fields
        t2.setForeground(Color.BLACK); // Set text color to black
        t2.setBackground(Color.WHITE); // Set background color to yellow

        t2.setColumns(10);
        t2.setBounds(277, 123, 139, 20);
        contentPane.add(t2);

        t3 = new JTextField();
        t3.setEditable(false);
        t3.setFont(new Font("Tahoma", Font.BOLD, 12));
        t3.setForeground(Color.BLACK); // Set text color to black
        t3.setBackground(Color.WHITE);
        t3.setColumns(10);
        t3.setBounds(277, 161, 221, 20);
        contentPane.add(t3);

        t4 = new JTextField();
        t4.setFont(new Font("Tahoma", Font.BOLD, 13));
        t4.setForeground(Color.BLACK); // Set text color to black
        t4.setBackground(Color.WHITE);
        t4.setColumns(10);
        t4.setBounds(277, 193, 139, 20);
        contentPane.add(t4);

        t5 = new JTextField();
        t5.setEditable(false);
        t5.setFont(new Font("Tahoma", Font.BOLD, 13));
        t5.setForeground(Color.BLACK); // Set text color to black
        t5.setBackground(Color.WHITE);
        t5.setColumns(10);
        t5.setBounds(277, 225, 139, 20);
        contentPane.add(t5);



        b1 = new JButton("Search");
        b1.addActionListener(this);
        b1.setFont(new Font("Tahoma", Font.BOLD, 12));
        b1.setBounds(428, 83, 80, 29);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        contentPane.add(b1);

        b2 = new JButton("Retrieve");
        b2.addActionListener(this);
        b2.setFont(new Font("Tahoma", Font.BOLD, 12));
        b2.setBounds(426, 188, 85, 29);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        contentPane.add(b2);

        b3 = new JButton("Back");
        b3.addActionListener(this);
        b3.setFont(new Font("Tahoma", Font.BOLD, 13));
        b3.setBounds(233, 270, 101, 29);
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        contentPane.add(b3);


        JPanel panel = new JPanel();
        panel.setForeground(new Color(34, 139, 34));
        panel.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 0), 2), "Forgot-Password",
                TitledBorder.LEADING, TitledBorder.TOP, null, new Color(34, 139, 34)));
        panel.setBounds(31, 30, 540, 310);
        panel.setBackground(Color.WHITE);
        contentPane.add(panel);
    }

    public void actionPerformed(ActionEvent ae){
        try{
            Conn con = new Conn();
            if(ae.getSource() == b1){
                String sql = "SELECT Name, question FROM Users WHERE username=?";
                PreparedStatement st = con.c.prepareStatement(sql);
                st.setString(1, t1.getText());
                ResultSet rs = st.executeQuery();

                if (rs.next()) {
                    t2.setText(rs.getString("Name"));
                    t3.setText(rs.getString("question"));
                } else {
                    JOptionPane.showMessageDialog(this, "Username not found!");
                }
            }
            if(ae.getSource() == b2){
                String sql = "SELECT Password FROM Users WHERE answer=?";
                PreparedStatement st = con.c.prepareStatement(sql);
                st.setString(1, t4.getText());
                ResultSet rs = st.executeQuery();

                if (rs.next()) {
                    t5.setText(rs.getString("password"));
                } else {
                    JOptionPane.showMessageDialog(this, "Incorrect answer!");
                }
            }
            if(ae.getSource() == b3){
                this.setVisible(false);
                new Login().setVisible(true);
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}

