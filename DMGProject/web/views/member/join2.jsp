<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.dmg.jsp.member.model.vo.*"%>
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
<form style="padding: 10px; height: 500px; width: 500px; margin: 0 auto;" id="joinForm"
		action="${pageContext.request.contextPath}/mInsert.me" method="post">
	<p style="font-size:24px;"align="center"><strong>DMG.COM 회원 가입</strong></p>
	<hr class="colorgraph">
	<strong>아이디</strong>
	<div class="input-group mb-3">
  		<input type="text" class="form-control" placeholder="아이디" aria-label="ID" aria-describedby="button-addon2" name="userId" id="userId" required="required">
  		<div class="input-group-append">
    		<button class="btn btn-outline-secondary" type="button" id="button-addon2" onclick="idcheck();">중복확인</button>
  		</div>
	</div>
	<strong>비밀번호</strong>
	<div class="input-group mb-3">
  		<input type="password" class="form-control" placeholder="비밀번호" aria-label="PASSWORD" aria-describedby="button-addon2" id="userPwd" name="userPwd" required="required"><br />
  	</div>
  	<strong>비밀번호 확인</strong>
  	<div class="input-group mb-3">
  		<input type="password" class="form-control" placeholder="비밀번호 확인" aria-label="Confirm Password" aria-describedby="button-addon2" id="userPwd2" name="userPwd2"><br />
  	</div>
  	<strong>이름</strong>
  	<div class="input-group mb-3">
  		<input type="text" class="form-control" placeholder="이름" aria-label="name" aria-describedby="button-addon2" name="userName"
						required="required"><br />
  	</div>
  	<strong>이메일</strong>
  	<div class="input-group mb-3">
  		<input type="email" class="form-control" placeholder="이메일" aria-label="E-MAIL" aria-describedby="button-addon2" id="email" name="email">
  		<div class="input-group-append">
  		</div>
  	</div>
  	<strong>전화번호</strong>
  	<div class="input-group mb-3">
  		<input type="text" maxlength="3" name="tel1" size="2" aria-describedby="button-addon2"> &nbsp;- &nbsp; 
						<input type="text" maxlength="4" name="tel2" size="2" aria-describedby="button-addon2"> &nbsp; - &nbsp;<input
						type="text" maxlength="4" name="tel3" size="2" aria-describedby="button-addon2">
  	</div>
  	<strong>우편번호</strong>
	<div class="input-group mb-3">
  		<input type="text" class="form-control" placeholder="우편번호" aria-label="ZIP-CODE" aria-describedby="button-addon2" readonly
  			id="zipCode" name="zipCode">
  		<div class="input-group-append">
    		<button class="btn btn-outline-secondary" type="button" id="button-addon2" onclick="addrSearch();">우편번호</button>
  		</div>
	</div>
	<strong>주소</strong>
	<div class="input-group mb-3">
  		<input type="text" class="form-control" placeholder="주소" aria-label="ADDRESS1" aria-describedby="button-addon2" readonly
  			id="address1" name="address1"><br />
  	</div>
  	<strong>상세주소</strong>
  	<div class="input-group mb-3">
  		<input type="text" class="form-control" placeholder="상세주소" aria-label="ADDRESS2" aria-describedby="button-addon2"
  			id="address2" name="address2"><br />
  	</div>
  	<hr class="colorgraph">
  	<div style="float: right;">
  		<button type="button" class="btn btn-outline-primary" onclick="goMain();">메인으로</button>
  		<button type="button" class="btn btn-success"onclick="insertMember();">회원가입</button>
  	</div>
</form>
	<script>
		var checkid = "false";

		function insertMember() {
			var email = document.getElementById("email").value;
			var exptext = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
			console.log(checkid);
			if (checkid == "false") {
				alert("아이디 중복 체크후 가입 가능합니다");
			} else if ($("#userPwd").val() == "" || $("#userId").val() == "") {
				alert("아이디나 비밀번호는 필수 값입니다.");
			} else if ($('#userPwd').val() != $('#userPwd2').val()) {
				alert("비밀번호 확인 값과 다릅니다.");
			} else if (exptext.test(email) == false) {
				//이메일 형식이 알파벳+숫자@알파벳+숫자.알파벳+숫자 형식이 아닐경우			
				alert("이메일형식이 올바르지 않습니다.");
				$('#email').select();
			} else {
				$("#joinForm").submit();
			}
		}
		// 참조 API : http://postcode.map.daum.net/guide
		function addrSearch() {
			new daum.Postcode({
				oncomplete : function(data) {
					// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
					// 각 주소의 노출 규칙에 따라 주소를 조합한다.
					// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
					var fullAddr = ''; // 최종 주소 변수
					var extraAddr = ''; // 조합형 주소 변수

					// 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
					if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
						fullAddr = data.roadAddress;
					} else { // 사용자가 지번 주소를 선택했을 경우(J)
						fullAddr = data.jibunAddress;
					}
					// 사용자가 선택한 주소가 도로명 타입일때 조합한다.
					if (data.userSelectedType === 'R') {
						//법정동명이 있을 경우 추가한다.
						if (data.bname !== '') {
							extraAddr += data.bname;
						}
						// 건물명이 있을 경우 추가한다.
						if (data.buildingName !== '') {
							extraAddr += (extraAddr !== '' ? ', '
									+ data.buildingName : data.buildingName);
						}
						// 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
						fullAddr += (extraAddr !== '' ? ' (' + extraAddr + ')'
								: '');
					}

					// 우편번호와 주소 정보를 해당 필드에 넣는다.
					$('#zipCode').val(data.zonecode); //5자리 새우편번호 사용

					$('#address1').val(fullAddr);

					// 커서를 상세주소 필드로 이동한다.
					$('#address2').focus();
				}
			}).open();
		};

		function goMain() {
			location.href = '/DMG/index.jsp';
		};

		function idcheck() {
			$.ajax({
				url : "/DMG/idDup.me",
				type : "post",
				data : {
					userId : $('#userId').val()
				},
				success : function(data) {
					if (data == 'ok') {
						alert("사용 가능한 아이디 입니다");
						checkid = "true";
					} else {
						alert("이미 사용 중인 아이디입니다.");
						$('#userId').select();
						checkid = "false";
					}

				},
				error : function(request, status, error) {
					console.log("---- ERROE ----")
					console.log(requset);
					console.log(status);
					console.log(error);
					console.log("---- ERROE ----")
				}
			})
		}
	</script>
	<br><br><br><br><br><br>
</body>
</html>