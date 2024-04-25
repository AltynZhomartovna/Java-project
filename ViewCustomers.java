package travel.management.system;
import java.awt.BorderLayout;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JTable;
import java.io.File;
import java.net.URL;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class ViewCustomers extends JFrame {
    Connection conn = null;
    private JPanel contentPane;
    private JTable table;
    private JLabel lblAvailability;
    private JLabel lblCleanStatus;
    private JLabel lblNewLabel;
    private JLabel lblNewLabel_1;
    private JLabel lblRoomNumber;
    private JLabel lblId;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ViewCustomers frame = new ViewCustomers();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    public ViewCustomers() throws SQLException {
        //conn = Javaconnect.getDBConnection();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(580, 220, 900, 530);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        table = new JTable();
        table.setBounds(0, 40, 900, 350);
        contentPane.add(table);
        DefaultTableModel model = new DefaultTableModel();
        table.setModel(model); // Set the table model
        // Add columns to the table model
        model.addColumn("Username");
        model.addColumn("Id Type");
        model.addColumn("Number");
        model.addColumn("Name");
        model.addColumn("Gender");
        model.addColumn("Country");
        model.addColumn("Address");
        model.addColumn("Phone");
        model.addColumn("Email");

        try {
            Conn c = new Conn();
            String displayCustomersql = "select * from customers";
            ResultSet rs = c.s.executeQuery(displayCustomersql);

            // Loop through the ResultSet and add rows to the table model
            while (rs.next()) {
                Object[] row = new Object[9]; // Array to hold data for each row
                // Retrieve data from the ResultSet and populate the row array
                row[0] = rs.getString("Username");
                row[1] = rs.getString("IdType");
                row[2] = rs.getString("Number");
                row[3] = rs.getString("Name");
                row[4] = rs.getString("Gender");
                row[5] = rs.getString("Coubtry");
                row[6] = rs.getString("Address");
                row[7] = rs.getString("Phone");
                row[8] = rs.getString("Email");
                // Add the row to the table model
                model.addRow(row);
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        JButton btnNewButton = new JButton("Back");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        btnNewButton.setBounds(390, 430, 120, 30);
        btnNewButton.setBackground(Color.BLACK);
        btnNewButton.setForeground(Color.WHITE);
        contentPane.add(btnNewButton);

        lblAvailability = new JLabel("Username");
        lblAvailability.setBounds(10, 15, 69, 14);
        contentPane.add(lblAvailability);

        lblCleanStatus = new JLabel("Id Type");
        lblCleanStatus.setBounds(110, 15, 76, 14);
        contentPane.add(lblCleanStatus);

        lblNewLabel = new JLabel("Number");
        lblNewLabel.setBounds(220, 15, 46, 14);
        contentPane.add(lblNewLabel);

        lblNewLabel_1 = new JLabel("Name");
        lblNewLabel_1.setBounds(320, 15, 76, 14);
        contentPane.add(lblNewLabel_1);


        lblId = new JLabel("Gender");
        lblId.setBounds(420, 15, 90, 14);
        contentPane.add(lblId);

        JLabel l3 = new JLabel("Country");
        l3.setBounds(520, 15, 90, 14);
        contentPane.add(l3);

        JLabel l4 = new JLabel("Address");
        l4.setBounds(620, 15, 90, 14);
        contentPane.add(l4);

        JLabel l5 = new JLabel("Phone");
        l5.setBounds(720, 15, 90, 14);
        contentPane.add(l5);

        JLabel l6 = new JLabel("Email");
        l6.setBounds(820, 15, 90, 14);
        contentPane.add(l6);

        getContentPane().setBackground(Color.WHITE);
    }

}