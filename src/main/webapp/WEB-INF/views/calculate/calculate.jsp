<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="${pageContext.request.contextPath}/resources/assets/css/mainPage.css" rel="stylesheet" type="text/css">
	<script src="https://cdn.jsdelivr.net/npm/sweetalert2@10.10.1/dist/sweetalert2.all.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js"></script>
	<title>GSS</title>
</head>
<body>
	<c:import url="${pageContext.request.contextPath}/main/nav"></c:import>
	<div class="div_main_mid">	
		<table class="table table-striped table-hover" style="table-layout: fixed">
			<ul class="list-group list-group-flush">
				<tr>
					<th>파티이름</th><th>인원</th>
				</tr>
				<tr>
					<td>
						<li class="list-group-item">${partyName}</li>
					</td>
					<td> 
						<li class="list-group-item">${count} 명</li>
					</td>
				</tr>
				<tr>
					<th>보스</th><th>난이도</th>
				</tr>
				<tr>
					<td>
						<c:forEach items="${calcBoss}" var="calcBoss" varStatus="loop">
							<li class="list-group-item">${calcBoss.bossName}</li>					
						</c:forEach>
					</td>
					<td>
						<c:forEach items="${calcBoss}" var="calcBoss" varStatus="loop">
							<li class="list-group-item">${calcBoss.bossGrade}</li>	
						</c:forEach>
					</td>	
				</tr>
				<tr>
					<th colspan="2">파티장</th>
				</tr>
				<tr>
					<td colspan="2">
						<li class="list-group-item"> ${partyLeader}</li>
					</td>
				</tr>
				<tr>
					<th colspan="2">파티원</th>
				</tr>
				<tr>
					<td colspan="2">
						<c:forEach items="${calcMember}" var="calcMember" varStatus="loop">
						 	<li class="list-group-item"> ${calcMember.charaterName} </li> 
						</c:forEach>
					</td>
				</tr>
				<tr>
					<th>아이템</th>
					<th>가격</th>
				</tr>
				<tr>
					<td colspan="2">
						<li class="list-group-item btn" data-bs-toggle="modal" data-bs-target="#staticBackdrop">+</li>
					</td>
				</tr>
			</ul>
		</table>
	</div>
	<!-- Modal -->
	<div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="staticBackdropLabel">아이템 검색</h5>
	        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	      </div>
	      <div class="modal-body">
	      
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
	        <button type="button" class="btn btn-primary">INSERT</button>
	      </div>
	    </div>
	  </div>
	</div>
	<c:import url="${pageContext.request.contextPath}/main/bottom"></c:import>
</body>
</html>