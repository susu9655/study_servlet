<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
</head>
<body>
<button type="button" class="btn btn-success"
	onclick="location.href='form.do'">추가하기</button>
<h3>Test 테이블 데이타 출력</h3>
<table class="table table-bordered" style="width:700px;">
	<tr bgcolor="#ccc">
		<th width="50">번호</th>
		<th width="70">이름</th>
		<th width="60">나이</th>
		<th width="60">키</th>
		<th width="100">생년월일</th>
		<th width="120">작성일</th>
		<th width="100">수정/삭제</th>	
	</tr>
	<c:forEach var="a" items="${list}" varStatus="n">
		<tr align="center">
			<td>${n.count}</td>
			<td>${a.name}</td>
			<td>${a.age}세</td>
			<td>${a.height}Cm</td>
			<td>${a.birth}</td>
			<td>
				<fmt:formatDate value="${a.writeday}"
					pattern="yyyy-MM-dd HH:mm"/>
			</td>
			<td>
				<button type="button" class="btn btn-xs btn-info"
				onclick="location.href='updateform.do?num=${a.num}'">수정</button>
				
				<button type="button" class="btn btn-xs btn-danger"
				onclick="location.href='delete.do?num=${a.num}'">삭제</button>
				
			</td>
		</tr>
	</c:forEach>
</table>
</body>

</html>