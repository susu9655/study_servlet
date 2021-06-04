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
<form action="insert" method="post" enctype="multipart/form-data">
	<table class="table table-bordered" style="width: 800px;">
		<caption><b>카페 메뉴 등록</b></caption>
		<tr>
			<th bgcolor="#F2B705">음료명</th>
			<td>
				<input type="text"  name="drink" class="form-control">
			</td>
		</tr>
		<tr>
			<th bgcolor="#F2B705">가격</th>
			<td>
				<input type="text" class="form-control" name="price">
			</td>
		</tr>
		<tr>
			<th bgcolor="#F2B705">이미지</th>
			<td>
				<input type="file"  class="form-control" name="upload">
			</td>
		</tr>
		<tr>
			<th bgcolor="#F2B705">설명</th>
			<td>
				<input type="text" class="form-control" name="description">
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<button type="submit" class="btn btn-info">저장</button>
				<button type="button" class="btn btn-success" onclick="location.href='list'">목록</button>
			</td>
		</tr>
	</table>
</form>
</body>
</html>