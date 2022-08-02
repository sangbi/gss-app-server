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
<title>내가 소속된 파티</title>
</head>
<body>
<c:import url="${pageContext.request.contextPath}/main/nav"></c:import>
<div class="div_ienParty_main">
	<div class="div_ienParty_mid">
	<form>
		<table class="table table-bordered" style="table-layout: fixed">	
			<tr>
				<th class="table-dark" colspan="2"><strong>파티 이름</strong></th>
			</tr>
			<tr>
				<td colspan="2">${ienterParty.partyName }</td>
			</tr>
			<tr>
				<th class="table-dark"><strong>보스 이름</strong></th>
				<th class="table-dark"><strong>난이도</strong></th>
			</tr>			
			<tr>
				<td>${ienterParty.bossName}</td>
				<td>${ienterParty.bossGrade}</td>
			</tr>
			<tr>
				<th class="table-dark"><strong>파티장</strong></th>
				<th class="table-dark"><strong>캐릭터 이름</strong></th>
	
			</tr>
			<tr>
				<td>${ienterParty.gssUserId}</td>
				<td>${ienterParty.charaterName}</td>
			</tr>
			<tr>
				<th class="table-dark"><strong>파티원</strong></th>
				<th class="table-dark"><strong>캐릭터 이름</strong></th>
			</tr>
			<c:forEach var="myMembers" items="${myMember}">
			<tr>
				<td>${myMembers.gssUserId}</td>
				<td>${myMembers.charaterName}</td>
			</tr>
			</c:forEach>
		</table>
	</form>
	<input type="button" value="목록" class="btn btn-dark"
		onClick="location.href='<c:url value="main" />'">
	</div>
</div>
<c:import url="${pageContext.request.contextPath}/main/bottom"></c:import>
</body>
</html>