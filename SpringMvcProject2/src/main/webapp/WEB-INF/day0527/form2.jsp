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
<form action="read2" method="post" class="form-inline">
	<table class="table table-bordered" style="width: 300px;">
		<caption><b>dto로 읽기</b></caption>
		<tr>
			<th bgcolor="orange" width="100">상품명</th>
			<td>
				<input type="text" name="sang" class="form-control">
			</td>
		</tr>
		<tr>
			<th bgcolor="orange" width="100">색상</th>
			<td>
				<div class="form-group">
					<input type="radio" name="color" class="form-control" value="orange" checked>오렌지
					<input type="radio" name="color" class="form-control" value="pink" checked>핑크
					<input type="radio" name="color" class="form-control" value="green" checked>초록색
				</div>
			</td>
		</tr>
		<tr>
			<th bgcolor="orange" width="100">가격</th>
			<td>
				<input type="text" name="price" class="form-control">
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<button type="submit" class="btn btn-info">데이타 전송</button>
			</td>
		</tr>
	</table>
</form>
</body>
</html>