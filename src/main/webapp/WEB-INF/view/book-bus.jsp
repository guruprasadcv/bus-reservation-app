<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
<script>
	$(function() {
		$("#datepicker").datepicker({
			dateFormat : 'dd-mm-yy',
			minDate : new Date()
		});
	});
</script>
<title>Book Buses</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
</head>


<style>
</style>
<body>
	<%@include file="menu.jsp"%>

	<h1 align="center">Book your Bus here.</h1>
	<h2 align="right">Hi, ${username}</h2>

	<div align="center">
		<form:form method="POST" action="/bus-reservation-app/bus/searchBus"
			modelAttribute="bus">
			
			<form:select class="form-select" aria-label="Default select example"
				path="source" title="select Source">
				<form:label path="source"></form:label>
				<form:option value="" label="Select Source" />
				<form:options items="${busSourceList}" />
			</form:select>

			<form:select class="form-select" aria-label="Default select example"
				path="destination" title="select Destination">
				<form:label path="destination"></form:label>
				<form:option value="" label="Select Destination" />
				<form:options items="${busDestinationList}" />
			</form:select>

			<label>Journey Date</label>
			<form:input id="datepicker" path="availableDate" />
			<input type="submit" class="btn btn-primary" value="search">
		</form:form>
	</div>
	<div align="center" style="color: red;">${errorMessage}</div>

	</br>

<c:if test="${size > 0}">
	<div align="center">
		<form:form modelAttribute="bus">
			<table class="table table-striped" style="">
				<thead class="table-dark">
					<tr>
						<th>Department Name</th>
						<th>Source</th>
						<th>Destination</th>
						<th>Fare</th>
						<th>Available Date</th>
						<th>Seats Available</th>
						<th>Departure Time</th>
						<th>Arrival Time</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach var="busList" items="${availableBuses}">
						<tr>
							<td>${busList.departmentName}</td>
							<td>${busList.source}</td>
							<td>${busList.destination}</td>
							<td>${busList.fare}</td>
							<td>${busList.availableDate}</td>
							<td>${busList.seatsAvailable}</td>
							<td>${busList.departureTime}</td>
							<td>${busList.arrivalTime}</td>

							<td><a
								href="/bus-reservation-app/booking/bookBus?busId=${busList.busId}"
								class="btn btn-primary">Book</a></td>
						</tr>
					</c:forEach>
				</tbody>

			</table>
		</form:form>
	</div>
	</c:if>
</body>
</html>