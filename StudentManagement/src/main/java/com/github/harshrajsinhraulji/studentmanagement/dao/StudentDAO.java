
package com.github.harshrajsinhraulji.studentmanagement.dao;
import com.github.harshrajsinhraulji.studentmanagement.db.DBUtil;
import com.github.harshrajsinhraulji.studentmanagement.model.Student;

import java.sql.*;

public class StudentDAO {
    
    
    public int addStudent(Student s){
        String sql="INSERT INTO students(name,email,phone_number,gender,dob,course,year_of_study) VALUES(?,?,?,?,?,?,?)";
        try(Connection conn=DBUtil.getConnection();
            PreparedStatement ps=conn.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS)){
            
            ps.setString(1, s.getName());
            ps.setString(2, s.getEmail());
            ps.setString(3, s.getPhoneNumber());
            ps.setString(4, s.getGender());
            ps.setDate(5, s.getDob());
            ps.setString(6, s.getCourse());
            ps.setInt(7, s.getYear());
            
            ps.executeUpdate();
            
            var rs=ps.getGeneratedKeys();              //var is a Java 10+ feature for local variable type inference.
            if(rs.next()){
                return rs.getInt(1);
            }else{
                return -1;
            }
                        
        }catch(SQLException e){
            System.out.println("Error Adding Student: "+e.getMessage());
            return -1;
        }
    }
}
