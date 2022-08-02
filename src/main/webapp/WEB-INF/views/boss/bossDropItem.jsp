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
	<div class="div_hr">
		<hr class="border-3 opacity-75">
		<h4 class="text-muted"> B O S S </h4>
		<hr class="border-3 opacity-75">
	</div>
	<div class="div_bossDrop_bossList">
		<table class="table table-dark table-striped">
		<tr>
		<td rowspan="3"><div class="select_img"><img src="${pageContext.request.contextPath}/${bossList.bossImagepath}" width="100%" height="100%" /></div></td>
		
		<tr>
			<th>보스이름</th>
			<td>${bossList.bossName}</td>
		</tr>
		<tr>
			<th>난이도</th>
			<td>${bossList.bossGrade }</td>
		</tr>
		</table>
	</div>
	<div class="div_bosList_main">
		<div class="div_item_list">
			<table class="table">
				<thead class="table-dark">
					<tr>
						<th></th>
						<th>아이템 이름</th>
						<th>분류</th>
					</tr>
				</thead>
					<tbody>
					<c:forEach var="itemList" items="${itemList}" varStatus="loop">
					<tr>
						<td width="100"><div class="select_img"><img src="${pageContext.request.contextPath}/${itemList.itemImagepath}" width="50" height="50"></div></td>
						<td>
						${itemList.itemName}</td>
						<td>${itemList.classification}</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		<a href="/boss/bossList"><input type="button" class="btn btn-dark" value="목록"></a>
		</div>
	</div>
	<c:import url="${pageContext.request.contextPath}/main/bottom"></c:import>
</body>
</html>