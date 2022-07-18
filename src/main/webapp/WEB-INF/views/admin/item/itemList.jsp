<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1" charset="UTF-8">
<title>아이템정보등록 아이템리스트</title>
</head>
<body>
<h1>아이템정보 등록</h1>
<table border="1"  style= "align: center; margin: 0 auto;">
	<tr>
		<th>아이템 이름</th>
		<th>분류</th>
		<th>아이템 이미지</th>
	</tr>
	<c:forEach var="itemList" items="${itemList}" varStatus="loop">
	<tr>
		<td>${itemList.itemName}</td>
		<td>${itemList.classification}</td>
		<td><img src="resources/file/${itemList.itemImagepath}" width="70" height="150"></td>
	</tr>
	</c:forEach>
</table>
<a href="/admin/main"><input type="button" value="목록"></a>
</body>
</html>