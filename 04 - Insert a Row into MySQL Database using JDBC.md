# 04 - Insert a Row into MySQL Database using JDBC

## Overview

In JDBC, the **INSERT** statement is used to add new records into a database table.

This program demonstrates how to:

* Establish a connection with MySQL database
* Create a Statement object
* Execute an INSERT SQL query
* Check the number of affected rows
* Close the database connection properly

This is one of the most fundamental operations in JDBC and is widely used in Java Full Stack applications.

---

## Objective

The objective of this program is to:

* Insert a new row into a MySQL table.
* Learn the use of executeUpdate().
* Understand how Statement executes SQL commands.
* Display the number of inserted rows.

---

## Java Program

```java
// A program to insert a row inside a database

// Import the core Java SQL package
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

        // SQL INSERT query
        String sql = "Insert into sample values(999,'Anusha')";

        // Establish connection
        Connection con = DriverManager.getConnection(
                url,
                user,
                pass);

        // Create Statement object
        Statement st = con.createStatement();

        // Execute INSERT query
        int row = st.executeUpdate(sql);

        // Print affected rows
        System.out.println("Rows Updated " + row);

        // Print connection details
        System.out.println("Connection Successful " + con);

        // Close connection
        con.close();
    }
}
```

---

## Output

```text
Rows Updated 1
Connection Successful com.mysql.cj.jdbc.ConnectionImpl@XXXXXXXX
```

Example:

```text
Rows Updated 1
Connection Successful com.mysql.cj.jdbc.ConnectionImpl@5f184fc6
```

**Explanation:**

* `1` means one row has been inserted successfully.
* The hexadecimal value represents the connection object's memory reference.

---

## Database Table Used

Example table:

```sql
CREATE TABLE sample(
    id INT,
    name VARCHAR(50)
);
```

Before Insert:

| id | name |
| -- | ---- |
| -  | -    |

After Insert:

| id  | name   |
| --- | ------ |
| 999 | Anusha |

---

## Line-by-Line Explanation

### 1. Import JDBC Package

```java
import java.sql.*;
```

Imports all important JDBC interfaces and classes:

* Connection
* DriverManager
* Statement
* ResultSet
* SQLException

---

### 2. Database URL

```java
String url = "jdbc:mysql://localhost:3306/test";
```

Explanation:

| Part      | Meaning         |
| --------- | --------------- |
| jdbc      | JDBC Protocol   |
| mysql     | Database Type   |
| localhost | Database Server |
| 3306      | MySQL Port      |
| test      | Database Name   |

---

### 3. Username

```java
String user = "root";
```

Stores the MySQL username.

---

### 4. Password

```java
String pass = "root";
```

Stores the MySQL password.

---

### 5. SQL Query

```java
String sql =
"Insert into sample values(999,'Anusha')";
```

Purpose:

* Inserts a row into the sample table.
* Value `999` is stored in the ID column.
* Value `"Anusha"` is stored in the Name column.

---

### 6. Establish Connection

```java
Connection con =
DriverManager.getConnection(
url,
user,
pass);
```

Creates a connection between:

* Java Application
* MySQL Database

---

### 7. Create Statement

```java
Statement st =
con.createStatement();
```

Creates a Statement object to send SQL commands.

---

### 8. Execute Insert Query

```java
int row =
st.executeUpdate(sql);
```

`executeUpdate()` is used for:

* INSERT
* UPDATE
* DELETE

Return value:

* Number of rows affected.

Example:

```text
1
```

Means:

```text
One row inserted successfully.
```

---

### 9. Print Rows Updated

```java
System.out.println("Rows Updated " + row);
```

Displays:

```text
Rows Updated 1
```

---

### 10. Print Connection Details

```java
System.out.println(
"Connection Successful " + con);
```

Shows the active JDBC connection object.

---

### 11. Close Connection

```java
con.close();
```

Purpose:

* Releases database resources.
* Closes the communication channel.
* Prevents memory leaks.

---

## Pseudocode

```text
START

SET url = "jdbc:mysql://localhost:3306/test"

SET user = "root"

SET password = "root"

SET sql =
"Insert into sample values(999,'Anusha')"

TRY

    OPEN connection

    CREATE Statement object

    EXECUTE INSERT query

    STORE affected rows

    PRINT affected rows

    PRINT connection details

    CLOSE connection

CATCH SQLException

    PRINT "Database insertion failed"

END TRY

END
```

---

## Important Methods Used

| Method                        | Purpose                         |
| ----------------------------- | ------------------------------- |
| DriverManager.getConnection() | Creates database connection     |
| createStatement()             | Creates Statement object        |
| executeUpdate()               | Executes INSERT, UPDATE, DELETE |
| close()                       | Closes database connection      |

---

## Important Points

* `executeUpdate()` returns the number of rows affected.
* INSERT queries do not return ResultSet.
* Always close the connection after use.
* SQLException may occur due to:

  * Invalid database name
  * Wrong username/password
  * Table does not exist
  * MySQL server not running

---

## Common Errors

### Error

```text
Table 'test.sample' doesn't exist
```

Reason:

The table `sample` has not been created.

---

### Error

```text
Duplicate entry for primary key
```

Reason:

Trying to insert an existing ID value.

---

### Error

```text
Access denied for user 'root'
```

Reason:

Incorrect username or password.

---

## Best Practice

In real-world applications:

* Use PreparedStatement instead of Statement.
* Avoid hardcoding database credentials.
* Store credentials in configuration files.
* Use try-with-resources for automatic resource management.

---

## Summary

This program demonstrates how to insert a single row into a MySQL database using JDBC.

Concepts covered:

* JDBC Connection
* DriverManager
* Statement Interface
* executeUpdate()
* SQL INSERT Statement
* Database Resource Management

This forms the foundation for performing Create (Insert) operations in CRUD-based Java Full Stack applications.
