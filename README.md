# Student Management Web App

![Java](https://img.shields.io/badge/Java-17-blue)
![Maven](https://img.shields.io/badge/Maven-3.8.7-green)
![MySQL](https://img.shields.io/badge/MySQL-8.0-orange)
![Servlet](https://img.shields.io/badge/Servlet-Jakarta%20EE-red)

A **web application** built with **Java Servlets, JSP, JDBC, and MySQL** to manage student information. Users can add, view, update, and delete student records through an interactive web interface.

---

## Features

- Add new students with details: name, email, phone number, gender, DOB, course, and year of study.
- View student details by ID.
- Update existing student information.
- Delete student records.
- List all students.
- Interactive forms with HTML and JSP.

---

## Technologies Used

| Layer             | Technology/Library                  |
|------------------|-----------------------------------|
| Backend           | Java, Servlet API                  |
| Frontend          | HTML, JSP                          |
| Database          | MySQL (via WAMP)                   |
| Database Access   | JDBC                               |
| Build & Dependency| Maven                              |
| IDE               | NetBeans                           |
| Web Server        | Apache Tomcat (default port 8080)  |

---

## Project Structure

StudentManagementWebApp/
│
├─ src/main/java/
│ └─ com/github/harshrajsinhraulji/studentmanagement/
│ ├─ servlets/ # Servlet classes
│ ├─ dao/ # Database access objects
│ └─ model/ # Student model class
│
├─ src/main/webapp/
│ ├─ index.html # Main landing page
│ ├─ addStudent.html # Form to add a student
│ └─ jsp/ # JSP pages for messages/results
│
├─ pom.xml # Maven build and dependencies
└─ README.md


---

## Database Setup (WAMP)

1. Make sure **WAMP server is running** and **MySQL** is active.
2. Open **phpMyAdmin** at `http://localhost/phpmyadmin/` and create a database:

```sql
CREATE DATABASE student_management;
CREATE TABLE students (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    phone_number VARCHAR(15),
    gender VARCHAR(10),
    dob DATE,
    course VARCHAR(50),
    year_of_study INT
);

Update your DBUtil.java with the database credentials:
public class DBUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/student_management";
    private static final String USER = "root"; // default WAMP user
    private static final String PASS = "";     // default WAMP password

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}

Running the Project

Open the project in NetBeans or any Java IDE.

Make sure WAMP MySQL server is running.

Build the project using Maven → Clean and Build.

Deploy the project on Tomcat (or any servlet container).

Open http://localhost:8080/StudentManagementWebApp/ in your browser.

Navigate through pages to add, view, or manage students.

Maven Dependencies
<dependencies>
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>8.1.0</version>
    </dependency>
    <dependency>
        <groupId>jakarta.servlet</groupId>
        <artifactId>jakarta.servlet-api</artifactId>
        <version>6.0.0</version>
        <scope>provided</scope>
    </dependency>
</dependencies>

Future Improvements

Add search functionality for students.

Implement login and session management.

Improve UI using Bootstrap or custom CSS.

Create dedicated error handling JSP pages.

Add pagination for large student lists.

License (MIT)
MIT License

Copyright (c) 2025 Harshrajsinh Raulji

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

Author

Harshrajsinh Raulji
GitHub: https://github.com/harshrajsinhraulji

LinkedIn: https://www.linkedin.com/in/harshrajsinhraulji
