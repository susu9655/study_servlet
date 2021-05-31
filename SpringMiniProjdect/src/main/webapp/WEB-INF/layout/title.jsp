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
<style type="text/css">
	b.status{
		color: red;
		margin-left: 20px;
		font-size: 14pt;
		
	}
</style>
</head>
<body>
<c:set var="root" value="<%=request.getContextPath() %>"/>
<a href="${root }/home"><img alt="" src="${root }/image/조냥이.jpg" style="width: 30px;">Spring5+Mybatis3+Tiles3 Project</a>
<span style="margin-left: 20px;">
	<c:if test="${sessionScope.loginok==null }">
		<button type="button" class="btn btn-success" onclick="location.href='${root}/login'">로그인</button>
	</c:if>
	<c:if test="${sessionScope.loginok!=null }">
		<b class="status">${sessionScope.myid }님</b>
		<button type="button" class="btn btn-danger" onclick="location.href='${root}/logout'">Logout</button>
	</c:if>
</span>
</body>
</html>