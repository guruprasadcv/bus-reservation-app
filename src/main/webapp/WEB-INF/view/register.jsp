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
<div class="container" align="center">
<h1>Register Here</h1>
<body>

<div align="right">
<a href="/bus-reservation-app/home/homePage" class="btn btn-primary">Home</a>
</div>
	<form:form action="processRegister" modelAttribute="user">

		<div align="center">
			<p>
				<label>User Name:</label>
				</br>
				<form:input path="userName" />
			</p>

			<p>
				<label>Password:</label>
				</br>
				<form:password path="password" />
			</p>

			<p>
				<label>Email:</label>
				</br>
				<form:input path="email" />
			</p>

			<p>
				<label>Phone:</label>
				</br>
				<form:input path="phoneNumber" />
			</p>
			
			<p>
			<input type="submit" value="Register" class="btn btn-primary">
		</div>
		<div align="center" style="color: red;">${registerError}</div>
		<div align="center">
		
		<c:if test="${registerSuccess ne null}">
			<div align="center"></div>${registerSuccess}
			</br>
			Click <a href="/bus-reservation-app/login/loginPage"> here </a>  to Login
		</c:if>
		</div>
	</form:form>
</body>
</div>
</html>