<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="${pageContext.request.contextPath}/resources/assets/css/mainPage.css" rel="stylesheet" type="text/css">
	<script src="https://cdn.jsdelivr.net/npm/sweetalert2@10.10.1/dist/sweetalert2.all.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<title>GSS</title>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light navbar-dark bg-dark">
		<a class="navbar-brand" href="/main/home">GSS</a>
		<button class="navbar-toggler" type="button"
				data-toggle="collapse"
				data-target="#navbarTogglerDemo02"
				aria-controls="navbarTogglerDemo02"
				aria-expanded="false"
				aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarTogglerDemo02">
			<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
				<li class="nav-item active">
					<a class="nav-link" href="/main/home">Home<span class="sr-only">(current)</span></a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="#">내정보</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="/boss/bossList">보스</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="/item/itemList">아이템</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="#">파티</a>
				</li>
				<li class="nav-item dropdown">
					<a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">정산</a>
					<ul class="dropdown-menu">
            			<li><a class="dropdown-item" href="/calculate/partyList?userId=kjg">정산 진행 중</a></li>
            			<li><a class="dropdown-item" href="/calculate/calculateComplete?userId=kjg">정산 완료</a></li>
         			 </ul>
				</li>
			</ul>
			<form class="form-inline my-2 my-lg-0">
				<button class="mr-sm-2 btn btn-outline-success my-2 my-sm-0" 
						type="submit" 
						onclick="loction.href='#'">Sign Up
				</button>
				<button class="mr-sm-2 btn btn-outline-success my-2 my-sm-0"
						type="submit"
						onclick="loction.href='/member/login'">Login
				</button>
			</form>
		</div>
	</nav>
</body>
</html>