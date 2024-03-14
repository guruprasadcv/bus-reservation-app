<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
</head>
<body>

<%@include file="menu.jsp"%>

<div align="center">
	<form:form modelAttribute="user">
		<table class="table table-striped">
			<thead class="table-dark">
				<tr>
					<th>Username</th>
					<th>Email</th>
					<th>Phone Number</th>
				</tr>
			</thead>

			<tbody>
					<tr>
						<td>${userInfo.userName}</td>
						<td>${userInfo.email}</td>
						<td>${userInfo.phoneNumber}</td>
					</tr>
			</tbody>
		</table>
	</form:form>
	</div>
</body>
</html>