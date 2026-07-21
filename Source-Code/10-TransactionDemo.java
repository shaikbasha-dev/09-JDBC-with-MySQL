/*
 * =============================================================================
 * Program Name : TransactionDemo.java
 * Repository   : 09-JDBC-with-MySQL
 * Topic        : Transaction Management in JDBC
 * Description  : This program demonstrates how to perform transaction
 *                management using commit() and rollback() methods in JDBC.
 *                It uses a simple bank money transfer example.
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
public class TransactionDemo {

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

        // Declare the PreparedStatement reference for debit operation.
        PreparedStatement debitStatement = null;

        // Declare the PreparedStatement reference for credit operation.
        PreparedStatement creditStatement = null;

        try {

            // Establish a connection with the MySQL database.
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            // Display connection success message.
            System.out.println("Database Connected Successfully.");

            // Disable Auto Commit mode.
            // This starts manual transaction management.
            connection.setAutoCommit(false);

            // SQL query to deduct money from the sender's account.
            String debitQuery =
                    "UPDATE bank_account SET balance = balance - ? WHERE account_number = ?";

            // SQL query to add money to the receiver's account.
            String creditQuery =
                    "UPDATE bank_account SET balance = balance + ? WHERE account_number = ?";

            // Create PreparedStatement object for debit operation.
            debitStatement = connection.prepareStatement(debitQuery);

            // Create PreparedStatement object for credit operation.
            creditStatement = connection.prepareStatement(creditQuery);

            // Amount to transfer.
            double transferAmount = 5000.00;

            // --------------------- Debit Operation ---------------------

            // Set transfer amount.
            debitStatement.setDouble(1, transferAmount);

            // Sender Account Number.
            debitStatement.setInt(2, 1001);

            // Execute debit operation.
            int debitRows = debitStatement.executeUpdate();

            // --------------------- Credit Operation ---------------------

            // Set transfer amount.
            creditStatement.setDouble(1, transferAmount);

            // Receiver Account Number.
            creditStatement.setInt(2, 1002);

            // Execute credit operation.
            int creditRows = creditStatement.executeUpdate();

            // Verify whether both operations were successful.
            if (debitRows > 0 && creditRows > 0) {

                // Permanently save both database operations.
                connection.commit();

                // Display success message.
                System.out.println("==============================================");
                System.out.println("Transaction Completed Successfully.");
                System.out.println("Amount Transferred : ₹" + transferAmount);
                System.out.println("Transaction Committed.");
                System.out.println("==============================================");

            } else {

                // Cancel all database changes.
                connection.rollback();

                // Display rollback message.
                System.out.println("==============================================");
                System.out.println("Transaction Failed.");
                System.out.println("Rollback Executed.");
                System.out.println("==============================================");
            }

        }
        catch (SQLException e) {

            try {

                // Check whether the connection object exists.
                if (connection != null) {

                    // Undo all database changes.
                    connection.rollback();

                    // Display rollback message.
                    System.out.println("Transaction Rolled Back Successfully.");
                }

            }
            catch (SQLException exception) {

                // Print rollback exception details.
                exception.printStackTrace();
            }

            // Display SQL exception message.
            System.out.println("Transaction Failed Due To Database Error.");

            // Print complete exception details.
            e.printStackTrace();

        }
        finally {

            try {

                // Restore Auto Commit mode.
                if (connection != null) {

                    connection.setAutoCommit(true);
                }

                // Close Debit PreparedStatement.
                if (debitStatement != null) {

                    debitStatement.close();

                    System.out.println("Debit PreparedStatement Closed Successfully.");
                }

                // Close Credit PreparedStatement.
                if (creditStatement != null) {

                    creditStatement.close();

                    System.out.println("Credit PreparedStatement Closed Successfully.");
                }

                // Close the database connection.
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
