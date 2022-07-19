<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<!DOCTYPE html>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
party ________________
<br>
<form action="insert" method="post">
	<table border="1" >
    	<caption><strong>파티생성해보자 </strong></caption> 
    	<tr><td>파티이름</td><td><input type="text"name="partyname"></td>
    	<tr>
    		<td>Boss select</td>
    		<td><select name='bossname'>
    		<option value="bossa">자쿰</option>
    		<option value="bossb">상빈</option></select></td>
    	</tr>
		<tr>
   			<td>난이도선택</td>
    		<td><select name='level'>
    		<option value="easy">쉬움</option>
    		<option value="nomal">보통</option>
    		<option value="hard">어려움</option></select></td>
    	</tr>
    	<tr>
    		<td>생성자 이메일</td>
    		<td><input type="text"name="email" value="dua@itbank.com"></td>
    	</tr>
		<tr>
			<td>캐릭터이름</td>
			<td><input type="text"name="character" value="기사"></td>
		</tr>
	</table>
	<input type="submit" value="파티생성">
	</form>
    <input type="button" value="목록으로 돌아가기" onClick="location.href='<c:url value="main" />'">
</body>
</html>