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
	<div class="insertProduct" onclick="insertProuct()">상품 추가</div>
	<div class="insertProduct" onclick="selectProductList()">상품 리스트 보기</div>
	<br><br><br><br><br>
	<br><br><br><br><br>
	<br><br><br><br><br>
	<%@ include file="views/common/footer.jsp" %>
	<script>
	function goNotice(){
		location.href="/DMG/selectList.no";
	}
	function insertProuct(){
		location.href="/DMG/cLselect.do";
	}
	function selectProductList(){
		location.href="/DMG/pList.do";
	}
	</script>
</body>
</html>