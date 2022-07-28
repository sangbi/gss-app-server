<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1" charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="${pageContext.request.contextPath}/resources/assets/css/bootstrap.css" rel="stylesheet"type="text/css">
	<link href="${pageContext.request.contextPath}/resources/assets/css/mainPage.css" rel="stylesheet" type="text/css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/assets/js/itemAdd.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/itemImage"></script>
<title>추가 페이지</title>
</head>
<body>
		<div class="div_item_list">
		<table class="table">
			<thead class="table-dark">
				<tr>
					<th>아이템 이름</th>
					<th>분류</th>
					<th>아이템 이미지</th>
					<th>추가</th>
				</tr>
			</thead>
				<tbody>
				<c:forEach var="item" items="${item}" varStatus="loop">
				<tr>
					<td>
					${item.itemName}</td>
					<td>${item.classification}</td>
					<td><div class="select_img"><img src="${pageContext.request.contextPath}/${item.itemImagepath}" width="50" height="50"></div></td>
					<td><a href=<c:url value="/admin/insertDropItem?itemNum=${item.itemNum}&bossName=${bossName}&bossGrade=${bossGrade}"/>><input type="button" value="추가"></a></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	<a href="/admin/bossAndDrop"><input type="button" value="목록"></a>
</div>
</body> 
</html>