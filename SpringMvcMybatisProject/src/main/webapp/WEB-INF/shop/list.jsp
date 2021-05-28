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
<div class="alert alert-info">
	<b>총 ${totalCount }개의 상품이 등록되었습니다</b>
	
	<button type="button" class="btn btn-danger" style="width: 100px;margin-left: 20px;" onclick="location.href='addform'">상품추가</button>
</div>
<br>
<table style="width: 700px;border: 3px solid gray;" class="table table-bordered">
	<caption><b>상품목록</b></caption>
	<tr bgcolor="orange">
		<th width="100">번호</th>
		<th width="300">상품명</th>
		<th width="120">가격</th>
		<th width="150">입고일</th>
	</tr>
	<c:forEach var="dto" items="${list }" varStatus="n">
		<tr align="center">
			<td>${n.count }</td>
			<td align="left">
				<a href="content?num=${dto.num }" style="color: black;">${dto.sangpum }&nbsp;
					<c:if test="${dto.photo!='no' }">
						<span class="glyphicon glyphicon-picture"></span>
					</c:if>
				</a>
			</td>
			<td align="right">
				<fmt:formatNumber type="currency" value="${dto.price }"/>
			</td>
			<td>${dto.ipgoday }</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>