<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="${pageContext.request.contextPath}/resources/assets/css/bootstrap.css"
	rel="stylesheet" type="text/css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/assets/js/main.js"></script>
<title>GSS</title>
</head>
<body>
	<nav
		class="navbar navbar-expand-lg navbar-light bg-light navbar-dark bg-dark">
		<a class="navbar-brand" href="/main/home">GSS</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarTogglerDemo02"
			aria-controls="navbarTogglerDemo02" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarTogglerDemo02">
			<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
				<li class="nav-item active"><a class="nav-link"
					href="/main/home">Home<span class="sr-only">(current)</span></a></li>
				<li class="nav-item"><a class="nav-link" href="/member/mypage">내정보</a></li>
				<li class="nav-item"><a class="nav-link" href="/boss/bossList">보스</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="/item/itemList">아이템</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="/party/main">파티</a></li>
				<li class="nav-item"><a class="nav-link"
					href="/calculate/partyList?userId=ㅁ">정산</a></li>
			</ul>
			<c:if test="${empty authInfo}">
				<button class="mr-sm-2 btn btn-outline-success my-2 my-sm-1 "
					onclick="moveJoin()">SignUp</button>
				<button class="mr-sm-2 btn btn-outline-success my-2 my-sm-1 "
					onclick="moveLogin()">Login</button>
			</c:if>
			<c:if test="${!empty authInfo }">
				<button class="mr-sm-2 btn btn-outline-success my-2 my-sm-1 "
					onclick="moveMyPage()">Hello!<br>${authInfo.id }</button>
			</c:if>
			<c:if test="${!empty authInfo }">
				<button class="mr-sm-2 btn btn-outline-success my-2 my-sm-1 "
					onclick="logOut()">Log Out</button>
			</c:if>
		</div>
	</nav>
</body>
</html>