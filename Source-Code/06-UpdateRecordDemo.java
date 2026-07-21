/*
 * =============================================================================
 * Program Name : UpdateRecordDemo.java
 * Repository   : 09-JDBC-with-MySQL
 * Topic        : Update Record Using PreparedStatement
 * Description  : This program demonstrates how to update an existing record
 *                in a MySQL database using the PreparedStatement interface.
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
public class UpdateRecordDemo {

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

            // SQL query with parameter placeholders.
            String query = "UPDATE sample SET name = ?, cgpa = ? WHERE roll = ?";

            // Create the PreparedStatement object.
            preparedStatement = connection.prepareStatement(query);

            // Set the updated student name.
            preparedStatement.setString(1, "Rahul Kumar");

            // Set the updated CGPA.
            preparedStatement.setDouble(2, 9.10);

            // Specify the roll number of the record to be updated.
            preparedStatement.setInt(3, 105);

            // Execute the UPDATE query.
            int rowsAffected = preparedStatement.executeUpdate();

            // Check whether the record was updated successfully.
            if (rowsAffected > 0) {

                // Display success message.
                System.out.println("==========================================");
                System.out.println("Record Updated Successfully.");
                System.out.println("Rows Affected : " + rowsAffected);
                System.out.println("==========================================");

            } else {

                // Display message when no matching record exists.
                System.out.println("No Matching Record Found.");
            }

        }
        catch (SQLException e) {

            // Display an error message.
            System.out.println("Unable to update the record.");

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
