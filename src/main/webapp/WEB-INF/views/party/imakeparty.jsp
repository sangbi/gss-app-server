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
<title>Insert title here</title>
</head>
<body>
<c:import url="${pageContext.request.contextPath}/main/nav"></c:import>
<div class="div_makeParty_main">
	<div class="div_makeParty_mid">
		<form>
			<table class="table table-bordered" style="table-layout: fixed">	
				<tr>
					<th class="table-dark" colspan="2"><strong>파티 이름</strong></th>
				</tr>
				<tr>
					<td colspan="2">${myParty.partyName}</td>
				</tr>
				<tr>
					<th class="table-dark"><strong>보스 이름</strong></th>
					<th class="table-dark"><strong>난이도</strong></th>
				</tr>
				<tr>
					<td>${myParty.bossName}</td>
					<td>${myParty.bossGrade}</td>
				</tr>
				<tr>
					<th class="table-dark"><strong>파티장</strong></th>
					<th class="table-dark"><strong>캐릭터 이름</strong></th>
	
				</tr>
				<tr>
					<td>${myParty.gssUserId}</td>
					<td>${myParty.charaterName}</td>
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
	</div>
	
	<div>
		<form action="getSearchList" method="get">
			<fieldset>
				<legend> 파티원 추가 </legend>
					<input type="hidden" name=partyName value="${myParty.partyName}">
					<input type="hidden" name="id" value="gssUserId">
					<input type="hidden" name=gssUserId value="${myParty.gssUserId}"> 
					<div class="div_partyButton">
						<input type="text" name=keyWord value="" class="form-control" style="width:300px">
					</div>	
					<input type="submit" value="검색" class="btn btn-dark">
					
			</fieldset>
		</form>
	</div>
	<div class="div_makeParty_insert">
		<form action="insertPerson" method="get">	
			<table class="table table-bordered" style="table-layout: fixed">
				<tr>
					<th class="table-dark">ID</th>
					<th class="table-dark">E-MAIL</th>
				</tr>
				<c:forEach var="list" items="${search}">
					<tr>
						<td><input type="radio" name="insertId" class="form-check-input"
							value="${list.gssUserId}"> ${list.gssUserId}</td>
						<td>EMAIL: ${list.email }</td>
					</tr>
				</c:forEach>
				<tr>
					<th class="table-light" style="vertical-align:middle">
						캐릭터 이름
					</th>
					<td>
						<input type="hidden" name="partyName" value="${myParty.partyName}">	
						<input type="text" name="charaterName" class="form-control" style="width:300px">
					</td>
				</tr>
			</table>
			<input type="hidden" name="gssUserId" value="${myParty.gssUserId}">
			<input type="submit" value="추가" class="btn btn-dark">
			<input type="button" value="목록" class="btn btn-dark" onClick="location.href='<c:url value="main" />'">
		</form>
	</div>
</div>	
<c:import url="${pageContext.request.contextPath}/main/bottom"></c:import>
</body>
</html>