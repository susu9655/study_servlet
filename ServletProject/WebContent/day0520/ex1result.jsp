<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
</head>
<body>
 <%--자바코드로 request의 데이터를 얻어서 출력해보자 --%>
<%--<%
	String name=(String)request.getAttribute("name");
	String addr=(String)request.getAttribute("addr");
	String hp=(String)request.getAttribute("hp");
%>
<pre>
<h2>서블릿으로부터 전달받은 데이터</h2>
이름:<%= name %>
주소:<%= addr %>
핸드폰:<%= hp %>
</pre> --%>
<h1>JSTL을 이용한 request값 출력</h1>
이름 : ${name}<br><!-- ${변수}:request에 저장한 데이터를 가져온다 -->
주소 : ${addr}<br>
핸드폰 : ${hp}<br>
</body>
</html>