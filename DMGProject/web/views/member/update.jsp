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
<form style="padding: 10px; height: 500px; width: 500px; margin: 0 auto;" id="updateForm" action="/DMG/mUpdate.me" method="post">
	<p style="font-size:24px;"align="center"><strong>회원 정보 수정</strong></p>
	<hr class="colorgraph">
	<table style="border-collapse: separate; border-spacing: 0 20px;">
		<tr>
			<td style="width: 200px"><strong>회원 아이디</strong>
			</td>
			<td style="width: 200px"><%= m.getUserId() %>
			</td>
		</tr>
		<tr>
			<td style="width: 200px"><strong>비밀번호</strong>
			</td>
			<td><input style="border: none; border-bottom: 3px solid  #5293BF;" type="password" class="form-control-plaintext" id="userPwd" name="userPwd" value=""></td>
		</tr>
		<tr>
			<td style="width: 200px"><strong>비밀번호 확인</strong>
			</td>
			<td><input style="border: none; border-bottom: 3px solid  #5293BF;" type="password" class="form-control-plaintext" id="userPwd2" name="userPwd" value=""></td>
		</tr>
		<tr>
			<td style="width: 200px"><strong>이름</strong>
			</td>
			<td style="width: 200px"><%= m.getUserName() %>
			</td>
		</tr>
		<tr>
			<td style="width: 200px"><strong>자택 주소</strong>
			</td>
			<td><input type="text" style="border: none; width:50px" readonly id="zipCode" name="zipCode" value="">
			<button type="button" class="btn btn-outline-info">우편번호</button>
			</td>
		</tr>
		<tr>
			<td style="width: 200px">
			</td>
			<td style="width: 200px"><span class="badge badge-secondary">주소</span>
			<input type="text" readonly class="form-control-plaintext" id="address1" name="address1" value=""></td>
		</tr>
		<tr>
			<td style="width: 200px">
			</td>
			<td style="width: 200px"><span class="badge badge-secondary">상세주소</span>
			<input style="border: none; border-bottom: 3px solid  #5293BF;" type="text" class="form-control-plaintext" id="address2" name="address2" value=""></td>
		</tr>
		<tr>
			<td style="width: 200px"><strong>연락처</strong>
			</td>
			<td style="width: 200px">
			<input style="border: none; border-bottom: 3px solid  #5293BF;" type="text" maxlength="3" id="tel1" name="tel1" size="2">-
			<input style="border: none; border-bottom: 3px solid  #5293BF;" type="text" maxlength="4" id="tel2" name="tel2" size="2">-
			<input style="border: none; border-bottom: 3px solid  #5293BF;" type="text" maxlength="4" id="tel3" name="tel3" size="2">
			</td>
		</tr>
		<tr>
			<td style="width: 200px"><strong>이메일</strong>
			</td>
			<td style="width: 200px"><input style="border: none; border-bottom: 3px solid  #5293BF;" type="text" class="form-control-plaintext" id="email" name="email" value="<%= m.getEmail() %>"></td>
		</tr>
	</table>
	<hr class="colorgraph">
	<div style="float: right;">
  		<button type="button" class="btn btn-outline-primary" onclick="goMain();">메인으로</button>
  		<button type="button" class="btn btn-danger" data-toggle="modal"
		data-target="#exampleModal" >회원탈퇴</button>
  		<button type="button" class="btn btn-success" onclick="updateMember();">정보수정</button>
  		
  	</div>
