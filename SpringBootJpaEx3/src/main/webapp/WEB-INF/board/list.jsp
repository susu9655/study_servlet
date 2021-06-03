
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100&display=swap" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
<style type="text/css">
	body *{
		font-family: 'Noto Sans KR', sans-serif;
		font-size: 1.1em;
	}
	.box{
		width: 40px;
		height: 40px;
		border: 1px solid black;
	}
</style>
</head>
<body>
<h2 class="alert alert-info">${mes}</h2>
<button type="button" class="btn btn-info"
	style="width: 120px;"
	onclick="location.href='carform'">추가</button>
<hr>
<!-- 테이블로 출력하는데 번호,자동차명,단가,색상,구입일,등록일 -->
<table class="table table-bordered" style="width: 800px;">
	<caption>자동차 목록</caption>
	<tr bgcolor="#ddd">
		<th width="60">번호</th>
		<th width="130">자동차명</th>
		<th width="130">단가</th>
		<th width="80">색상</th>
		<th width="120">구입일</th>
		<th width="150">등록일</th>
		<th>관리</th>		
	</tr>
	<c:forEach var="dto" items="${list}" varStatus="n">
		<tr align="center">
			<td>${n.count}</td>
			<td align="left">${dto.carname}</td>
			<td align="right">
				<fmt:formatNumber value="${dto.carprice}"
				type="currency"/>
			</td>
			<td>
				<div style="background-color: ${dto.carcolor}"
				class="box"></div>
				<b>${dto.carcolor}</b>
			</td>
			<td>${dto.carguip}</td>
			<td>
				<fmt:formatDate value="${dto.writeday}"
				pattern="yyyy-MM-dd HH:mm"/>
			</td>
			<td>
				<button type="button" class="btn btn-success btn-xs"
				onclick="location.href='updateform?num=${dto.num}'">수정</button>
				
				<button type="button" class="btn btn-success btn-xs"
				onclick="location.href='delete?num=${dto.num}'">삭제</button>
			</td>
		</tr>
	</c:forEach>
</table>	
</body>
</html>
