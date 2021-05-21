<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
</head>
<body>
<h3>서블릿으로부터 받은 리스트 출력하기</h3>
<table class="table table-bordered" style="width: 400px;">
	<tr bgcolor="orange">
		<th>index</th><th>count</th><th>name</th>
		<th>addr</th><th>hp</th>
	</tr>
	<c:forEach var="dto" items="${list}" varStatus="i">
		<tr>
			<td align="center">${i.index}</td>
			<td align="center">${i.count}</td>
			<td>${dto.name}</td>
			<td>${dto.addr}</td>
			<td>${dto.hp}</td>		
			
		</tr>
	</c:forEach>
</table>
</body>

</html>