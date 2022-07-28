<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
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
	src="${pageContext.request.contextPath}/resources/assets/js/joinend.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>회원 정보 수정</title>
</head>
<body>
	<c:import url="${pageContext.request.contextPath}/main/nav"></c:import>
	<script>
		$('.carousel').carousel({
			interval : 1000
		//기본 5초
		})
	</script>
	<div class="container">
		<div id="demo" class="carousel slide" data-ride="carousel">
			<div class="carousel-inner">
				<!-- 슬라이드 쇼 -->
				<div class="carousel-item active">
					<!--가로-->
					<img class="d-block w-100" style="height: 500px;"
						src="${pageContext.request.contextPath}../resources/bossImage/자쿰.PNG"
						alt="First slide">
					<div class="carousel-caption d-none d-md-block"></div>
				</div>
				<div class="carousel-item">
					<img class="d-block w-100" style="height: 500px;"
						src="${pageContext.request.contextPath}../resources/bossImage/혼테일.PNG"
						alt="Second slide">
				</div>
				<div class="carousel-item">
					<img class="d-block w-100" style="height: 500px;"
						src="${pageContext.request.contextPath}../resources/bossImage/핑크빈.PNG"
						alt="Third slide">
				</div>
				<!-- / 슬라이드 쇼 끝 -->

				<!-- 인디케이터 -->
				<ul class="carousel-indicators">
					<li data-target="#demo" data-slide-to="0" class="active"></li>
					<!--0번부터시작-->
					<li data-target="#demo" data-slide-to="1"></li>
					<li data-target="#demo" data-slide-to="2"></li>
				</ul>
				<!-- 인디케이터 끝 -->
			</div>
		</div>
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel">
			<div class="modal-dialog modal-sm" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h4 class="modal-title" id="myModalLabel">사용자 정보 수정</h4>
					</div>
					<div class="modal-body">
						사용자 정보가 수정되어 로그아웃 됩니다.<br>다시 로그인 부탁드립니다.
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-dark" data-dismiss="modal"
							onclick="moveLogin()">로그인 페이지 이동</button>
						<button type="button" class="btn btn-dark" data-dismiss="modal"
							onclick="moveHome()">메인 페이지 이동</button>
					</div>
				</div>
			</div>
		</div>
		<div class="row justify-content-center">
			<div class="card" style="width: 50rem;">
				<div class="card-body">
					<h5 class="card-title">사용자 정보 수정</h5>
					<p class="card-text">사용자 정보가 수정되어 로그아웃 됩니다.</P>
					<p class="card-text">다시 로그인 부탁드립니다.</p>
					<p class="card-text">하단의 버튼으로 원하시는 페이지로의 이동이 가능합니다.</p>
				</div>
				<div class="row justify-content-center">
					<button type="button" class="btn btn-dark col-3"
						data-dismiss="modal" onclick="moveLogin()">로그인 페이지 이동</button>
					<button type="button" class="btn btn-dark col-3"
						data-dismiss="modal" onclick="moveHome()">메인 페이지 이동</button>
				</div>

			</div>
		</div>
	</div>
</body>
</html>