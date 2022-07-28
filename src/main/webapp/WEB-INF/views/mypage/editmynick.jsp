<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="${pageContext.request.contextPath}/resources/assets/css/bootstrap.css"
	rel="stylesheet" type="text/css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/assets/js/bootstrap.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/assets/js/mypage.js"></script>
<meta charset="UTF-8">
<title>MY Info</title>
</head>
<body>
	<c:import url="${pageContext.request.contextPath}/main/nav"></c:import>
	<div class="container text-center">
		<br> <br>
		<h2>안녕하세요! ${authInfo.id }님!</h2>
		<br> <br>
		<form:form>
		<div class="table-responsive-sm">
			<table class="table table-striped table-bordered table-sm col-md-6">
				<thead class="table-dark">
					<tr>
						<th class="col-md-1"><spring:message code="party.name" /></th>
						<th colspan="2" class="col-md-2"><spring:message
								code="partyofmyNick" /></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><label><input type="hidden" value="${partyName} ">${partyName} </label></td>
						<td><input type="text" placeholder="${charaterName }" onfocus="this.placeholder=''" onblur="this.placeholder='${charaterName }'"></td>
						<td><a href="<c:url value='/member/editMyNick?partyName=${MIL.partyName }&charaterNick=${MIL.charaterName }'/>">
								<button type="submit"
									class=" btn-sm btn-outline-success btn btn-dark btn-lg col-lg-8">
									<spring:message code="editNick" />
								</button>
						</a></td>
					<tr>
				</tbody>
			</table>
		</div>
		</form:form>
	</div>
</body>
</html>