/*
 * =============================================================================
 * Program Name : SelectRecordDemo.java
 * Repository   : 09-JDBC-with-MySQL
 * Topic        : Select Record Using PreparedStatement
 * Description  : This program demonstrates how to retrieve a specific record
 *                from a MySQL database using the PreparedStatement interface
 *                and the ResultSet interface.
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

// Import ResultSet to store the records returned by a SELECT query.
import java.sql.ResultSet;

// Import SQLException to handle database-related exceptions.
import java.sql.SQLException;

// Main class of the program.
public class SelectRecordDemo {

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

        // Declare the ResultSet reference.
        ResultSet resultSet = null;

        try {

            // Establish a connection with the MySQL database.
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            // Display connection success message.
            System.out.println("Database Connected Successfully.");

            // SQL query with a parameter placeholder.
            String query = "SELECT * FROM sample WHERE roll = ?";

            // Create the PreparedStatement object.
            preparedStatement = connection.prepareStatement(query);

            // Specify the roll number of the record to be retrieved.
            preparedStatement.setInt(1, 101);

            // Execute the SELECT query.
            resultSet = preparedStatement.executeQuery();

            // Check whether a record is available.
            if (resultSet.next()) {

                // Retrieve the Roll Number.
                int roll = resultSet.getInt("roll");

                // Retrieve the Student Name.
                String name = resultSet.getString("name");

                // Retrieve the CGPA.
                double cgpa = resultSet.getDouble("cgpa");

                // Display the retrieved record.
                System.out.println("\n==========================================");
                System.out.println("Student Record Found");
                System.out.println("==========================================");
                System.out.println("Roll Number : " + roll);
                System.out.println("Name        : " + name);
                System.out.println("CGPA        : " + cgpa);
                System.out.println("==========================================");

            } else {

                // Display message when no matching record exists.
                System.out.println("No Record Found With Roll Number : 101");
            }

        }
        catch (SQLException e) {

            // Display an error message.
            System.out.println("Unable to retrieve the record.");

            // Print the complete exception details.
            e.printStackTrace();

        }
        finally {

            try {

                // Check whether the ResultSet object exists.
                if (resultSet != null) {

                    // Close the ResultSet object.
                    resultSet.close();

                    // Display confirmation message.
                    System.out.println("ResultSet Closed Successfully.");
                }

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
