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
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/assets/js/bootstrap.js"></script>
<title>아이템정보등록 아이템리스트</title>
</head>
<body>
<h1>아이템정보 등록</h1>
<div class="div_item_list">
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
					<td><a href=<c:url value="/admin/selectItem?itemName=${itemList.itemName}&classification=${itemList.classification}"/>>
						${itemList.itemName}</a></td>
					<td>${itemList.classification}</td>
					<td><div class="select_img"><img src="${pageContext.request.contextPath}/${itemList.itemImagepath}" width="50" height="50"></div></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	<a href="/admin/main"><input type="button" value="목록"></a>
	<a href="/admin/addItem"><input type="button" value="아이템정보 추가"></a>
</div>
</body>
</html>