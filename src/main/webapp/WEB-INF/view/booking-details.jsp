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
	<div align="center" >
	<h2 class="h4 text-center">Booking Review</h2>
	
	<form:form modelAttribute="busDTO">
		<div class="row margin-top 10">
			<div class="col-sm-3 fontstyle text-right">Department Name:</div>
			<div class="col-sm-3 fontstyle text-left">
			<b><span>${busDto.departmentName}</span></b>
			</div>
			
			<div class="col-sm-3 fontstyle text-right">Bus ID:</div>
			<div class="col-sm-3 fontstyle text-left">
			<b><span>${busDto.busId}</span></b>
			</div>
			
			<div class="col-sm-3 fontstyle text-right">Source:</div>
			<div class="col-sm-3 fontstyle text-left">
			<b><span>${busDto.source}</span></b>
			</div>
			
			<div class="col-sm-3 fontstyle text-right">Destination:</div>
			<div class="col-sm-3 fontstyle text-left">
			<b><span>${busDto.destination}</span></b>
			</div>
			
			<div class="col-sm-3 fontstyle text-right">Fare:</div>
			<div class="col-sm-3 fontstyle text-left">
			<b><span>${busDto.fare}</span></b>
			</div>
			
			<div class="col-sm-3 fontstyle text-right">Available Date:</div>
			<div class="col-sm-3 fontstyle text-left">
			<b><span>${busDto.availableDate}</span></b>
			</div>
			
			<div class="col-sm-3 fontstyle text-right">Departure Time:</div>
			<div class="col-sm-3 fontstyle text-left">
			<b><span>${busDto.departureTime}</span></b>
			</div>
			
			<div class="col-sm-3 fontstyle text-right">Arrival Time:</div>
			<div class="col-sm-3 fontstyle text-left">
			<b><span>${busDto.arrivalTime}</span></b>
			</div>
			
		</div>
	</form:form>
		
		<div align="left">
		<a href="/bus-reservation-app/passenger/addPassenger">Add Passenger</a>
		</div>
	</div>

</body>
</html>