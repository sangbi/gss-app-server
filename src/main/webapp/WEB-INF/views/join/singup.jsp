<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="${pageContext.request.contextPath}/resources/assets/css/bootstrap.css"
	rel="stylesheet" type="text/css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/assets/js/bootstrap.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/assets/js/mypage.js"></script>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<c:import url="${pageContext.request.contextPath}/main/nav"></c:import>
	<div class="div_signup">
		<div class="container">
			<form:form modelAttribute="MemberCreateDto" method="POST">
				<div class="form-group col-lg-12">
					<h2>회원가입</h2>
					<br> <label for="userid" style="text-align: left"
						class="font-weight-bolder  col-lg-6">ID</label>
					<form:input class="form-control-lg" path="userid"
						type="text" placeholder="ID 영문 8글자 이내 입력"
						onfocus="this.placeholder=''"
						onblur="this.placeholder='ID 영문 8글자 이내 입력'" size="60"/>
				</div>
				<c:if test="${not empty valid_userid}">
					<label class="text-danger">${valid_userid}</label>
				</c:if>
				<c:if test="${not empty valid_alreadyuserid}">
					<label class="text-danger">${valid_alreadyuserid}</label>
				</c:if>
				<div class="form-group col-lg-12">
					<label for="email" style="text-align: left"
						class="font-weight-bolder  col-lg-6">E-MAIL</label>
					<form:input class="form-control-lg" path="email"
						type="text" placeholder="e-mail 입력" onfocus="this.placeholder=''"
						onblur="this.placeholder='e-mail 입력'" size="60"/>
				</div>
				<div class="form-group col-lg-12">
					<input class="form-control-lg" id="certificationNumber"
						type="text" placeholder="e-mail로 발송된 문자를 넣어주세요"
						onfocus="this.placeholder=''"
						onblur="this.placeholder='e-mail로 발송된 문자를 넣어주세요'" size="60"/> 
						<br><br>
						<input
						class="btn btn-dark btn-lg"
						id="sendEmail" type="button" value="이메일 인증 발송"> 
						<input
						class="btn btn-dark btn-lg"
						id="certificationEmailConfirm" type="button" value="이메일 인증">
				</div>
				<c:choose>
					<c:when test="${not empty valid_email}">
						<label class="text-danger">${valid_email}</label>
					</c:when>
					<c:when test="${not empty valid_alreadyemail}">
						<label class="text-danger">${valid_alreadyemail}</label>
					</c:when>
					<c:when
						test="${not empty valid_alreadyemail} and ${not empty valid_email}">
						<label class="text-danger">${valid_email}</label>
					</c:when>
				</c:choose>
				<c:if test="${not empty valid_certificationFlag}">
					<label class="text-danger">${valid_certificationFlag}</label>
				</c:if>
				<div class="form-group col-lg-12">
					<label for="name" style="text-align: left"
						class="font-weight-bolder  col-lg-6">NAME</label>
					<form:input class="form-control-lg" path="name"
						type="text" placeholder="이름 입력" onfocus="this.placeholder=''"
						onblur="this.placeholder='이름 입력'" size="60"/>
				</div>
				<c:if test="${not empty valid_name}">
					<label class="text-danger">${valid_name}</label>
				</c:if>
				<div class="form-group col-lg-12">
					<label for="password" style="text-align: left"
						class="font-weight-bolder  col-lg-6">PASSWORD</label>
					<form:input class="form-control-lg" path="password"
						type="password" placeholder="8자 이상 숫자, 영문, 특수문자 조합"
						onfocus="this.placeholder=''"
						onblur="this.placeholder='8자 이상 숫자, 영문, 특수문자 조합'" size="60"/>
				</div>
				<c:if test="${not empty valid_password}">
					<label class="text-danger">${valid_password}</label>
				</c:if>
				<div class="form-group col-lg-12">
					<label for="confirmPassword" style="text-align: left"
						style="text-align:left" class="font-weight-bolder  col-lg-6">CONFIRM
						PASSWORD</label>
					<form:input class="form-control-lg" path="confirmPassword"
						type="password" placeholder="8자 이상 숫자, 영문, 특수문자 조합"
						onfocus="this.placeholder=''"
						onblur="this.placeholder='8자 이상 숫자, 영문, 특수문자 조합'" size="60"/>
				</div>
				<c:choose>
					<c:when test="${not empty valid_confirmPassword}">
						<label class="text-danger">${valid_confirmPassword}</label>
					</c:when>
					<c:when test="${not empty valid_confirmPasswordNot}">
						<label class="text-danger">${valid_confirmPasswordNot}</label>
					</c:when>
					<c:when
						test="${not empty valid_confirmPasswordNot} and ${not empty valid_confirmPassword}">
						<label class="text-danger">${valid_confirmPassword}</label>
					</c:when>
				</c:choose>
				<div class="form-group col-lg-12">
					<label for="phoneNumber" style="text-align: left"
						class="font-weight-bolder  col-lg-6">PHONE NUMBER</label>
	
					<form:input class="form-control-lg" path="phoneNumber"
						type="text" placeholder="-를 포함하여 입력. EX)010-1234-5678"
						onfocus="this.placeholder=''"
						onblur="this.placeholder='-를 포함하여 입력. EX)010-1234-5678'" size="60"/>
				</div>
				<c:choose>
					<c:when test="${not empty valid_phoneNumber}">
						<label class="text-danger">${valid_phoneNumber}</label>
					</c:when>
					<c:when test="${not empty valid_alreadyPhoneNumber}">
						<label class="text-danger">${valid_alreadyPhoneNumber}</label>
					</c:when>
					<c:when
						test="${not empty valid_alreadyPhoneNumber} and ${not empty valid_phoneNumber}">
					</c:when>
				</c:choose>
				<br>
				<div class="row justify-content-center">
					<br> <input
						class="btn btn-dark btn-lg col-3 "
						type="submit" value="회원 가입"> <input
						class="btn btn-dark btn-lg col-3 "
						type="button" onclick="joinCancle()" value="취소">
				</div>
				<form:input type="hidden" path="certificationFlag" />
			</form:form>
		</div>
	</div>
	<c:import url="${pageContext.request.contextPath}/main/bottom"></c:import>
</body>
</html>