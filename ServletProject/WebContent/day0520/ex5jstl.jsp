<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
</head>
<body>
<h2>formatNumber와 formatDate공부</h2>
<c:set  var="day" value="<%=new Date() %>"/>
<c:set  var="num1" value="7894560"/>
<c:set  var="num2" value="12.34567"/>

<h4>날짜와 숫자 그대로 출력해보기</h4>
day : ${day }<br>
num1 : ${num1 }<br>
num2 : ${num2 }<br>
<hr>
type 을 currency : <fmt:formatNumber type="currency" value="${num1 }"/><br>
type 을 number : <fmt:formatNumber type="number" value="${num1 }"/><br>
type 을 percent : <fmt:formatNumber type="percent" value="${num2 }"/><br>
pattern으로 :  <fmt:formatNumber value="${num2 }" pattern="0.00"/><br>
pattern으로 :  <fmt:formatNumber value="${num2 }" pattern="#,##0"/><br>

<h3>날짜 출력</h3>
<fmt:formatDate value="${day }" pattern="yyyy-MM-dd HH:mm"/><br>
<fmt:formatDate value="${day }" pattern="yyyy-MM-dd a HH:mm"/><br>
<fmt:formatDate value="${day }" pattern="yyyy-MM-dd HH:mm EEE"/><br>
<fmt:formatDate value="${day }" pattern="yyyy-MM-dd HH:mm EEEE"/><br>
</body>
</html>