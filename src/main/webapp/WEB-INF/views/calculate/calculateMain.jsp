<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="${pageContext.request.contextPath}/resources/assets/css/bootstrap.css"
	rel="stylesheet" type="text/css">
<link
	href="${pageContext.request.contextPath}/resources/assets/css/mainPage.css"
	rel="stylesheet" type="text/css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/assets/js/bootstrap.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/assets/js/itemAdd.js"></script>
<title>GSS</title>
</head>
<body>
	<c:import url="${pageContext.request.contextPath}/main/nav"></c:import>
	<c:choose>
		<c:when test="${empty userList}">
			<div class="div_empty_page">
				<img
					src="${pageContext.request.contextPath}/resources/tagImage/mir.png"
					style="width: 150px; height: 150px;">
				<p class="text-muted">THE PAGE EMPTY</p>
			</div>
		</c:when>
		<c:otherwise>
			<div class="div_hr">
				<hr class="border-3 opacity-75">
				<h4 class="text-muted">CALCULATE ~ ING</h4>
				<hr class="border-3 opacity-75">
			</div>
			<div class="div_calculate_main">
				<c:forEach items="${userList}" var="userList" varStatus="loop">
					<form action="/calculate/calculateList" method="get">
						<table class="table table-hover table-bordered"
							style="table-layout: fixed">
							<thead>
								<tr>
									<th class="table-dark">파티 이름</th>
									<th class="table-dark">캐릭터 이름</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td><input type="submit" name="partyName"
										value="${userList.partyName}" class="btn btn-link"
										style="color: black;" onclick="moveCalculateList(this.form)"></td>
									<td style="vertical-align: middle">${userList.charaterName}</td>
								</tr>
							</tbody>
						</table>
					</form>
					<br>
				</c:forEach>
			</div>
		</c:otherwise>
	</c:choose>
	<c:import url="${pageContext.request.contextPath}/main/bottom"></c:import>
</body>
</html>