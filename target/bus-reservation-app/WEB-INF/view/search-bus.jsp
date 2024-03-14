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
/*   $( function() {
    $( "#datepicker" ).datepicker({dateFormat: 'dd-mm-yy'});
  } ); */
  
  $( function() {
	    $( "#datepicker" ).datepicker({dateFormat: 'dd-mm-yy',  minDate: new Date() });
	  } );

  </script>
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
		<form:form method="POST" action="/bus-reservation-app/bus/searchBus" modelAttribute="bus">
			<form:select path="source">
				<form:label path="source"></form:label>
				<form:option value="" label="Select Source" />
				<form:options items="${busSource}" />
			</form:select>

			<form:select path="destination">
				<form:label path="destination"></form:label>
				<form:option value="" label="Select Destination" />
				<form:options items="${busDestination}" />
			</form:select>
			
			<label>Journey Date</label>
			<form:input id="datepicker" path="availableDate" />
			<input type="submit" class="btn btn-primary" value="search">
		</form:form>
	</div>
</body>
</html>