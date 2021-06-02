<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Nanum+Myeongjo&display=swap" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
<style type="text/css">
	div.layout {
		border: 0px solid gray;
		font-family: 'Nanum Myeongjo';
		}
		div.title {
		font-size: 33pt;
		text-align: center;
		font-weight: bold;
		}
		div.menu {
		font-size: 25pt;
		text-align: center;
		font-weight: bold;
		}
		div.layout a{
		color:black;
		text-decoration: none; 
		}
		div.info{
		position: absolute;
		left: 30px;
		top: 200px;
		width: 200px;
		height: 230px;
		border: 2px solid gray;
		border-radius: 30px;
		text-align: center;
		font-size: 14pt;
		padding: 20px 20px;
		}
		div.main{
		position: absolute;
		left: 500px;
		top: 160px;
		width: 1200px;
		height: 700px;
		font-size: 15pt;
		}
		
</style>
</head>
<body>
<div class="title layout">
	<tiles:insertAttribute name="title"/>
</div>
<div class="menu layout">
	<tiles:insertAttribute name="menu"/>
</div>
<div class="info layout">
	<tiles:insertAttribute name="info"/>
</div>
<div class="main layout">
	<tiles:insertAttribute name="main"/>
</div>
</body>
</html>