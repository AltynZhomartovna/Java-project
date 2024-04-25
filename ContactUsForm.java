package travel.management.system;
import javax.swing.*;
import java.awt.*;

public class ContactUsForm extends JFrame {
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField emailField;
    private JTextField mobileField;
    private JTextArea messageArea;

    public ContactUsForm() {
        setTitle("Contact Us Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null); // Center the window
        setLayout(new BorderLayout());

        JPanel formPanel = new JPanel(new GridLayout(6, 1));

        // Add form components
        formPanel.add(new JLabel("First Name"));
        firstNameField = new JTextField();
        formPanel.add(firstNameField);

        formPanel.add(new JLabel("Last Name"));
        lastNameField = new JTextField();
        formPanel.add(lastNameField);

        formPanel.add(new JLabel("Email"));
        emailField = new JTextField();
        formPanel.add(emailField);

        formPanel.add(new JLabel("Mobile"));
        mobileField = new JTextField();
        formPanel.add(mobileField);

        formPanel.add(new JLabel("Type Your Message Here..."));
        messageArea = new JTextArea();
        messageArea.setRows(5);
        JScrollPane scrollPane = new JScrollPane(messageArea);
        formPanel.add(scrollPane);

        JButton sendButton = new JButton("Send");
        sendButton.addActionListener(e -> sendMessage());
        formPanel.add(sendButton);

        add(formPanel, BorderLayout.CENTER);
    }

    private void sendMessage() {
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String email = emailField.getText();
        String mobile = mobileField.getText();
        String message = messageArea.getText();

        // Perform sending message logic here
        System.out.println("Sending message...");
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Email: " + email);
        System.out.println("Mobile: " + mobile);
        System.out.println("Message: " + message);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ContactUsForm form = new ContactUsForm();
            form.setVisible(true);
        });
    }
}
