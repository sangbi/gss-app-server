<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/assets/js/itemAdd.js" async></script>
<meta name="viewport" content="width=device-width, initial-scale=1" charset="UTF-8">
<title>아이템 추가페이지</title>
</head>
<body>
<form:form modelAttribute="ItemDto" method="POST" enctype="multipart/form-data" onsubmit="return check()">
		<table 
		width="50%" 
		height=200
		border="1">
		<tr>
		<td rowspan="4"><div class="select_img"><img style=width:150px; id="preview-image"/></div></td>
		
		<tr>
			<th>아이템이름</th>
			<td><input type="text" name="itemName"></td>
		</tr>
		<tr>
			<th>분류</th>
			<td><select name="classification">
					<option value="">분류 선택</option>
					<option value="장비">장비</option>
					<option value="소비">소비</option>
					<option value="기타">기타</option>
				</select>
			</td>
		</tr>
		<tr>
			<th>아이템 이미지</th>
			<td><input type="file" name="itemImagepath" id="input-image"class="hidden"value=""></td>
		</tr>
		</table>
		<input type="submit" value="등록">
</form:form>
</body>
</html>