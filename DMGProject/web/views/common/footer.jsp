<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/Swiper/4.4.1/css/swiper.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/Swiper/4.4.1/js/swiper.min.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.css">
<script src="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.js"></script>

<script src="/DMG/resources/js/jquery-3.4.1.min.js"></script>
<title>Header</title>

<style>
.common_header{ display : inline-block;
		width : 1200px;
}
.container{
	width: 1200px;
	margin: 0 auto;
}

.button {
	border-radius : 12px;
	background-color : white;
	color : orange;
	border : 1px solid gray;
	width: 60px; 
	height: 20px;
    font-size: 3px;
}
/* .footCopy{
	font-weight: bold;
	font-size: 30px;
} */


		
</style>
</head>

<body> 

	<section class="container">
		<div style="display : inline-block;">
			<div style = "display : inline-block; width : 100px; margin-left: 20px;"><span><a href="#">회사소개</a></span></div>&nbsp;
			<div style = "display : inline-block; width : 150px;"><span><a href="#">개인정보처리 방침</a></span></div>&nbsp;
			<div style = "display : inline-block; width : 100px;"><span><a href="#">이용약관</a></span></div>&nbsp;
		</div>
		
		<hr style="border: 0.3px solid gray;">
	</section>
	
	<section class="container" style="margin-top: 20px;">
		<div style="float: left;">
			<p><span style="margin-left: 20px;">(주)디엠지닷컴</span></p>
			<span style="display: inline-block;"><img src="/DMG/resources/images/headset.png" style="width: 30px; height: 30px; margin-left: 20px;"></span>
			<span style="display: inline-block;">1544-7877</span>
			<span><button class="button" onclick="inquiry()">문의</button></span>
			<span><button class="button" onclick="one_oneInquiry()">1:1고객센터</button></span>
			<p style="margin-left: 20px;">
				대표자 : Daniel Yu<br>
				주소 : 서울특별시 강남구 테헤란로 14길 6 남도빌딩<br>
				Fax : 00-0000-0000<br>
				<a href="mailto:dmg@dmg.com">dmg@dmg.com</a>
			</p>	
		</div>

		<div class="footCopy" style="float: right; margin-top: 50px;" >
			<h2 style=" font-size: 40px; font-weight: bold;
				padding-left: 60px;" >DMG.COM</h2>
			<p style=" font-weight: bold; 
				font-size: 30px;">&copy;ALL RIGHTS RESERVED</p>
		</div>
		
	</section>
	
	<br>
	<br>
	<br>
	
	<!-- 문의 버튼 -->
	<script>
		function inquiry() {
			
		}
	</script>
	
	<!-- 1:1고객센터 버튼 -->
	<script>
		function one_oneInquiry() {
			
		}
	</script>

</body>
</html>
