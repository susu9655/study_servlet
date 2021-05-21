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
<h2>JSTL의 기본 연산자 공부</h2>
<h3>JSTL변수 선언</h3>
<c:set var="su1" value="7"/>
<c:set var="su2" value="4"/>
su1 : ${su1},su2 : ${su2}
<table class="table table-hover" style="width: 400px;">
	<tr bgcolor="#ccc">
		<th style="width: 300px;">수식</th>
		<th>결과값</th>
	</tr>
	<tr>
		<td>\${su1+su2}</td>
		<td align="center">${su1+su2}</td>
	</tr>
	<tr>
		<td>\${su1-su2}</td>
		<td align="center">${su1-su2}</td>
	</tr>
	<tr>
		<td>\${su1*su2}</td>
		<td align="center">${su1*su2}</td>
	</tr>
	<tr>
		<td></td>
		<td align="center"></td>
	</tr>
	<tr>
		<td>\${su1/su2}</td>
		<td align="center">${su1/su2}</td>
	</tr>
	<tr>
		<td>\${su1%su2}</td>
		<td align="center">${su1%su2}</td>
	</tr>
	<tr>
		<td>\${su1 div su2}</td>
		<td align="center">${su1 div su2}</td>
	</tr>
	<tr>
		<td>\${su1 mod su2}</td>
		<td align="center">${su1 mod su2}</td>
	</tr>
	<tr>
		<td>\${su1==su2}</td>
		<td align="center">${su1==su2}</td>
	</tr>
	<tr>
		<td></td>
		<td align="center"></td>
	</tr>
	<tr>
		<td></td>
		<td align="center"></td>
	</tr>
</table>
</body>
</html>