</form>
	<!-- Modal -->
	<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-body">
					<div class="container">
						<div class="row">
							<div style="margin-right: auto; margin-left: auto;">
								<form id="deleteuserform"
								action="${pageContext.request.contextPath}/mDelete.me" method="post">
									<fieldset>
										<p style="font-size: 24px;" align="center">
											<strong>탈퇴시 데이터를 복구할수 없습니다. 정말 탈퇴하시겠습니까?</strong>
										</p>
										<hr
											style="height: 5px; border-top: 0; background: #c4e17f; border-radius: 5px; background-image: -webkit-linear-gradient(left, #c4e17f, #c4e17f 12.5%, #f7fdca 12.5%, #f7fdca 25%, #fecf71 25%, #fecf71 37.5%, #f0776c 37.5%, #f0776c 50%, #db9dbe 50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%, #669ae1 87.5%, #62c2e4 87.5%, #62c2e4); background-image: -moz-linear-gradient(left, #c4e17f, #c4e17f 12.5%, #f7fdca 12.5%, #f7fdca 25%, #fecf71 25%, #fecf71 37.5%, #f0776c 37.5%, #f0776c 50%, #db9dbe 50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%, #669ae1 87.5%, #62c2e4 87.5%, #62c2e4); background-image: -o-linear-gradient(left, #c4e17f, #c4e17f 12.5%, #f7fdca 12.5%, #f7fdca 25%, #fecf71 25%, #fecf71 37.5%, #f0776c 37.5%, #f0776c 50%, #db9dbe 50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%, #669ae1 87.5%, #62c2e4 87.5%, #62c2e4); background-image: linear-gradient(to right, #c4e17f, #c4e17f 12.5%, #f7fdca 12.5%, #f7fdca 25%, #fecf71 25%, #fecf71 37.5%, #f0776c 37.5%, #f0776c 50%, #db9dbe 50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%, #669ae1 87.5%, #62c2e4 87.5%, #62c2e4);"
											class="colorgraph">
										<div class="form-group">
											<label for="IDinput">Enter ID</label> <input type="text"
												class="form-control" id="userId" name="userId"
												aria-describedby="emailHelp" placeholder="Enter ID">
										</div>
										<div class="form-group">
											<label for="passwordinput">Password</label> <input
												type="password" class="form-control" name="userPwd"
												id="userPwd" placeholder="Password">
										</div>
										<hr
											style="height: 5px; border-top: 0; background: #c4e17f; border-radius: 5px; background-image: -webkit-linear-gradient(left, #c4e17f, #c4e17f 12.5%, #f7fdca 12.5%, #f7fdca 25%, #fecf71 25%, #fecf71 37.5%, #f0776c 37.5%, #f0776c 50%, #db9dbe 50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%, #669ae1 87.5%, #62c2e4 87.5%, #62c2e4); background-image: -moz-linear-gradient(left, #c4e17f, #c4e17f 12.5%, #f7fdca 12.5%, #f7fdca 25%, #fecf71 25%, #fecf71 37.5%, #f0776c 37.5%, #f0776c 50%, #db9dbe 50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%, #669ae1 87.5%, #62c2e4 87.5%, #62c2e4); background-image: -o-linear-gradient(left, #c4e17f, #c4e17f 12.5%, #f7fdca 12.5%, #f7fdca 25%, #fecf71 25%, #fecf71 37.5%, #f0776c 37.5%, #f0776c 50%, #db9dbe 50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%, #669ae1 87.5%, #62c2e4 87.5%, #62c2e4); background-image: linear-gradient(to right, #c4e17f, #c4e17f 12.5%, #f7fdca 12.5%, #f7fdca 25%, #fecf71 25%, #fecf71 37.5%, #f0776c 37.5%, #f0776c 50%, #db9dbe 50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%, #669ae1 87.5%, #62c2e4 87.5%, #62c2e4);"
											class="colorgraph">
										<button type="submit" class="btn btn-danger btn-lg btn-block"
											>회원 탈퇴</button>
										<button type="button"
											class="btn btn-secondary btn-lg btn-block">취소</button>
									</fieldset>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


	<br> <br> <br> <br> <br> <br>
					<script>
$(function(){

	var phoneArr = '<%=m.getPhone()%>'.split('-');

	$('#tel1').val(phoneArr[0]);
	$('#tel2').val(phoneArr[1]);
	$('#tel3').val(phoneArr[2]);
	
	var addressArr = '<%=m.getAddress()%>'.split('/ ');
	
	$('#zipCode').val(addressArr[0]);
	$('#address1').val(addressArr[1]);
	$('#address2').val(addressArr[2]);
	
	})
	
	function goMain() {
		location.href = '/DMG/index.jsp'; }
	
	function updateMember() {
		var email = document.getElementById("email").value;
		var exptext = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
		if($("#userPwd").val() == "") alert("비밀번호는 필수 값입니다.");
		else if ($('#userPwd').val() != $('#userPwd2').val()) {
			alert("비밀번호 확인 값과 다릅니다."); }
		else if (exptext.test(email) == false) {
			//이메일 형식이 알파벳+숫자@알파벳+숫자.알파벳+숫자 형식이 아닐경우			
			alert("이메일형식이 올바르지 않습니다.");
			$('#email').select(); }
		else {
			$("#updateForm").submit();
		}
	}
</script>
</body>
</html>