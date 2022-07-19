<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="${pageContext.request.contextPath}/resources/assets/css/bootstrap.css" rel="stylesheet"
		type="text/css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/assets/js/bootstrap.js"></script>
	<script type="text/javascript">
	function getSearchList(){
		$.ajax({
			type: 'GET',
			url : "/getSearchList",
			data : $("form[name=search-form]").serialize(),
			success : function(result){
				//테이블 초기화
				$('#boardtable > tbody').empty();
				if(result.length>=1){
					result.forEach(function(item){
						str='<tr>'
						str += "<td>"+item.idx+"</td>";
						str+="<td>"+item.writer+"</td>";
						str+="<td><a href = '/board/detail?idx=" + item.idx + "'>" + item.title + "</a></td>";
						str+="<td>"+item.date+"</td>";
						str+="<td>"+item.hit+"</td>";
						str+="</tr>"
						$('#boardtable').append(str);
	        		})				 
				}
			}
		})
	}
	</script>
	<title>아이템</title>
	<style>
      table {
        width: 100%;
        border-top: 1px solid #444444;
        border-collapse: collapse;
			}
      th, td {
        border-bottom: 1px solid #444444;
        padding: 10px;
        text-align: center;
			}
      th {
   		background-color: #bbdefb;
			}
	  td {
    	background-color: #e3f2fd;
			}
    </style>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light navbar-dark bg-dark">
		<a class="navbar-brand" href="#">GSS</a>
		<button class="navbar-toggler" type="button"
				data-toggle="collapse"
				data-target="#navbarTogglerDemo02"
				aria-controls="navbarTogglerDemo02"
				aria-expanded="false"
				aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarTogglerDemo02">
			<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
				<li class="nav-item active">
					<a class="nav-link" href="/main/home">Home<span class="sr-only">(current)</span></a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="#">내정보</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="#">보스</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="/main/nav/item">아이템</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="#">파티</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="#">정산</a>
				</li>
			</ul>
			<form class="form-inline my-2 my-lg-0">
				<button class="mr-sm-2 btn btn-outline-success my-2 my-sm-0" 
						type="submit" 
						onclick="loction.href='#'">Sign Up
				</button>
				<button class="mr-sm-2 btn btn-outline-success my-2 my-sm-0"
						type="submit"
						onclick="loction.href='/member/login'">Login
				</button>
			</form>
		</div>
	</nav>
	<h1>아이템정보 등록</h1>
	<table border="1"  style= "align: center; margin: 0 auto;">
		<tr>
			<th>아이템 이름</th>
			<th>분류</th>
			<th>아이템 이미지</th>
		</tr>
		<c:forEach var="itemList" items="${itemList}" varStatus="loop">
		<tr>
			<td>${itemList.itemName}</td>
			<td>${itemList.classification}</td>
			<td><img src="resources/file/${itemList.itemImagepath}" width="70" height="150"></td>
		</tr>
		</c:forEach>
	</table>
	<div>
		<form name="search-form" autocomplete="off">
			<select name="type">
				<option selected value="">검색 내용 선택</option>
				<option value="이름">이름</option>
				<option value="분류">분류</option>
			</select>
			<input type="text" name="keyword" value=""></input>
			<input type="button" onclick="getSearchList()" class="btn btn=outline-primart mr -2" value="검색"></input>
		</form>
	</div>
</body>
</html>