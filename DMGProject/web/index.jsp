<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.security.SecureRandom" %>
<%@ page import="java.math.BigInteger" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.dmg.jsp.member.model.vo.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">


<script src="/DMG/resources/js/jquery-3.4.1.min.js"></script>
<link rel="stylesheet" type="text/css"
   href="/DMG/resources/css/semantic.min.css">
<script src="/DMG/resources/js/semantic.min.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js" charset="utf-8"></script>


<style>
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


<title>DMGProject 임시 메인 페이지</title>
</head>
<body>

<%
  	String clientId = "3_Nv4pf63XY2WISxV507";//애플리케이션 클라이언트 아이디값";
  	String redirectURI = URLEncoder.encode("http://127.0.0.1:8088/DMG/callback.me", "UTF-8");
  	SecureRandom random = new SecureRandom();
  	String state = new BigInteger(130, random).toString();
  	String apiURL = "https://nid.naver.com/oauth2.0/authorize?response_type=code";
  	apiURL += "&client_id=" + clientId;
  	apiURL += "&redirect_uri=" + redirectURI;
  	apiURL += "&state=" + state;
  	session.setAttribute("state", state);
%>
	<%@ include file="views/common/header.jsp" %>
	<h1>임시 메인 페이지 입니다.</h1>

		<!-- Button trigger modal -->
	<button type="button" class="btn btn-primary" data-toggle="modal"
		data-target="#exampleModal">로그인</button>
	<!-- <div class="menu" onclick="gologin()">로그인</div> -->
	<!-- <div class="menu" onclick="gojoin()">회원가입</div> -->
	<div class="menu" onclick="goNotice()">공지사항 임시 게시판</div>
	<div class="menu" onclick="gojoin2()">회원가입2</div>
	<div onclick="gofindid()">아이디 찾기</div>
	<div onclick="gofindpassword()">비밀번호 찾기</div>
	<div onclick="gopasswordedit()">비밀번호 변경</div>
	<div onclick="gouseredit()">회원정보 수정</div>
	
	----------------------------------------------------------
	

	<div class="insertProduct" onclick="insertProuct()">상품 추가</div>
	<div class="insertProduct" onclick="selectProductList()">상품 리스트 보기</div>
	
	-----------------------------------------------------------
	
	<div onclick="goreDetail()">reDetail</div>
	<div onclick="goreInsert()">reInsert</div>
	<div onclick="goreUpdateView()">reUpdateView</div>
	<div onclick="gothumbnailList()">thumbnailList</div>
	
	<!--                                                                 -->
	
	


	<!-- Modal -->
	<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-body">
					<div style="margin-right: auto; margin-left: auto;">
								<form id="loginform" action="/DMG/login.me" method="post">
									<fieldset>
										<p style="font-size: 24px;" align="center">
											<strong>DMG.COM 로그인</strong>
										</p>
										<hr
											style="height: 5px; border-top: 0; background: #c4e17f; border-radius: 5px; background-image: -webkit-linear-gradient(left, #c4e17f, #c4e17f 12.5%, #f7fdca 12.5%, #f7fdca 25%, #fecf71 25%, #fecf71 37.5%, #f0776c 37.5%, #f0776c 50%, #db9dbe 50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%, #669ae1 87.5%, #62c2e4 87.5%, #62c2e4); background-image: -moz-linear-gradient(left, #c4e17f, #c4e17f 12.5%, #f7fdca 12.5%, #f7fdca 25%, #fecf71 25%, #fecf71 37.5%, #f0776c 37.5%, #f0776c 50%, #db9dbe 50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%, #669ae1 87.5%, #62c2e4 87.5%, #62c2e4); background-image: -o-linear-gradient(left, #c4e17f, #c4e17f 12.5%, #f7fdca 12.5%, #f7fdca 25%, #fecf71 25%, #fecf71 37.5%, #f0776c 37.5%, #f0776c 50%, #db9dbe 50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%, #669ae1 87.5%, #62c2e4 87.5%, #62c2e4); background-image: linear-gradient(to right, #c4e17f, #c4e17f 12.5%, #f7fdca 12.5%, #f7fdca 25%, #fecf71 25%, #fecf71 37.5%, #f0776c 37.5%, #f0776c 50%, #db9dbe 50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%, #669ae1 87.5%, #62c2e4 87.5%, #62c2e4);"
											class="colorgraph">
										<div class="form-group">
											<label for="IDinput">Enter ID</label> <input
												type="text" class="form-control" id="userId" name="userId"
												aria-describedby="emailHelp" placeholder="Enter ID">
											<small id="idHelp" class="form-text text-muted">
												ID를 입력해 주세요.</small>
										</div>
										<div class="form-group">
											<label for="passwordinput">Password</label> <input
												type="password" class="form-control" name="userPwd"
												id="userPwd" placeholder="Password">
										</div>
										<p>
											<a href="#">아이디</a> <a href="#">비밀번호 찾기</a>
 											<a href="<%=apiURL%>"><img height="34"
												src="/DMG/resources/images/naver_login.png" /></a>

										</p>
										<hr
											style="height: 5px; border-top: 0; background: #c4e17f; border-radius: 5px; background-image: -webkit-linear-gradient(left, #c4e17f, #c4e17f 12.5%, #f7fdca 12.5%, #f7fdca 25%, #fecf71 25%, #fecf71 37.5%, #f0776c 37.5%, #f0776c 50%, #db9dbe 50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%, #669ae1 87.5%, #62c2e4 87.5%, #62c2e4); background-image: -moz-linear-gradient(left, #c4e17f, #c4e17f 12.5%, #f7fdca 12.5%, #f7fdca 25%, #fecf71 25%, #fecf71 37.5%, #f0776c 37.5%, #f0776c 50%, #db9dbe 50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%, #669ae1 87.5%, #62c2e4 87.5%, #62c2e4); background-image: -o-linear-gradient(left, #c4e17f, #c4e17f 12.5%, #f7fdca 12.5%, #f7fdca 25%, #fecf71 25%, #fecf71 37.5%, #f0776c 37.5%, #f0776c 50%, #db9dbe 50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%, #669ae1 87.5%, #62c2e4 87.5%, #62c2e4); background-image: linear-gradient(to right, #c4e17f, #c4e17f 12.5%, #f7fdca 12.5%, #f7fdca 25%, #fecf71 25%, #fecf71 37.5%, #f0776c 37.5%, #f0776c 50%, #db9dbe 50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%, #669ae1 87.5%, #62c2e4 87.5%, #62c2e4);"
											class="colorgraph">
										<button type="button" class="btn btn-primary btn-lg btn-block" onclick="submit()">로그인</button>
										<button type="button" class="btn btn-secondary btn-lg btn-block">회원가입</button>

									</fieldset>
								</form>

					</div>
	<script>
	function submit() {
		$("#loginform").submit();
		opener.parent.location.reload();
		window.close();
	}

	</script>
				</div>
			</div>
		</div>
	</div>



	<!--                                                                 -->
	<br><br><br><br><br>
	<br><br><br><br><br>
	<br><br><br><br><br>
	<a href="/DMG/views/member/memberjoinform.jsp">ww</a>
	<div class="menu" onclick="goNotice()">공지사항 임시 게시판</div>
	<a href="http://localhost:8088/DMG/views/member/naverlogin.jsp">naver login</a>
	<br><br><br><br><br>
	<%@ include file="views/common/footer.jsp" %>
	<script>
	function goNotice(){
		location.href="/DMG/selectList.no";
	}
	function gologin(){
		var Url = "/DMG/views/member/login.jsp";	//팝업창에 출력될 페이지 URL
		var Option = "width=900, height=450, resizable=no, scrollbars=no, status=no;";    //팝업창 옵션(optoin)
			window.open(Url,"",Option);
		}
	function gojoin(){
		location.href="/DMG/views/member/join.jsp"
		}
	function gojoin2(){
		location.href="/DMG/views/member/join2.jsp"
		}
	function gofindid(){
		location.href="/DMG/views/member/findid.jsp"
	}
	function gofindpassword(){
		location.href="/DMG/views/member/findpassword.jsp"
	}
	function gopasswordedit(){
		location.href="/DMG/views/member/passwordedit.jsp"
	}
	function gouseredit(){
		location.href="/DMG/views/member/update.jsp"
	}
	function submit() {
		$("#loginform").submit();
		//opener.parent.location.reload();
		//window.close();
	}
	function insertProuct(){
		location.href="/DMG/cLselect.do";
	}
	function selectProductList(){
		location.href="/DMG/pList.do";
	}
	function goreDetail(){
		location.href="/DMG/views/thumbnail/reDetail.jsp";
	}
	function goreInsert(){
		location.href="/DMG/views/thumbnail/reInsert.jsp";
	}
	function goreUpdateView(){
		location.href="/DMG/views/thumbnail/reUpdateView.jsp";
	}
	
	function gothumbnailList(){
		location.href="/DMG/views/thumbnail/thumbnailList.jsp";
	}
	
	</script>
</body>
</html>