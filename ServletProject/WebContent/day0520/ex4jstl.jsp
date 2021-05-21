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
<fmt:requestEncoding value="utf-8"/>
<form action="ex4jstl.jsp" method="post">
	이름입력: <input type="text" name="name" size="6"><br>
	여행가고 싶은 나라는?
	<input type="text" name="nara" size="10"><br>
	<input type="submit" value="전송">
</form>

<c:if test="${!empty param.name }"><!-- 이름을 입력한 경우에만 if문 실행 -->
	<h2>결과를 출력합니다.</h2>
	<h3>${param.name }님이 여행가고 싶은 나라는 ${param.nara }입니다</h3>
	
	<c:set var="n" value="${param.nara }"/>
	
	<c:if test="${n=='스위스' }">
		<h4 class="alert alert-warning">
			스위스는 경치가 아름다운 나라입니다
		</h4>
	</c:if>
	<c:if test="${n=='미국' }">
		<h4 class="alert alert-success">
			미국의 피자는 맛있습니다
		</h4>
	</c:if>
	<c:if test="${n=='프랑스' }">
		<h4 class="alert alert-danger">
			에펠탑 최고
		</h4>
	</c:if>
	<c:if test="${n=='체코' }">
		<h4 class="alert alert-info">
			체코의 프라하는  참 아름다운 도시입니다.
		</h4>
	</c:if>
</c:if>
<br><br>
<c:choose>
	<c:when test="${n=='스위스'  }">
	<h4 class="alert alert-warning">
		스위스는 경치가 아름다운 나라입니다
	</h4>
	</c:when>
	<c:when test="${n=='프랑스'  }">
	<h4 class="alert alert-warning">
		에펠탑 최고
	</h4>
	</c:when>
	<c:when test="${n=='체코'  }">
	<h4 class="alert alert-warning">
		체코의 프라하는 참 아름다운 도시입니다.
	</h4>
	</c:when>
	<c:when test="${n=='미국'  }">
	<h4 class="alert alert-warning">
		미국의 피자는 맛있습니다
	</h4>
	</c:when>
	<c:otherwise>
		<h4 class="alert alert-default">
			${n } 나라에 대한 정보는 없습니다.
		</h4>
	</c:otherwise>
</c:choose>

</body>
</html>