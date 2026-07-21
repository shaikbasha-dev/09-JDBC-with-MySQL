/*
 * =============================================================================
 * Program Name : BatchProcessingDemo.java
 * Repository   : 09-JDBC-with-MySQL
 * Topic        : Batch Processing Using PreparedStatement
 * Description  : This program demonstrates how to execute multiple SQL
 *                INSERT statements efficiently using JDBC Batch Processing.
 *
 * Author       : Shaik Mahaboob Basha
 * =============================================================================
 */

// Import the Connection interface to establish a database connection.
import java.sql.Connection;

// Import DriverManager to obtain the database connection.
import java.sql.DriverManager;

// Import PreparedStatement to execute parameterized SQL queries.
import java.sql.PreparedStatement;

// Import SQLException to handle database-related exceptions.
import java.sql.SQLException;

// Main class of the program.
public class BatchProcessingDemo {

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

        // Declare the PreparedStatement reference.
        PreparedStatement preparedStatement = null;

        try {

            // Establish a connection with the MySQL database.
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            // Display connection success message.
            System.out.println("Database Connected Successfully.");

            // SQL query containing parameter placeholders.
            String query = "INSERT INTO sample (roll, name, cgpa) VALUES (?, ?, ?)";

            // Create the PreparedStatement object.
            preparedStatement = connection.prepareStatement(query);

            // -------------------- Batch Record 1 --------------------

            // Set the roll number.
            preparedStatement.setInt(1, 201);

            // Set the student name.
            preparedStatement.setString(2, "Rahul");

            // Set the student CGPA.
            preparedStatement.setDouble(3, 8.45);

            // Add the current SQL statement to the batch.
            preparedStatement.addBatch();

            // -------------------- Batch Record 2 --------------------

            // Set the roll number.
            preparedStatement.setInt(1, 202);

            // Set the student name.
            preparedStatement.setString(2, "Priya");

            // Set the student CGPA.
            preparedStatement.setDouble(3, 9.12);

            // Add the current SQL statement to the batch.
            preparedStatement.addBatch();

            // -------------------- Batch Record 3 --------------------

            // Set the roll number.
            preparedStatement.setInt(1, 203);

            // Set the student name.
            preparedStatement.setString(2, "Arjun");

            // Set the student CGPA.
            preparedStatement.setDouble(3, 8.90);

            // Add the current SQL statement to the batch.
            preparedStatement.addBatch();

            // Execute all SQL statements stored in the batch.
            int[] result = preparedStatement.executeBatch();

            // Display success message.
            System.out.println("==============================================");
            System.out.println("Batch Processing Executed Successfully.");
            System.out.println("Total Records Processed : " + result.length);
            System.out.println("==============================================");

        }
        catch (SQLException e) {

            // Display an error message.
            System.out.println("Error while executing batch processing.");

            // Print the complete exception details.
            e.printStackTrace();

        }
        finally {

            try {

                // Check whether the PreparedStatement object exists.
                if (preparedStatement != null) {

                    // Close the PreparedStatement object.
                    preparedStatement.close();

                    // Display confirmation message.
                    System.out.println("PreparedStatement Closed Successfully.");
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
