<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<body>
	<c:import url="${pageContext.request.contextPath}/main/nav"></c:import>
	<div class="div_main_mid">	
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
	</div>
	<c:import url="${pageContext.request.contextPath}/main/bottom"></c:import>
</body>
</html>