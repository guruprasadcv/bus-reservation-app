<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<%@include file="header1.jsp"%>

<body>
    <div id="login">
        <h3 class="text-center text-white pt-5">forgot password</h3>
        <div class="container">
            <div id="login-row" class="row justify-content-center align-items-center">
                <div id="login-column" class="col-md-6">
                    <div id="login-box" class="col-md-12">
                    <form:form action="resetPassword" modelAttribute="fp">
                            <h3 class="text-center text-info">Reset Password</h3>
                            <div class="form-group">
                                <label for="username" class="text-info">Username:</label><br>
                                <form:input path="username" class="form-control"/>
                            </div>
                            <div class="form-group">
                                <label for="password" class="text-info">Password:</label><br>
                                <form:password path="password" class="form-control"/>
                            </div>
                            <div class="form-group">
                                <input type="submit" name="submit" class="btn btn-info btn-md" value="Reset">
                            </div>
                            <c:if test="${successMessage ne null}">
									<div align="center"></div>${successMessage}
									</br>
									Click <a href="/bus-reservation-app/login/loginPage"> here </a>  to Login
								</c:if>
							</div>
							<%-- <div align="center" style="color: red;">${errorMessage}</div>  --%>
							<c:if test="${errorMessage ne null}">
								<div align="center"></div>${errorMessage}
								</br>Please <a href="/bus-reservation-app/register/registerPage">Register</a>
							</c:if>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>

</html>