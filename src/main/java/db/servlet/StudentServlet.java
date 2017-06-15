package db.servlet;

import db.DB;
import utilits.MyArray;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by root on 15.06.17.
 */
public class StudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        MyArray<Cookie> cookies = new MyArray<>();
        cookies.addAll(request.getCookies());

        int user_id_ = Integer.parseInt(cookies.findAll(o -> o.getName().equals("user_id")).get(0).getValue());

        DB.loadDateBaseForStudent(user_id_);
        request.getRequestDispatcher("/forms/student/student_main.jsp").include(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {



        super.doPost(request, response);
    }
}
