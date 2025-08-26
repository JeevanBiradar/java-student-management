# Java Student Management System

A simple yet robust command-line (CLI) application for managing student records, built with Java and connected to a MySQL database.

This project was developed as a hands-on exercise to master fundamental Java concepts, including Object-Oriented Programming, JDBC for database connectivity, and software architecture principles like the Data Access Object (DAO) pattern.

---

## Features

* **Full CRUD Operations**: Add, Update, Delete, and Find student records.
* **Persistent Storage**: All data is stored and managed in a MySQL database, ensuring data is saved between sessions.
* **Interactive Menu**: A user-friendly, menu-driven interface for easy operation from the command line.
* **Data Validation**: Prevents adding students with duplicate roll numbers.
* **Clean Architecture**: Follows a 3-layer architecture to separate concerns:
    * **UI Layer (`Main.java`)**: Handles all user interaction.
    * **Data Access Layer (`StudentDAO.java`)**: Manages all communication with the database.
    * **Model Layer (`Student.java`)**: Represents the core student data structure.

---

## Technologies Used

* **Language**: Java
* **Database**: MySQL
* **API**: JDBC (Java Database Connectivity)
* **Core Concepts**: Object-Oriented Programming (OOP), Data Access Object (DAO) Pattern, Exception Handling

---

## How to Run

1.  **Database Setup**:
    * Ensure you have a MySQL server running.
    * Create a database (e.g., `studentdb`).
    * Execute the following SQL command to create the necessary table:
        ```sql
        CREATE TABLE students (
            rollnumber INT PRIMARY KEY,
            sname      VARCHAR(255) NOT NULL,
            section    VARCHAR(50),
            department VARCHAR(100),
            semester   VARCHAR(50)
        );
        ```

2.  **Configuration**:
    * Open the `StudentDAO.java` file.
    * Update the database `url`, `user`, and `password` variables to match your MySQL setup.

3.  **Execution**:
    * Compile all `.java` files.
    * Run the `Main.java` file to start the application.# java-studnet-management
A simple, command-line student management system built with Java and MySQL. This project demonstrates core Java skills, JDBC for database connectivity, and a 3-layer application architecture (UI, DAO, Model).
