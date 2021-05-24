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
<h3>데이타 수정하기</h3>
<form action="update.do" method="post">
	<input type="hidden" name="num" value="${dto.num }">
	<table  class="table table-bordered" style="width: 600px;">
		<tr>
			<th width="70" bgcolor="#ddd">이름</th>
			<td width="100">
				<input type="text" class="form-control input-sm" name="name" style="width: 70px;" value="${dto.name }">
			</td>
		</tr>
		<tr>
			<th width="70" bgcolor="#ddd">나이</th>
			<td width="100">
				<input type="text" class="form-control input-sm" name="age" style="width: 70px;" value="${dto.age }">
			</td>
		</tr>
		<tr>
			<th width="70" bgcolor="#ddd">키</th>
			<td width="100">
				<input type="text" class="form-control input-sm" name="height" style="width: 100px;" value="${dto.height }">
			</td>
		</tr>
		<tr>
			<th width="70" bgcolor="#ddd">생년월일</th>
			<td width="100">
				<input type="date" class="form-control input-sm" name="birth" value="${dto.birth }">
			</td>
		</tr>
		<tr>
			<td colspan="4" align="center">
				<button type="submit" class="btn btn-info" style="width: 100px;">DB저장</button>			
				<button type="button" class="btn btn-info" style="width: 100px;" onclick="location.href='list.do'">목록가기</button>
			</td>
		</tr>
	</table>
</form>
</body>
</html>