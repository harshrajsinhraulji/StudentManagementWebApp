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

@WebServlet("/addSudent")
public class AddStudentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<html><head><title>Add Student Result</title></head><body>");

        try {
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String phoneNumber = request.getParameter("phoneNumber");
            String gender = request.getParameter("gender");
            String dobStr = request.getParameter("dob");
            String course = request.getParameter("course");
            String yearStr = request.getParameter("year");

            Date dob = Date.valueOf(dobStr);
            int year = Integer.parseInt(yearStr);

            Student student = new Student(name, email, phoneNumber, gender, dob, course, year);

            StudentDAO dao = new StudentDAO();
            int studentId = dao.addStudent(student);

            if (studentId > 0) {
                out.println("<h2><b>Student added successfully!<b></h2>");
                out.println("<p>Generated ID: " + studentId + "</p>");
            } else {
                out.println("<h2>Failed to add student.</h2>");
            }

        } catch (Exception e) {
            out.println("<h2>Error occurred:</h2>");
            out.println("<pre>");
            e.printStackTrace(out); // show full stacktrace in browser
            out.println("</pre>");
        } finally {
            out.println("</body></html>");
            out.close();
        }
    }
}
