
package travel.management.system;


import java.awt.BorderLayout;
import java.awt.*;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.Image;
import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class ViewPackage extends JFrame {
    JPanel contentPane;
    Choice c1;
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ViewPackage frame = new ViewPackage("");
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public ViewPackage(String username)  {
        setBounds(580, 220, 550, 450);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);



        JLabel lblName = new JLabel("VIEW PACKAGE DETAILS");
        lblName.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
        lblName.setBounds(88, 11, 350, 53);
        contentPane.add(lblName);
        JLabel lblId = new JLabel("Package :");
        lblId.setBounds(35, 70, 200, 14);
        contentPane.add(lblId);
        c1 = new Choice();
        Conn p = new Conn();
        try {
            ResultSet rs = p.s.executeQuery("select * from bookpackage");
            while (rs.next()) {
                c1.add(rs.getString("packageNAme"));
            }

            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        c1.setBounds(271, 70, 150, 30);
        add(c1);;

        JLabel lb3 = new JLabel("Username :");
        lb3.setBounds(35, 110, 200, 14);
        contentPane.add(lb3);

        JLabel l1 = new JLabel();
        l1.setBounds(271, 110, 200, 14);
        contentPane.add(l1);

        JLabel lb2 = new JLabel("Number of Persons :");
        lb2.setBounds(35, 150, 200, 14);
        contentPane.add(lb2);

        JLabel l3 = new JLabel();
        l3.setBounds(271, 150, 200, 14);
        contentPane.add(l3);

        JLabel lblName_1 = new JLabel("ID :");
        lblName_1.setBounds(35, 190, 200, 14);
        contentPane.add(lblName_1);

        JLabel l4 = new JLabel();
        l4.setBounds(271, 190, 200, 14);
        contentPane.add(l4);


        JLabel lblGender = new JLabel("Number :");
        lblGender.setBounds(35, 230, 200, 14);
        contentPane.add(lblGender);

        JLabel l5 = new JLabel();
        l5.setBounds(271, 230, 200, 14);
        contentPane.add(l5);

        JLabel lblCountry = new JLabel("Price :");
        lblCountry.setBounds(35, 270, 200, 14);
        contentPane.add(lblCountry);

        JLabel l6 = new JLabel();
        l6.setBounds(271, 270, 200, 14);
        contentPane.add(l6);


        JButton b1 = new JButton("Check");
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Conn l = new Conn();
                try {
                    PreparedStatement pstmt = l.c.prepareStatement("select * from BookPackage where PackageName = ?");
                    pstmt.setString(1, c1.getSelectedItem());
                    ResultSet rs = pstmt.executeQuery();
                    if (rs.next()) {// assuming ID is at index 1
                        l1.setText(rs.getString(1));
                        l3.setText(rs.getString(6));
                        l4.setText(rs.getString(2));
                        l5.setText(rs.getString(3));
                        l6.setText(rs.getString(4));

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


        JButton btnExit = new JButton("Back");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        btnExit.setBounds(160, 350, 120, 30);
        btnExit.setBackground(Color.BLACK);
        btnExit.setForeground(Color.WHITE);
        contentPane.add(btnExit);

        getContentPane().setBackground(Color.WHITE);
    }
}