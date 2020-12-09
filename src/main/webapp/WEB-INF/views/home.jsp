<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Please Log in!
</h1>
<form action="login.htm" method="post">
	User Name: <input type="text" name="username" />
	Password: <input type="text" name="password" />
	<input type="submit" value="*** Login ***"/>
</form>
</body>
</html>
