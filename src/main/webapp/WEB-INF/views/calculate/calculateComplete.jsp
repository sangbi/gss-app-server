<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<c:import url="${pageContext.request.contextPath}/main/nav"></c:import>
	<div class="div_main_mid">
		<table class="table table-bordered" style="table-layout: fixed">	
				<tr>
					<th class="table-dark">파티 이름</th>
					<th class="table-dark">캐릭터 이름</th>
					<th class="table-dark">정산 금액</th>
					<th class="table-dark">날짜</th>
				</tr>
			<c:forEach items="${calculateComplete}" var="calculateComplete" varStatus="loop">
				<tr>
					<td><a href="/calculate/calculateCompleteList?partyName=${calculateComplete.partyName}">${calculateComplete.partyName}</a></td>
					<td>${calculateComplete.charaterName}</td>
					<td>${calculateComplete.resultprice}</td>
					<td>${calculateComplete.resultDate}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<c:import url="${pageContext.request.contextPath}/main/bottom"></c:import>
</body>
</html>