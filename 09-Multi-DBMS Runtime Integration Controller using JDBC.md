# Multi-DBMS Runtime Integration Controller using JDBC

## Overview

This project demonstrates how a Java application can connect to multiple database systems using JDBC.

The program establishes connections with:

* Oracle Database
* MySQL Database

The purpose of this application is to show how enterprise Java applications interact with heterogeneous database environments while keeping the application logic independent of database vendors.

---

## Why is this Program Important?

In modern enterprise applications:

* Customer information may be stored in MySQL.
* Financial records may be stored in Oracle.
* Legacy systems may use different DBMS vendors.

Java applications should be able to communicate with all of them using a common API.

JDBC provides this abstraction.

---

## Architectural Benefits

### Unified Database Access

Java uses:

```java
java.sql.*
```

which provides:

* Connection
* DriverManager
* Statement
* PreparedStatement
* ResultSet

This allows the application to communicate with different databases using the same programming model.

---

### Modular Design

The application separates:

```text
connectOracle()

connectMySql()
```

Each method manages:

* Driver loading
* Connection creation
* Resource cleanup

This makes the code:

* Easy to maintain
* Easy to extend
* Reusable

---

## Method Registry

| **Method**                        | **Purpose**                         |
| ----------------------------- | ------------------------------- |
| main()                        | Entry point of application      |
| connectOracle()               | Connects to Oracle Database     |
| connectMySql()                | Connects to MySQL Database      |
| Class.forName()               | Loads JDBC Driver               |
| DriverManager.getConnection() | Establishes database connection |
| close()                       | Releases database resources     |

---

## Complete Java Program

```java
import java.sql.*;

class ConnnectDemo {

    public static void main(String[] args)
            throws Exception {

        connectOracle();

        connectMySql();
    }

    private static void connectOracle()
            throws Exception {

        String driver =
                "oracle.jdbc.driver.OracleDriver";

        String url =
                "jdbc:oracle:thin:@localhost:1521:xe";

        String user =
                "System";

        String pass =
                "System";

        Class.forName(driver);

        Connection con =
                DriverManager.getConnection(
                        url,
                        user,
                        pass);

        System.out.println(
                "Connected to Oracle DBMS: "
                        + con);

        con.close();
    }

    private static void connectMySql()
            throws Exception {

        String url =
                "jdbc:mysql://localhost:3306/test";

        String user =
                "root";

        String pass =
                "root";

        Connection con =
                DriverManager.getConnection(
                        url,
                        user,
                        pass);

        System.out.println(
                "Connected to MySQL DBMS: "
                        + con);

        con.close();
    }
}
```

---

## Output

```text
Connected to Oracle DBMS:
oracle.jdbc.driver.OracleConnection@7a072482

Connected to MySQL DBMS:
com.mysql.cj.jdbc.ConnectionImpl@2ef3eef9
```

**Note:**

The hexadecimal values after `@` are object hashcodes and vary each time the program runs.

---

## Oracle Connection URL

```java
jdbc:oracle:thin:@localhost:1521:xe
```

Explanation:

| **Part**      | **Meaning**                    |
| --------- | -------------------------- |
| jdbc      | JDBC protocol              |
| oracle    | Oracle database            |
| thin      | Oracle Thin Driver         |
| localhost | Server                     |
| 1521      | Oracle default port        |
| xe        | Oracle Express Edition SID |

---

## MySQL Connection URL

```java
jdbc:mysql://localhost:3306/test
```

Explanation:

| **Part**      | **Meaning**            |
| --------- | ------------------ |
| jdbc      | JDBC protocol      |
| mysql     | MySQL database     |
| localhost | Server             |
| 3306      | MySQL default port |
| test      | Database name      |

---

## Why use Class.forName() for Oracle?

```java
Class.forName(
"oracle.jdbc.driver.OracleDriver");
```

Purpose:

* Loads Oracle JDBC Driver into JVM.
* Registers the driver with DriverManager.

This is commonly used for:

* Oracle JDBC
* Older JDBC drivers

---

## Why is Class.forName() not used for MySQL?

Modern MySQL JDBC drivers support:

```text
SPI
(Service Provider Interface)
```

Therefore:

```java
DriverManager.getConnection(...)
```

automatically loads the driver.

---

## Architectural Flow

```text
Java Application

       |

       v

+-----------------+

connectOracle()

       |

Oracle JDBC Driver

       |

Oracle Database

+-----------------+

connectMySql()

       |

MySQL JDBC Driver

       |

MySQL Database
```

---

## Pseudocode

```text
START

CALL connectOracle()

CALL connectMySql()

--------------------------------

connectOracle()

LOAD Oracle Driver

OPEN Oracle Connection

PRINT Success Message

CLOSE Connection

--------------------------------

connectMySql()

OPEN MySQL Connection

PRINT Success Message

CLOSE Connection

END
```

---

## Real World Applications

This architecture is used in:

* Banking Systems
* ERP Applications
* Insurance Systems
* E-Commerce Platforms
* Hospital Management Systems
* Data Migration Projects
* Financial Reporting Systems

---

## Advantages

✔ Supports multiple databases

✔ Vendor-independent architecture

✔ Modular design

✔ Easy to extend

✔ Standard JDBC interfaces

✔ Reusable connection modules

✔ Enterprise application ready

---

## Best Practices

* Store credentials in properties files.
* Avoid hardcoding passwords.
* Use Connection Pooling.
* Close connections properly.
* Use PreparedStatement for queries.
* Implement exception handling.

---

## Common Errors

### ClassNotFoundException

Reason:

```text
Oracle JDBC driver jar is missing.
```

---

### SQLException

Reason:

```text
Wrong username or password.
```

---

### Communications Link Failure

Reason:

```text
Database server is not running.
```

---

## Summary

This program demonstrates how a Java application can connect to multiple DBMS platforms using JDBC while maintaining a clean and modular architecture.

### Concepts Covered

* Oracle JDBC Connection
* MySQL JDBC Connection
* DriverManager
* Class.forName()
* Connection Interface
* Multi-DBMS Architecture
* JDBC Standard API
* Resource Management
* Enterprise Application Design

This is an advanced JDBC topic and an excellent addition to a Java Full Stack Developer GitHub repository because it demonstrates practical database integration skills used in enterprise applications.
