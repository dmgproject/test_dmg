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
<link rel="stylesheet" type="text/css"
   href="/DMG/resources/css/semantic.min.css">
<script src="/DMG/resources/js/semantic.min.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<title>DMG JOIN PAGE</title>
<style>
.colorgraph {
  height: 5px;
  border-top: 0;
  background: #c4e17f;
  border-radius: 5px;
  background-image: -webkit-linear-gradient(left, #c4e17f, #c4e17f 12.5%, #f7fdca 12.5%, #f7fdca 25%, #fecf71 25%, #fecf71 37.5%, #f0776c 37.5%, #f0776c 50%, #db9dbe 50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%, #669ae1 87.5%, #62c2e4 87.5%, #62c2e4);
  background-image: -moz-linear-gradient(left, #c4e17f, #c4e17f 12.5%, #f7fdca 12.5%, #f7fdca 25%, #fecf71 25%, #fecf71 37.5%, #f0776c 37.5%, #f0776c 50%, #db9dbe 50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%, #669ae1 87.5%, #62c2e4 87.5%, #62c2e4);
  background-image: -o-linear-gradient(left, #c4e17f, #c4e17f 12.5%, #f7fdca 12.5%, #f7fdca 25%, #fecf71 25%, #fecf71 37.5%, #f0776c 37.5%, #f0776c 50%, #db9dbe 50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%, #669ae1 87.5%, #62c2e4 87.5%, #62c2e4);
  background-image: linear-gradient(to right, #c4e17f, #c4e17f 12.5%, #f7fdca 12.5%, #f7fdca 25%, #fecf71 25%, #fecf71 37.5%, #f0776c 37.5%, #f0776c 50%, #db9dbe 50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%, #669ae1 87.5%, #62c2e4 87.5%, #62c2e4);
}
</style>
</head>
<body>
<form style="padding: 10px; height: 300px; width: 300px; margin: 0 auto;">
	<p style="font-size:24px;"align="center"><strong>DMG.COM 회원 가입</strong></p>
	<hr class="colorgraph">
	<div class="input-group mb-3">
  		<input type="text" class="form-control" placeholder="아이디" aria-label="ID" aria-describedby="button-addon2">
  		<div class="input-group-append">
    		<button class="btn btn-outline-secondary" type="button" id="button-addon2">중복확인</button>
  		</div>
	</div>
	<div class="input-group mb-3">
  		<input type="password" class="form-control" placeholder="비밀번호" aria-label="PASSWORD" aria-describedby="button-addon2"><br />
  	</div>
  	<div class="input-group mb-3">
  		<input type="password" class="form-control" placeholder="비밀번호 확인" aria-label="Confirm Password" aria-describedby="button-addon2"><br />
  	</div>
  	<div class="input-group mb-3">
  		<input type="text" class="form-control" placeholder="이름" aria-label="name" aria-describedby="button-addon2"><br />
  	</div>
  	<div class="input-group mb-3">
  		<input type="text" class="form-control" placeholder="이메일" aria-label="E-MAIL" aria-describedby="button-addon2"><br />
  	</div>
  	<div class="input-group mb-3">
  		<input type="text" class="form-control" placeholder="전화번호" aria-label="PHONE" aria-describedby="button-addon2"><br />
  	</div>
	<div class="input-group mb-3">
  		<input type="text" class="form-control" placeholder="우편번호" aria-label="ZIP-CODE" aria-describedby="button-addon2" readonly>
  		<div class="input-group-append">
    		<button class="btn btn-outline-secondary" type="button" id="button-addon2">우편번호</button>
  		</div>
	</div>
	<div class="input-group mb-3">
  		<input type="text" class="form-control" placeholder="주소" aria-label="ADDRESS1" aria-describedby="button-addon2" readonly><br />
  	</div>
  	<div class="input-group mb-3">
  		<input type="text" class="form-control" placeholder="상세주소" aria-label="ADDRESS2" aria-describedby="button-addon2"><br />
  	</div>
  	<hr class="colorgraph">
  	<div style="float: right;">
  		<button type="button" class="btn btn-outline-primary">메인으로</button>
  		<button type="button" class="btn btn-success">회원가입</button>
  	</div>
</form>
</body>
</html>