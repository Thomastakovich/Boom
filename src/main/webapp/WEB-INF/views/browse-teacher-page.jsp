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
<h1>Browse teachers:</h1>
<table border="1" >
	<tr>
		<th>Teacher Name</th>
		<th>Teacher User Name</th>
		<th>Teacher ZoomId</th>
	</tr>
<c:forEach var="teacher" items="${requestScope.teachers}">
	<tr>
		<td><c:out value="${teacher.getFirstName()}"/></td>
		<td><c:out value="${teacher.getUserName()}"/></td>
		<td><c:out value="${teacher.getZoomId()}"/></td>
	</tr>
</c:forEach>
</table>
<a href="admin.htm">Go back</a>
</body>
</html>