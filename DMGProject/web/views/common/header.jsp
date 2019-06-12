<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.dmg.jsp.member.model.vo.*"%>
<%
	Member m = (Member)session.getAttribute("member");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="/DMG/resources/js/jquery-3.4.1.min.js"></script>
<title>Header</title>
<style>
	body {

	}
</style>
</head>
<body>
	<h1>DMG.COM</h1>
	<div class="loginArea">
	<%if ( m == null ) { %>
		<form id="loginForm" action="/DMG/login.me" method="post">
			<table>
				<tr>
					<td>
						<label class="text" float="right">ID : </label>
					</td>
					<td>
						<input type="text" name="userId">
					</td>
				</tr>
					<tr>
					<td>
						<label class="text">PWD : </label>
					</td>
					<td>
						<input type="password" name="userPwd">
					</td>
				</tr>
			</table>
			<div class="btns" align="center">
				<div id="memberJoinBtn" onclick="memberJoin()">회원가입</div>
				<div id="loginBtn" onclick='login()'>로그인</div> 
			</div>
			
		</form>
		<% } else { %>
		<div id="userInfo">
			<label><%= m.getUserName() %>님의 방문을 환영합니다.</label>
			<div class="btns" align="right">
				<div id="changeInfo" onclick="changeInfo()">정보수정</div>
				<div id="logoutBtn" onclick='logout()'>로그아웃</div> 
			</div>
			
		</div>
	<% } %>
	</div>
	<script>
		function login(){
			$('#loginForm').submit();
		}
		
		function logout(){
			location.href="/DMG/logout.me";
		}
		
		function memberJoin(){
			location.href="/DMG/views/member/memberJoinForm.jsp";
		}
		
		function changeInfo(){
			location.href="/DMG/views/member/memberUpdateForm.jsp";
		}
	</script>
	<hr>
</body>
</html>