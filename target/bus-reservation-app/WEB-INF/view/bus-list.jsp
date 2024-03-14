<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
  <script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
   <script>
  $( function() {
    $( "#datepicker" ).datepicker({dateFormat: 'dd-mm-yy'});
  } );
  </script>
<title>Book Your Tickets.</title>
</head>
<body>

	<div align="center">
		<form:form action="/bus-reservation-app/bus/searchBus" modelAttribute="bus">
			<form:select path="source">
				<form:label path="source"></form:label>
				<form:option value="" label="Select Source" />
				<form:options items="${busSourceList}" />
			</form:select>

			<form:select path="destination">
				<form:label path="destination"></form:label>
				<form:option value="" label="Select Destination" />
				<form:options items="${busDestinationList}" />
			</form:select>
			
			<label>Journey Date</label>
			<form:input id="datepicker" path="availableDate" />
			<input type="submit" value="search">
		</form:form>
	</div>
	
	</br>
	
	<div align="center">
	<form:form modelAttribute="bus">
		<table>
			<thead>
				<tr>
					<th>Department Name</th>
					<th>Source</th>
					<th>Destination</th>
					<th>Fare</th>
					<th>Available Date</th>
					<th>Seats Available</th>
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
					</tr>
				</c:forEach>
			</tbody>

		</table>
	</form:form>
	</div>

</body>
</html>