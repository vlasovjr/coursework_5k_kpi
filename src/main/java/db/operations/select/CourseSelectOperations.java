package db.operations.select;

import db.DB;
import entity.Course;
import entity.Study_groups;
import utilits.MyArray;

import java.sql.*;

/**
 * Created by root on 15.06.17.
 */
public class CourseSelectOperations {
    public MyArray<Course> ByGroupId(int group_id){
        MyArray<Course> c = new MyArray<Course>();
        try {
            String Query = "SELECT * FROM course WHERE group_id = "+group_id;

            Connection connection = null;
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DB.connectionURL,DB.connectionUser,DB.connectionPassword);
            if(!connection.isClosed())
                System.out.println("Successfully connected to " + "MySQL server using TCP/IP...");
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(Query);

            while(rs.next()){
                Course course = new Course();
                course.setCourse_id(rs.getInt("course_id"));
                course.setGroup_id(rs.getInt("group_id"));
                course.setSubject_id(rs.getInt("subject_id"));;
                c.add(course);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return c;
    }
}
