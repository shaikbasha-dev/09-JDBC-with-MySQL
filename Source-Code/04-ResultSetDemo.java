/*
 * =============================================================================
 * Program Name : ResultSetDemo.java
 * Repository   : 09-JDBC-with-MySQL
 * Topic        : ResultSet Interface in JDBC
 * Description  : This program demonstrates how to retrieve records from a
 *                MySQL database using the ResultSet interface and process
 *                each row returned by a SELECT query.
 *
 * Author       : Shaik Mahaboob Basha
 * =============================================================================
 */

// Import the Connection interface to establish a database connection.
import java.sql.Connection;

// Import DriverManager to obtain the database connection.
import java.sql.DriverManager;

// Import Statement to execute SQL queries.
import java.sql.Statement;

// Import ResultSet to store records returned by a SELECT query.
import java.sql.ResultSet;

// Import SQLException to handle database-related exceptions.
import java.sql.SQLException;

// Main class of the program.
public class ResultSetDemo {

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

        // Declare the Statement reference.
        Statement statement = null;

        // Declare the ResultSet reference.
        ResultSet resultSet = null;

        try {

            // Establish a connection with the MySQL database.
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            // Display connection success message.
            System.out.println("Database Connected Successfully.");

            // Create a Statement object.
            statement = connection.createStatement();

            // SQL query to retrieve all student records.
            String query = "SELECT * FROM sample";

            // Execute the SQL query and store the returned records
            // inside the ResultSet object.
            resultSet = statement.executeQuery(query);

            // Display the table heading.
            System.out.println("\n====================================================");
            System.out.println("           STUDENT INFORMATION");
            System.out.println("====================================================");
            System.out.printf("%-10s %-25s %-10s%n", "ROLL", "NAME", "CGPA");
            System.out.println("----------------------------------------------------");

            // Traverse the ResultSet one row at a time.
            while (resultSet.next()) {

                // Read the value of the "roll" column.
                int roll = resultSet.getInt("roll");

                // Read the value of the "name" column.
                String name = resultSet.getString("name");

                // Read the value of the "cgpa" column.
                double cgpa = resultSet.getDouble("cgpa");

                // Display the retrieved record.
                System.out.printf("%-10d %-25s %-10.2f%n", roll, name, cgpa);
            }

            // Display completion message.
            System.out.println("----------------------------------------------------");
            System.out.println("All Records Retrieved Successfully.");
            System.out.println("====================================================");

        }
        catch (SQLException e) {

            // Display an error message.
            System.out.println("Unable to retrieve records from the database.");

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

                // Check whether the Statement object exists.
                if (statement != null) {

                    // Close the Statement object.
                    statement.close();

                    // Display confirmation message.
                    System.out.println("Statement Closed Successfully.");
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
