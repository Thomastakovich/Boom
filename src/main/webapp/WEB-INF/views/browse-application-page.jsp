<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Applications</title>
</head>
<body>
<h1>Applications waiting for handle: </h1>
<form action="handleApplication.htm" method="POST">
	<c:out value="${requestScope.number} Applications is waiting for handle."></c:out>
	<br/>
	<c:forEach var="app" items="${requestScope.applications}">
		<input type="radio" name="apps" value="${app.getId() }"> Name: <c:out value="${app.getStudent().getFirstName()}" /> <c:out value="${app.getStudent().getLastName()}" /> Course: <c:out value="${app.getCourse().getName()}" /> <br/>
	</c:forEach>
	<br/>
	<input type="submit" name="option" value="Approve"/>
	<input type="submit" name="option" value="Deny"/>
</form>
<a href="admin.htm"> Go back </a>
</body>
</html>