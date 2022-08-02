<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SET PARTY</title>
</head>
<body>
	<c:import url="${pageContext.request.contextPath}/main/nav"></c:import>
	<c:choose>
		<c:when test="${empty myParty2}">
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
				<h4 class="text-muted">SET PARTY</h4>
				<hr class="border-3 opacity-75">
			</div>
			<div class="div_party_mainPage">
				<div class="div_party_list">
					<table class="table table-bordered" style="table-layout: fixed">
						<tr>
							<th class="table-dark">파티 이름</th>
							<th class="table-dark">캐릭터 이름</th>
						</tr>
						<c:forEach var="imFollower" items="${myParty2}">
							<tr>
								<td><a
									href='<c:url value="ienterparty?gssUserId=${imFollower.gssUserId}&partyName=${imFollower.partyName}"/>'>
										${imFollower.partyName}</a></td>
								<td>${imFollower.charaterName}</td>
							</tr>
						</c:forEach>
					</table>
					<div>
						<ul class="pagination container-fluid justify-content-center">
							<c:forEach var="pageNum" begin="${pc2.beginPage}"
								end="${pc2.endPage}">
								<li class="page-item"><a
									href='<c:url value="/party/mainMember?page=${pageNum}"/>'
									class="page-link">${pageNum}</a></li>
							</c:forEach>
						</ul>
					</div>
				</div>
			</div>
		</c:otherwise>
	</c:choose>
	<c:import url="${pageContext.request.contextPath}/main/bottom"></c:import>
</body>
</html>