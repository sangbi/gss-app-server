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
<form>
 <table border="1" >
    <caption><strong>내가 소속된 파티정보 </strong></caption>
   
    <tr>
        <td><strong>파티이름</strong></td>
        <td>${bookvo.booknum }</td>
    </tr>
   
    <tr>
       <td><strong>보스이름</strong></td>
       <td>${bookvo.bookname}</td>
       <td>난이도</td><td>(난이도데이터)</td>
    </tr>
    <tr>
       <td><strong>파티장</strong></td>
        <td>${bookvo.writer}(파티장아이디)</td>
       <td><strong>캐릭터네임</strong></td>
        <td>${bookvo.publisher}(캐릭터이름데이터)</td>
    </tr>
</table>
</form>
<input type="button" value="목록"
onClick="location.href='<c:url value="main" />'">
</body>
</html>