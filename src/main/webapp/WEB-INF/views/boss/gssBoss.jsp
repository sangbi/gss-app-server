<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="${pageContext.request.contextPath}/resources/assets/css/bootstrap.css" rel="stylesheet"type="text/css">
	<link href="${pageContext.request.contextPath}/resources/assets/css/mainPage.css" rel="stylesheet" type="text/css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/assets/js/bootstrap.js"></script>
	<title>보스</title>
</head>
<body>
	<c:import url="${pageContext.request.contextPath}/main/nav"></c:import>
	<div class="div_calculate_main">
	<div class="div_boss_list">		
		<table class="table">
			<thead class="table-dark">
				<tr>
					<th></th>
					<th>보스 이름</th>
					<th>난이도</th>
				</tr>
			</thead>
				<tbody>
				<c:forEach var="bossList" items="${bossList}" varStatus="loop">
				<tr>
					<td><div class="select_img"><img src="${pageContext.request.contextPath}/${bossList.bossImagepath}" width="70" height="70"></div></td>
					<td><a href=<c:url value="/boss/selectBoss?bossName=${bossList.bossName}&bossGrade=${bossList.bossGrade }"/>>
					${bossList.bossName}</a></td>
					<td>${bossList.bossGrade}</td>	
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	</div>   
	<!-- paging -->
	<nav aria-label="Page navigation example" class="css-paging">
	       <ul class="pagination justify-content-center">
	           <!--이전-->
	           <c:if test="${page ne 1 }">
	               <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath }/boss/bossList?page=${page-1 }">&laquo;</a></li>
	           </c:if>
	
	           <!--페이지 그룹-->
	           <c:forEach begin="${start }" end="${end }" var="i">
	               <c:choose>
	                   <c:when test="${page eq i}"> <!-- pageNumber 시작은 0 , i는 1부터 -->
	                       <li class="page-item active"><a class="page-link" href="${pageContext.request.contextPath }/boss/bossList?page=${i }" >${i}</a></li>
	                   </c:when>
	                   <c:otherwise>
	                       <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath }/boss/bossList?page=${i }">${i}</a></li>
	                   </c:otherwise>
	               </c:choose>
	           </c:forEach>
	
	           <!--다음-->
	           <c:if test="${page ne end }">
	               <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath }/boss/bossList?page=${page+1 }">&raquo;</a></li>
	           </c:if>
	       </ul>
	   </nav>
       <!-- paging -->
	
	<c:import url="${pageContext.request.contextPath}/main/bottom"></c:import>
</body>
</html>