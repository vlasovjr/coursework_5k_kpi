package db;

import java.sql.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.*;

public class DB_static extends HttpServlet{

    public void doPost(HttpServletRequest request, HttpServletResponse response){

        String user_login_ = request.getParameter("login");
        String pwd_ = request.getParameter("password");

        //session.setAttribute("user_login_", user_login_);

        Statement st = null;
        try {
            String connectionURL = "jdbc:mysql://localhost:3306/vlasov_db";
            Connection connection = null;
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(connectionURL, "java", "vlasov");
            if(!connection.isClosed())
                System.out.println("Successfully connected to " + "MySQL server using TCP/IP...");
            st = connection.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM users_login WHERE user_login = '"+user_login_+"'");

            if(rs.next())
            {
                if(rs.getString("user_pass").equals(pwd_))
                {
                    switch (rs.getString("user_category")){
                        case "teacher":
                            connection.close();
                            response.sendRedirect("/forms/teacher/teacher_main.jsp");
                        case "student":
                            connection.close();
                            response.sendRedirect("/forms/student/student_main.jsp");
                        case "admin":
                            connection.close();
                            response.sendRedirect("/forms/admin/admin_main.jsp");
                        default:
                            connection.close();
                            response.sendRedirect("/forms/ERROR.html");
                    }
                }
                else
                {
                    System.out.println("<br\\><br\\><h1>Invalid password try again</h1>");
                }
            }

            connection.close();
        }catch(Exception ex){
            System.out.println("Unable to connect to database"+ex);
        }
    }

    public static String sayHello(){
        return "hello";
    }
}