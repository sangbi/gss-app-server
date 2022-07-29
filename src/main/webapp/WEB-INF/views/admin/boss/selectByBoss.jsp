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
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/assets/js/bossAdd.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/bossImage"></script>
<title>${bossList.bossName}정보</title>
</head>
<body>
	<div class="div_calculate_main">
		<table 
		width="30%"
		height=200
		border="1">
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
		<a href="/admin/boss"><input type="button" value="목록"></a>
		<a href="/admin/deleteBoss?bossName=${bossList.bossName}&bossGrade=${bossList.bossGrade}"><input type="button" value="삭제"></a>
	</div>
</body>
</html>