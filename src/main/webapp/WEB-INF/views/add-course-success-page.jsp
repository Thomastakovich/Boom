<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
Added success!
<br/>
Course name: ${course.getName()} <br/>
Start Date: ${course.getStartDate().toString()} <br/>
End Date: ${course.getEndDate().toString()} <br/>
Course description: ${course.getDescription()} <br/>
<a href="admin.htm"> Go to main page </a>
</body>
</html>