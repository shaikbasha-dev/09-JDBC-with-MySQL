# Editions of Java and Web Application Architecture

## 1. Editions of Java

Java is divided into different editions based on the type of application development.

### 1. JSE - Java Standard Edition

Java Standard Edition (JSE) is used to **develop standalone or desktop applications**. 

It provides the core features of Java such as:

* Object-Oriented Programming
* Exception Handling
* Collections Framework
* Multithreading
* File Handling
* JDBC
* Generics

**Examples:**

* Calculator Application
* Student Management System
* Text Editor
* Banking Desktop Application

---

### 2. JEE - Java Enterprise Edition

Java Enterprise Edition (JEE), now known as Jakarta EE, is used to **develop web and enterprise applications**.

It provides technologies such as:

* Servlets
* JSP (Java Server Pages)
* JDBC
* JPA
* Web Services
* Enterprise Applications

**Examples:**

* E-Commerce Websites
* Banking Applications
* Hospital Management Systems
* ERP Systems

---

### 3. JME - Java Micro Edition

Java Micro Edition (JME) is used to **develop applications for small devices with limited memory and processing power**.

**Examples:**

* Mobile Devices
* Embedded Systems
* Smart Cards
* IoT Devices

---

### 4. JavaFX

JavaFX is a Java platform used for **building Graphical User Interface (GUI) applications**.

Features:

* Rich User Interface
* Charts and Graphs
* Animation Support
* Multimedia Support
* CSS Styling

**Examples:**

* Media Player
* Dashboard Applications
* Desktop GUI Applications

---

## 2. Desktop Applications

Applications that can be used only on a single computer system are called:

* Desktop Applications
  OR
* Standalone Applications

These applications are generally developed using **Java Standard Edition (JSE)**.

Examples:

* Calculator
* Notepad
* Inventory System
* Desktop Banking Application

---

## 3. Web Applications

Applications that can be accessed by multiple users over the internet are called:

**Web Applications**

These applications are generally developed using:

* HTML
* CSS
* JavaScript
* Servlet
* JSP
* JDBC
* Database

Examples:

* Amazon
* Flipkart
* Facebook
* Online Banking System

---

# 4. Basic Architecture of a Web Application

```text
Client (Browser)
        |
        | 1. Request
        v
Web Server / Application Server
        |
        | 2. Forward request to Servlet/JSP
        v
Servlet / JSP / Controller
        |
        | 3. Process business logic
        v
Database (DBMS)
        |
        | 4. Return data
        v
Servlet / JSP / Controller
        |
        | 5. Generate response
        v
Client (Browser)
        |
        | 6. Display result
        v
User
```

---

## Explanation of Architecture

### Step 1: Client Request

The user sends a request through a browser such as:

* Google Chrome
* Mozilla Firefox
* Microsoft Edge

Example:

```text
http://localhost:8080/login
```

---

### Step 2: Web Server Receives Request

The request is received by a web server or application server such as:

* Apache Tomcat
* GlassFish
* WildFly

The server forwards the request to:

* Servlet
* JSP
* Controller

---

### Step 3: Business Logic Processing

The Servlet or Controller:

* validates user input
* processes business logic
* interacts with the database using JDBC

---

### Step 4: Database Communication

JDBC is used to connect Java applications with databases.

Common databases are:

* MySQL
* Oracle
* PostgreSQL
* SQL Server

The database:

* stores data
* retrieves data
* updates data
* deletes data

---

### Step 5: Generate Response

The Servlet or JSP receives the data from the database and generates a response.

The response may contain:

* HTML page
* Success message
* User information
* Product details

---

### Step 6: Display Result

The browser receives the response and displays it to the user.

---

# 5. Front-End and Back-End

## Front-End

The visible part of an application that users interact with is called the Front-End.

Technologies:

* HTML
* CSS
* JavaScript
* Bootstrap
* Angular

Responsibilities:

* User Interface
* Form Design
* Navigation
* User Interaction

---

## Back-End

The logic and processing part of an application is called the Back-End.

Technologies:

* Java
* Servlet
* JSP
* JDBC
* Spring Boot
* MySQL

Responsibilities:

* Business Logic
* Database Operations
* Authentication
* Data Processing

---

# 6. Servlet

A Servlet is a Java program that runs on the server.

It is used to:

* Receive client requests
* Process requests
* Interact with databases
* Generate responses

Examples:

* Login Servlet
* Registration Servlet
* Payment Servlet

---

# 7. JSP (Java Server Pages)

JSP is a technology used to create dynamic web pages.

Features:

* Combines HTML with Java
* Generates dynamic content
* Reduces Servlet code

Examples:

* Login Page
* Dashboard Page
* Profile Page

---

# 8. JDBC (Java Database Connectivity)

JDBC is an API used to connect Java applications with databases.

JDBC is used for:

* Establishing connection
* Executing SQL queries
* Inserting records
* Updating records
* Deleting records
* Retrieving records

Supported Databases:

* MySQL
* Oracle
* PostgreSQL
* SQL Server

---

# 9. DBMS (Database Management System)

DBMS is software used to store and manage data efficiently.

Popular DBMS:

* MySQL
* Oracle Database
* PostgreSQL
* SQL Server

Functions:

* Store Data
* Retrieve Data
* Update Data
* Delete Data
* Security Management

---

# 10. Important Terms

| **Abbreviation** | **Full Form**                  |
| ------------ | -------------------------- |
| JSP          | Java Server Pages          |
| JDBC         | Java Database Connectivity |
| DBMS         | Database Management System |
| HTML         | Hyper Text Markup Language |
| CSS          | Cascading Style Sheet      |
| JSE          | Java Standard Edition      |
| JEE          | Java Enterprise Edition    |
| JME          | Java Micro Edition         |

---

# Summary

* Java is divided into JSE, JEE, JME, and JavaFX.
* JSE is used for Desktop Applications.
* JEE is used for Web Applications.
* Web applications follow Client-Server Architecture.
* Servlets and JSP handle business logic and presentation.
* JDBC connects Java applications with relational databases.
* DBMS stores and manages application data.
* Understanding this architecture is essential before learning JDBC programming.

This chapter provides the foundation for learning JDBC and understanding how Java applications communicate with databases in real-world Java Full Stack Development.
