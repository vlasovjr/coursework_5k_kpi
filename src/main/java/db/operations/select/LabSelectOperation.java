package db.operations.select;

import db.DB;
import entity.Course;
import entity.Lab;
import entity.Subject;
import utilits.MyArray;

import java.sql.*;

/**
 * Created by root on 15.06.17.
 */
public class LabSelectOperation {
    public MyArray<Lab> BySubjectsArray(MyArray<Subject> subjects){
        MyArray<Lab> answer = new MyArray<Lab>();

        subjects.forEach(s -> answer.addAll(this.BySubjectId(s.getSubject_id())));

        return answer;
    }

    public MyArray<Lab> BySubjectId(int subject_id){
        MyArray<Lab> labs = new MyArray<>();
        try {
            String Query = "SELECT * FROM lab WHERE subject_id= "+subject_id;

            Connection connection = null;
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DB.connectionURL,DB.connectionUser,DB.connectionPassword);
            if(!connection.isClosed())
                System.out.println("Successfully connected to " + "MySQL server using TCP/IP...");
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(Query);

            while(rs.next()){
                Lab l = new Lab();
                l.setLab_id(rs.getInt("lab_id"));
                l.setLab_name(rs.getString("lab_name"));
                l.setLab_body(rs.getString("lab_body"));
                l.setSubject_id(rs.getInt("subject_id"));
                labs.add(l);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return labs;
    }
}
