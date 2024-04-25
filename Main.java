package travel.management.system;

public class Main {
    public static void main(String[] args) {
        // Create an instance of Conn to establish the connection
        Conn connection = new Conn();

        // If the connection was successfully established
        if (connection.c != null) {
            System.out.println("Connection to SQL Server database successful!");
            try {
                // Close the connection after testing
                connection.c.close();
                System.out.println("Connection closed successfully!");
            } catch (Exception e) {
                System.out.println("Failed to close connection: " + e);
            }
        } else {
            System.out.println("Failed to establish connection to SQL Server database.");
        }
    }
}

