<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>GSS</title>
</head>
<body>
	<c:import url="${pageContext.request.contextPath}/main/nav"></c:import>
	<div>
		<ul>
		<c:forEach items="${noticeList}" var="notice">
			<li><a href="/main/notice?address=${notice.noticeUrl}">${notice.noticeTitle}</a>
			${notice.noticePostTime}
			<br><br>
		</c:forEach>
		</ul>
	</div>
</body>
</html>