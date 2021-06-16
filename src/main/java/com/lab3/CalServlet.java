package com.lab3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "CalServlet", value = "/CalServlet")
public class CalServlet extends HttpServlet {
    //todo 1: create a method to add(int firstVal, int secondVal) two number
    public double add(double firstVal,double secondVal){
        return firstVal+secondVal;
    }
    //todo 2: create a method to subtract two number
    public double subtract(double firstVal,double secondVal){
        return firstVal-secondVal;
    }
    //todo 3: create a method to multiply two number
    public double multiply(double firstVal,double secondVal){
        return firstVal*secondVal;
    }
    //todo 4: create a method to divide two number
    public double divide(double firstVal,double secondVal){
        return firstVal/secondVal;
    }
    //todo 5: create a method to computeLength of a string
    public int computerLength(String name){
        return name.trim().length();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //todo 6: get all request parameters- firstValue , secondValue,name,action
        double firstVal=request.getParameter("firstVal")!=null?Double.parseDouble(request.getParameter("firstVal")):0.0;
        double secondVal=request.getParameter("secondVal")!=null?Double.parseDouble(request.getParameter("secondVal")):0.0;
        String name=request.getParameter("name");
        String action=request.getParameter("action");
        //todo 7: use if else to determine action is add or subtract or multiply or divide or computerLength
        //todo 8 : call method add, subtract , multiply, divide or computeLength based on action and get the calculated result
        //todo 9: if action =add or subtract or multiply or divide
        //todo 10 :create 3 cookie name cFirstValue, cSecondValue,cResult and set the value of cookie
        //todo 11 : add 3 cookies into response
        if(action.equals("add")){
            double result=add(firstVal,secondVal);
            Cookie cFirstValue=new Cookie("cFirstVal",String.valueOf(firstVal));
            Cookie cSecondValue=new Cookie("cSecondVal",String.valueOf(secondVal));
            Cookie cResult=new Cookie("cResult",String.valueOf(result));
            //cFirstValue.setMaxAge(5);
            //cSecondValue.setMaxAge(5);
            //cResult.setMaxAge(5);
            response.addCookie(cFirstValue);
            response.addCookie(cSecondValue);
            response.addCookie(cResult);
        }else if(action.equals("subtract")){
            double result=subtract(firstVal,secondVal);
            Cookie cFirstValue=new Cookie("cFirstVal",String.valueOf(firstVal));
            Cookie cSecondValue=new Cookie("cSecondVal",String.valueOf(secondVal));
            Cookie cResult=new Cookie("cResult",String.valueOf(result));
            //cFirstValue.setMaxAge(5);
            //cSecondValue.setMaxAge(5);
            //cResult.setMaxAge(5);
            response.addCookie(cFirstValue);
            response.addCookie(cSecondValue);
            response.addCookie(cResult);
        }else if(action.equals("multiply")){
            double result=multiply(firstVal,secondVal);
            Cookie cFirstValue=new Cookie("cFirstVal",String.valueOf(firstVal));
            Cookie cSecondValue=new Cookie("cSecondVal",String.valueOf(secondVal));
            Cookie cResult=new Cookie("cResult",String.valueOf(result));
            //cFirstValue.setMaxAge(5);
            //cSecondValue.setMaxAge(5);
            //cResult.setMaxAge(5);
            response.addCookie(cFirstValue);
            response.addCookie(cSecondValue);
            response.addCookie(cResult);
        }else if(action.equals("divide")){
            double result=divide(firstVal,secondVal);
            Cookie cFirstValue=new Cookie("cFirstVal",String.valueOf(firstVal));
            Cookie cSecondValue=new Cookie("cSecondVal",String.valueOf(secondVal));
            Cookie cResult=new Cookie("cResult",String.valueOf(result));
            //cFirstValue.setMaxAge(5);
            //cSecondValue.setMaxAge(5);
            //cResult.setMaxAge(5);
            response.addCookie(cFirstValue);
            response.addCookie(cSecondValue);
            response.addCookie(cResult);
        }
        //todo 12: if action =computeLength
        //todo 13 :create 2 cookies name cName, cLength and set the value
        //todo 14 : add 2 cookies into response
        else if(action.equals("computeLength")){
            double result=computerLength(name);
            Cookie cName=new Cookie("cName",name);
            Cookie cLength=new Cookie("cLength",String.valueOf(result));
            //cName.setMaxAge(5);
            //cLength.setMaxAge(5);
            response.addCookie(cName);
            response.addCookie(cLength);
        }
        //todo 13 : send redirect to cal.jsp
        response.sendRedirect("/2019211001000713ZhouWeiqiang_war_exploded/lab3/cal.jsp");
    }
}