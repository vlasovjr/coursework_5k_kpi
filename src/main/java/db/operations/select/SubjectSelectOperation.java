package db.operations.select;

import db.DB;
import entity.Course;
import entity.Subject;
import utilits.MyArray;

import java.sql.*;

/**
 * Created by root on 15.06.17.
 */
public class SubjectSelectOperation {
    public MyArray<Subject> ByCoursesArray(MyArray<Course> courses) {
        MyArray<Subject> answer = new MyArray<Subject>();

        for(Course c: courses)
            if(!answer.containsSuchThat(o -> (o.getSubject_id() == c.getSubject_id())))
                answer.add(this.BySubjectId(c.getSubject_id()));

        return answer;
    }

    public Subject BySubjectId(int subject_id){
        Subject s = null;
        try {
            String Query = "SELECT * FROM subject WHERE subject_id= "+subject_id;

            Connection connection = null;
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DB.connectionURL,DB.connectionUser,DB.connectionPassword);
            if(!connection.isClosed())
                System.out.println("Successfully connected to " + "MySQL server using TCP/IP...");
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(Query);

            while(rs.next()){
                s = new Subject();
                s.setTeacher_id(rs.getInt("teacher_id"));
                s.setSubject_name(rs.getString("subject_name"));
                s.setSubject_id(rs.getInt("subject_id"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return s;
    }
}
