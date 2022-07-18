<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:import url="${pageContext.request.contextPath}/main/nav"></c:import>
	<form:form modelAttribute="LoginDto">
		<form:errors />
		<p>
			<label> <spring:message code="userid" /><br> <form:input
					path="userid" /> <form:errors path="userid" />
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
</body>
</html>