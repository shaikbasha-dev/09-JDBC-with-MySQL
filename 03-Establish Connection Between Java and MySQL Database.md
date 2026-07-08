# Establish Connection Between Java and MySQL Database

## Overview

Establishing a connection is the first and most important step in JDBC. Before executing any SQL query, a Java application must connect to the database using the JDBC API.

This example demonstrates how to establish a connection between a Java program and a MySQL database using:

* DriverManager
* Connection Interface
* MySQL JDBC URL
* Database Username and Password

---

## Objective

The objective of this program is to:

* Connect Java with MySQL Database.
* Verify whether the connection is successful.
* Display the connection object.
* Close the database connection properly.

---

## Java Program

```java
// A program to establish connection between Java Program and MYSQL Database

// Import all classes from java.sql package
import java.sql.*;

// Define a class named ConnectionDemo
class ConnectionDemo {

    // Main method
    public static void main(String[] args) throws SQLException {

        // Establish connection with MySQL database
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/test",
                "root",
                "root");

        // Print successful connection message
        System.out.println("Connection Successful " + con);

        // Close the connection
        con.close();
    }
}
```

---

## Output

```text
Connection Successful com.mysql.cj.jdbc.ConnectionImpl@XXXXXXXX
```

**Note:**

`XXXXXXXX` represents a unique hexadecimal hash code generated for the Connection object instance in memory.

Example:

```text
Connection Successful com.mysql.cj.jdbc.ConnectionImpl@5f184fc6
```

---

## Explanation of JDBC URL

```java
jdbc:mysql://localhost:3306/test
```

This URL contains:

| **Part**      | **Meaning**                   |
| --------- | ------------------------- |
| jdbc      | JDBC Protocol             |
| mysql     | Database Type             |
| localhost | Database Server Address   |
| 3306      | MySQL Default Port Number |
| test      | Database Name             |

---

## Line-by-Line Explanation

### 1. Import SQL Package

```java
import java.sql.*;
```

Imports all JDBC classes and interfaces such as:

* Connection
* DriverManager
* Statement
* PreparedStatement
* ResultSet
* SQLException

---

### 2. Create Class

```java
class ConnectionDemo
```

Creates a class named `ConnectionDemo`.

---

### 3. Main Method

```java
public static void main(String[] args) throws SQLException
```

* Program execution starts here.
* `throws SQLException` is used to handle database exceptions automatically.

---

### 4. Establish Connection

```java
Connection con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/test",
        "root",
        "root");
```

Explanation:

* DriverManager searches for a suitable JDBC driver.
* Creates a connection to MySQL database.
* Returns a Connection object.

Parameters:

1. Database URL
2. Username
3. Password

---

### 5. Print Connection Status

```java
System.out.println("Connection Successful " + con);
```

Displays:

* Success message.
* Connection object's information.

---

### 6. Close Connection

```java
con.close();
```

Purpose:

* Releases database resources.
* Closes communication with MySQL server.
* Prevents resource leaks.

---

## Pseudocode

```text
START

SET database_url = "jdbc:mysql://localhost:3306/test"
SET database_user = "root"
SET database_password = "root"

TRY

    OPEN connection using:
        database_url
        database_user
        database_password

    PRINT "Connection Successful"

    PRINT connection object details

    CLOSE connection

CATCH SQLException

    PRINT "Database connection failed"

END TRY

END
```

---

## Important Points

* JDBC stands for Java Database Connectivity.
* DriverManager is responsible for creating Connection objects.
* Connection acts as a bridge between Java and Database.
* MySQL default port number is 3306.
* Always close the connection after use.
* SQLException occurs when:

  * Database is not running.
  * Wrong username/password is provided.
  * Database name is incorrect.
  * JDBC Driver is missing.

---

## Common Errors

### Error 1

```text
Communications link failure
```

Reason:

* MySQL server is not running.

---

### Error 2

```text
Access denied for user 'root'
```

Reason:

* Incorrect username or password.

---

### Error 3

```text
Unknown database 'test'
```

Reason:

* Database does not exist.

---

## Best Practice

In real-world applications:

* Use try-with-resources.
* Store credentials in configuration files.
* Avoid hardcoding usernames and passwords.
* Use PreparedStatement for executing SQL queries.

---

## Summary

This program demonstrates how to establish a connection between a Java application and a MySQL database using JDBC.

Key concepts covered:

* JDBC Connection
* DriverManager
* MySQL JDBC URL
* Connection Object
* SQLException
* Resource Management

This is the foundation for all JDBC operations such as Insert, Update, Delete, and Select queries in Java Full Stack Development.
