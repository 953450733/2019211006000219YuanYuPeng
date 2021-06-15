package com.YuanYuPeng.controller;

import com.YuanYuPeng.dao.UserDao;
import com.YuanYuPeng.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "UpdateUserServlet", value = "/updateUser")
public class UpdateUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("in");
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String mail=request.getParameter("email");
        String sex=request.getParameter("sex");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date birth= null;
        try {
            System.out.println(request.getParameter("birth").trim());

            birth = simpleDateFormat.parse(request.getParameter("birth").trim());
        } catch (ParseException e) {
            System.out.println(e);
        }
        String id=request.getParameter("id");
        User u=new User(Integer.valueOf(id),username,password,mail,sex,birth);
        UserDao userDao=new UserDao();
        try {
            userDao.updateUser((Connection)getServletContext().getAttribute("con"),u);
            HttpSession session=request.getSession();
            session.setMaxInactiveInterval(60*60);
            session.setAttribute("user",u);

        } catch (SQLException e) {
            System.out.println(e);
        }
        System.out.println(birth);
        request.getRequestDispatcher("accountDetails").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("herhe");
        request.getRequestDispatcher("WEB-INF/views/updateUser.jsp").forward(request,response);
    }
}