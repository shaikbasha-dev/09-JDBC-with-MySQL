/*
 * =============================================================================
 * Program Name : ConnectionDemo.java
 * Repository   : 09-JDBC-with-MySQL
 * Topic        : Establish Connection Between Java and MySQL
 * Description  : This program demonstrates how to establish a connection
 *                between a Java application and a MySQL database using JDBC.
 *
 * Author       : Shaik Mahaboob Basha
 * =============================================================================
 */

// Import the Connection interface to represent a database connection.
import java.sql.Connection;

// Import DriverManager to establish a connection with the database.
import java.sql.DriverManager;

// Import SQLException to handle database-related exceptions.
import java.sql.SQLException;

// Main class of the program.
public class ConnectionDemo {

    // Database URL containing protocol, host, port, and database name.
    private static final String URL = "jdbc:mysql://localhost:3306/test";

    // Username used to connect to the MySQL database.
    private static final String USERNAME = "root";

    // Password used to connect to the MySQL database.
    private static final String PASSWORD = "root";

    // Main method - program execution starts here.
    public static void main(String[] args) {

        // Declare a Connection reference.
        // Initially it does not point to any database connection.
        Connection connection = null;

        try {

            // Establish a connection with the MySQL database.
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            // Display success message.
            System.out.println("======================================");
            System.out.println(" Connection Established Successfully");
            System.out.println("======================================");

            // Display the database URL.
            System.out.println("Database URL : " + URL);

            // Display the connected username.
            System.out.println("User Name    : " + USERNAME);

        }
        catch (SQLException e) {

            // Display a failure message if the connection cannot be established.
            System.out.println("Database Connection Failed!");

            // Print the complete exception details for debugging.
            e.printStackTrace();
        }
        finally {

            try {

                // Check whether the connection object was created successfully.
                if (connection != null) {

                    // Close the database connection to release resources.
                    connection.close();

                    // Display confirmation message.
                    System.out.println("\nConnection Closed Successfully.");
                }

            }
            catch (SQLException e) {

                // Print any exception that occurs while closing the connection.
                e.printStackTrace();
            }
        }
    }
}
