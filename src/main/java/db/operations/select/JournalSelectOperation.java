package db.operations.select;

import db.DB;
import entity.Journal;
import entity.Lab;
import entity.Student;
import utilits.MyArray;

import java.sql.*;

/**
 * Created by root on 15.06.17.
 */
public class JournalSelectOperation {
    public MyArray<Journal> ByStudentEntity(Student student) {
        MyArray<Journal> journals = new MyArray<>();

        try {
            String Query = "SELECT * FROM journal WHERE student_id= "+student.getStudent_id();

            Connection connection = null;
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DB.connectionURL,DB.connectionUser,DB.connectionPassword);
            if(!connection.isClosed())
                System.out.println("Successfully connected to " + "MySQL server using TCP/IP...");
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(Query);

            while(rs.next()){
                Journal j = new Journal();
                j.setLab_id(rs.getInt("lab_id"));
                j.setRating(rs.getString("rating"));
                j.setStudent_id(rs.getInt("student_id"));
                j.setJurnal_id(rs.getInt("jurnal_id"));
                journals.add(j);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return  journals;
    }
}
