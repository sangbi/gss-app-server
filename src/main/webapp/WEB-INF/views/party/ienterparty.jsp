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
	<form>
		<table border="1">
			<caption>
				<strong>내가 소속된 파티정보 </strong>
			</caption>

			<tr>
				<td><strong>파티이름</strong></td>
				<td>${ienterParty.partyName }</td>
			</tr>

			<tr>
				<td><strong>보스이름</strong></td>
				<td>${ienterParty.bossName}</td>
				<td>보스난이도</td>
				<td>${ienterParty.bossGrade}</td>
			</tr>
			<tr>
				<td><strong>파티장</strong></td>
				<td>${ienterParty.gssUserId}</td>
				<td><strong>캐릭터네임</strong></td>
				<td>${ienterParty.charaterName}</td>
			</tr>
			<c:forEach var="myMembers" items="${myMember}">
			<tr>
				<td><strong>파티원</strong></td>
				<td>${myMembers.gssUserId}</td>
				<td><strong>캐릭터네임</strong></td>
				<td>${myMembers.charaterName}</td></tr>
				</c:forEach>
		</table>
	</form>
	<input type="button" value="목록"
		onClick="location.href='<c:url value="main" />'">
</body>
</html>