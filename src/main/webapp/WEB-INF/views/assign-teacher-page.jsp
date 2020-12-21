<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Please assign a teacher</title>
</head>
<body>
<h1>Please assign a teacher to ${sessionScope.course.getName()}</h1>
<form action="assignTeacher.htm" method="POSt">
	<table>
		<c:forEach var="teacher" items="${sessionScope.teachers}">
			<td><input type="radio" name="teacher" value="${teacher.getId()}"/></td>
			<td><c:out value="${teacher.getFirstName()}"></c:out><c:out value="${teacher.getLastName()}"></c:out></td>
		</c:forEach>
	</table>
	<input type="submit" value="Assign"> 
</form>
</body>
</html>