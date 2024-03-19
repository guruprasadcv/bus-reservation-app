<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Booking Details</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
</head>
<body>
	<%@include file="menu.jsp"%>
	<div align="center">
		<form:form modelAttribute="busDTO">
			<table class="table table-striped" style="">
				<thead class="table-dark">
					<tr>
						<th>Department Name</th>
						<th>Source</th>
						<th>Destination</th>
						<th>Fare</th>
						<th>Available Date</th>
						<th>Username</th>
						<th>Email</th>
						<th>Phone</th>
					</tr>
					
				</thead>

				<tbody>
						<tr>
							<td>${busDto.departmentName}</td>
							<td>${busDto.source}</td>
							<td>${busDto.destination}</td>
							<td>${busDto.fare}</td>
							<td>${busDto.availableDate}</td>
							<td>${busDto.username}</td>
							<td>${busDto.email}</td>
							<td>${busDto.phoneNumber}</td>
						</tr>
				</tbody>

			</table>
		</form:form>
		
		<div align="left">
		<a href="/bus-reservation-app/passenger/addPassenger">Add Passenger</a>
		</div>
	</div>

</body>
</html>