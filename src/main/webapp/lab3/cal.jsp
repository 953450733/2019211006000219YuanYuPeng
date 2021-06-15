
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script>
        function submitForm(i){
            var form=document.getElementById("myForm");
            if(!validateForm()){
                return false;
            }
            else{
                if(i===1)
                    document.forms["myForm"]["action"].value="add";
                else if(i===2)
                    document.forms["myForm"]["action"].value="subtract";
                else if(i===3)
                    document.forms["myForm"]["action"].value="multiply";
                else if(i===4)
                    document.forms["myForm"]["action"].value="divide";
                else if(i===5)
                    document.forms["myForm"]["action"].value="computeLength";
                form.submit();
            }
        }
        function formReset(){
            document.getElementById("myForm").reset();
        }
        function validateForm(){
            var str=document.forms["myForm"]["name"].value;
            var flag = 0;
            if(parseFloat(str).toString() === "NaN"){
                flag=1;
            }
            if(!flag){
                alert("Name is not valid");
            }
            var val1=document.forms["myForm"]["firstVal"].value;
            if (parseFloat(val1).toString() === "NaN") {
                alert("First Value is not a Number");
                return false;
            }
            var val2=document.forms["myForm"]["secondVal"].value;
            if (parseFloat(val2).toString() === "NaN") {
                alert("Second Value is not a Number");
                return false;
            }
            return true;
        }
    </script>
</head>
<body>
<%
    Cookie[] cookies=request.getCookies();
    String firstVal="";
    String secondVal="";
    String result="";
    String name="";
    String length="";
    if (cookies!=null){
        for (Cookie cookie:cookies){
            if (cookie.getName().equals("cFirstVal")){
                firstVal=cookie.getValue();
            }
            if (cookie.getName().equals("cSecondVal")){
                secondVal=cookie.getValue();
            }
            if (cookie.getName().equals("cResult")){
                result=cookie.getValue();
            }
            if (cookie.getName().equals("cName")){
                name=cookie.getValue();
            }
            if (cookie.getName().equals("cLength")){
                length=cookie.getValue();
            }
        }
    }
    //update 5 user basepath
%>
<form method="post" action="<%=request.getContextPath()+"/CalServlet"%>" id="myForm">
    <table>
        <tr><td>First Val:</td> <td><input type="text" name="firstVal" id="firstVal" value="<%=firstVal%>"></td>
            <td>Enter a Name:</td> <td><input type="text" name="name" id="name" value="<%=name%>"></td></tr>
        <tr><td>Second Val:</td> <td><input type="text" name="secondVal" id="secondVal" value="<%=secondVal%>"></td>
            <td>Length:</td> <td><input type="text" name="length" value="<%=length%>"></td></tr>
        <tr><td>Result:</td> <td><input type="text" name="result" value="<%=result%>"></td></tr>
    </table>
    <p><input type="button" value="add" onclick="submitForm(1)"> <input type="button" value="subtract" onclick="submitForm(2)">
        <input type="button" value="multiply" onclick="submitForm(3)"> <input type="button" value="divide" onclick="submitForm(4)">
        <input type="button" value="computeLength" onclick="submitForm(5)"> <input type="button" value="Reset" onclick="formReset()"></p>
    <input type="hidden" name="action">
</form>
</body>
</html>
