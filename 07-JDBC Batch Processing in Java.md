# JDBC Batch Processing in Java

## Overview

JDBC Batch Processing is a feature that allows multiple SQL statements to be grouped together and executed as a single batch.

Instead of sending each SQL query separately to the database, JDBC sends all queries together in one network call.

This improves:

* Performance
* Database efficiency
* Network utilization
* Execution speed

Batch Processing is commonly used in:

* Banking applications
* Payroll systems
* E-commerce applications
* Student Management Systems
* Enterprise Java Applications

---

## What is JDBC Batch Processing?

Batch Processing means:

```text
Group multiple SQL statements
+
Send them together
+
Execute them in one database trip
```

This is much faster than:

```text
executeUpdate(sql1);

executeUpdate(sql2);

executeUpdate(sql3);
```

because every executeUpdate() creates a separate network request.

---

## Why Use Batch Processing?

Without Batch:

```text
Java
 ↓
Query 1 → Database

Java
 ↓
Query 2 → Database

Java
 ↓
Query 3 → Database
```

Three separate network calls.

---

With Batch:

```text
Java
 ↓
Batch(Query1 + Query2 + Query3)
 ↓
Database
```

Only one network call.

---

## Advantages of JDBC Batch Processing

* Improves performance
* Reduces network traffic
* Executes multiple queries efficiently
* Reduces database overhead
* Faster than executing queries individually

---

## Java Program

```java
// Import all classes from the java.sql package
import java.sql.*;

// Define a class named RowDemo1
class RowDemo1 {

    // Main method
    public static void main(String[] args)
            throws SQLException {

        // Database URL
        String url =
                "jdbc:mysql://localhost:3306/test";

        // Database username
        String user = "root";

        // Database password
        String pass = "root";

        // First INSERT query
        String sql1 =
                "Insert into sample values(123,'Apple')";

        // Second INSERT query
        String sql2 =
                "Insert into sample values(456,'Banana')";

        // Establish connection
        Connection con =
                DriverManager.getConnection(
                        url,
                        user,
                        pass);

        // Create Statement
        Statement st =
                con.createStatement();

        // Add first query to batch
        st.addBatch(sql1);

        // Add second query to batch
        st.addBatch(sql2);

        // Execute entire batch
        int[] results =
                st.executeBatch();

        // Print batch execution status
        System.out.println(
                "Batch execution completed successfully. "
                + "Statements processed: "
                + results.length);

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
Batch execution completed successfully.
Statements processed: 2
```

This means:

* Query 1 executed successfully
* Query 2 executed successfully
* Total 2 statements processed

---

## Database Table

```sql
CREATE TABLE sample(
    id INT,
    name VARCHAR(50)
);
```

---

## Data Inserted

| ID  | Name   |
| --- | ------ |
| 123 | Apple  |
| 456 | Banana |

---

## Important JDBC Methods

### addBatch()

```java
st.addBatch(sql1);
```

Purpose:

Adds SQL command to the batch queue.

---

### executeBatch()

```java
int[] results =
st.executeBatch();
```

Purpose:

* Sends all batched SQL statements to database.
* Executes them together.

Returns:

```text
int[]
```

An array containing execution results.

Example:

```text
[1,1]
```

Meaning:

```text
First query affected 1 row

Second query affected 1 row
```

---

## Flow of JDBC Batch Processing

```text
Java Application
        |
        v
Statement Object

addBatch(sql1)
addBatch(sql2)
addBatch(sql3)

        |
        v

executeBatch()

        |
        v

Database Server

        |
        v

Results Array

[1,1,1]
```

---

## Pseudocode

```text
START

SET url

SET username

SET password

SET sql1

SET sql2

OPEN database connection

CREATE Statement

ADD sql1 to batch

ADD sql2 to batch

EXECUTE batch

STORE results

PRINT number of statements processed

CLOSE Statement

CLOSE Connection

END
```

---

## Normal Execution vs Batch Processing

| **Normal Execution**        | **Batch Processing**      |
| ----------------------- | --------------------- |
| Multiple database calls | Single database call  |
| Slower                  | Faster                |
| More network overhead   | Less network overhead |
| Executes one by one     | Executes together     |
| Less efficient          | More efficient        |

---

## Internal Working

When you call:

```java
st.addBatch(sql1);

st.addBatch(sql2);
```

JDBC does not execute immediately.

It stores the queries internally:

```text
Batch Queue

1. Insert into sample values(123,'Apple')

2. Insert into sample values(456,'Banana')
```

When:

```java
st.executeBatch();
```

JDBC sends the complete queue to MySQL in one request.

---

## Real World Applications

Batch Processing is used in:

* Bank transaction processing
* Salary generation systems
* Bulk student record insertion
* Order management systems
* Data migration projects
* CSV to Database import systems

---

## Common Errors

### Error

```text
Duplicate entry for primary key
```

Reason:

The ID already exists.

---

### Error

```text
BatchUpdateException
```

Reason:

One of the batch queries failed.

---

### Error

```text
Communications link failure
```

Reason:

MySQL server is not running.

---

## Best Practices

✔ Use Batch Processing for bulk inserts

✔ Close Statement and Connection

✔ Use PreparedStatement for dynamic user input

✔ Commit transactions carefully

✔ Handle BatchUpdateException properly

---

## Next Improvement

The next step after Batch Processing is:

```text
PreparedStatement + Batch Processing
```

This allows:

* Dynamic user input
* Protection against SQL Injection
* Better performance
* Safer database operations

This is the industry-standard approach used in Java Full Stack applications.

---

## Summary

JDBC Batch Processing allows multiple SQL statements to be executed together as a single unit.

### Concepts Covered

* JDBC Batch Processing
* Statement Interface
* addBatch()
* executeBatch()
* Batch Queue
* Performance Improvement
* Network Optimization
* Bulk Database Operations
* Real-world Applications

This is one of the most important JDBC concepts for Java Full Stack Development and is widely used in enterprise applications for efficient database operations.
