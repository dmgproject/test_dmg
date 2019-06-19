<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.dmg.jsp.member.model.vo.*"%>
<%
	Member m = (Member)session.getAttribute("member");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"><!-- 
<script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/Swiper/4.4.1/css/swiper.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/Swiper/4.4.1/js/swiper.min.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.css">
<script src="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.js"></script>
 -->
<title>Header</title>

<style>
.clearFix:after{
content: ''; clear: both; display: block;
}
.common_header{ display : inline-block;
		width : 1200px;
}
.container{
	width: 1200px;
	margin: 0 auto;
}

.menubar {
   border: none;
   border: 0px;
   margin: 0px;
   padding: 0px;
   font: 67.5% "Malgun Gothic";
   font-size: 14px;
   font-weight: bold;
   color : #FF773F;
   text-align: center;
   /*1번 background : #F2BD1D;*/
   /*2번 background : #F2C84B;*/
   /*3번 ackground: #F55A46;*/
  
}


.menubar ul {
   background: orange;
   height: 50px;
   list-style: none;
   margin: 0;
   padding: 0;
   font-color : #FF773F;
}

.menubar li {
   float:center;
   padding: 0px;
   margin : 0 10px;
   display: inline-block;
}

.menubar li a {
   /*background: #6AAFE6;*/
   color: black;
   display: inline-block;
   font-weight: normal;
   line-height: 50px;
   margin: 0px;
   padding: 0px 25px;
   text-align: center;
   text-decoration: none;
   
}

.menubar li a:hover, .menubar ul li:hover a {
   background: #ff6a00; 
   color: black;
   text-decoration: none;
}

.menubar li ul {
   background: #FF773F;    
   display: none;
   height: auto;
   padding: 0px;
   margin: 0px;
   border: 0px;
   position: absolute;
   width: 200px;
   z-index: 200;
   
}

.menubar li:hover ul {
   display: block;
}

.menubar li li {
   background: white;
   display: block;
   float: center;
   margin:0px;
   padding: 0px;
   width: 200px;
}

.menubar li:hover li a {
   background: none;
   
}

.menubar li ul a {
   display: block;
   height: 50px;
   font-size: 12px;
   font-style: normal;
   font-color : 
   margin: 0px;
   padding: 0px 10px 0px 15px;
   text-align: left;
   
}

.menubar li ul a:hover, .menubar li ul li:hover a {
   border: 0px;
   color: #FF773F;
   text-decoration: none;
}

.menubar p {
   clear: left;
}

.image{
	float: right;  
	padding : 10px; 
	margin : 30px auto; 
	display : block;
}
.image p{
	font-size: 12px;
	
}
		
</style>
</head>

