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
<h1>Browse courses:</h1>
<form action="assign.htm" method="POST">
	<table border="1" >
		<tr>
			<th>Course Name</th>
			<th>Course Date</th>
			<th>Course Time</th>
			<th>Teacher</th>
			<th>(Re)assign Teacher?</th>
		</tr>
		<c:forEach var="course" items="${requestScope.courses}">
			<tr>
				<td><c:out value="${course.getName()}"/></td>
				<td>From <c:out value="${course.getStartDate()}"/> to <c:out value="${course.getEndDate()}"/></td>
				<td>From <c:out value="${course.getStartTime()}"/> to <c:out value="${course.getEndTime()}"/></td>
				<td><c:if test="${course.getTeacher() == null}"><c:out value="Not assigned"/></c:if><c:if test="${course.getTeacher() != null}"><c:out value="${course.getTeacher().getFirstName()}"/></c:if></td>
				<td><input type="radio" name="courseId" value="${course.getId()}"></td>
			</tr>
		</c:forEach>
	</table>
	<input type="submit" value="Go">
</form>
<a href="admin.htm">Go back</a>
</body>
</html>