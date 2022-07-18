<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1" charset="UTF-8">
<title>보스별 드랍 아이템 보스리스트</title>
</head>
<body>
<h1>보스별 드랍아이템 추가</h1>
<table border="1"  style= "align: center; margin: 0 auto;">
	<tr>
		<th>보스 이름</th>
		<th>난이도</th>
		<th>보스 이미지</th>
	</tr>
	<c:forEach var="bossList" items="${bossList}" varStatus="loop">
	<tr>
		<td>${bossList.bossName}</td>
		<td>${bossList.bossGrade}</td>
		<td><img src="resources/file/${bossList.bossimagepath}" width="70" height="150"></td>
	</tr>
	</c:forEach>
</table>
<a href="/admin/main"><input type="button" value="목록"></a>
</body>
</html>