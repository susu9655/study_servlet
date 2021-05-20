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
<c:set var="name" value="강호동"/>
<c:set var="age" value="15"/>
<c:if test="${age>=20 }">
	<h2 style="color: blue;">${name }님은 ${age }세 이므로 성인입니다</h2>
</c:if>
<c:if test="${age<20 }">
	<h2 style="color: red;">${name }님은 ${age }세 이므로 미성년자입니다</h2>
</c:if>

</body>
</html>