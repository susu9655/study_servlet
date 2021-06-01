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
<c:if test="${sessionScope.loginok==null }">
	<c:redirect url="../login"/>
</c:if>
<form action="insert" method="post" enctype="multipart/form-data">
<!-- hidden -->
<input type="hidden" name="num" value="${num }">
<input type="hidden" name="pageNum" value="${pageNum }">
<input type="hidden" name="reg" value="${reg }">
<input type="hidden" name="restep" value="${restep }">
<input type="hidden" name="relevel" value="${relevel }">
<input type="hidden" name="id" value="${sessionScope.myid }">
<input type="hidden" name="writer" value="${name }">
	<table class="table table-bordered" style="width: 500px;">
		<caption><b>
		<c:if test="${num==0 }">새글쓰기</c:if>
		<c:if test="${num!=0 }">답글쓰기</c:if>
		</b></caption>
		<tr>
			<th bgcolor="#ddd" width="200">이름(아이디)</th>
			<td><b>${name }(${sessionScope.myid })</b></td>
		</tr>
		<tr>
			<th bgcolor="#ddd" width="120">제목</th>
			<td>
				<input type="text" name="subject" value="${subject }" class="form-control" required>
			</td>
		</tr>
		<tr>
			<th bgcolor="#ddd" width="120">사진</th>
			<td>
				<input type="file" name="photo" class="form-control" multiple>
			</td>
		</tr>
			<tr>
			<th bgcolor="#ddd" width="120">내용</th>
			<td>
				<textarea rows="" cols="" name="content" class="form-control" required style="width: 350px;height: 100px;"></textarea>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<button type="submit" class="btn btn-default" style="width: 120px;">글작성</button>
				<button type="submit" class="btn btn-default" style="width: 120px;" onclick="history.back()">이전</button>
			</td>
		</tr>
	</table>
</form>
</body>
</html>