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
<form action="update" method="post">
	<input type="hidden" name="num" value="${dto.num }">
	<table class="table table-bordered" style="width: 400px;">
		<caption><b>차 정보 수정</b></caption>
		<tr>
			<th width="130" bgcolor="#ddd">자동차명</th>
			<td>
				<input type="text" name="carname" class="form-control" placeholder="자동차명" value="${dto.carname }">
			</td>
		</tr>
		<tr>
			<th width="130" bgcolor="#ddd">단가</th>
			<td>
				<input type="text" name="carprice" class="form-control" placeholder="단가" value="${dto.carprice }">
			</td>
		</tr>
		<tr>
			<th width="130" bgcolor="#ddd">자동차색</th>
			<td>
				<input type="color" name="carcolor" class="form-control" value="${dto.carcolor }">
			</td>
		</tr>
		<tr>
			<th width="130" bgcolor="#ddd">구입일</th>
			<td>
				<input type="date" name="carguip" class="form-control" value="${carguip }">
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<button type="submit" class="btn btn-info" style="width: 120px;">jpa수정</button>
				<button type="button" class="btn btn-info" style="width: 120px;" onclick="location.href='list'">목록</button>
			</td>
		</tr>
	</table>
</form>
</body>
</html>