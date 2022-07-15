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
	<c:forEach items="${noticeList}" var="notice">
		title : <a href="/main/notice?address=${notice.noticeUrl}">${notice.noticeTitle}</a><br>
		url : ${notice.noticeUrl}<br>
		time : ${notice.noticePostTime}<br>
		<br><br>
	</c:forEach>
</body>
</html>