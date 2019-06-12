<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.dmg.jsp.member.model.vo.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 성공 화면!</title>
</head>
<body>
	<%@ include file="/views/common/header.jsp" %>
	
	<h1>로그인 성공!</h1>
	<h3><%= m.getUserName() %>님, 환영합니다!!</h3>
	<p>회원 정보 : <br>
	   <%= m.toString() %>
	</p>
	
	<br /><br />
	
	<a href="//index.jsp">처음으로 돌아가기</a>
	
	<button type="button" id="logoutBtn" onclick="logout()">로그아웃</button>
		
	<script>
		function logout(){
			location.href = '/DMG/logout.me';
		}
	</script>
	<%@ include file="/views/common/footer.jsp" %>
</body>
</html>








