/*
 * =============================================================================
 * Program Name : CallableStatementDemo.java
 * Repository   : 09-JDBC-with-MySQL
 * Topic        : CallableStatement Interface in JDBC
 * Description  : This program demonstrates how to call a MySQL Stored
 *                Procedure using the CallableStatement interface in JDBC.
 *
 * Author       : Shaik Mahaboob Basha
 * =============================================================================
 */

// Import the CallableStatement interface to execute stored procedures.
import java.sql.CallableStatement;

// Import the Connection interface to establish a database connection.
import java.sql.Connection;

// Import DriverManager to obtain the database connection.
import java.sql.DriverManager;

// Import SQLException to handle database-related exceptions.
import java.sql.SQLException;

// Main class of the program.
public class CallableStatementDemo {

    // Database URL containing protocol, host, port number, and database name.
    private static final String URL = "jdbc:mysql://localhost:3306/test";

    // Username used to connect to the MySQL database.
    private static final String USERNAME = "root";

    // Password used to connect to the MySQL database.
    private static final String PASSWORD = "root";

    // Main method - Program execution starts here.
    public static void main(String[] args) {

        // Declare the Connection reference.
        Connection connection = null;

        // Declare the CallableStatement reference.
        CallableStatement callableStatement = null;

        try {

            // Establish a connection with the MySQL database.
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            // Display connection success message.
            System.out.println("Database Connected Successfully.");

            // SQL syntax to call a stored procedure.
            String procedure = "{CALL insert_student(?, ?, ?)}";

            // Create the CallableStatement object.
            callableStatement = connection.prepareCall(procedure);

            // Set the Roll Number parameter.
            callableStatement.setInt(1, 301);

            // Set the Student Name parameter.
            callableStatement.setString(2, "Anjali");

            // Set the Student CGPA parameter.
            callableStatement.setDouble(3, 9.35);

            // Execute the stored procedure.
            callableStatement.execute();

            // Display success message.
            System.out.println("=========================================");
            System.out.println("Stored Procedure Executed Successfully.");
            System.out.println("Student Record Inserted.");
            System.out.println("=========================================");

        }
        catch (SQLException e) {

            // Display an error message.
            System.out.println("Unable to execute the stored procedure.");

            // Print the complete exception details.
            e.printStackTrace();

        }
        finally {

            try {

                // Check whether the CallableStatement object exists.
                if (callableStatement != null) {

                    // Close the CallableStatement object.
                    callableStatement.close();

                    // Display confirmation message.
                    System.out.println("CallableStatement Closed Successfully.");
                }

                // Check whether the Connection object exists.
                if (connection != null) {

                    // Close the database connection.
                    connection.close();

                    // Display confirmation message.
                    System.out.println("Connection Closed Successfully.");
                }

            }
            catch (SQLException e) {

                // Print any exception that occurs while closing resources.
                e.printStackTrace();
            }
        }
    }
}
