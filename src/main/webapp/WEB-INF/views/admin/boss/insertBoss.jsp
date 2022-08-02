<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1"
	charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>보스 추가페이지</title>
</head>
<body>
	<c:import url="${pageContext.request.contextPath}/main/nav"></c:import>
	<div class="div_hr">
		<hr class="border-3 opacity-75">
		<h4 class="text-muted">INSERT BOSS</h4>
		<hr class="border-3 opacity-75">
	</div>
	<div class="div_admin_insertBoss">
		<form:form modelAttribute="BossDto" method="POST"
			enctype="multipart/form-data" onsubmit="return check()">
			<table class="table table-dark table-striped">
				<tr>
					<td rowspan="4"><div class="select_img">
							<img style="width: 150px;" id="preview-image" />
						</div></td>
				<tr>
					<th>보스이름</th>
					<td><input type="text" class="form-control form-control-sm"
						name="bossName"></td>
				</tr>
				<tr>
					<th>난이도</th>
					<td><select name="bossGrade"
						class="form-select form-select-sm"
						aria-label=".form-select-sm example"
						style="width: 260px; text-align: left">
							<option value="">난이도 선택</option>
							<option value="익스트림">익스트림</option>
							<option value="카오스">카오스</option>
							<option value="하드">하드</option>
							<option value="노멀">노멀</option>
							<option value="이지">이지</option>
					</select></td>
				</tr>
				<tr>
					<th>보스 이미지</th>
					<td><input type="file" name="bossImagepath" id="input-image"
						class="hidden" value=""></td>
				</tr>
			</table>
			<input type="submit" class="btn btn-dark" value="등록">
			<a href="/admin/boss"><input type="button" class="btn btn-dark"
				value="뒤로가기"></a>
		</form:form>
	</div>
	<c:import url="${pageContext.request.contextPath}/main/bottom"></c:import>
</body>
</html>