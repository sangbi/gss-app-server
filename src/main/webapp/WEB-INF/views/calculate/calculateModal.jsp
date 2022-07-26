<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.gss.web.api.controller.CalculateApi" %>
<%
	CalculateApi calculapi = new CalculateApi();
%>

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
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<title>GSS</title>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/assets/js/itemAdd.js"></script>
</head>
<body>
		
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
	
</body>
</html>