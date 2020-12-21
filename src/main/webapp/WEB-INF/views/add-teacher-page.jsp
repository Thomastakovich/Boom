<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add teacher</title>
</head>
<body>
<form:form modelAttribute="teacher">
	Please Enter First Name:
	<form:input path="firstName"/> <br/> <form:errors path="firstName"/> <br/>
	Please Enter Last Name:
	<form:input path="lastName"/> <br/> <form:errors path="lastName"/> <br/>
	Please Enter User Name:
	<form:input path="userName"/> <br/> <form:errors path="userName"/> <br/>
	Please Enter Password:
	<form:input path="password"/> <br/> <form:errors path="password"/> <br/>
	Please Enter Zoom ID:
	<form:input path="zoomId"/> <br/> <form:errors path="zoomId"/> <br/>
	<input type="submit" value="Create a new teacher" />
</form:form>
<br/>
<a href="admin.htm"> Go Back </a>
</body>
</html>