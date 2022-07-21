<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
	<title>아이템</title>
</head>
<body>
	<c:import url="${pageContext.request.contextPath}/main/nav"></c:import>
	<h1>아이템</h1>
	<div class="div_item_list">
		<div>
			<form name="search-form" method="post" action="/item/itemList">
				<select name="type">
					<option selected value="">검색 내용 선택</option>
					<option value="itemname">이름</option>
					<option value="classification">분류</option>
				</select>
				<input type="text" name="keyword" value=""></input>
				<input type="submit" class="btn btn=outline-primart mr-2" value="검색"></input>
			</form>
		</div>
		<table class="table">
			<thead class="table-dark">
				<tr>
					<th>아이템 이름</th>
					<th>분류</th>
					<th>아이템 이미지</th>
				</tr>
			</thead>
				<tbody>
				<c:forEach var="itemList" items="${itemList}" varStatus="loop">
				<tr>
					<td>${itemList.itemName}</td>
					<td>${itemList.classification}</td>
					<td><img src="resources/itemImage/${itemList.itemImagepath}" width="50" height="50"></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<c:import url="${pageContext.request.contextPath}/main/bottom"></c:import>
</body>
</html>