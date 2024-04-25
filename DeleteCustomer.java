package travel.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

public class DeleteCustomer extends JFrame {
    private JPanel contentPane;
    Choice c1;
    JLabel l2, l3, l4, l5, l6, l7, l8, l9;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    DeleteCustomer frame = new DeleteCustomer();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public DeleteCustomer() throws SQLException {
        setBounds(580, 220, 550, 550);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblName = new JLabel("DELETE CUSTOMER DETAILS");
        lblName.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
        lblName.setBounds(118, 11, 300, 53);
        contentPane.add(lblName);

        JLabel lb3 = new JLabel("Username :");
        lb3.setBounds(35, 70, 200, 14);
        contentPane.add(lb3);

        c1 = new Choice();
        Conn c = new Conn();
        try {
            ResultSet rs = c.s.executeQuery("select * from customers");
            while (rs.next()) {
                c1.add(rs.getString("Username"));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        c1.setBounds(271, 70, 150, 30);
        add(c1);

        JLabel lblId = new JLabel("ID :");
        lblId.setBounds(35, 110, 200, 14);
        contentPane.add(lblId);

        l2 = new JLabel();
        l2.setBounds(271, 110, 200, 14);
        contentPane.add(l2);

        JLabel lb2 = new JLabel("Address :");
        lb2.setBounds(35, 150, 200, 14);
        contentPane.add(lb2);

        l3 = new JLabel();
        l3.setBounds(271, 150, 200, 14);
        contentPane.add(l3);

        JLabel lblName_1 = new JLabel("ID Type :");
        lblName_1.setBounds(35, 190, 200, 14);
        contentPane.add(lblName_1);

        l4 = new JLabel();
        l4.setBounds(271, 190, 200, 14);
        contentPane.add(l4);

        JLabel lblGender = new JLabel("Email :");
        lblGender.setBounds(35, 230, 200, 14);
        contentPane.add(lblGender);

        l5 = new JLabel();
        l5.setBounds(271, 230, 200, 14);
        contentPane.add(l5);

        JLabel lblCountry = new JLabel("Number :");
        lblCountry.setBounds(35, 270, 200, 14);
        contentPane.add(lblCountry);

        l6 = new JLabel();
        l6.setBounds(271, 270, 200, 14);
        contentPane.add(l6);

        JLabel lblReserveRoomNumber = new JLabel("Name :");
        lblReserveRoomNumber.setBounds(35, 310, 200, 14);
        contentPane.add(lblReserveRoomNumber);

        l7 = new JLabel();
        l7.setBounds(271, 310, 200, 14);
        contentPane.add(l7);

        JLabel lblCheckInStatus = new JLabel("Gender :");
        lblCheckInStatus.setBounds(35, 350, 200, 14);
        contentPane.add(lblCheckInStatus);
        JLabel lblDeposite = new JLabel("Country" +
                " :");
        lblDeposite.setBounds(35, 390, 200, 14);
        contentPane.add(lblDeposite);
        l8 = new JLabel();
        l8.setBounds(271, 350, 200, 14);
        contentPane.add(l8);;

        l9 = new JLabel();
        l9.setBounds(271, 390, 200, 14);
        contentPane.add(l9);

        JButton b1 = new JButton("Check");
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Conn l = new Conn();
                try {
                    PreparedStatement pstmt = l.c.prepareStatement("select * from Customers where Username = ?");
                    pstmt.setString(1, c1.getSelectedItem());
                    ResultSet rs = pstmt.executeQuery();
                    if (rs.next()) {
                        l2.setText(rs.getString(1)); // assuming ID is at index 1
                        l3.setText(rs.getString(3));
                        l4.setText(rs.getString(4));
                        l5.setText(rs.getString(2));
                        l6.setText(rs.getString(6));
                        l7.setText(rs.getString(7));
                        l8.setText(rs.getString(8));
                        l9.setText(rs.getString(9));
                    }
                } catch (Exception ee) {
                    ee.printStackTrace();
                }
            }
        });
        b1.setBounds(425, 70, 80, 22);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        contentPane.add(b1);

        JButton btnNewButton = new JButton("Delete");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Conn c = new Conn();
                try {
                    String s1 = c1.getSelectedItem();
                    String q1 = "delete from Customers where Username = '" + s1 + "'";
                    c.s.executeUpdate(q1);
                    JOptionPane.showMessageDialog(null, "Customer Detail Deleted Successfully");
                    setVisible(false);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                } catch (NumberFormatException s) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid Number");
                }
            }
        });
        btnNewButton.setBounds(100, 430, 120, 30);
        btnNewButton.setBackground(Color.BLACK);
        btnNewButton.setForeground(Color.WHITE);
        contentPane.add(btnNewButton);

        JButton btnExit = new JButton("Back");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        btnExit.setBounds(260, 430, 120, 30);
        btnExit.setBackground(Color.BLACK);
        btnExit.setForeground(Color.WHITE);
        contentPane.add(btnExit);

        getContentPane().setBackground(Color.WHITE);
    }
}
