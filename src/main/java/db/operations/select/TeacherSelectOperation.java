package db.operations.select;

import db.DB;
import entity.Study_groups;
import entity.Subject;
import entity.Teachers;
import utilits.MyArray;

import java.sql.*;

/**
 * Created by root on 15.06.17.
 */
public class TeacherSelectOperation {

    public MyArray<Teachers> BySubjectsArray(MyArray<Subject> subjects) {
        MyArray<Teachers> teachers = new MyArray<>();
        subjects.forEach(s -> {
            if(!teachers
                    .containsSuchThat(t -> t.getTeacher_id() == s.getTeacher_id()))
            teachers.add(this.ByTeacherId(s.getTeacher_id()));
        });
        return teachers;
    }

    public Teachers ByTeacherId(int teacher_id){
        Teachers t = null;
        try {
            String Query = "SELECT * FROM teacher WHERE teacher_id = "+teacher_id;

            Connection connection = null;
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DB.connectionURL,DB.connectionUser,DB.connectionPassword);
            if(!connection.isClosed())
                System.out.println("Successfully connected to " + "MySQL server using TCP/IP...");
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(Query);

            if(rs.next()){
                t = new Teachers();
                t.setTeacher_id(rs.getInt("teacher_id"));
                t.setTeacher_name(rs.getString("teache_name"));
                t.setUser_id(rs.getInt("user_id"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return t;
    }
}
