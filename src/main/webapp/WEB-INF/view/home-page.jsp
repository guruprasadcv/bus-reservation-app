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

<%@include file="header.jsp"%>

	<%-- <div class="bg-img bg-cover"
		style="background-image: url('<c:url value='https://5.imimg.com/data5/IP/BU/GLADMIN-17963951/airavat-club-class.jpg'/>'); height:100%; width:100%;">
		<h2 class="text-center">KSRTC Bus Reservation</h2>
		<p class="text-center">The Karnataka State Road Transport
			Corporation is a state-owned public road transport corporation in the
			Indian state of Karnataka.</p>
		<p class="text-center">It is wholly owned by the Government of Karnataka</p>
	</div>
 --%>

	<c:if test="${logoutMessage ne null}">
		<div align="center" style="color: red;">${logoutMessage}</div>
	</c:if>

	<div class="col-10 col-md-12">
		<img class="img-fluid rounded-start w-100 h-100 object-fit-cover"
			loading="lazy"
			src="https://upload.wikimedia.org/wikipedia/commons/thumb/a/ae/KSRTC-Scania-Airavat-Diamond-Class.jpg/1200px-KSRTC-Scania-Airavat-Diamond-Class.jpg">
	</div>

