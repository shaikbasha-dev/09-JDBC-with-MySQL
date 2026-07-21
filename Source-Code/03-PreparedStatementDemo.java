/*
 * =============================================================================
 * Program Name : PreparedStatementDemo.java
 * Repository   : 09-JDBC-with-MySQL
 * Topic        : PreparedStatement Interface in JDBC
 * Description  : This program demonstrates how to use the PreparedStatement
 *                interface to execute parameterized SQL queries in a MySQL
 *                database using JDBC.
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
public class PreparedStatementDemo {

    // Database URL containing protocol, host, port number, and database name.
    private static final String URL = "jdbc:mysql://localhost:3306/test";

    // Username used to connect to the MySQL database.
    private static final String USERNAME = "root";

    // Password used to connect to the MySQL database.
    private static final String PASSWORD = "root";

    // Main method - program execution starts here.
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

            // SQL query containing parameter placeholders (?).
            String query = "INSERT INTO sample (roll, name, cgpa) VALUES (?, ?, ?)";

            // Create a PreparedStatement object.
            preparedStatement = connection.prepareStatement(query);

            // Assign value to the first placeholder (roll).
            preparedStatement.setInt(1, 101);

            // Assign value to the second placeholder (name).
            preparedStatement.setString(2, "Shaik Mahaboob Basha");

            // Assign value to the third placeholder (cgpa).
            preparedStatement.setDouble(3, 9.25);

            // Execute the INSERT query.
            int rowsAffected = preparedStatement.executeUpdate();

            // Display the number of rows inserted.
            System.out.println("-----------------------------------------");
            System.out.println("Rows Inserted : " + rowsAffected);
            System.out.println("Record Inserted Successfully.");
            System.out.println("-----------------------------------------");

        }
        catch (SQLException e) {

            // Display an error message if the SQL statement fails.
            System.out.println("Error while executing PreparedStatement.");

            // Print complete exception details.
            e.printStackTrace();
        }
        finally {

            try {

                // Close the PreparedStatement object if it was created.
                if (preparedStatement != null) {

                    preparedStatement.close();

                    System.out.println("PreparedStatement Closed Successfully.");
                }

                // Close the database connection if it was established.
                if (connection != null) {

                    connection.close();

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
