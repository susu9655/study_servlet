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
<style type="text/css">
	div.box{
		width: 40px;height: 40px; border: 1px solid black;margin-right: 10px;float: left;
	}
</style>
</head>
<body>
<h2>반복문 연습</h2>
<c:forEach var="n" begin="1" end="10" step="1">
	<b>[${n }]&nbsp;</b>
</c:forEach>
<br><br>
<c:forEach var="n" begin="1" end="10" step="2">
	<b>[${n }]&nbsp;</b>
</c:forEach>
<br><br>
<%
	String []colors={"red","green","blue","pink","yellow","orange"};
%>
<!-- 자바영역의 변수를 jstl변수로 전환하려면 -->
<c:set var="mycolors" value="<%=colors %>"/>
<c:forEach var="a" items="${mycolors }">
	<div class="box" style="background-color: ${a};"></div>
</c:forEach>
<br><br>
<table class="table table-bordered" style="width: 200px;">
	<tr>
		<th>index</th><th>count</th><th>value</th>
	</tr>
	<c:forEach var="a" items="${mycolors}" varStatus="n">
		<tr>
			<td align="center">${n.index }</td>
			<td align="center">${n.count }</td>
			<td bgcolor="${a }">${a }</td>
		</tr>
	</c:forEach>
</table>
<br><br>
<table class="table table-bordered" style="width: 200px;">
	<tr>
		<th>index</th><th>count</th><th>value</th>
	</tr>
	<c:forEach var="a" begin="2" end="4" items="${mycolors}" varStatus="n">
		<tr>
			<td align="center">${n.index }</td>
			<td align="center">${n.count }</td>
			<td bgcolor="${a }">${a }</td>
		</tr>
	</c:forEach>
</table>






</body>
</html>