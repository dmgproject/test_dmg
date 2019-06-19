<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.security.SecureRandom" %>
<%@ page import="java.math.BigInteger" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.dmg.jsp.member.model.vo.*"%>
<%
	Member m = (Member)session.getAttribute("member");
%>
<!DOCTYPE html>
<html>
<head>
<!-- Standard Meta -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0">

<script src="/DMG/resources/css/components/form.js"></script>
<script src="/DMG/resources/components/transition.js"></script>
<script src="/DMG/resources/js/jquery-3.4.1.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="/DMG/resources/css/semantic.min.css">
<script src="/DMG/resources/js/semantic.min.js"></script>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">


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
<title>DMG LOGIN PAGE</title>
</head>
<body>
  <%
  	String clientId = "3_Nv4pf63XY2WISxV507";//애플리케이션 클라이언트 아이디값";
  	String redirectURI = URLEncoder.encode("http://localhost:8088/DMG/views/member/callback.jsp", "UTF-8");
  	SecureRandom random = new SecureRandom();
  	String state = new BigInteger(130, random).toString();
  	String apiURL = "https://nid.naver.com/oauth2.0/authorize?response_type=code";
  	apiURL += "&client_id=" + clientId;
  	apiURL += "&redirect_uri=" + redirectURI;
  	apiURL += "&state=" + state;
  	session.setAttribute("state", state);
  %>
	<div class="container">
		<div class="row" style="margin-top: 20px; margin-right: auto; margin-left: auto;">
			<div
				class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3"
				style="margin-right: auto; margin-left: auto;">
				<form id="loginform"action="/DMG/login.me" method="post">
					<fieldset>
						<p style="font-size:24px;"align="center"><strong>DMG.COM 로그인</strong></p>
						<hr class="colorgraph">
						<div class="form-group">
							<input type="text" name="userId" id="userId"
								class="form-control input-lg" placeholder="아이디">
						</div>
						<div class="form-group">
							<input type="password" name="userPwd" id="userPwd"
								class="form-control input-lg" placeholder="비밀번호">
						</div>
						<p>
							<a href="#">아이디</a>
							<a href="#">비밀번호 찾기</a>
							<a href="<%=apiURL%>"><img height="34" src="/DMG/resources/images/naver_login.png"/></a>
						</p>
						<hr class="colorgraph">
						<div class="row">
							<div class="col-xs-6 col-sm-6 col-md-6">
									<input type="button" class="btn btn-lg btn-success btn-block" onclick="submit();"
									style="height: 42.5px; border: tomato; background-color: tomato;"
									value="회원가입">
							</div>
							<div class="col-xs-6 col-sm-6 col-md-6">
								<input type="button" class="btn btn-lg btn-success btn-block" onclick="submit();"
									style="height: 42.5px; border: tomato; background-color: tomato;"
									value="로그인">
							</div>
						</div>
					</fieldset>
				</form>
			</div>
		</div>
	</div>
	<script>
	function submit() {
		$("#loginform").submit();
		opener.parent.location.reload();
		window.close();
	}

	</script>
</body>
</html>