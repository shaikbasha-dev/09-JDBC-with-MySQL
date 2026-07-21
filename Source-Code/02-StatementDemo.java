/*
 * =============================================================================
 * Program Name : StatementDemo.java
 * Repository   : 09-JDBC-with-MySQL
 * Topic        : Statement Interface in JDBC
 * Description  : This program demonstrates how to use the Statement interface
 *                to execute SQL queries in a MySQL database using JDBC.
 *
 * Author       : Shaik Mahaboob Basha
 * =============================================================================
 */

// Import the Connection interface to establish a database connection.
import java.sql.Connection;

// Import DriverManager to obtain the database connection.
import java.sql.DriverManager;

// Import ResultSet to store the records returned by the SQL query.
import java.sql.ResultSet;

// Import SQLException to handle database-related exceptions.
import java.sql.SQLException;

// Import Statement to execute SQL queries.
import java.sql.Statement;

// Main class of the program.
public class StatementDemo {

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

            // Create a Statement object using the active database connection.
            statement = connection.createStatement();

            // SQL query to retrieve all records from the sample table.
            String query = "SELECT * FROM sample";

            // Execute the SELECT query.
            resultSet = statement.executeQuery(query);

            // Display table heading.
            System.out.println("\n---------------------------------------------");
            System.out.println("Roll No\tName\t\tCGPA");
            System.out.println("---------------------------------------------");

            // Traverse through each row of the ResultSet.
            while (resultSet.next()) {

                // Read the Roll Number from the current row.
                int roll = resultSet.getInt("roll");

                // Read the Student Name from the current row.
                String name = resultSet.getString("name");

                // Read the CGPA from the current row.
                double cgpa = resultSet.getDouble("cgpa");

                // Display the retrieved record.
                System.out.println(roll + "\t" + name + "\t\t" + cgpa);
            }

            // Display completion message.
            System.out.println("---------------------------------------------");
            System.out.println("Records Retrieved Successfully.");

        }
        catch (SQLException e) {

            // Display error message.
            System.out.println("Error while executing SQL query.");

            // Print complete exception details.
            e.printStackTrace();
        }
        finally {

            try {

                // Close the ResultSet if it was created.
                if (resultSet != null) {
                    resultSet.close();
                    System.out.println("ResultSet Closed Successfully.");
                }

                // Close the Statement object.
                if (statement != null) {
                    statement.close();
                    System.out.println("Statement Closed Successfully.");
                }

                // Close the database connection.
                if (connection != null) {
                    connection.close();
                    System.out.println("Connection Closed Successfully.");
                }

            }
            catch (SQLException e) {

                // Print any exception that occurs during resource cleanup.
                e.printStackTrace();
            }
        }
    }
}
