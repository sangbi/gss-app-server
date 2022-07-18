<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<form:form modelAttribute="MemberCreateDto" method="POST">
		<div>
			<label>ID</label>
		</div>
		<form:input path="userid" type="text" />
		<br>
		<c:if test="${not empty valid_userid}">
			<label>${valid_userid}</label>
		</c:if>
		<br>
		<div>
			<label>e-mail</label>
		</div>
		<form:input path="email" type="text" />
		<br>
		<c:if test="${not empty valid_email}">
			<label>${valid_email}</label>
		</c:if>
		<br>
		<label>password</label>
		<div>
			<form:input path="password" type="password" />
		</div>
		<c:if test="${not empty valid_password}">
			<label>${valid_password}</label>
		</c:if>
		<br>
		<label>password 확인</label>
		<div>
			<form:input path="confirmPassword" type="password" />
		</div>
		<c:if test="${not empty valid_confirmPassword}">
			<label>${valid_confirmPassword}</label>
		</c:if>
		<c:if test="${not empty valid_confirmPasswordNot}">
			<label>${valid_confirmPasswordNot}</label>
		</c:if>
		<br>
		<div>
			<label>phone number</label>
		</div>
		<div>
			<form:input path="phoneNumber" type="text" />
			<br>
		</div>
		<c:if test="${not empty valid_phoneNumber}">
			<label>${valid_phoneNumber}</label>
		</c:if>
		<br>
		<input type="submit" value="회원 가입">
		<input type="button" value="취소">
	</form:form>

</body>
</html>