<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
<style type="text/css">

	img.photo{
		width: 210px;
		height: 220px;
		margin-left: 10px;
		border: 2px solid gray;
		border-radius: 20px;
		box-shadow: 5px 5px 5px gray;
		cursor: pointer;
	}
	
	span.day{
		color: gray;
		font-size: 0.8em;
	}
	
	div.list2{
		width: 800px;
		margin-top: 10px;
		border: 1px dotted gray;
		cursor: pointer;
	}
	div.list2 pre{
		border: none;
		background-color: white;
		color: blue;
		font-weight: bold;
	}
	
	#showentire{
		position: absolute;
		left: 900px;
		top: 100px;
	}
	
	.img1{
		width: 300px;
		height: 300px;
		border: 3px solid gray;
		margin-left: 40px;
		margin-bottom: 10px;
	}
</style>
<script type="text/javascript">
	$(function(){
		list1();
		$("#list1").click(function(){
			list1();
		});
		
		$("#list2").click(function(){
			$("#list2").css("color","red");
			$("#list1").css("color","black");
			
			$.ajax({
				type:"get",
				url:"../ajax/list2",
				dataType:"json",
				success:function(data){
					var s="<b>"+data.length+"개의 자료가 있습니다.<b><br>";
					$.each(data, function(i, a) {
						s+="<div class='list2'>";
						s+="<span class='title'>제목:"+a.subject+"</span><br>";
						s+="<span class='writer'>작성자:"+a.writer+"</span><br>";
						s+="<span class='writeday'>작성일:"+a.writeday+"</span><br>";
						s+="<span class='content'><pre>"+a.content+"</pre></span><br>";					
						s+="</div>";
					});
					
					
					$("#showboard").html(s);
				}
			});
		});
		
	});
	
function list1(){
	$("#list1").css("color","red");
	$("#list2").css("color","black");
	
	$.ajax({
		type:"get",
		url:"../ajax/list1",
		dataType:"json",
		success:function(data){
			var s="<b>"+data.length+"개의 자료가 있습니다.<b><br>";
			s+="<table class='phototb'>";
			s+="<tr>";
			
			$.each(data, function(i, a) {
				var photo=a.uploadname.split(",");
				s+="<td align='center'>";
				s+="<img class='photo' src='../image/"+photo[0]+"' num="+a.num+"><br>";
				s+="제목:"+a.subject+"(사진 총"+photo.length+"개)<br>";
				s+="작성자:"+a.writer+"<br>";
				s+="<span class='day'>작성일:"+a.writeday+"</span><br><br>";
				s+="</td>";
				if((i+1)%3==0)
					s+="</tr><tr>";
			});
			s+="</table>";
			$("#showboard").html(s);
		}
	});
}
</script>
</head>
<body>
<div class="alert alert-danger" style="font-size: 20pt;font-weight: bold;width: 800px;">Ajax로 Board목록 출력하기
	<span class="glyphicon glyphicon-th-large" id="list1" style="margin-left: 200px;cursor: pointer;"></span>
	<span class="glyphicon glyphicon-th-list" id="list2" style="margin-left: 3px;cursor: pointer;"></span>
</div>

<div id="showboard">aa</div>
<div id="showentire">df</div>
<script type="text/javascript">
//이미지를 클릭했을 때 그 글에 대한 내용과 모든 사진이 출력 마우스가 벗어나면 다시 지워지게 하기
$(document).on("mouseover","img.photo",function(){
	var num=$(this).attr("num");
	
	$.ajax({
		type:"get",
		url:"../ajax/data1",
		dataType:"json",
		data:{"num":num},
		success:function(data){
			var n="";
			var photo=data.uploadname.split(",");
			n+="<div class='data1'>";
			n+="<span class='title'>제목:"+data.subject+"</span><br>";
			n+="<span class='writer'>작성자:"+data.writer+"</span><br>";
			n+="<span class='writeday'>작성일:"+data.writeday+"</span><br>";
			n+="<span class='content'><pre>"+data.content+"</pre></span><br>";		
			//이미지 반복문 돌리기
			$.each(photo, function(i, elt) {
				n+="<span class='photo'><img src='../image/"+elt+"' class=img1></span><br>";		
			});
			
			n+="</div>";
			
			$("#showentire").html(n).show();
		}
	});


});

$(document).on("mouseleave","img.photo",function(){
	$("#showentire").html("").hide();
	
});

</script>
</body>
</html>