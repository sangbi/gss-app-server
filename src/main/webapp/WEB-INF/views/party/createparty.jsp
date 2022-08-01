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
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/assets/js/bossgradelist.js"></script>

<title>Insert title here</title>
</head>
<body>
<c:import url="${pageContext.request.contextPath}/main/nav"></c:import>
<div class="div_create_party">
	<form action="insert" method="post">
	<table class="table" id="modalItem" style="table-layout: fixed">
			<tr>
				<th class="table-dark" colspan="2">파티이름</th>
				<th class="table-dark" colspan="2">아이디</th>
			</tr>
			<tr>
				<td colspan="2"><input type="text" name="partyName" style="width:150px"></td>
				<td colspan="2"><input type="text" name="id" value="${authInfo.id}"
					readonly style="width:150px"></td>
			</tr>
			<tr>
				<th class="table-dark" colspan="2">보스</th>
				<th class="table-dark" colspan="2">난이도</th>
			</tr>
			<tr>
				<td colspan="2"><select name='bossName' id="bossName" style="width:150px">
						<c:forEach var="bossName" items="${getBossName}">
							<option value="${bossName}">${bossName}</option>
						</c:forEach>
				</select></td>
				
				<td colspan="2"><select name='level' id="bossGrade" style="width:150px">
						<option value="">선택</option>
				</select></td>
			</tr>
			<tr>
				<td colspan="2" class="table-dark">캐릭터 이름</td>
				<td colspan="2"><input type="text" name="charaterName" style="width:150px"></td>
			</tr>
		</table>
		<br><br>
		<input type="submit" class="btn btn-dark" value="파티생성">
		<input type="button" class="btn btn-dark" value="목록으로 돌아가기"
		onClick="location.href='<c:url value="main" />'">
	</form>
</div>
<c:import url="${pageContext.request.contextPath}/main/bottom"></c:import>
</body>
</html>