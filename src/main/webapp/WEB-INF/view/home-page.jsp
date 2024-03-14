<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

</br>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">

<div align="right">
	<a href="/bus-reservation-app/register/registerPage"
		class="btn btn-primary">Register</a> </br> </br> <a
		href="/bus-reservation-app/login/loginPage" class="btn btn-primary">Login</a>
</div>


<div class="has-bg-img">
	<div class="bg-img bg-cover"
		style="background-image: url('<c:url value='/resources/images/Airavata.jpeg'/>'); height:100%; width:100%;">
		<h2 class="text-center">KSRTC Bus Reservation</h2>
		<p class="text-center">The Karnataka State Road Transport
			Corporation is a state-owned public road transport corporation in the
			Indian state of Karnataka.</p>
		<p class="text-center">It is wholly owned by the Government of Karnataka</p>
	</div>

	</br>
	<c:if test="${logoutMessage ne null}">
		<div align="center" style="color: red;">${logoutMessage}</div>
	</c:if>
</div>