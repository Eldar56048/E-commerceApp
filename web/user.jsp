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
<%
if(request.getSession().getAttribute("User")!=null){
    User user = (User) request.getSession().getAttribute("User");
    out.println("<h1>"+user.getName()+" "+user.getSurname()+" "+user.getUsername()+" "+user.getRole()+" "+user.getBirthday()+"</h1>");
}
%>
</body>
</html>
