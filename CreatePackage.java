package travel.management.system;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;
import javax.swing.*;

public class CreatePackage extends JFrame implements ActionListener {
    private Container c;
    private JLabel label, pid, pname, date, cost,user,per;
    private Font f;
    private JTextField tid, tname, tdate, tcost,pers,tuser;
    private JButton back,  save;

    CreatePackage() {
        initcomponents();
    }

    public void initcomponents() {
        c = getContentPane();
        c.setLayout(null);
        this.setTitle("Package Pane");
        this.setBackground(Color.WHITE);
        this.setBounds(550, 250, 500, 450);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f = new Font("Arial", Font.BOLD, 20);

        label = new JLabel("Create Package");
        label.setBounds(170, 20, 200, 30);
        label.setFont(f);
        label.setForeground(Color.black);
        c.add(label);
        user = new JLabel("Username:");
        user.setBounds(100, 70, 100, 30);
        c.add(user);
        tuser= new JTextField();
        tuser.setBounds(250, 73, 120, 25);
        c.add(tuser);
        pid = new JLabel("Service ID:");
        pid.setBounds(100, 110, 100, 30);
        c.add(pid);
        tid = new JTextField();
        tid.setBounds(250, 113, 120, 25);
        c.add(tid);

        pname = new JLabel("Package Name:");
        pname.setBounds(100, 150, 100, 30);
        c.add(pname);
        tname = new JTextField();
        tname.setBounds(250, 153, 120, 25);
        c.add(tname);

        date = new JLabel("Travel Days:");
        date.setBounds(100, 190, 100, 30);
        c.add(date);
        tdate = new JTextField();
        tdate.setBounds(250, 193, 120, 25);
        c.add(tdate);
        cost = new JLabel("Travel Cost:");
        cost.setBounds(100, 230, 100, 30);
        c.add(cost);
        tcost = new JTextField();
        tcost.setBounds(250, 233, 120, 25);
        c.add(tcost);
        per = new JLabel("Total Persons:");
        per.setBounds(100, 270, 100, 30);
        c.add(per);

        pers = new JTextField();
        pers.setBounds(250, 273, 120, 25);
        c.add(pers);


        back = new JButton("Main Menu");
        back.setBounds(250, 320, 113, 25);
        back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                new Home("").setVisible(true);
            }
        });
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        c.add(back);

        save = new JButton("Save");
        save.setBackground(Color.BLACK);
        save.setForeground(Color.WHITE);
        save.setBounds(100, 320, 113, 25);
        save.addActionListener(this);
        c.add(save);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String clickbutton = e.getActionCommand();

        if (clickbutton.equals(back.getText())) {
            new Home("").setVisible(true);
            this.setVisible(false);
        } else if (clickbutton.equals(save.getText())) {
            createDB();
            JOptionPane.showMessageDialog(null, "New Package Saved");
        }
    }


    public void createDB() {
        String query = "INSERT INTO BookPackage (Username, Id, PackageName, TravelDays, TravelCost, TotalPersons) " +
                "VALUES ('" + tuser.getText() + "','" + tid.getText() + "','" + tname.getText() + "','" +
                tdate.getText() + "','" + tcost.getText() + "','" + pers.getText() + "')";
        System.out.println(query);
        Connection con = null;
        Statement st = null;
    }

    public static void main(String[] args) {
        new CreatePackage().setVisible(true);

    }
}
