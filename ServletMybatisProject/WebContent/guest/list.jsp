<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
<style type="text/css">
	span.mod a{
		color: blue;
		text-decoration: none;
		font-size: 10pt;
	}
	span.mod a:hover{
		color: red;	
	}
	span.del a{
		color: blue;
		text-decoration: none;
		font-size: 10pt;
	}
	span.del a:hover{
		color: red;
	}
</style>
</head>
<body>

<button type="button" class="btn btn-info" onclick="location.href='writeform'" style="margin-left: 300px;margin-bottom: 20px;">방명록 글쓰기</button>
<div class="alert alert-danger" style="width: 400px;">
	<b style="font-size: 14pt;">
		총 ${totalCount }개의 글이 있습니다.
	</b>
</div><br>
<hr align="left" width="400">
<c:forEach var="dto" items="${list }">
	<table class="table table-bordered" style="width: 400px;">
		<tr>
			<td>
				<b>No ${no }</b>
				<c:set var="no" value="${no-1 }"/>
				<span style="margin-left: 20px;">닉네임 : ${dto.nickname }</span>
				<!-- 수정,삭제 -->
				<span style="margin-left: 10px;" class="mod">
					<a href="updatepassform?num=${dto.num }&pageNum=${currentPage}">수정</a>
				</span>
				<span style="margin-left: 10px;" class="del">
					<a href="updatepassform?num=${dto.num }&pageNum=${currentPage}">삭제</a>
				</span>
				
				<span style="float: right;color: gray;font-size: 0.8em;">
					<fmt:formatDate value="${dto.writeday }" pattern="yyyy-MM-dd HH:mm"/>
				</span>
			</td>
		</tr>
		<tr>
			<td>
				<img alt="" src="../avata/${dto.avata }.png" width="50" align="left">
				<pre style="border: none;">${dto.content }</pre>
			</td>
		</tr>
	</table>
	<br>
</c:forEach>
<!-- 페이지번호 출력 -->
<div style="width: 400px;text-align: center;">
	<ul class="pagination">
	<!-- 이전 -->
		<c:if test="${startPage>1 }">
			<li><a href="list?pageNum=${startPage-1}">이전</a></li>
		</c:if>
		<c:forEach var="pp" begin="${startPage }" end="${endPage }">
			<c:if test="${currentPage==pp }">
				<li class="active">
					<a href="list?pageNum=${pp }">${pp }</a>
				</li>
			</c:if>
			<c:if test="${currentPage!=pp }">
				<li>
					<a href="list?pageNum=${pp }">${pp }</a>
				</li>
			</c:if>
		</c:forEach>
		<!-- 다음 -->
		<c:if test="${endPage<totalPage }">
			<li><a href="list?pageNum=${endPage+1 }">다음</a></li>
		</c:if>
	</ul>
</div>
</body>
</html>