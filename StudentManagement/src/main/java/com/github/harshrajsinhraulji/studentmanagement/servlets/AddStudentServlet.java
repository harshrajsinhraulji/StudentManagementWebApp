package com.github.harshrajsinhraulji.studentmanagement.servlets;

import com.github.harshrajsinhraulji.studentmanagement.dao.StudentDAO;
import com.github.harshrajsinhraulji.studentmanagement.model.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet("/addStudent") // matches your form action
public class AddStudentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 1. Read parameters from form
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phoneNumber");
        String gender = request.getParameter("gender");
        String dobStr = request.getParameter("dob");
        String course = request.getParameter("course");
        String yearStr = request.getParameter("year");

        // 2. Convert DOB and year
        Date dob = null;
        int year = 0;
        try {
            dob = Date.valueOf(dobStr); // yyyy-mm-dd to java.sql.Date
            year = Integer.parseInt(yearStr);
        } catch (Exception e) {
            request.setAttribute("error", "Invalid date or year format.");
            request.getRequestDispatcher("index.html").forward(request, response);
            return;
        }

        // 3. Create Student object
        Student student = new Student(name, email, phoneNumber, gender, dob, course, year);

        // 4. Call DAO to add student
        StudentDAO dao = new StudentDAO();
        int studentId = dao.addStudent(student);

        // 5. Handle success/failure
        if (studentId > 0) {
            request.setAttribute("message", "Student added successfully. ID: " + studentId);
        } else {
            request.setAttribute("message", "Failed to add student.");
        }

        // 6. Forward back to the HTML page to display message
        request.getRequestDispatcher("index.html").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Optionally, redirect GET requests to the form
        response.sendRedirect("index.html");
    }
}
