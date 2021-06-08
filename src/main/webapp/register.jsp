<%--
  Created by IntelliJ IDEA.
  User: 86156
  Date: 2021/3/11
  Time: 15:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--<html>
<head>
    <title>Register</title>


    <script>
        $.validator.addMethod("dateFormat",function (value,element) {
            var DATE_FORMAT = /^(\d{4})-(0\d{1}|[12]\d{1}|3[01])-(0\d{1}|1[0-2])$/;
            if(DATE_FORMAT.test(value)) return true;
            else return false;
        }," The date format should be yyyy-dd-mm");
    </script>

    <script>
        $().ready(function() {
            $("#signupForm").validate({
                rules: {
                    username: {
                        required: true,
                        minlength: 2
                    },
                    password: {
                        required: true,
                        minlength: 8
                    },
                    confirm_password: {
                        required: true,
                        minlength: 8,
                        equalTo: "#password"
                    },
                    email: {
                        required: true,
                        email: true
                    },
                    birthday: {
                        required: true,
                        dateFormat: true
                    },
                },
                messages: {
                    username: {
                        required: " Please input username",
                        minlength: " At least 2 characters"
                    },
                    password: {
                        required: " Please input password",
                        minlength: " At least 8 characters"
                    },

                    birthday: {
                        required: " Please input your birthday,surprise on the day :D",
                        dateFormat:" The date format incorrect，it should be yyyy-mm-dd"
                    },
                }
            });
        });
    </script>
    <style>
        .error{
            color:red;
        }
    </style>
</head>
<body> -->
<%@include file="header.jsp"%>

<div class="center">
    <form action="register" method="post" >
        <h1>Register User</h1>

        Username:<input type="text" name="username" required/><br/>
        Password:<input type="password" name="password" id="password"  required/><br/>
        Email :<input type="email" name="email" required/><br/>
        <tr>
            <td>Gender:</td>
            <td>
                <input type="radio" name="gender" value="Male" checked="checked"/> Male <!-- checked="checked"默认选择项 -->
                <input type="radio" name="gender" value="Female"/> Female
            </td>
        </tr>
        <br/>
        Birthdate :<input type="date" name="birthdate" required /><br/>


        <tr> <td></td><td><input type="submit" value="Register"/></td>  </tr>
    </form>

    <br/><br/><br/><br/>
</div>
<div class="bottom" >

    <div class="bottomTOP">WuYaling</div>
    <div class="bottomLeft">Email:1520144588@qq.com</div>
    <div class="bottomRight">id:2019211001000703 </div>

</div>

<!--
<form method="post" action="register"> <!within doPost() in servlet
    Username:<input type="text" name="Username"><br/>
    Password:<input type="text" name="password"><br/>
    Email:<input type="text" name="Email"><br/>
    Gender: <input type="radio" name="Gender" value="male">Male<input type="radio" name="gender" value="female">Female<br/>
    <--if name is same it make array ->
    Date of Birth:<input type="text name" name="BirthDate" ><br/>
    <input type="submit" value="Register"/>
</form>-->
<%@include file="footer.jsp"%>
