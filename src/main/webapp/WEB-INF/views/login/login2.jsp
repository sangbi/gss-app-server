<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="${pageContext.request.contextPath}/resources/assets/css/bootstrap.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/resources/assets/css/mainPage.css" rel="stylesheet" type="text/css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/assets/js/bootstrap.js"></script>	
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/assets/js/naverlogin.js" async></script>
<!-- <script type="text/javascript" src="https://static.nid.naver.com/js/naveridlogin_js_sdk_2.0.0.js" charset="utf-8"></script> -->
<title>Insert title here</title>
</head>
<body>
	<c:import url="${pageContext.request.contextPath}/main/nav"></c:import>
	<form:form modelAttribute="LoginDto">
		<form:errors />
		<p>
			<label> <spring:message code="username" /><br> <form:input
					path="username" /> <form:errors path="username" />
			</label>
		</p>
		<p>
			<label> <spring:message code="password" /><br> <form:password
					path="password" /> <form:errors path="password" />
			</label>
		</p>
		<p>
			<label><spring:message code="rememberID" /> <form:checkbox
					path="rememberUserid" /></label>
		</p>
		<c:if test="${not empty idpasswordNotMatch}">
			<div>
				<label>${idpasswordNotMatch }</label>
			</div>
		</c:if>
		<input type="submit" value="<spring:message code="login.btn"/>">
	</form:form>
	<br>
	<div><button onclick="showLoginPopup();">네이버</button></div>
	<c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION }">
	<p style="color:red; font-weight:bold;"> login Failed : ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message }</p>
	<c:remove var="SPRING_SECURITY_LAST_EXCEPTION" scope="session" />
	<c:import url="${pageContext.request.contextPath}/main/bottom"></c:import>
</c:if>
</body>
</html>