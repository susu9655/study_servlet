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
<%
	String str="red,green,orange,magenta,purple,gray,black";
%>
<c:set var="str" value="<%=str %>"/>
<h3>문자열을 분리</h3>
<c:forTokens var="a" items="${str }" delims="," varStatus="i">
	<b>${i.count }</b>:
	<span style="color: ${a};font-size:2em;">${a }</span><br>
</c:forTokens>
</body>
</html>