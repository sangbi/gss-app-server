<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="${pageContext.request.contextPath}/resources/assets/css/bootstrap.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/resources/assets/css/mainPage.css" rel="stylesheet" type="text/css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<title>GSS</title>
</head>
<body>
	<div class="main_background">
	<c:import url="${pageContext.request.contextPath}/main/nav"></c:import>
	<div class="div_main_mid">
		<table class="table table-light table-hover">
			<thead class="table-dark">
				<tr>
					<th>공지사항</th><th>날짜</th>
				</tr>
			</thead>
			<c:forEach items="${noticeList}" var="notice" varStatus="status">
				<tbody>
					<tr>
						<td><a href="/main/notice?address=${notice.noticeUrl}" style="color: black;">${notice.noticeTitle}</a></td>
						<td>${notice.noticePostTime}</td>
					</tr>
				</tbody>
			</c:forEach>
		</table>
	</div>
	<div class="div_main_botnav">
		<nav aria-label="Page navigation example">
			<ul class="pagination container-fluid justify-content-center">
				<c:choose>
					<c:when test="${page > 1}">
						<c:choose>
							<c:when test="${page >= 10}">
								<li class="page-item">
								<a class="page-link" href="/main/home/page=${(page-(page%10)+1)-10}" aria-label="Previous">
					        		<span aria-hidden="true">&laquo;</span>
					      		</a>
					      		</li>
							</c:when>
							<c:otherwise>
								<li class="page-item">
									<a class="page-link" href="/main/home/page=1" aria-label="Previous">
					        			<span aria-hidden="true">&laquo;</span>
					      			</a>
					      		</li>
					      	</c:otherwise>
				      	</c:choose>
				      	<li class="page-item">
							<a class="page-link" href="/main/home/page=${page-1}" aria-label="Previous">
							    <span aria-hidden="true">&lt;</span>
							</a>
						</li>
			      	</c:when>
			      	<c:otherwise>
			      		<li class="page-item">
							<a class="page-link" href="#" aria-label="Previous">
			        			<span aria-hidden="true">&laquo;</span>
			      			</a>
			      		</li>
			      		<li class="page-item">
							<a class="page-link" href="#" aria-label="Previous">
					        	<span aria-hidden="true">&lt;</span>
					      	</a>
			      		</li>
			      	</c:otherwise>
				</c:choose>	
				<c:choose>
					<c:when test="${pageCount < endPageCount}">
						<c:forEach items="${noticeList}" var="notice" varStatus="status">
							<c:choose>
								<c:when test="${pageCount%10 != 0}">
									<li class="page-item"><a class="page-link" href="/main/home/page=${(pageCount-(pageCount%10))+status.count}">${(pageCount-(pageCount%10))+status.count}</a></li>
								</c:when>
								<c:otherwise>
									<li class="page-item"><a class="page-link" href="/main/home/page=${(pageCount-(pageCount%10)-10)+status.count}">${(pageCount-(pageCount%10))+status.count}</a></li>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<c:forEach var="i" begin="1" end="10" varStatus="status">
							<li class="page-item"><a class="page-link" href="/main/home/page=${(pageCount-(pageCount%10)-1)+status.count}">${(pageCount-(pageCount%10)-1)+status.count}</a></li>
						</c:forEach>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${pageCount != 1}">
						<li class="page-item">
							<a class="page-link" href="/main/home/page=${page+1}" aria-label="Next">
			        			<span aria-hidden="true">&gt;</span>
			      			</a>
			      		</li>
					</c:when>
					<c:otherwise>
						<li class="page-item">
							<a class="page-link" href="/main/home/page=2" aria-label="Next">
			        			<span aria-hidden="true">&gt;</span>
			      			</a>
			      		</li>
					</c:otherwise>
				</c:choose>
				<li class="page-item">
					<a class="page-link" href="/main/home/page=${(page-(page%10))+10}" aria-label="Next">
			        	<span aria-hidden="true">&raquo;</span>
			      	</a>
			    </li>
			</ul>
		</nav>
	</div>
	<c:import url="${pageContext.request.contextPath}/main/bottom"></c:import>
	</div>
</body>
</html>