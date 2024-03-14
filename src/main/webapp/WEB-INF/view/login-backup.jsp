<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register page</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
</head>
<style></style>
<div class="container" align="center">
<h1>Log in</h1>
<body>
	<form:form action="processLogin" modelAttribute="loginUser">

			<p>
				<label>User Name:</label>
				</br>
				<form:input path="username" />
			</p>

			<p>
				<label>Password:</label>
				</br>
				<form:password path="password" />
			</p>
			<p>
				 <input type="submit" class="btn btn-primary" value="LogIn"/>
				<div align="center" style="color: red;">${errorMessage}</div> 
	</form:form>
</body>
</div>
</html>