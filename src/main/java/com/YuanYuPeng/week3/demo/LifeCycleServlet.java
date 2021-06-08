package com.YuanYuPeng.week3.demo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LifeCycleServlet extends HttpServlet {
    //1. tomcat read web.xml file find out all servlet class
    //2. load servlet - when? 2. first request for this servlet com in - from client
    //3. call default constructor - add code
    public LifeCycleServlet(){
        System.out.println("i am in constructor --> LifeCycleServlet()"); // line 1
    }
    //4. init () - add code
    //use for
    public void init(){
        System.out.println("i am in init()"); // line 2
    }
    //5. tomcat call servlet()--> call doGet() or doPost

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("i am in service () --> doGet()"); //line 3

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("i am in destroy()"); //when ? -stop tomcat
    }
}
