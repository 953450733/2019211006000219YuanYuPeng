<%--
  Created by IntelliJ IDEA.
  User: 86156
  Date: 2021/4/23
  Time: 13:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1>User Update</h1>
<%
    User u=(User) session.getAttribute("user");
%>
<form method="post" action="/2019211001000703WuYaling_war_exploded/updateUser">
    <table>
        <tr> <td>Id:</td> <td><input type="text" name="Id" value="<%=u.getId()%>" required><br/></td></tr>
        <tr> <td>Username:</td> <td><input type="text" name="Username" value="<%=u.getUsername()%>"><br/></td></tr>
        <tr> <td>Password:</td> <td><input type="password" name="Password" value="<%=u.getPassword()%>"><br/></td></tr>
        <tr> <td>Email:</td> <td><input type="email" name="Email" value="<%=u.getEmail()%>"><br/></td></tr>
        <tr>
            <td>Gender:</td>
            <td>
                <input type="radio" name="Gender" value="Male" <%="Male".equals(u.getGender())?"checked":""%>/> Male
                <input type="radio" name="Gender" value="Female" <%="Female".equals(u.getGender())?"checked":""%>/> Female
            </td>
        </tr>
        <tr> <td>Birthdate:</td> <td><input type="date" name="Birthdate" value="<%=u.getBirthdate()%>"><br/></td></tr>
        <tr> <td></td><td><input type="submit" value="Save Changes"/></td>  </tr>
    </table>
</form>
<%@include file="footer.jsp"%>