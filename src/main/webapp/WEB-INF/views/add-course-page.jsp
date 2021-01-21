<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add a course here</title>
</head>
<body>
<form:form modelAttribute="course">
	Please Enter Course Name: <form:input path="name"/><br/><form:errors path="name" /><br/>
	
	Please Enter Start Date: <form:input type="date" path="startDate"/><br/><form:errors path="startDate" /><br/>
	
	Please Enter End Date: <form:input type="date" path="endDate"/><br/><form:errors path="endDate" /><br/>
	
	Please Enter Start Time: <form:input type="time" path="startTime"/><br/><form:errors path="startTime" /><br/>
	
	Please Enter End Time: <form:input type="time" path="endTime"/><br/><form:errors path="endTime" /><br/>
	
	Description: <form:textarea path="description"/><br/><form:errors path="description" /><br/>
	
	<input type="submit" value="Add Course"/>
	<br/>
	<a href="admin.htm"> Go Back </a>
</form:form>
</body>
</html>