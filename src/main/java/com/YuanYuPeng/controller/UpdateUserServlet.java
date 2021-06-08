package com.YuanYuPeng.controller;

import com.YuanYuPeng.dao.UserDao;
import com.YuanYuPeng.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "UpdateUserServlet", value = "/updateUser")
public class UpdateUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/updateUser.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int Id= Integer.parseInt(request.getParameter("Id"));
        String Username=request.getParameter("Username");
        String password=request.getParameter("password");
        String Email=request.getParameter("Email");
        String Gender=request.getParameter("Gender");
        try {
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            Date Date=sdf.parse(request.getParameter("Date"));
            User user=new User();
            user.setId(Id);
            user.setUsername(Username);
            user.setPassword(password);
            user.setEmail(Email);
            user.setGender(Gender);
            user.setBirthdate(Date);
            UserDao userDao=new UserDao();
            Connection con = (Connection) getServletContext().getAttribute("con");
            try {
                if(userDao.updateUser(con,user)!=0) {
                    User user1=userDao.findByUsernamePassword(con,Username,password);
                    HttpSession session=request.getSession();
                    session.setMaxInactiveInterval(10);
                    session.setAttribute("user",user1);
                    request.getRequestDispatcher("accountDetails").forward(request, response);
                }
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
