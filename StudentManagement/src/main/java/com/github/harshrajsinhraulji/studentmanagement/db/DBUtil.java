
package com.github.harshrajsinhraulji.studentmanagement.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    private static final String URL="jdbc:mysql://localhost:3306/studentdb";
    private static final String USER="root";
    private static final String PASS="";
    
    static{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e){
            throw new RuntimeException("Failed to load MYSQL Driver", e);
        }
    }
    
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(URL,USER,PASS);
    }
}
