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
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Gothic+A1:wght@300;400&display=swap" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
<style type="text/css">
	body *{
		font-family: 'Do Hyeon', sans-serif;
		font-size: 1.1em;
	}
	.image{
		width: 60px; height: 60px;
		margin-left: 10px;
	}
	table{
		margin-left: 100px;
	}
</style>
</head>
<body>
<br><br>
<button type="button" class="btn btn-warning" onclick="location.href='writeform'">메뉴 추가</button>
<br><br>
<table class="table table-bordered" style="width: 800px;">
	<caption><b>카페 메뉴</b></caption>
	<tr bgcolor="#F2E205">
		<th width="50">번호</th>
		<th width="120">이름</th>
		<th width="50">가격</th>
		<th width="130">설명</th>
		<th width="80">등록일</th>
		<th width="50">관리</th>
	</tr>
	<c:forEach var="dto" items="${list }" varStatus="n">
		<tr align="center">
			<td style="line-height: 60px;">${n.count }</td>
			<td  style="line-height: 60px;">
				${dto.drink}
				<img alt="" src="../${dto.image }" class="image">
			</td>
			<td align="center" style="line-height: 60px;">${dto.price }</td>
			<td align="center" style="line-height: 60px;">${dto.description }</td>
			<td align="center" style="line-height: 60px;">
				<fmt:formatDate value="${dto.ipgoday }" pattern="yyyy-MM-dd"/>
			</td>
			<td align="center" style="line-height: 60px;">
				<button type="button" class="btn btn-warning btn-xs" onclick="location.href='updateform?num=${dto.num}'">수정</button>
				<button type="button" class="btn btn-warning btn-xs" onclick="location.href='delete?num=${dto.num}'">삭제</button>
			</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>