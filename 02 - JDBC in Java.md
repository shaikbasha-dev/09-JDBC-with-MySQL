# 02 - JDBC in Java

## 1. What is JDBC?

**JDBC (Java Database Connectivity)** is a Java API used to connect a Java application with a database and execute SQL queries.

JDBC provides a standard way for Java programs to:

* Connect to a database
* Execute SQL queries
* Insert records
* Update records
* Delete records
* Retrieve records from a database

JDBC is part of the **java.sql** package.

---

## 2. Why Do We Need JDBC?

JDBC is used because Java applications often need to store and retrieve data from databases.

Using JDBC, a Java program can:

* Store employee records
* Save customer details
* Retrieve student information
* Manage banking transactions
* Process online orders

Without JDBC, Java applications cannot communicate directly with relational databases.

---

## 3. Steps to Perform JDBC

To fetch data from a database into a Java application, the following steps are followed:

### Step 1: Import the SQL Package

```java
import java.sql.*;
```

This package contains important interfaces and classes such as:

* Connection
* DriverManager
* Statement
* PreparedStatement
* ResultSet
* SQLException

---

### Step 2: Load the JDBC Driver

```java
Class.forName(driver_name);
```

Example for MySQL:

```java
Class.forName("com.mysql.cj.jdbc.Driver");
```

Purpose:

* Loads the JDBC Driver class into memory.
* Registers the driver with DriverManager.

---

### Step 3: Establish Connection

```java
Connection con =
DriverManager.getConnection(
"url",
"username",
"password");
```

Example:

```java
Connection con =
DriverManager.getConnection(
"jdbc:mysql://localhost:3306/studentdb",
"root",
"root");
```

Purpose:

* Creates a connection between Java and the database.
* Acts as a bridge for data exchange.

---

### Step 4: Create Statement

```java
Statement st = con.createStatement();
```

Purpose:

* Sends SQL queries to the database.
* Receives results from the database.

---

### Step 5: Execute Query and Fetch Result

```java
ResultSet rs =
st.executeQuery("SELECT * FROM student");
```

Purpose:

* Executes the SQL query.
* Stores the returned data in a ResultSet object.

---

## 4. JDBC Architecture

```text
Java Application
        |
        | 1. Send SQL Request
        v
JDBC API
        |
        | 2. Call JDBC Driver
        v
JDBC Driver
        |
        | 3. Convert Java Calls into SQL Calls
        v
Database (DBMS)
        |
        | 4. Return Result
        v
JDBC Driver
        |
        | 5. Convert Result into Java Objects
        v
JDBC API
        |
        | 6. Give Result to Java Application
        v
ResultSet / Java Program
```

---

## 5. JDBC Flow Explanation

### Step 1

The Java application sends an SQL request.

Example:

```sql
SELECT * FROM student;
```

---

### Step 2

The JDBC API forwards the request to the JDBC Driver.

---

### Step 3

The JDBC Driver converts Java calls into database-specific SQL commands.

Examples:

* MySQL Driver
* Oracle Driver
* PostgreSQL Driver

---

### Step 4

The DBMS executes the SQL statement and returns the result.

---

### Step 5

The JDBC Driver converts the result into Java-readable objects.

---

### Step 6

The JDBC API returns the result to the Java program in the form of:

```java
ResultSet
```

---

# 6. JDBC Drivers

A JDBC Driver is software that enables communication between Java applications and databases.

It:

* Converts Java calls into SQL commands
* Sends SQL commands to the database
* Converts database responses into Java objects

Examples:

| Database   | Driver Class                    |
| ---------- | ------------------------------- |
| MySQL      | com.mysql.cj.jdbc.Driver        |
| Oracle     | oracle.jdbc.driver.OracleDriver |
| PostgreSQL | org.postgresql.Driver           |

---

# 7. Connection Interface

A **Connection** acts as a bridge between:

* Java Application
* Database

Example:

```java
Connection con =
DriverManager.getConnection(
"jdbc:mysql://localhost:3306/studentdb",
"root",
"root");
```

Functions:

* Establish connection
* Commit transactions
* Rollback transactions
* Create Statement objects

---

# 8. Statement Interface

A **Statement** is used to send SQL queries from Java to the DBMS.

Example:

```java
Statement st = con.createStatement();
```

Using Statement:

```java
ResultSet rs =
st.executeQuery("SELECT * FROM student");
```

Common Methods:

| Method          | Description                     |
| --------------- | ------------------------------- |
| executeQuery()  | Executes SELECT query           |
| executeUpdate() | Executes INSERT, UPDATE, DELETE |
| execute()       | Executes any SQL statement      |

---

# 9. ResultSet Interface

A **ResultSet** stores the data retrieved from the database after executing a query.

Example:

```java
ResultSet rs =
st.executeQuery("SELECT * FROM student");
```

Reading Data:

```java
while(rs.next()) {
    System.out.println(rs.getInt(1));
    System.out.println(rs.getString(2));
}
```

Common Methods:

| Method      | Description             |
| ----------- | ----------------------- |
| next()      | Moves to next row       |
| getInt()    | Retrieves integer value |
| getString() | Retrieves string value  |
| getDouble() | Retrieves double value  |
| getDate()   | Retrieves date value    |

---

# 10. Important Definitions

### a) JDBC Driver

A Driver converts Java calls into SQL calls and SQL results into Java-readable form.

---

### b) Connection

A Connection acts as a bridge between a Java application and the database.

---

### c) Statement

A Statement is used to send SQL queries from the Java application to the DBMS and receive results back.

---

### d) ResultSet

A ResultSet stores the data retrieved from the database after executing a query.

---

# 11. Important JDBC Interfaces

* Driver
* Connection
* Statement
* PreparedStatement
* CallableStatement
* ResultSet
* DatabaseMetaData
* ResultSetMetaData

These interfaces are available in:

```java
java.sql package
```

---

# 12. Summary

* JDBC stands for Java Database Connectivity.
* JDBC is used to connect Java applications with relational databases.
* The main JDBC steps are:

  * Import package
  * Load driver
  * Establish connection
  * Create statement
  * Execute query
  * Process ResultSet
* Connection acts as a bridge between Java and DBMS.
* Statement sends SQL commands.
* ResultSet stores the retrieved data.
* JDBC is one of the most important technologies in Java Full Stack Development because it enables database communication between Java applications and relational databases.
