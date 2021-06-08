<%--
  Created by IntelliJ IDEA.
  User: 86156
  Date: 2021/3/31
  Time: 18:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Count</title>
</head>
<body>
    This is Count JSP page. <br/>
    <%! int count=0;%>
    The page count is now : <%out.println(++count);%>
</body>
</html>
