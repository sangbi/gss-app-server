<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="${pageContext.request.contextPath}/resources/assets/css/bootstrap.css" rel="stylesheet"type="text/css">
	<link href="${pageContext.request.contextPath}/resources/assets/css/mainPage.css" rel="stylesheet" type="text/css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/assets/js/bootstrap.js"></script>
	<title>보스</title>
</head>
<body>
	<c:import url="${pageContext.request.contextPath}/main/nav"></c:import>
	<h1>아이템</h1>
	<div class="div_boss_list">		
		<table class="table">
			<thead class="table-dark">
				<tr>
					<th>보스 이름</th>
					<th>난이도</th>
					<th>보스 이미지</th>
				</tr>
			</thead>
				<tbody>
				<c:forEach var="bossList" items="${bossList}" varStatus="loop">
				<tr>
					<td>${bossList.bossName}</td>
					<td>${bossList.bossGrade}</td>
					<td><div class="select_img"><img src="${pageContext.request.contextPath}/${bossList.bossImagepath}" width="50" height="50"></div></td>
				</tr>
				</c:forEach>
			</tbody>
	</div>
		</table>
	<c:import url="${pageContext.request.contextPath}/main/bottom"></c:import>
</body>
</html>