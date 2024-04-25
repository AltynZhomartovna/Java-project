package travel.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.net.URL;
import java.io.File;
public class Home extends JFrame{
    String username;
    public static void main(String[] args) {
        new Home("").setVisible(true);
    }
    public Home(String username) {
        super("Travel and Tourism Management System");
        this.username = username;
        setForeground(Color.CYAN);
        setLayout(null);


        JLabel NewLabel = new JLabel();
        NewLabel.setBounds(0, 0, 700, 700);
        add(NewLabel);

        try {
            File file = new File("C:\\Users\\user\\IdeaProjects\\Java project\\home.jpg");
            String imagePath = file.toURI().toURL().toString();
            ImageIcon c1 = new ImageIcon(new URL(imagePath));
            Image i1 = c1.getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT);
            ImageIcon i2 = new ImageIcon(i1);
            JLabel l6 = new JLabel(i2);
            l6.setBounds(0, 0, 800, 600);
            add(l6);
        } catch (Exception e) {
            e.printStackTrace();
        }
        JPanel textPanel = new JPanel(new BorderLayout());
        textPanel.setOpaque(false); // Make the panel transparent

        JLabel l1 = new JLabel("Welcome to our Travel Agency");
        l1.setForeground(Color.BLACK);
        l1.setFont(new Font("Tahoma", Font.BOLD, 35));
        l1.setBounds(130, 180, 600, 100);
        NewLabel.add(l1);
        JLabel l2 = new JLabel("We offer personalized travel experiences tailored to your needs.");
        l2.setForeground(Color.black);
        l2.setFont(new Font("Tahoma", Font.PLAIN ,20));
        l2.setBounds(120, 240, 600, 100);
        NewLabel.add(l2);
        JLabel additionalTextLabel = new JLabel("Explore our exciting destinations and book your dream vacation today!");
        additionalTextLabel.setForeground(Color.black);
        additionalTextLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        additionalTextLabel.setBounds(108, 290, 600, 50); // Position it below the first label
        NewLabel.add(additionalTextLabel);


        JButton contactButton = new JButton("Get Started");
        contactButton.setForeground(Color.white);
        contactButton.setBackground(Color.black);
        contactButton.setBounds(300, 380, 150, 40);
        contactButton.setFont(new Font("Arial", Font.PLAIN, 20)); // Set font and size
        contactButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                // Open Contact Us form
                new ContactUsForm().setVisible(true);
            }
        });

        NewLabel.add(contactButton, BorderLayout.CENTER);


        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu m1 = new JMenu("CUSTOMER");
        m1.setForeground(Color.BLACK);
        menuBar.add(m1);

        JMenuItem mi1 = new JMenuItem("ADD CUSTOMER");
        m1.add(mi1);


        JMenuItem mi3 = new JMenuItem("VIEW CUSTOMER DETAILS");
        m1.add(mi3);

        JMenuItem mi4 = new JMenuItem("DELETE CUSTOMER DETAILS");
        m1.add(mi4);

        mi1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    new AddCustomer(username).setVisible(true);
                }catch(Exception e ){}
            }
        });
        mi3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    new ViewCustomers().setVisible(true);
                }catch(Exception e ){}
            }
        });
        mi4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    new DeleteCustomer().setVisible(true);
                }catch(Exception e ){}
            }
        });

        JMenu m2 = new JMenu("PACKAGES");
        m2.setForeground(Color.BLACK);
        menuBar.add(m2);

        JMenuItem mi6 = new JMenuItem("CREATE PACKAGE");
        m2.add(mi6);

        JMenuItem mi7 = new JMenuItem("BOOK PACKAGE");
        m2.add(mi7);

        JMenuItem mi5 = new JMenuItem("VIEW PACKAGE");
        m2.add(mi5);

        mi6.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    new CreatePackage().setVisible(true);
                }catch(Exception e ){}
            }
        });


        mi7.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    new BookPackage(username).setVisible(true);
                }catch(Exception e ){}
            }
        });


        mi5.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    new ViewPackage(username).setVisible(true);
                }catch(Exception e ){}

            }
        });

        JMenu m5 = new JMenu("CONTACT");
        m5.setForeground(Color.BLACK);
        menuBar.add(m5);

        JMenuItem mi12 = new JMenuItem("CONTACT US");
        m5.add(mi12);
        m5.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                new ContactUsForm().setVisible(true);
            }
        });

        JMenu m6 = new JMenu("UTILITY");
        m6.setForeground(Color.BLACK);
        menuBar.add(m6);

        JMenuItem mi13 = new JMenuItem("NOTEPAD");
        m6.add(mi13);

        JMenuItem mi14 = new JMenuItem("CALCULATOR");
        m6.add(mi14);

        mi13.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    Runtime.getRuntime().exec("notepad.exe");
                }catch(Exception e){ }
            }
        });


        mi14.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    Runtime.getRuntime().exec("calc.exe");
                }catch(Exception e){ }
            }
        });

        JMenu m7 = new JMenu("ABOUT");
        m7.setForeground(Color.BLACK);
        menuBar.add(m7);

        JMenuItem mi15 = new JMenuItem("ABOUT");
        m7.add(mi15);

        mi15.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                new About().setVisible(true);
            }
        });



        setPreferredSize(new Dimension(800, 600)); // Set preferred size for the frame
        pack(); // Pack the components to fit the preferred size
        setLocationRelativeTo(null); // Center the frame on the screen
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set default close operation
        getContentPane().setBackground(Color.WHITE);
    }

}