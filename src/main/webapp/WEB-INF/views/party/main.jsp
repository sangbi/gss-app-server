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
party_____________________________
<br>

<input type="button" value="파티생성"
onClick="location.href='<c:url value="createparty" />'">
<br>
<table border="1" >
<input type="button" value="내가만든파티정보"
onClick="location.href='<c:url value="imakeparty" />'">
<tr>
<td colspan="2">파티리스트</td>
</tr>
<tr><td>파티이름</td><td> 보스이름 및 난이도 </td>
</tr>
<%-- <c:forEach var="ho" items="${booklist}"> --%> 
<tr>
<td><a href="/web/readbook?booknum=${ho.booknum}"> ${ho.bookname}</a>파티데이터넣기</td>
<td>보스,난이도데이터?불러오는곳</td></tr>
 
</table>

<table border="1" >
<input type="button" value="내가참여한파티보기"
onClick="location.href='<c:url value="ienterparty" />'">
<tr>
<td colspan="2">파티리스트</td>
</tr>
<tr><td>파티이름</td><td> 보스이름 및 난이도 </td>
</tr>
<tr><td>데이터</td><td>자쿰 난이도테이블없음</td>
</table>










</body>
</html>