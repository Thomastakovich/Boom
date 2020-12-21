<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Please Register Your Account</title>
</head>
<body>
<form:form modelAttribute="student">
	Please Enter Your First Name: 
	<form:input type="text" path="firstName" /><br/><form:errors path="firstName" /><br/>
	Please Enter Your Last Name: 
	<form:input type="text" path="lastName" /><br/><form:errors path="lastName" /><br/>
	Please Enter Your User Name: 
	<form:input type="text" path="userName" /><br/><form:errors path="userName" /><br/>
	Please Enter Your Password: 
	<form:input type="password" path="password" /><br/><form:errors path="password" /><br/>
	Please Input Your email: 
	<form:input type="text" path="email" /><br/><form:errors path="email" /><br/>
	Please Enter Your Zoom Account: 
	<form:input type="text" path="zoomId" /><br/><form:errors path="zoomId" /><br/>
	<input type="submit" value="Register Now"/> 
</form:form> 
<br/>
<a href="login.htm">Quit</a>
</body>
</html>