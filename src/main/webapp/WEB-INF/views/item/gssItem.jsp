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
	<title>아이템</title>
</head>
<body>
	<c:import url="${pageContext.request.contextPath}/main/nav"></c:import>
	<div class="div_hr">
		<hr class="border-3 opacity-75">
		<h4 class="text-muted"> I T E M </h4><hr class="border-3 opacity-75">	
	</div>
	<div class="div_item_main">	
		<table class="table">
			<thead class="table-dark">
				<tr>
					<th></th>
					<th>아이템 이름</th>
					<th>분류</th>
				</tr>
			</thead>
				<tbody>
				<c:forEach var="itemList" items="${itemList}" varStatus="loop">
				<tr>
				<td><div class="select_img"><img src="${pageContext.request.contextPath}/${itemList.itemImagepath}" width="30" height="30"></div></td>
					<td><a href=<c:url value="/item/gssSelectItem?itemName=${itemList.itemName}&classification=${itemList.classification}"/>>
						${itemList.itemName}</a></td>
					<td>${itemList.classification}</td>
					
				</tr>
				</c:forEach>
			</tbody>
		</table>
		</div>
		<div class="div_item_search">
			<form name="search-form" method="get" action="/item/itemSearch">
				<select name="type" class="form-select form-select-lg mb-3" aria-label=".form-select-lg example">
					<option selected value="">선택</option>
					<option value="itemname">이름</option>
					<option value="classification">분류</option>
				</select>
				<input type="text" name="keyword" value=""></input>
				<input type="submit" class="btn btn-dark" style="font-size:15px; padding:4px 5px;" value="검색"></input>
			</form>
		</div>
		
		<!-- paging -->
		<nav aria-label="Page navigation example" class="css-paging">
	       <ul class="pagination justify-content-center">
	           <!--이전-->
	           <c:if test="${page ne 1 }">
	               <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath }/item/itemList?&page=${page-1}">&laquo;</a></li>
	           </c:if>
	
	           <!--페이지 그룹-->
	           <c:forEach begin="${start }" end="${end }" var="i">
	               <c:choose>
	                   <c:when test="${page eq i}"> <!-- pageNumber 시작은 0 , i는 1부터 -->
	                       <li class="page-item active"><a class="page-link" href="${pageContext.request.contextPath }/item/itemList?page=${i }" >${i}</a></li>
	                   </c:when>
	                   <c:otherwise>
	                       <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath }/item/itemList?page=${i }">${i}</a></li>
	                   </c:otherwise>
	               </c:choose>
	           </c:forEach>
	
	           <!--다음-->
	           <c:if test="${page ne end }">
	               <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath }/item/itemList?page=${page+1 }">&raquo;</a></li>
	           </c:if>
	       </ul>
	   </nav>
       <!-- paging -->
	<c:import url="${pageContext.request.contextPath}/main/bottom"></c:import>
</body>
</html>