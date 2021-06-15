<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>validate</title>
</head>
<body>
<%--Todo 1: Use <jsp:useBean> to create a Login bean instance in request scope --%>
<jsp:useBean id="login" class="com.lab2.Login" scope="request">
    <%--Todo 2: Use <jsp:setProperty> to set  beans' property username and password--%>
    <jsp:setProperty name="login" property="username" value="${param.username}"/>
    <jsp:setProperty name="login" property="password" value="${param.password}"/>
</jsp:useBean>

<%
    //todo 3: use if check username is admin and ppassword is admin
    if(login.getUsername().equals("admin")&&login.getPassword().equals("admin")) {
%>
<%--todo 4: use jsp:forward to welcome.jsp page--%>
<jsp:forward page="welcome.jsp"/>
<%--todo 5: else part{ --%>
<%
}
else {
// todo 6: print username or password error message
%>
<c:out value="username or password error"/>
<%--todo 7: use jsp:include login.jsp page --%>
<jsp:include page="login.jsp" flush="false"/>
<%--todo 8: close else --%>
<%
    }
%>
</body>
</html>