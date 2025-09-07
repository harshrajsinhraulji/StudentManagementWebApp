# Student Management Web Application

A Java-based web application for managing student records, built using Jakarta EE (Servlets, JSP, JDBC) and Maven.

## Features

- Add new students with details: name, email, phone, gender, date of birth, course, and year of study
- Form validation on the frontend
- Persistent storage using JDBC and a DAO layer
- Simple web interface for data entry

## Project Structure

```
StudentManagement/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/github/harshrajsinhraulji/studentmanagement/
│   │   │       └── servlets/
│   │   │           └── AddStudentServlet.java
│   │   ├── resources/
│   │   │   └── META-INF/persistence.xml
│   │   └── webapp/
│   │       ├── add-student.html
│   │       ├── index.html
│   │       └── WEB-INF/web.xml
│   └── test/
├── pom.xml
└── README.md
```

## Getting Started

### Prerequisites

- Java 17 or higher
- Maven
- Jakarta EE compatible server (e.g., Tomcat 10+)

### Build

```powershell
mvn clean package
```

### Deploy

1. Deploy the generated WAR file (`target/StudentManagement-1.0-SNAPSHOT.war`) to your servlet container.
2. Access the app at: `http://localhost:8080/StudentManagement-1.0-SNAPSHOT/add-student.html`

### Usage

- Fill out the form on `add-student.html` and submit to add a student.
- The form posts to the `/addStudent` servlet, which processes and stores the data.

## Configuration

- Servlet mappings are defined in `WEB-INF/web.xml`.
- Database connection settings are in `META-INF/persistence.xml`.

## License

This project is licensed under the MIT License.
