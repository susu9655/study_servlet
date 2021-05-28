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
<style type="text/css">
	.photo{
		width: 200px;
		height: 200px;
		border: 3px solid gray;
		float: left;
		margin-right: 10px;
		margin-bottom: 10px;
	}
</style>
</head>
<body>
<table class="table table-bordered" style="width: 600px;border: 2px solid gray;">
	<caption><b>상품 상세 보기</b></caption>
	<tr>
		<td>
			<span style="font-size: 2em;">${dto.sangpum}</span>
			<span style="float: right;color: gray">
				등록일 : 
				<fmt:formatDate value="${dto.writeday }" pattern="yyyy-MM-dd HH:mm"/>
			</span>
			<br>
		</td>
	</tr>
	<tr>
		<td>
			가격 : <fmt:formatNumber type="currency" value="${dto.price }"/><br>
			입고일 : ${dto.ipgoday }<br>
			상품색상:<br>
			<div style="width: 30px;height: 30px;background-color: ${dto.color};border-radius: 100px;"></div><br>
			<c:forTokens var="n" items="${dto.photo }" delims="," varStatus="i">
				<c:if test="${n=='no' }">
					<b>등록하신 사진이 없습니다.</b>
				</c:if>
				<c:if test="${n!='no' }">
					<img alt="" src="photo/${n }" class="photo">
				</c:if>
			</c:forTokens>
			
		</td>
	</tr>
	<tr>
		<td>
			<button type="button" class="btn btn-info btn-sm" style="width: 80px;" onclick="location.href='addform'">상품등록</button>
			<button type="button" class="btn btn-info btn-sm" style="width: 80px;" onclick="location.href='list'">상품목록</button>
			<button type="button" class="btn btn-info btn-sm" style="width: 80px;" onclick="location.href='updateform?num=${dto.num}'">상품수정</button>
			<button type="button" class="btn btn-info btn-sm" style="width: 80px;" onclick="location.href='delete?num=${dto.num}'">상품삭제</button>
		</td>
	</tr>
</table>
</body>
</html>