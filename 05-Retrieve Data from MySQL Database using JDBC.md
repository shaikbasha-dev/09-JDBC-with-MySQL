# Retrieve Data from MySQL Database using JDBC

## Overview

Retrieving data is one of the most common operations performed in JDBC. Java applications frequently need to fetch records stored in databases and display them to users.

This program demonstrates how to:

* Connect Java with MySQL Database
* Execute a SELECT query
* Retrieve records using ResultSet
* Iterate through the rows returned from the database
* Close JDBC resources properly

---

## Objective

The objective of this program is to:

* Retrieve all rows from the `sample` table.
* Learn how ResultSet works.
* Understand the use of executeQuery().
* Display records row by row.

---

## Java Program

```java
// Import all classes from the java.sql package
import java.sql.*;

// Define a class named DataDemo
class DataDemo {

    // Main method
    public static void main(String[] args) throws SQLException {

        // Database URL
        String url = "jdbc:mysql://localhost:3306/test";

        // Database username
        String user = "root";

        // Database password
        String pass = "root";

        // SQL SELECT query
        String sql = "Select * from sample";

        // Establish connection
        Connection con =
                DriverManager.getConnection(
                        url,
                        user,
                        pass);

        // Create Statement object
        Statement st = con.createStatement();

        // Execute SELECT query
        ResultSet rs = st.executeQuery(sql);

        // Read rows one by one
        while(rs.next()) {

            System.out.println(
                    rs.getInt(1)
                    + ":" +
                    rs.getString(2));
        }

        // Close ResultSet
        rs.close();

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
123:Apple
456:Banana
```

Example Table:

| id  | name   |
| --- | ------ |
| 123 | Apple  |
| 456 | Banana |

Program Output:

```text
123:Apple
456:Banana
```

---

## Database Table Used

```sql
CREATE TABLE sample(
    id INT,
    name VARCHAR(50)
);
```

Sample Data:

```sql
INSERT INTO sample VALUES(123,'Apple');

INSERT INTO sample VALUES(456,'Banana');
```

---

## Line-by-Line Explanation

### 1. Import JDBC Package

```java
import java.sql.*;
```

Imports all JDBC interfaces and classes:

* Connection
* DriverManager
* Statement
* ResultSet
* SQLException

---

### 2. Database URL

```java
String url =
"jdbc:mysql://localhost:3306/test";
```

Explanation:

| **Part**      | **Meaning**         |
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

Stores database username.

---

### 4. Password

```java
String pass = "root";
```

Stores database password.

---

### 5. SQL Query

```java
String sql =
"Select * from sample";
```

This query retrieves all rows and columns from:

```text
sample table
```

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

Creates a Statement object for sending SQL commands.

---

### 8. Execute SELECT Query

```java
ResultSet rs =
st.executeQuery(sql);
```

Purpose:

* Executes SELECT statement.
* Returns the results as ResultSet.

---

### 9. ResultSet

```java
while(rs.next())
```

`next()`:

* Moves cursor to next row.
* Returns true if row exists.
* Returns false when no more rows exist.

---

### 10. Retrieve Column Values

```java
rs.getInt(1)
```

Gets integer value from:

```text
Column 1 -> id
```

---

```java
rs.getString(2)
```

Gets String value from:

```text
Column 2 -> name
```

---

### Print Output

```java
System.out.println(
rs.getInt(1)
+ ":"
+ rs.getString(2));
```

Output:

```text
123:Apple

456:Banana
```

---

### 11. Close ResultSet

```java
rs.close();
```

Releases memory occupied by ResultSet.

---

### 12. Close Statement

```java
st.close();
```

Closes SQL execution object.

---

### 13. Close Connection

```java
con.close();
```

Terminates communication with MySQL server.

---

## Pseudocode

```text
START

SET url = "jdbc:mysql://localhost:3306/test"

SET user = "root"

SET password = "root"

SET sql_query =
"Select * from sample"

TRY

    OPEN database connection

    CREATE Statement

    EXECUTE SELECT query

    STORE result in ResultSet

    WHILE ResultSet contains rows

        READ id

        READ name

        PRINT id:name

    END WHILE

    CLOSE ResultSet

    CLOSE Statement

    CLOSE Connection

CATCH SQLException

    PRINT "Database query failed"

END TRY

END
```

---

## Important JDBC Methods Used

| **Method**            | **Purpose**                     |
| ----------------- | --------------------------- |
| getConnection()   | Creates database connection |
| createStatement() | Creates Statement object    |
| executeQuery()    | Executes SELECT query       |
| next()            | Moves to next row           |
| getInt()          | Retrieves integer value     |
| getString()       | Retrieves String value      |
| close()           | Closes JDBC resources       |

---

## Difference Between executeQuery() and executeUpdate()

| **executeQuery()**    | **executeUpdate()**                 |
| ----------------- | ------------------------------- |
| Used for SELECT   | Used for INSERT, UPDATE, DELETE |
| Returns ResultSet | Returns integer                 |
| Retrieves records | Modifies records                |

---

## Important Points

* SELECT queries use `executeQuery()`.
* Returned records are stored in ResultSet.
* ResultSet cursor initially points before the first row.
* `next()` moves the cursor forward.
* Always close:

  * ResultSet
  * Statement
  * Connection

to prevent resource leaks.

---

## Common Errors

### Error

```text
Table 'test.sample' doesn't exist
```

Reason:

The table `sample` is not created.

---

### Error

```text
Unknown column
```

Reason:

Column name or column index is incorrect.

---

### Error

```text
Communications link failure
```

Reason:

MySQL server is not running.

---

## Best Practice

For production applications:

* Use PreparedStatement instead of Statement.
* Use try-with-resources.
* Avoid hardcoding database credentials.
* Store credentials in configuration files.
* Use column names instead of indexes when possible.

Example:

```java
rs.getInt("id");

rs.getString("name");
```

---

## Summary

This program demonstrates how to retrieve data from a MySQL database using JDBC.

Concepts covered:

* JDBC Connection
* DriverManager
* Statement Interface
* executeQuery()
* ResultSet
* ResultSet Traversal
* Resource Management

This forms the foundation for implementing Read operations in CRUD-based Java Full Stack applications and is one of the most important JDBC concepts for interviews and real-world development.
