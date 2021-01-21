<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Choose a course</title>
</head>
<body>
<h1>Please choose one course you want to attend:</h1>

<form action="courseApply.htm" method="POST">
	<table border="1" >
		<tr>
			<th></th>
			<th>Course Name</th>
			<th>Course Date</th>
			<th>Course Time</th>
			<th>Teacher</th>
			<th>Description</th>
			<th>Selected</th>
		</tr>
		<c:forEach var="course" items="${requestScope.courses}">
			<tr>
				<td><input type="radio" id="${course.getId()}" name="course" value="${course.getId()}" /></td>
				<td><c:out value="${course.getName()}"/></td>
				<td>From <c:out value="${course.getStartDate()}"/> to <c:out value="${course.getEndDate()}"/></td>
				<td>From <c:out value="${course.getStartTime()}"/> to <c:out value="${course.getEndTime()}"/></td>
				<td><c:out value="${course.getDescription()}"/></td>
				<td><c:if test="${course.getTeacher() == null}"><c:out value="Not assigned"/></c:if><c:if test="${course.getTeacher() != null}"><c:out value="${course.getTeacher().getFirstName()}"/></c:if></td>
				<td><c:out value="${course.getStudents().size()}"/></td>
			</tr>
		</c:forEach>
	</table>

	<input type="submit" value="Apply!">
</form>

<a href="student.htm">Go back</a>
</body>
</html>