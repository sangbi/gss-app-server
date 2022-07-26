<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<title>GSS</title>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/assets/js/itemAdd.js"></script>
</head>
<body>
	<c:import url="${pageContext.request.contextPath}/main/nav"></c:import>
	<div class="div_main_mid">
		<form onsubmit="return priceList('${partyName}')" method="post">
		<table class="table" id="modalItem" style="table-layout: fixed">
			<ul class="list-group list-group-flush">
				<thead class="table-dark">
				<tr>
					<th>파티이름</th><th>인원</th>
				</tr>
				</thead>
				<tr>
					<td>
						<li class="list-group-item">${partyName}</li>
					</td>
					<td> 
						<li class="list-group-item">${count} 명</li>
					</td>
				</tr>
				<thead class="table-dark">
				<tr>
					<th>보스</th><th>난이도</th>
				</tr>
				</thead>
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
				<thead class="table-dark">
				<tr>
					<th>파티장</th><th>분배율</th>
				</tr>
				</thead>
				<tr>
					<td>
						<li class="list-group-item"> ${partyLeader.charaterName}</li>
					</td>
					<td>
						 <li class="list-group-item"> ${partyLeader.divisionPercent}%</li>						 	
					</td>
				</tr>
				<thead class="table-dark">
				<tr>
					<th>파티원</th><th>분배율</th>
				</tr>
				</thead>
				<tr>
					<td>
						<c:forEach items="${calcMember}" var="calcMember" varStatus="loop">
						 	<li class="list-group-item"> ${calcMember.charaterName}</li> 
						</c:forEach>
					</td>
					<td>
						<c:forEach items="${calcMember}" var="calcMember" varStatus="loop">
						 	<li class="list-group-item"> ${calcMember.divisionPercent}%</li>						 	
						</c:forEach>
					</td>
				</tr>
				<thead class="table-dark">
				<tr>
					<th>아이템</th>
					<th>가격</th>
				</tr>
				</thead>
				<tr>
					<td>
						<c:forEach items="${pgiList}" var="pgiList" varStatus="loop">
							<li class="list-group-item list-group-item-action">
								${pgiList.itemName}
							</li>
						</c:forEach>
					</td>
					<td>
						<c:forEach items="${pgiList}" var="pgiList" varStatus="loop">
							<li class="list-group-item list-group-item-action">
								${pgiList.itemSalePrice}
							</li>
						</c:forEach>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<li class="list-group-item list-group-item-action" data-bs-toggle="modal" data-bs-target="#exampleModalToggle">
							<img src="${pageContext.request.contextPath}/resources/tagImage/plus.png" width="20px" height="20px">
						</li>
					</td>
				</tr>
				<tr>
					<td>
						<li class="list-group-item list-group-item-action">
							총 합 (수수로 5% 적용) : 
						</li>
					</td>
					<td>
						<li class="list-group-item list-group-item-action">
							${price}
						</li>
					</td>
				</tr>
			</ul>
		</table>
		<input type="button" class="btn btn-dark" data-bs-toggle="modal" data-bs-target="#staticBackdrop2" value="비율 설정">
		<input type="submit" class="btn btn-dark" value="저장">
		<input type="button" class="btn btn-dark" data-bs-toggle="modal" data-bs-target="#staticBackdrop3" value="정산 하기">
		</form>
	</div>
	<!-- Modal -->
	<div class="modal fade" id="exampleModalToggle" aria-hidden="true" aria-labelledby="exampleModalToggleLabel" tabindex="-1">
	  <div class="modal-dialog modal-dialog-centered">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalToggleLabel">Modal 1</h5>
	        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	      </div>
	      <div class="modal-body">
	       	<input type="text" class="form-control itemName" placeholder="검색" aria-label="Recipient's username" aria-describedby="button-addon2">
	       	<input type="submit" class="btn btn-outline-secondary" data-bs-target="#exampleModalToggle2" data-bs-toggle="modal" id="button-addon2">
		       	<table class="table table-hover" style="table-layout: fixed">
					<thead class="table-light">
						<tr>
							<th>아이템 이름</th>
							<th>분류</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${itemList}" var="itemList" varStatus="loop">
							<tr onclick="addModalItem(this)" data-bs-dismiss="modal">
								<td><img src="${pageContext.request.contextPath}/${itemList.itemImagepath}" width="20px" height="20px">${itemList.itemName}</td>
								<td>${itemList.classification}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
	      	</div>
	    </div>
	  </div>
	</div>
	<div class="modal fade" id="exampleModalToggle2" aria-hidden="true" aria-labelledby="exampleModalToggleLabel2" tabindex="-1">
	  <div class="modal-dialog modal-dialog-centered">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalToggleLabel2">Modal 2</h5>
	        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	      </div>
	      <div class="modal-body">
	      	<table class="table table-hover" style="table-layout: fixed">
					<thead class="table-light">
						<tr>
							<th>아이템 이름</th>
							<th>분류</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${itemList}" var="itemList" varStatus="loop">
							<tr onclick="addModalItem(this)" data-bs-dismiss="modal">
								<td><img src="${pageContext.request.contextPath}/${itemList.itemImagepath}" width="20px" height="20px">${itemList.itemName}</td>
								<td>${itemList.classification}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
	      </div>
	      <div class="modal-footer">
	        <button class="btn btn-primary" data-bs-target="#exampleModalToggle" data-bs-toggle="modal">Back to first</button>
	      </div>
	    </div>
	  </div>
	</div>
	
	<!--Percent Modal -->
	<div class="modal fade" id="staticBackdrop2" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="staticBackdropLabel">비율 설정</h5>
	        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	      </div>
	      <form action="/calculate/ratioSetting?partyName=${partyName}" method="post">
	      	<div class="modal-body">
		      	<table class="table table-hover" style="table-layout: fixed">
		      		<thead class="table-light">
			      		<tr>
			      			<th>캐릭터 이름</th>
			      			<th>비율</th>
			      		</tr>
		      		</thead>
		      		<tbody>
			      		<c:forEach items="${allMember}" var="allMember" varStatus="loop">
				      		<tr>
				      			<td><input type="text" name="memberList" value="${allMember.charaterName}" readonly></td>
				      			<td><input type="number" name="ratio" min='0' max='100'></td>
				      		</tr>
			      		</c:forEach>
			      			
		      		</tbody>
		      	</table>
		      	<div id="errorMessage"></div>
	      	</div>
	      	<div class="modal-footer">
	     		<input type="button" class="btn btn-primary" value="입력 완료" onclick="checkRatio(this.form)">
	       	 	<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
	     	 </div>
	      </form>
	    </div>
	  </div>
	</div>
	
	<!--ask Modal -->
	<div class="modal fade" id="staticBackdrop3" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="staticBackdropLabel">확인</h5>
	        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	      </div>
	      <form action="/calculate/ratioComplete?partyName=${partyName}&price=${price}" method="post">
	      	<br>
	      	<h4>정산 하시겠습니까?</h4>
	      	<div class="modal-body">
		      	<input type="submit" class="btn btn-secondary" value="확인">
	       	 	<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
	      	</div>
	      </form>
	    </div>
	  </div>
	</div>
	<c:import url="${pageContext.request.contextPath}/main/bottom"></c:import>
</body>
</html>
