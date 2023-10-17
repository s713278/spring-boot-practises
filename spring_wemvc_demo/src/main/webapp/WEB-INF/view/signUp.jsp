<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<html>
<head>
<title>First Web Application</title>
</head>

<body>
    <font color="red">${errorMessage}</font>
    
     <form:form id="regForm" modelAttribute="user" action="/user/register" method="post">
        Name : <form:input type="text" name="name" path="name"/><span> <form:errors path="name"/></span>
        <br>
        Email : <form:input type="text" name="email" path="email"/> <span><form:errors path="email"/></span>
        <br>
      <form:button id="register" name="register">Register</form:button>
    </form:form>
</body>

</html>