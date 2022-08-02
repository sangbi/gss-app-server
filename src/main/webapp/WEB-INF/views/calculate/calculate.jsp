<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/assets/js/itemAdd.js" async></script>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
	<c:import url="${pageContext.request.contextPath}/main/nav"></c:import>
	<div class="div_hr">
		<hr>
		<h4 class="text-muted"> CALCULATE </h4>
		<hr>
	</div>
	<div class="div_calc_mid">
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
								<div class="div_td_img">
									<a data-bs-toggle="modal" data-bs-target="#staticBackdrop4${pgiList.pgiKey}"><img src="${pageContext.request.contextPath}/resources/tagImage/delete.png" width="20px" height="20px"></a>
								</div>
							</li>
						</c:forEach>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<li class="list-group-item list-group-item-action" data-bs-toggle="modal" data-bs-target="#staticBackdrop">
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
							${money}
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
	<div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="staticBackdropLabel">Modal title</h5>
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
					<c:forEach items="${bossItemList}" var="bossItemList" varStatus="loop">
						<tr onclick="addModalItem(this)" data-bs-dismiss="modal">
							<td><img src="${pageContext.request.contextPath}/${bossItemList.itemImagePath}" width="20px" height="20px">${bossItemList.itemName}</td>
							<td>${bossItemList.classification}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
      	  </div>
		  <div class="modal-footer">
		       <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
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
	<!--delete Modal -->
	<c:forEach items="${pgiList}" var="pgiList" varStatus="loop">
		<div class="modal fade" id="staticBackdrop4${pgiList.pgiKey}" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="staticBackdropLabel">확인</h5>
		        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
		      </div>
		      <form action="/calculate/deleteItem?partyName=${partyName}&pgiKey=${pgiList.pgiKey}" method="post">
		      	<br>
		      	<h4>삭제 하시겠습니까?</h4>
		      	<div class="modal-body">
			      	<input type="submit" class="btn btn-secondary" value="확인">
		       	 	<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
		      	</div>
		      </form>
		    </div>
		  </div>
		</div>
	</c:forEach>
	<c:import url="${pageContext.request.contextPath}/main/bottom"></c:import>
</body>
</html>
