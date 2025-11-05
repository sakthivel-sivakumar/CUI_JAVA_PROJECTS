<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<div align="center">
		<h2>Login Form</h2>
	</div>
	<form action="Login" method="post">
		<div align="center">

			<label>UserName: </label> <input type="text" id="userName"
				name="userName">
		</div>
		<br> <br>
		<div align="center">
			<label>Password: </label> <input type="text" id="password"
				name="password">
		</div>
		<br> <br>
		<div align="center">
			<input type="submit" value="Login">
		</div>
		
	</form>
</body>
</html>