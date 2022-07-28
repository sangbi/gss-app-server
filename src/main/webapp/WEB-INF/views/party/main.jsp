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
<title>Insert title here</title>
</head>
<body>
	<c:import url="${pageContext.request.contextPath}/main/nav"></c:import>
	<div class="div_party_list">

		party_____________________________ <br> <input type="button"
			value="파티생성" onClick="location.href='<c:url value="createparty" />'">
		<br>
		<table border="1">
			<input type="button" value="내가만든파티정보">
			<tr>
				<td colspan="2">파티리스트</td>
				<%--  *여기 아이디 세션으로 받아서 id넣고 출력되게
 바꿔야함 아이디는 지금 메퍼에 1로저장함 DB에1로 된 아이디값 반영됨(테스트) --%>
			</tr>
			<tr>
				<td>파티이름</td>
				<td>보스이름</td>
				<td>난이도</td>
			</tr>
			<c:forEach var="imLeader" items="${myParty}">
				<tr>
					<td><a
						href='<c:url value="imakeparty?gssUserId=${imLeader.gssUserId}&partyName=${imLeader.partyName}"/>'>
							${imLeader.partyName}</a></td>
					<td>${imLeader.bossName}</td>
					<td>${imLeader.bossGrade}</td>
				</tr>
			</c:forEach>
		</table>
		<c:forEach var="pageNum" begin="${pc.beginPage}" end="${pc.endPage}">
			<a href='<c:url value="/party/main?page=${pageNum}"/>'>${pageNum}</a>
		</c:forEach>
		<br> <br>
		<table border="1">
			<input type="button" value="내가참여한파티보기">
			<tr>
				<td colspan="2">파티리스트</td>
			</tr>
			<tr>
				<td>파티이름</td>
				<td>보스이름</td>
				<td>난이도</td>
			</tr>
			<c:forEach var="imFollower" items="${myParty2}">
				<tr>
					<td><a href='<c:url value="ienterParty?gssUserId=${imFollower.gssUserId}&partyName=${imFollower.partyName}"/>'>
							${imFollower.partyName}</a></td>
					<td>${imFollower.bossName}</td>
					<td>${imFollower.bossGrade}</td>
				</tr>
			</c:forEach>
		</table>
		<br> <br>
	</div>
	<c:import url="${pageContext.request.contextPath}/main/bottom"></c:import>
</body>
</html>