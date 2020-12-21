<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
</head>
<body>
<button>Current Time</button>
<div id="contentdiv"></div>
<h1>Welcome: ${sessionScope.user.getFirstName()}</h1>
<br/>
Your courses:
<br/>
<form action="drop.htm" method="post">
<table border="1">
	<tr>
		<th></th>
		<th>Course Name</th>
		<th>Course Date</th>
		<th>Course Time</th>
		<th>Teacher</th>
	</tr>
	<c:forEach var="c" items="${sessionScope.user.getCourses()}">
		<tr>
			<td><input type="radio" name="course" value="${c.getId()}"></td>
			<td><c:out value="${c.getName()}"></c:out>
			<td>From <c:out value="${c.getStartDate()}" /> To <c:out value="${c.getEndDate()}" /> </td>
			<td>From <c:out value="${c.getStartTime()}" /> To <c:out value="${c.getEndTime()}" /> </td>
			<td><c:if test="${c.getTeacher() == null}"><c:out value="Not assigned"/></c:if><c:if test="${c.getTeacher() != null}"><c:out value="${c.getTeacher().getFirstName()}"/></c:if></td>
		</tr>
	</c:forEach>
	
</table>
<input type="submit" value="drop"/>
</form>
<br/>
<a href = "studentBrowseCourse.htm"> Browse & Apply for a course </a>
<br/>
<a href = "login.htm">Log Out</a>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	$("button").click(function() {
		$.get("getTime.htm", function ( data ) {
			$("#contentdiv").html(data);
		});
	});
</script>
</html>