
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WELCOME ADMINISTRATOR</title>
</head>
<body>
<button>Current Time</button>
<div id="contentdiv"></div>
<h1>Administrate Your System: </h1>
*<a href="browseCourses.htm"> Browse courses </a> <br/><br/>
*<a href="addCourse.htm"> Add a new course </a> <br/><br/>
*<a href="browseTeachers.htm"> Browse teachers </a> <br/><br/>
*<a href="addTeacher.htm"> Add a new teacher </a> <br/><br/>
*<a href="applications.htm"> Handel Applications </a> <br/><br/>
*<a href="login.htm"> Logout </a>
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