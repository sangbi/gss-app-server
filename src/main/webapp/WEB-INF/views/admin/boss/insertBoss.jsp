<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1" charset="UTF-8">
<title>보스 추가페이지</title>
</head>
<body>
<form:form modelAttribute="BossDto" method="POST" enctype="multipart/form-data" onsubmit="return check()">
		<table 
		width="50%" 
		height=200
		border="1">
		<tr>
		<td rowspan="4"><div class="select_img"><img src="" id="image-thumbnail"/></div></td>
		
		<tr>
			<th>보스이름</th>
			<td><input type="text" name="bossName"></td>
		</tr>
		<tr>
			<th>난이도</th>
			<td><input type="text" name="bossGrade"></td>
		</tr>
		<tr>
			<th>보스 이미지</th>
			<td><input type="file" name="bossImagepath" id="file" value=""></td>
		</tr>
		</table>
		<input type="submit" value="등록">
	</form:form>
	<script type="text/javascript">
		function check(){
			var i = document.getElementByid("file").val();
			
			if(i){
				return true;
			}else{
				return false;
				alert("파일을 넣어주세요");
			}
		}
	</script>
</body>
</html>