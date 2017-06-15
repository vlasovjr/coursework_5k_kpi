<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head><title>Student COnfirmation Title</title></head>

<body>

    <%@ page import="java.sql.*" %>
    <%@ page import="javax.sql.*" %>

    <%
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
                out.println("Successfully connected to " + "MySQL server using TCP/IP...");
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
                    out.println("<br\\><br\\><h1>Invalid password try again</h1>");
                }
            }

            connection.close();
        }catch(Exception ex){
            out.println("Unable to connect to database"+ex);
        }
    %>

</body>
</html>