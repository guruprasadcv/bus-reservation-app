<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<link rel="stylesheet"
	href="https://unpkg.com/bootstrap@5.3.2/dist/css/bootstrap.min.css">

<%@include file="header1.jsp"%>

<section class="bg-light p-3 p-md-4 p-xl-5">
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-12 col-xxl-11">
				<div class="card border-light-subtle shadow-sm">
					<div class="row g-0">
						<div class="col-12 col-md-6">
							<img class="img-fluid rounded-start w-100 h-100 object-fit-cover"
								loading="lazy" src="https://i.pinimg.com/564x/85/41/1c/85411ca0fae820f198bc068760c17a55.jpg">
						</div>
						<div
							class="col-12 col-md-6 d-flex align-items-center justify-content-center">
							<div class="col-12 col-lg-11 col-xl-10">
								<div class="card-body p-3 p-md-4 p-xl-5">
									<div class="row">
										<div class="col-12">
											<div class="mb-5">
												<div class="text-center mb-4">
													<a href="#!"> <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR08xHo7seBMdP6s4iOfQfY6hSHnpkbtvIBQw&usqp=CAU"
														 width="175" height="100">
													</a>
												</div>
												<h2 class="h4 text-center">Sign up</h2>
											</div>
										</div>
									</div>
									<form:form action="processRegister" modelAttribute="user">
										<div class="row gy-3 overflow-hidden">
											<div class="col-12">
											<label for="lastName" class="form-label">Username</label>
												<div class="form-floating mb-3">
													<form:input path="userName" class="form-control"/>
												</div>
											</div>
											<div class="col-12">
													<label for="lastName" class="form-label">Password</label>
												<div class="form-floating mb-3">
													<form:password path="password" class="form-control" />
												</div>
											</div>
											<div class="col-12">
													<label for="email" class="form-label">Email</label>
												<div class="form-floating mb-3">
													<form:input path="email" class="form-control" />
												</div>
											</div>
											<div class="col-12">
													<label for="password" class="form-label">Phone
														Number</label>
												<div class="form-floating mb-3">
													<form:input path="phoneNumber" class="form-control" />
												</div>
											</div>
										</div>
										<br>
										<div class="col-12">
											<div class="d-grid">
												<button class="btn btn-dark btn-lg" type="submit">Sign
													up</button>
											</div>
										</div>
								</div>
								 <div id="register-link" class="text-center">
                                <a href="/bus-reservation-app/login/loginPage" class="text-info">Already Registered?</a>
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

						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>
</section>
</html>