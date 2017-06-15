package db.servlet;

import db.DB;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by root on 15.06.17.
 */
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String user_login_ = request.getParameter("login");
        String pwd_ = request.getParameter("password");

        PrintWriter out = response.getWriter();

        Statement st = null;
        try {
            Connection connection = null;
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(DB.connectionURL, DB.connectionUser, DB.connectionPassword);
            if(!connection.isClosed())
                System.out.println("Successfully connected to " + "MySQL server using TCP/IP...");
            st = connection.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM users_login WHERE user_login = '"+user_login_+"'");

            if(rs.next())
            {

                if(rs.getString("user_pass").equals(pwd_))
                {
                    Cookie cookie_user_id = new Cookie("user_id", rs.getString("user_id"));
                    response.addCookie(cookie_user_id);

                    switch (rs.getString("user_category")){
                        case "teacher":
                            connection.close();
                            response.sendRedirect("/forms/teacher/teacher_main.jsp");
                            break;
                        case "student":
                            connection.close();
                            response.sendRedirect("/student");
                            break;
                        case "admin":
                            connection.close();
                            response.sendRedirect("/forms/admin/admin_main.jsp");
                            break;
                        default:
                            connection.close();
                            response.sendRedirect("/ERROR");
                            break;
                    }
                }
                else
                {
                    out.println("<br\\><br\\><h1>Invalid password try again</h1>");
                }
            }
            else
            {
                connection.close();
                response.sendRedirect("/ERROR");
            }
        }catch(Exception ex){
            System.out.println("Unable to connect to database"+ex);
            response.sendRedirect("/ERROR");
        }

    }
}
