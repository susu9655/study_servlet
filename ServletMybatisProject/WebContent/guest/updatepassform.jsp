<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
</head>
<body>
<form action="updateform" method="post" class="form-inline">
	<!-- hidden -->
	<input type="hidden" name="num" value="${num}">
	<input type="hidden" name="pageNum" value="${pageNum}">	

	<h3>수정시 필요한 비밀번호를 입력해주세요</h3>
	<b>비밀번호 : </b>
	<input type="password" class="form-control" style="width: 120px;"
	required="required" name="pass">
	<button type="submit" class="btn btn-danger">비밀번호 확인</button>
	<br><br>
	<button type="button" class="btn btn-info"
		style="margin-left: 100px;"
		 onclick="history.back()">이전 페이지로 가기</button>
</form>

</body>
</html>