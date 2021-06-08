package com.YuanYuPeng.week4.demo;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(
        urlPatterns = {"/config"},
        initParams = {
                @WebInitParam(name = "name", value = "WuYaling"),
                @WebInitParam(name = "studentId", value = "2019211001000703")
        }
)


public class ConfigDemoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletConfig config=getServletConfig();
        String name=config.getInitParameter("name");
        String studentId=config.getInitParameter("studentId");
        PrintWriter writer= response.getWriter();
        writer.println("Name : "+name);
        writer.println("StudentID : "+studentId);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
