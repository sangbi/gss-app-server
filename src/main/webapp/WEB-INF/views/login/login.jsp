<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="${pageContext.request.contextPath}/resources/assets/css/bootstrap.css"
	rel="stylesheet" type="text/css">
<link
	href="${pageContext.request.contextPath}/resources/assets/css/mainPage.css"
	rel="stylesheet" type="text/css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/assets/js/bootstrap.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/assets/js/naverlogin.js"
	async></script>
<!-- <script type="text/javascript" src="https://static.nid.naver.com/js/naveridlogin_js_sdk_2.0.0.js" charset="utf-8"></script> -->
<title>Insert title here</title>
</head>
<body>
	<c:import url="${pageContext.request.contextPath}/main/nav"></c:import>
	<div class="container">
		<br>
		<br>
		<br>
		<div class="card text-center">
			<div class="card" >
				<div class="card-body">
					<form:form modelAttribute="LoginDto">
						<form:errors />
						<br>
						<div>
							<label class="font-weight-bolder"style="text-align: left"> <spring:message code="username" /><br> <form:input
							class="form-control-lg col-lg-14"	path="userid" /> <form:errors path="userid" />
							</label>
						</div>

						<div>
							<label class="font-weight-bolder" style="text-align: left"> <spring:message code="password" /><br> <form:password
								class="form-control-lg col-lg-14"	path="password" /> <form:errors path="password" />
							</label>
						</div>

						<label><spring:message code="rememberID" /> <form:checkbox
								path="rememberUserid" /></label>

						<c:if test="${not empty idpasswordNotMatch}">
							<div>
								<label>${idpasswordNotMatch }</label>
							</div>
						</c:if>
						<br>
						<input class="btn btn-outline-success btn btn-dark btn-lg col-3 "type="submit" value="<spring:message code="login.btn"/>">
					</form:form>
					<br>
				</div>
			</div>
		</div>
	</div>
	<c:import url="${pageContext.request.contextPath}/main/bottom"></c:import>
	<!-- <div><button onclick="showLoginPopup();">네이버</button></div> -->
</body>
</html>