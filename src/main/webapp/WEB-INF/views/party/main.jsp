<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
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
	src="${pageContext.request.contextPath}/resources/assets/js/mypage.js"></script>
<title>GET PARTY</title>
</head>
<body>
	<c:import url="${pageContext.request.contextPath}/main/nav"></c:import>
	<c:choose>
		<c:when test="${empty myParty}">
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
			<h4 class="text-muted">GET PARTY</h4>
			<hr class="border-3 opacity-75">
		</div>
		<div class="div_party_mainPage">
			<div class="div_party_list">
				<table class="table table-bordered" style="table-layout: fixed">
					<tr>
						<th class="table-dark">파티 이름</th>
						<th class="table-dark">캐릭터 이름</th>
					</tr>
					<c:forEach var="imLeader" items="${myParty}">
						<tr>
							<td><a
								href='<c:url value="imakeparty?gssUserId=${imLeader.gssUserId}&partyName=${imLeader.partyName}"/>'>${imLeader.partyName}</a></td>
							<td>${imLeader.charaterName}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<div class="div_party_bottom">
				<input type="button" class="btn btn-dark" value="파티생성"
					onClick="location.href='<c:url value="createparty" />'">
			</div>
			<div>
				<ul class="pagination container-fluid justify-content-center">
					<c:forEach var="pageNum" begin="${pc1.beginPage}"
						end="${pc1.endPage}">
						<li class="page-item"><a class="page-link"
							href='<c:url value="/party/main?page=${pageNum}"/>'>${pageNum}</a>
						</li>
					</c:forEach>
				</ul>
			</div>
		</div>
		</c:otherwise>
	</c:choose>
	<c:import url="${pageContext.request.contextPath}/main/bottom"></c:import>
</body>
</html>