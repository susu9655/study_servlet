<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
<style type="text/css">
	.imgsel{
		border: 2px solid red;
		padding: 3px 3px;
	}
</style>
<script type="text/javascript">
	$(function(){
		//아바타 초기값 지정
		$("img.avata").eq(0).addClass("imgsel");
		$("img.avata").click(function(){
			$(this).siblings().removeClass("imgsel");
			$(this).addClass("imgsel");
			$("#avata").val($(this).attr("aname"));
		});
	});
</script>
</head>
<body>
<form action="insert" method="post">
	<table class="table talbe-bordered" style="width: 500px;">
		<caption><b>방명록 글쓰기</b></caption>
		<tr>
			<th width="100" bgcolor="pink">닉네임</th>
			<td width="130">
				<input type="text" name="nickname" style="width: 120px;" class="form-control" placeholder="닉네임" required>
			</td>
			<th width="100" bgcolor="pink">비밀번호</th>
			<td width="130">
				<input type="password" name="pass" style="width: 120px;" class="form-control" placeholder="비밀번호" required>
			</td>
		</tr>
		<tr>
			<th width="100" bgcolor="pink">아바타</th>
			<td colspan="3">
				<c:forEach var="a" begin="1" end="5">
					<c:set var="aname" value="0${a }"/>
					<c:set var="imgname" value="../avata/${aname }.png"/>
					<img src="${imgname }" width="50" class="avata" aname="${aname }">&nbsp;				
				</c:forEach>
				
				<input type="hidden" name="avata" id="avata" value="01">
			</td>
		</tr>
		<tr>
			<td colspan="4">
				<textarea name="content" style="width: 480px;height: 100px;" class="form-control" required></textarea>
			</td>
		</tr>
		<tr>
			<td colspan="4" align="center">
				<button type="submit" class="btn btn-info" style="width: 120px;">저장하기</button>
				<button type="button" class="btn btn-success" style="width: 120px;" onclick="location.href='list'">목록</button>
			</td>
		</tr>
	</table>
</form>
</body>
</html>