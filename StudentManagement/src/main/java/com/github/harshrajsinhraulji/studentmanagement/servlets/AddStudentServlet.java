package com.github.harshrajsinhraulji.studentmanagement.servlets;

import com.github.harshrajsinhraulji.studentmanagement.dao.StudentDAO;
import com.github.harshrajsinhraulji.studentmanagement.model.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

@WebServlet("/addStudent") // matches form action
public class AddStudentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            // 1. Read parameters
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String phoneNumber = request.getParameter("phoneNumber");
            String gender = request.getParameter("gender");
            String dobStr = request.getParameter("dob");
            String course = request.getParameter("course");
            String yearStr = request.getParameter("year");

            // 2. Convert values
            Date dob = Date.valueOf(dobStr);
            int year = Integer.parseInt(yearStr);

            // 3. Create Student object
            Student student = new Student(name, email, phoneNumber, gender, dob, course, year);

            // 4. Call DAO
            StudentDAO dao = new StudentDAO();
            int studentId = dao.addStudent(student);

            // 5. Show result directly
            if (studentId > 0) {
                out.println("<h2>Student added successfully!</h2>");
                out.println("<p>Generated ID: " + studentId + "</p>");
            } else {
                out.println("<h2>Failed to add student.</h2>");
            }

        } catch (Exception e) {
            out.println("<h2>Error: " + e.getMessage() + "</h2>");
        } finally {
            out.close();
        }
    }
}
