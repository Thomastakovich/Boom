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
<form action="login.htm" method="POST">
	User Name: <input type="text" name="username" />
	Password: <input type="password" name="password" />
	<select name="role">
		<option value="student"> Student </option>
		<option value="teacher"> Teacher </option>
		<option value="admin"> Administrator </option>
	</select>
	<input type="submit" value="*** Login ***"/>
</form>
<a href="register.htm">No account? Register now!</a>
</body>
</html>
