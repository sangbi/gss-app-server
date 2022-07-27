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
<title>${itemList.itemName}정보</title>
</head>
<body>
<form:form modelAttribute="ItemDto" method="POST" enctype="multipart/form-data" onsubmit="return check()">
		<table 
		width="50%" 
		height=200
		border="1">
		<tr>
		<td rowspan="4"><div class="select_img"><img style=width:150px; id="preview-image"/></div></td>
		
		<tr>
			<th>아이템이름</th>
			<td><input type="text" name="itemName"></td>
		</tr>
		<tr>
			<th>분류</th>
			<td><select name="classification">
					<option value="">분류 선택</option>
					<option value="장비">장비</option>
					<option value="소비">소비</option>
					<option value="기타">기타</option>
				</select>
			</td>
		</tr>
		<tr>
			<th>아이템 이미지</th>
			<td><input type="file" name="itemImagepath" id="input-image"class="hidden"value=""></td>
		</tr>
		</table>
		<input type="submit" value="등록">
		<a href="/admin/item"><input type="button" value="뒤로가기"></a>
</form:form>
<%-- 		<table 
		width="30%"
		height=200
		border="1">
		<tr>
		<td rowspan="3"><div class="select_img"><img src="${pageContext.request.contextPath}/${itemList.itemImagepath}" width="100%" height="100%" /></div></td>
		
		<tr>
			<td>아이템 이름</td>
			<td>${itemList.itemName}</td>
			<td><input type="text"></td>
		</tr>
		<tr>
			<td>분류</td>
			<td>${itemList.classification}</td>
			<td><input type="text"></td>
		</tr>
		<tr>
			<td><input type="submit" value="추가"></td>
		</tr>
		</table>
		<a href="/admin/bossDropItem"><input type="button" value="뒤로가기"></a>--%>
</body> 
</html>