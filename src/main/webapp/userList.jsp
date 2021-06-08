<%--
  Created by IntelliJ IDEA.
  User: 86156
  Date: 2021/4/6
  Time: 21:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<h1>User List</h1>
<table border=1>
    <tr>
        <td>Id</td><td>Username</td><td>password</td><td>Email</td><td>Gender</td><td>Birthdate</td>
    </tr>
    <%
        //get rs from request attribute
        ResultSet rs= (ResultSet) request.getAttribute("name"); //name of attribute
        if(rs==null){


    %>
    <tr><td>No Data !!!</td></tr>
    <%}else {


        while (rs.next()) {
            out.println("<tr>");
            int id=rs.getInt("id");
            String username=rs.getString("username");
            String password=rs.getString("password");
            String email=rs.getString("email");
            String gender=rs.getString("gender");
            Date birthdate=rs.getDate("birthdate");
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            out.println("<tr><td>"+id+"</td><td>"+username+"</td><td>"+password+"</td><td>"+email+"</td><td>"+gender+"</td><td>"+sdf.format(birthdate)+"</td></tr>");
            out.println("<td>" + rs.getInt("id") + "</td>");
            out.println("<td>" + rs.getString("username") + "</td>");
            out.println("<td>" + rs.getString("password") + "</td>");
            out.println("<td>" + rs.getString("email") + "</td>");
            out.println("<td>" + rs.getString("gender") + "</td>");
            out.println("<td>" + rs.getString("birthdate") + "</td>");

            out.println("</tr>");
        }
    }
    //we will get data in next demo#3
    %>
</table>
<%@include file="footer.jsp"%>