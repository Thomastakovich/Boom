<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
	Please Enter Course Name:
	<form:input path="name"/><br/><form:errors path="name" /><br/>
	
	Please Enter Start Date:
	<form:input path="startDate"/><br/><form:errors path="startDate" /><br/>
	
	Please Enter End Date:
	<form:input path="endDate"/><br/><form:errors path="endDate" /><br/>
	
	Please Enter Start Time:
	<form:input path="startTime"/><br/><form:errors path="startTime" /><br/>
	
	Please Enter End Time:
	<form:input path="endTime"/><br/><form:errors path="endTime" /><br/>
	
	<input type="submit" value="Add Course"/>
	<br/>
	<a href="admin.htm"> Go Back </a>
</form:form>
</body>
</html>