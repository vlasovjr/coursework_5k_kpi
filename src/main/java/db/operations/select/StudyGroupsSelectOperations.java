package db.operations.select;

import db.DB;
import entity.Student;
import entity.Study_groups;

import java.sql.*;

/**
 * Created by root on 15.06.17.
 */
public class StudyGroupsSelectOperations {
    public Study_groups ByStudentEntity(Student student) {
        return this.ByGroupId(student.getGroup_id());
    }

    public Study_groups ByGroupId(int group_id){
        Study_groups sg = null;
        try {
            String Query = "SELECT * FROM study_group WHERE group_id = "+group_id;

            Connection connection = null;
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DB.connectionURL,DB.connectionUser,DB.connectionPassword);
            if(!connection.isClosed())
                System.out.println("Successfully connected to " + "MySQL server using TCP/IP...");
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(Query);

            if(rs.next()){
                sg = new Study_groups();
                sg.setGroup_id(rs.getInt("group_id"));
                sg.setGroup_name(rs.getString("group_name"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sg;
    }
}
