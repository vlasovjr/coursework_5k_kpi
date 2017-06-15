package db.operations.select;

import db.DB;
import entity.Student;

import java.sql.*;

public class StudentSelectOperations{
    public Student ByUserId(int user_id){
        Student s = null;
        try {
            String Query = "SELECT * FROM student WHERE user_id = "+user_id;

            Connection connection = null;
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DB.connectionURL,DB.connectionUser,DB.connectionPassword);
            if(!connection.isClosed())
                System.out.println("Successfully connected to " + "MySQL server using TCP/IP...");
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(Query);

            if(rs.next()){
                s = new Student();
                s.setGroup_id(rs.getInt("group_id"));
                s.setStudent_id(rs.getInt("student_id"));
                s.setStudent_name(rs.getString("student_name"));
                s.setUser_id(rs.getInt("user_id"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return s;
    }
}
