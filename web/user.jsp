<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    HttpSession httpSession = request.getSession();
if(httpSession.getAttribute("User")!=null){
    User user = (User) httpSession.getAttribute("User");
}
else {
    response.sendRedirect("Product");
}
%>
<%@ page import="com.company.models.User" %><%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 13.10.2020
  Time: 11:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
${sessionScope.User.name}
</body>
</html>