<body>

	<section class="container">
		<div class="login_menu clearFix" >
			<div class="go_Inquiry" onclick="customerService()" style="float:right; color: gray; padding:10px; margin-right : 100px;" >고객센터</div>
			<div class="go_Insert" onclick="joinMember()" style="float:right; color: gray; padding:10px;">회원가입</div>	
			<div class="go_Login" onclick="login()" style="float:right; color: gray; padding:10px; ">로그인</div>			
		</div>
	</section>
	
	<section class="container">
	<div class="common_header middle">
		<div style="display : inline-block; margin : 10px;">
		<img src="/DMG/resources/images/logo.png" style="width: 180px; height: 80px;" onclick="location.href='/DMG/index.jsp'">
	    </div>
	    <div style="display : inline-block; margin-top : 40px; margin-left : 30px; height : auto; position : absolute;">
	    <div class="ui icon input">
			<select class="ui compact selection dropdown">
				<option value="all">All</option>
				<option value="articles">Articles</option>
				<option value="products">Products</option>
			</select>
		  	<input type="text" style="width: 500px; " placeholder="Search...">
		  	<i class="circular search link icon"></i>
		</div>
 		</div>
 		<div style = "float : right; margin-right :20px;">
 		<div class="image">
			<span class="myPage" style="width: 50px; height: 50px; margin-left: 12px; ">
	 			<img src="/DMG/resources/images/user.png" style="width: 20px; height: 20px; ">
	 		</span>
	 		<p>My DMG</p> 		
	 	</div>
		
		<div class="image" >
	 		<span class="delivery" style="width:50px; height: 50px; margin-left: 25px; ">
	 			<img src="/DMG/resources/images/delivery.png"  style="width: 26px; height: 20px; ">	
	 		</span>
	 		<p>주문배송조회</p>
		</div>
			
	 	<div class="image" >
	 		<span class="cart" style="width: 50px; height: 50px; margin-left: 15px; ">
	 			<img src="/DMG/resources/images/cart.png" style="width: 20px; height: 20px; ">
	 		</span>
	 		<p>장바구니</p>
	 	</div>
	 	
	 </div>	
	 </div>
	 </section>
	 
	 <section class="container">
		 <div class="menubar">
      <ul>
         <!-- 메뉴바 시작 -->
         
         <li style="left: 90px;"><i class="angle double down icon"></i>
            <ul>
               <li><a href="">소분류</a></li>
               <li style="top: 50px;"><a href="">개발자 소개</a></li>
               <li style="top: 50px;"><a href="">개발자 소개</a></li>
               <li style="top: 50px;"><a href="">개발자 소개</a></li>
               <li style="top: 50px;"><a href="">개발자 소개</a></li>
               <li style="top: 50px;"><a href="">개발자 소개</a></li>
               <li style="top: 50px;"><a href="">개발자 소개</a></li>
            </ul></li>
         
         <li style="left: 90px;"><a href="" id="moa">카테고리1</a>
            <ul>
               <li><a href="">페이지 소개</a></li>
               <li style="top: 50px;"><a href="">개발자 소개</a></li>
            </ul></li>
         <!-- MoA소개 메뉴 끝 -->

         <li style="left: 290px;"><a href="" id="Pv">카테고리2</a>
            <ul>
               <li><a href="">정책정보 조회</a></li>
               <li style="top: 50px;"><a href="">맞춤형 조회</a></li>
               <li style="top: 100px;"><a href="">우리동네 복지센터</a></li>
            </ul></li>
         <!-- 정책보기 메뉴 끝 -->

         <li style="left: 490px;"><a href="" id="comu">카테고리3</a>
            <ul>
               <li><a href="">공지사항</a></li>
               <li style="top: 50px;"><a href="">자유게시판</a></li>
               <li style="top: 100px;"><a href="">정책뉴스</a></li>
            </ul></li>
         <!-- 커뮤니티 메뉴 끝 -->

         <li style="left: 690px;"><a href="" id="QnA">카테고리4</a>
            <ul>
               <li><a href="">자주묻는 질문</a></li>
               <li style="top: 50px;"><a href="">1:1 문의</a></li>
            </ul></li>
         <!-- 문의하기 메뉴 끝  -->

         <li style="left: 890px;"><a href="" id="bascket">카테고리5</a>
         <ul>
               <li><a href="">자주묻는 질문</a></li>
               <li style="top: 50px;"><a href="">1:1 문의</a></li>
            </ul></li>
          <li style="left: 890px;"><a href="" id="">카테고리6</a>
         <ul>
               <li><a href="">자주묻는 질문</a></li>
               <li style="top: 50px;"><a href="">1:1 문의</a></li>
            </ul></li>
          <li style="left: 890px;"><a href="" id="">카테고리7</a>
         <ul>
               <li><a href="">자주묻는 질문</a></li>
               <li style="top: 50px;"><a href="">1:1 문의</a></li>
            </ul></li>
          <li style="left: 890px;"><a href="" id="">카테고리8</a>
         <ul>
               <li><a href="">자주묻는 질문</a></li>
               <li style="top: 50px;"><a href="">1:1 문의</a></li>
            </ul></li>
          
         
      </ul>
      <!-- 메뉴바 끝 -->

   </div>
	 	
	 </section>
	 
	 <!-- 헤더 상단에 로그인 버튼 -->
	 <script>
	 	function customerService() {
			
		}
	 </script>
	 
	 <!-- 헤더 상단에 회원가입 버튼 -->
	 <script>
	 	function joinMember() {
			
		}
	 </script>
	 
	 <!-- 헤더 상단에 고객센터 버튼 -->
	 <script>
	 	function login() {
			
		}
	 </script>
		
	
	 		
	
	


</body>
</html>
