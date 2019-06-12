<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DMGProject 임시 메인 페이지</title>
</head>
<body>
	<%@ include file="views/common/header.jsp" %>
	<h1>임시 메인 페이지 입니다.</h1>
	<div class="menu" onclick="goNotice()">공지사항 임시 게시판</div>
	<a href="http://localhost:8088/DMG/views/member/naverlogin.jsp">naver login</a>
	<br><br><br><br><br>
	<br><br><br><br><br>
	<br><br><br><br><br>
	<%@ include file="views/common/footer.jsp" %>
	<script>
	function goNotice(){
		location.href="/DMG/selectList.no";
	}
	</script>
</body>
</html>