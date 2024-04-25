package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class BookPackage extends JFrame {
    private JPanel contentPane;
    private JTextField t1;
    private Choice c1;
    private JLabel l2, l3, l4, l5;
    private String username;

    public BookPackage(String username) {
        this.username = username;
        setTitle("Book Package");
        setBounds(420, 220, 700, 450);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblName = new JLabel("BOOK PACKAGE");
        lblName.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
        lblName.setBounds(118, 11, 300, 53);
        contentPane.add(lblName);

        JLabel la2 = new JLabel("Username:");
        la2.setBounds(35, 70, 200, 14);
        contentPane.add(la2);

        JLabel l1 = new JLabel(username);
        l1.setBounds(271, 70, 200, 14);
        contentPane.add(l1);
        JLabel lblId = new JLabel("Select Package:");
        lblId.setBounds(35, 110, 200, 14);
        contentPane.add(lblId);
        c1 = new Choice();

        try {
            Conn connection = new Conn();
            String query = "SELECT PackageName FROM BookPackage";
            ResultSet resultSet = connection.s.executeQuery(query);

            while (resultSet.next()) {
                String packageName = resultSet.getString("PackageName");
                c1.add(packageName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        c1.setBounds(271, 110, 150, 30);
        contentPane.add(c1);


        JLabel la3 = new JLabel("Total Persons:");
        la3.setBounds(35, 150, 200, 14);
        contentPane.add(la3);

        t1 = new JTextField();
        t1.setText("0");
        t1.setBounds(271, 150, 150, 20);
        contentPane.add(t1);
        t1.setColumns(10);
;


        JButton b1 = new JButton("Check Price");
        String packageType = c1.getSelectedItem();
        try {
            // Establish database connection and execute query to retrieve price based on package name
            Conn connection = new Conn();
            String query = "SELECT TravelCost  FROM BookPackage WHERE PackageName = ?";
            PreparedStatement pstmt = connection.c.prepareStatement(query);
            pstmt.setString(1, packageType);
            ResultSet resultSet = pstmt.executeQuery();

            if (resultSet.next()) {
                double price = resultSet.getDouble("TravelCost");
                int totalPersons = Integer.parseInt(t1.getText());
                double totalPrice = price * totalPersons;
                l5.setText(Double.toString(totalPrice));
            } else {
                JOptionPane.showMessageDialog(null, "Package not found in database");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        b1.setBounds(50, 350, 120, 30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        contentPane.add(b1);

        JButton btnNewButton = new JButton("Book");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bookPackage();
            }
        });
        btnNewButton.setBounds(200, 350, 120, 30);
        btnNewButton.setBackground(Color.BLACK);
        btnNewButton.setForeground(Color.WHITE);
        contentPane.add(btnNewButton);

        JButton btnExit = new JButton("Back");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        btnExit.setBounds(350, 350, 120, 30);
        btnExit.setBackground(Color.BLACK);
        btnExit.setForeground(Color.WHITE);
        contentPane.add(btnExit);

        JLabel la4 = new JLabel("ID:");
        la4.setBounds(35, 190, 200, 14);
        contentPane.add(la4);

        l2 = new JLabel();
        l2.setBounds(271, 190, 200, 14);
        contentPane.add(l2);

        JLabel lbl2 = new JLabel("Travel Days:");
        lbl2.setBounds(35, 230, 200, 14);
        contentPane.add(lbl2);

        l3 = new JLabel();
        l3.setBounds(271, 230, 200, 14);
        contentPane.add(l3);
        JTextField userField = new JTextField();
        userField.setBounds(271, 70, 200, 20);
        contentPane.add(userField);
        JTextField idField = new JTextField();
        idField.setBounds(271, 190, 200, 20);
        contentPane.add(idField);

        JTextField numberField = new JTextField();
        numberField.setBounds(271, 230, 200, 20);
        contentPane.add(numberField);


        JTextField priceField = new JTextField();
        priceField.setBounds(271, 270, 200, 20);
        contentPane.add(priceField);


        getContentPane().setBackground(Color.WHITE);
    }

    private void calculatePrice() {
        String p = c1.getSelectedItem();
    }

    private void bookPackage() {
        String packageType = c1.getSelectedItem();
        String totalPersons = t1.getText();
        String id = l2.getText();
        String totalPrice = l5.getText();
        String totalDays = l3.getText();

        try {
            Conn p = new Conn();
            String query = "INSERT INTO BookPackage (Username, PackageName, totalPersons, Id, TravelCost,TravelDays) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = p.c.prepareStatement(query);
            pstmt.setString(1, username);
            pstmt.setString(2, packageType);
            pstmt.setString(3, totalPersons);
            pstmt.setString(4, id);
            pstmt.setString(7, totalDays);

            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null, "Package Booked Successfully");
                setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "Failed to book package");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                BookPackage frame = new BookPackage("");
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
