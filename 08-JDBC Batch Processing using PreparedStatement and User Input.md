# JDBC Batch Processing using PreparedStatement and User Input

## Overview

JDBC Batch Processing becomes even more powerful when combined with **PreparedStatement**.

Instead of hardcoding SQL values, PreparedStatement allows:

* Dynamic user input
* Precompiled SQL statements
* Better performance
* Protection against SQL Injection attacks
* Efficient batch insertion of multiple records

This is the preferred approach used in real-world Java Full Stack applications.

---

## Why PreparedStatement is Better than Statement

Statement:

```java
String sql =
"Insert into sample values(123,'Apple')";
```

Problems:

* Hardcoded values
* Vulnerable to SQL Injection
* Query compilation occurs repeatedly

---

PreparedStatement:

```java
String sql =
"Insert into sample values(?, ?)";
```

Advantages:

* Dynamic values
* Query compiled once
* More secure
* Faster execution
* Easy to use with Batch Processing

---

## Java Program

```java
// Import JDBC classes
import java.sql.*;

// Import Scanner class
import java.util.Scanner;

// Define class
class RowDemo1 {

    public static void main(String[] args)
            throws SQLException {

        // Database URL
        String url =
                "jdbc:mysql://localhost:3306/test";

        // Database username
        String user = "root";

        // Database password
        String pass = "root";

        // Parameterized SQL query
        String sql =
                "Insert into sample values(?, ?)";

        // Establish connection
        Connection con =
                DriverManager.getConnection(
                        url,
                        user,
                        pass);

        // Create PreparedStatement
        PreparedStatement pst =
                con.prepareStatement(sql);

        // Scanner for user input
        Scanner sc =
                new Scanner(System.in);

        // Collect data for two rows
        for (int i = 1; i <= 2; i++) {

            System.out.print(
                    "Enter ID for row "
                    + i + ": ");

            int id =
                    sc.nextInt();

            sc.nextLine();

            System.out.print(
                    "Enter Name for row "
                    + i + ": ");

            String name =
                    sc.nextLine();

            System.out.println();

            // Bind values
            pst.setInt(1, id);

            pst.setString(2, name);

            // Add to batch
            pst.addBatch();
        }

        // Execute entire batch
        int[] results =
                pst.executeBatch();

        System.out.println(
                "Batch execution completed successfully. "
                + "Statements processed: "
                + results.length);

        // Close resources
        sc.close();

        pst.close();

        con.close();
    }
}
```

---

## Output

```text
Enter ID for row 1: 789
Enter Name for row 1: Grapes

Enter ID for row 2: 321
Enter Name for row 2: Orange

Batch execution completed successfully.
Statements processed: 2
```

---

## Database Table

```sql
CREATE TABLE sample(
    id INT,
    name VARCHAR(50)
);
```

---

## Records Inserted

| ID  | Name   |
| --- | ------ |
| 789 | Grapes |
| 321 | Orange |

---

## Parameterized Query

```java
String sql =
"Insert into sample values(?, ?)";
```

Explanation:

```text
? -> First parameter (ID)

? -> Second parameter (Name)
```

PreparedStatement replaces these placeholders at runtime.

---

## Binding Parameters

### setInt()

```java
pst.setInt(1, id);
```

Meaning:

```text
Parameter 1 = id
```

Example:

```text
pst.setInt(1,789);
```

---

### setString()

```java
pst.setString(2, name);
```

Meaning:

```text
Parameter 2 = name
```

Example:

```text
pst.setString(2,"Grapes");
```

---

## addBatch()

```java
pst.addBatch();
```

Purpose:

Stores the current parameter values into the internal batch queue.

Example:

```text
Batch Queue

Row 1

789 -> Grapes

Row 2

321 -> Orange
```

---

## executeBatch()

```java
int[] results =
pst.executeBatch();
```

Purpose:

Executes all queued SQL statements together.

Returns:

```text
int[]
```

Example:

```text
[1,1]
```

Meaning:

```text
First record inserted successfully

Second record inserted successfully
```

---

## Internal Working

```text
User Input

789 , Grapes

321 , Orange

        |

        v

PreparedStatement

Insert into sample values(?,?)

        |

Bind values

(789,Grapes)

(321,Orange)

        |

addBatch()

        |

executeBatch()

        |

Database

        |

Results

[1,1]
```

---

## Pseudocode

```text
START

SET database URL

SET username

SET password

SET query

OPEN database connection

CREATE PreparedStatement

OPEN Scanner

FOR 2 iterations

    READ id

    READ name

    SET id into parameter 1

    SET name into parameter 2

    ADD to batch

END FOR

EXECUTE batch

STORE results

PRINT results length

CLOSE Scanner

CLOSE PreparedStatement

CLOSE Connection

END
```

---

## PreparedStatement vs Statement

| **Statement**                      | **PreparedStatement**           |
| ------------------------------ | --------------------------- |
| Hardcoded SQL                  | Parameterized SQL           |
| Less secure                    | Prevents SQL Injection      |
| Compiles repeatedly            | Compiles once               |
| Slower                         | Faster                      |
| Not suitable for dynamic input | Excellent for dynamic input |

---

## Why PreparedStatement Prevents SQL Injection

Suppose the user enters:

```text
' OR '1'='1
```

Statement may create:

```sql
SELECT * FROM users
WHERE name='' OR '1'='1'
```

which is dangerous.

PreparedStatement treats the input as data only.

Therefore:

```text
SQL Injection is prevented.
```

---

## Real World Uses

PreparedStatement Batch Processing is used in:

* Banking applications
* Student Management Systems
* Payroll systems
* Hospital Management Systems
* E-Commerce applications
* Employee Management Systems
* Bulk CSV Import applications

---

## Best Practices

✔ Use PreparedStatement instead of Statement

✔ Use Batch Processing for multiple inserts

✔ Always close:

* Scanner
* PreparedStatement
* Connection

✔ Use parameterized queries

✔ Avoid hardcoded SQL values

✔ Handle SQLException properly

---

## Common Errors

### Error

```text
Duplicate entry for primary key
```

Reason:

ID already exists.

---

### Error

```text
Data too long for column
```

Reason:

Input string exceeds column length.

---

### Error

```text
Communications link failure
```

Reason:

MySQL server is not running.

---

## Summary

This program demonstrates how to perform JDBC Batch Processing using PreparedStatement and dynamic user input.

### Concepts Covered

* JDBC Batch Processing
* PreparedStatement
* Parameterized Queries
* Scanner
* Dynamic User Input
* addBatch()
* executeBatch()
* SQL Injection Prevention
* Bulk Record Insertion
* Resource Management
* JDBC Best Practices

This is one of the most important JDBC concepts used in modern Java Full Stack Development and is the industry-standard approach for performing secure and efficient database operations.
