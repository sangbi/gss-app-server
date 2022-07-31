
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1" charset="UTF-8">
<title>관리자 페이지</title>
</head>
<body>
<c:import url="${pageContext.request.contextPath}/main/nav"></c:import>
<div class="div_admin_main">
	<fieldset>
    	<legend>관리자 페이지</legend>
		<br>
		<a href="/admin/boss"><input type="button" class="btn btn-outline-secondary" style="width:200px" value="보스정보 등록"></a><br><br>
		<a href="/admin/item"><input type="button" class="btn btn-outline-secondary" style="width:200px" value="아이템정보 등록"></a><br><br>
		<a href="/admin/bossAndDrop"><input type="button" class="btn btn-outline-secondary" style="width:200px" value="보스별 드랍 아이템 추가"></a>
	</fieldset>
</div>
<c:import url="${pageContext.request.contextPath}/main/bottom"></c:import>
</body>
</html>