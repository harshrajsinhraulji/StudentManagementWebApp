package com.github.harshrajsinhraulji.studentmanagement.dao;

import com.github.harshrajsinhraulji.studentmanagement.db.DBUtil;
import com.github.harshrajsinhraulji.studentmanagement.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    // CREATE
    public int addStudent(Student s) {
        String sql = "INSERT INTO students(name,email,phone_number,gender,dob,course,year_of_study) VALUES(?,?,?,?,?,?,?)";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, s.getName());
            ps.setString(2, s.getEmail());
            ps.setString(3, s.getPhoneNumber());
            ps.setString(4, s.getGender());
            ps.setDate(5, s.getDob());
            ps.setString(6, s.getCourse());
            ps.setInt(7, s.getYear());

            ps.executeUpdate();

            var rs = ps.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            } else {
                return -1;
            }

        } catch (SQLException e) {
            System.out.println("Error Adding Student: " + e.getMessage());
            return -1;
        }
    }

    // READ
    public Student getStudentById(int id) {
        String sql = "SELECT * FROM students WHERE id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            var rs = ps.executeQuery();

            if (rs.next()) {
                return new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("phone_number"),
                        rs.getString("gender"),
                        rs.getDate("dob"),
                        rs.getString("course"),
                        rs.getInt("year_of_study")
                );
            } else {
                return null;
            }

        } catch (SQLException e) {
            System.out.println("Error fetching student: " + e.getMessage());
            return null;
        }
    }

    // UPDATE
    public boolean updateStudent(Student s) {
        String sql = "UPDATE students SET name = ?, email = ?, phone_number = ?, gender = ?, dob = ?, course = ?, year_of_study = ? WHERE id = ?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, s.getName());
            ps.setString(2, s.getEmail());
            ps.setString(3, s.getPhoneNumber());
            ps.setString(4, s.getGender());
            ps.setDate(5, s.getDob());
            ps.setString(6, s.getCourse());
            ps.setInt(7, s.getYear());
            ps.setInt(8, s.getID());

            int rows = ps.executeUpdate();
            return rows > 0;

        } catch (SQLException e) {
            System.out.println("Error updating student: " + e.getMessage());
            return false;
        }
    }

    // DELETE
    public boolean deleteStudent(int id) {
        String sql = "DELETE FROM students WHERE id = ?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            return rows > 0;

        } catch (SQLException e) {
            System.out.println("Error deleting student: " + e.getMessage());
            return false;
        }
    }

    // LIST ALL
    public List<Student> getAllStudents() {
        String sql = "SELECT * FROM students";
        List<Student> students = new ArrayList<>();

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                students.add(new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("phone_number"),
                        rs.getString("gender"),
                        rs.getDate("dob"),
                        rs.getString("course"),
                        rs.getInt("year_of_study")
                ));
            }

        } catch (SQLException e) {
            System.out.println("Error fetching students: " + e.getMessage());
        }

        return students;
    }
}
