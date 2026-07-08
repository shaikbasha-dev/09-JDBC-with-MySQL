# Insert Multiple Rows into MySQL Database using JDBC

## Overview

In JDBC, multiple records can be inserted into a database table by executing several SQL INSERT statements using a Statement object.

This program demonstrates:

* Connecting Java with MySQL Database
* Creating a Statement object
* Executing multiple INSERT statements
* Checking the number of rows inserted
* Closing database resources properly

This is one of the fundamental JDBC operations used in Java Full Stack Development.

---

## Objective

The objective of this program is to:

* Establish a connection with MySQL.
* Insert multiple records into a table.
* Understand executeUpdate().
* Verify the number of rows inserted successfully.

---

## Java Program

```java
// Import all classes from the java.sql package to use JDBC classes
import java.sql.*;

// Define a class named RowDemo
class RowDemo {

    // Main method
    public static void main(String[] args) throws SQLException {

        // Database URL
        String url = "jdbc:mysql://localhost:3306/test";

        // Database username
        String user = "root";

        // Database password
        String pass = "root";

        // First SQL INSERT query
        String sql1 =
                "Insert into sample values(123,'Apple')";

        // Second SQL INSERT query
        String sql2 =
                "Insert into sample values(456,'Banana')";

        // Establish database connection
        Connection con =
                DriverManager.getConnection(
                        url,
                        user,
                        pass);

        // Create Statement object
        Statement st =
                con.createStatement();

        // Execute first INSERT query
        int row1 =
                st.executeUpdate(sql1);

        System.out.println(
                "Row1 Updated " + row1);

        // Execute second INSERT query
        int row2 =
                st.executeUpdate(sql2);

        System.out.println(
                "Row2 Updated " + row2);

        // Print connection details
        System.out.println(
                "Connection Successful " + con);

        // Close Statement
        st.close();

        // Close Connection
        con.close();
    }
}
```

---

## Output

```text
Row1 Updated 1
Row2 Updated 1
Connection Successful com.mysql.cj.jdbc.ConnectionImpl@XXXXXXXX
```

**Note:**

`XXXXXXXX` represents the memory hash code of the connection object and may differ every time the program runs.

---

## Database Table Used

```sql
CREATE TABLE sample(
    id INT,
    name VARCHAR(50)
);
```

---

## Inserted Records

| ID  | Name   |
| --- | ------ |
| 123 | Apple  |
| 456 | Banana |

---

## Explanation of Important Statements

### Database URL

```java
String url =
"jdbc:mysql://localhost:3306/test";
```

Explanation:

| **Part**      | **Meaning**            |
| --------- | ------------------ |
| jdbc      | JDBC protocol      |
| mysql     | Database type      |
| localhost | Database server    |
| 3306      | MySQL default port |
| test      | Database name      |

---

### Establishing Connection

```java
Connection con =
DriverManager.getConnection(
url,
user,
pass);
```

Purpose:

* Opens communication between Java and MySQL.
* Returns a Connection object.

---

### Creating Statement

```java
Statement st =
con.createStatement();
```

Purpose:

* Creates a Statement object.
* Used to execute SQL queries.

---

### Executing INSERT Query

```java
int row1 =
st.executeUpdate(sql1);
```

Purpose:

* Executes INSERT statement.
* Returns number of affected rows.

Example:

```text
1
```

means:

```text
One row inserted successfully.
```

---

### Executing Another INSERT Query

```java
int row2 =
st.executeUpdate(sql2);
```

Again:

```text
1
```

means:

```text
One additional row inserted successfully.
```

---

### Printing Connection Status

```java
System.out.println(
"Connection Successful " + con);
```

Example:

```text
Connection Successful
com.mysql.cj.jdbc.ConnectionImpl@4b85612c
```

This confirms:

* Database connection established.
* JDBC driver is working correctly.

---

## Pseudocode

```text
START

SET url =
"jdbc:mysql://localhost:3306/test"

SET user = "root"

SET password = "root"

SET sql1 =
"Insert into sample values(123,'Apple')"

SET sql2 =
"Insert into sample values(456,'Banana')"

TRY

    OPEN database connection

    CREATE Statement

    EXECUTE sql1

    STORE affected rows in row1

    PRINT row1

    EXECUTE sql2

    STORE affected rows in row2

    PRINT row2

    PRINT connection successful

    CLOSE Statement

    CLOSE Connection

CATCH SQLException

    PRINT database error

END TRY

END
```

---

## JDBC Methods Used

| **Method**            | **Purpose**                         |
| ----------------- | ------------------------------- |
| getConnection()   | Creates database connection     |
| createStatement() | Creates Statement object        |
| executeUpdate()   | Executes INSERT, UPDATE, DELETE |
| close()           | Closes JDBC resources           |

---

## Important Points

* executeUpdate() is used for:

  * INSERT
  * UPDATE
  * DELETE

* It returns:

```text
Number of rows affected
```

* Statement is suitable for:

  * Static SQL queries
  * Fixed values

* Always close:

  * Statement
  * Connection

to avoid resource leaks.

---

## Limitations of this Approach

This program executes:

```text
INSERT Query 1

INSERT Query 2
```

separately.

For a large number of records:

* Performance becomes slower.
* More network calls are made.
* Database overhead increases.

---

## Better Approach

For multiple insertions, JDBC provides:

* Batch Processing
* PreparedStatement
* executeBatch()

These techniques:

* Improve performance
* Reduce network traffic
* Increase efficiency

You will cover these concepts in the next JDBC programs.

---

## Common Errors

### Error

```text
Duplicate entry for primary key
```

Reason:

The inserted ID already exists.

---

### Error

```text
Unknown database 'test'
```

Reason:

Database is not created.

---

### Error

```text
Communications link failure
```

Reason:

MySQL server is not running.

---

## Summary

This program demonstrates how to insert multiple rows into a MySQL database using JDBC Statement and executeUpdate().

### Concepts Covered

* JDBC Connection
* DriverManager
* Statement Interface
* executeUpdate()
* Multiple INSERT Queries
* Row Count
* Resource Management
* Database Connectivity

This is one of the most important JDBC programs for beginners and serves as the foundation for advanced topics such as JDBC Batch Processing and PreparedStatement in Java Full Stack Development.
