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
	.photo{
		float: left;
		margin-right: 10px;
	}
	.photo img{
		width: 200px;
		height: 200px;
		border: 1px solid gray;
	}
</style>
</head>
<body>
<h2>이미지 업로드한 결과</h2>
<h3>작성자 : ${name }</h3>
<h3>업로드된 파일명 : ${photo }</h3>
<c:forEach var="im" items="${files }">
	<figure class="photo">
		<img alt="" src="image/${im }">
		<figcaption>${im }</figcaption>
	</figure>
</c:forEach>
</body>
</html>