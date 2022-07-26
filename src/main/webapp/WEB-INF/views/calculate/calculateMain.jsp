<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="${pageContext.request.contextPath}/resources/assets/css/bootstrap.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/resources/assets/css/mainPage.css" rel="stylesheet" type="text/css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/assets/js/bootstrap.js"></script>
	<title>GSS</title>
</head>
<body>
	<c:import url="${pageContext.request.contextPath}/main/nav"></c:import>
	<div class="div_main_mid">
		<c:forEach items="${userList}" var="userList" varStatus="loop">
		<table class="table table-hover table-bordered" style="table-layout: fixed">
			<thead>
				<tr>
					<th>파티 이름</th><th>캐릭터 이름</th>
				</tr>
			</thead>
			<tbody>	
				<tr>
					<td><a href="/calculate/calculateList?partyName=${userList.partyName}">${userList.partyName}</a></td><td>${userList.charaterName}</td>	
				</tr>
			</tbody>
		</table>
		<br>
	</c:forEach>
	</div>
	<c:import url="${pageContext.request.contextPath}/main/bottom"></c:import>
</body>
</html>