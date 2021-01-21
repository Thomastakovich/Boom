<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="assign.htm" method="POST">
	<h1>Browse courses:</h1>	
	<table border="1">
		<tr>
			<th>Course Name</th>
			<th>Course Date</th>
			<th>Course Time</th>
			<th>Teacher</th>
			<th>Description</th>
			<th>Seats remain</th>
			<th></th>
			<th></th>
		</tr>
		<c:forEach var="course" items="${requestScope.courses}">
			<input type="hidden" name="c" value="${course.getId()}">
			<tr>
				<td><c:out value="${course.getName()}"/></td>
				<td>From <c:out value="${course.getStartDate().toString()}"/> to <c:out value="${course.getEndDate().toString()}"/></td>
				<td>From <c:out value="${course.getStartTime()}"/> to <c:out value="${course.getEndTime()}"/></td>
				<td><c:if test="${course.getTeacher() != null}"><c:out value="${course.getTeacher().getFirstName()}"/></c:if><c:if test="${course.getTeacher() == null}"><c:out value="Not assigned"/></c:if></td>
				<td><c:out value="${course.getDescription()}"/></td>
				<td><c:out value="${50 - course.getStudents().size()}"/></td>
				<td><button name="courseId" onclick="location.href='/assign.htm" value="${course.getId()}">(re)assign teacher</button></td>
				<td><input type="submit" value="delete"></td>
			</tr>
		</c:forEach>
	</table>
</form>
	<!-- check null-->
<a href="admin.htm">Go back</a>
</body>
</html>