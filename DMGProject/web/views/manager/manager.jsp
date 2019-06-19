<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">


<script src="/DMG/resources/js/jquery-3.4.1.min.js"></script>
<title>관리자페이지</title>
<style>

.container{
	width: 1200px;
	margin: 0 auto;
}
.managerMenu {
    list-style-type: none;
    margin: 0;
    padding: 0;
    width: 200px;
    background-color: orange;
}
.managerMenu li div {
    display: block;
    color: #000;
    padding: 8px 16px;
    text-decoration: none;
}
.managerMenu li div.active {
    background-color: hotpink;
    color: black;
}
.managerMenu li div:hover:not(.active) {
    background-color: #FF773F;
    color: black;
}
.category select{
	border-radius: 3px; 
	border: 1px solid rgba(34,36,38,.15);
}
.category input{
	border-radius: 3px; 
	border: 1px solid rgba(34,36,38,.15);
	margin-bottom: 15px;
	margin-top: 15px;
}
.category1 button{
	border-radius: 3px; 
	background : none;
	border: 1px solid rgba(34,36,38,.15);
}



</style>

</head>
<body>
	<%@ include file="../common/header.jsp" %>

	<section class="container">
	<div style="width: 200px; height: 30px;">
		<ul class="managerMenu">
	      <li><div onclick="menu1()">카테고리</div></li>
	      <li><div onclick="menu2()">카테고리</div></li>
	      <li><div onclick="menu3()">카테고리</div></li>
	    </ul></div>
	   
	    <div class="category" style="display: inline-block; margin-left: 300px; margin-top: 10px;">    
	    	
	    	<div class="category1"   style="display: inline-block;">
				<span style="display: inline-block; font-size: 13px;">
					<p style=" margin-top:5px; ">상품 분류</p><br>
					<p>등록 상품 명</p><br>
					<p>가격</p><br>
					<p>무게</p><br>
					<p>단위</p><br>
					<p>첨부 파일</p><br>
					<p>상태</p><br>
					<button type="submit">저장</button>
					
					
				</span>
				
				<span class="category1" style="display: inline-block; height: 333px; margin-left: 50px;" >
					<div style=" font-size: 13px;">
					<select>
		                <option value="">대분류</option>
		                <option value="">대분류</option>
		                <option value="">대분류</option>
		                <option value="">대분류</option>
		                <option value="">대분류</option>
		                <option value="">대분류</option>  
					</select>
					<select>
		                <option value="">중분류</option>
		                <option value="">중분류</option>
		                <option value="">중분류</option>
		                <option value="">중분류</option>
		                <option value="">중분류</option>
		                <option value="">중분류</option>  
					</select>
					<select>
		                <option value="">소분류</option>
		                <option value="">소분류</option>
		                <option value="">소분류</option>
		                <option value="">소분류</option>
		                <option value="">소분류</option>
		                <option value="">소분류</option>     
					</select>
					</div><br>
					<input type="text"><br>
					<input type="number"><br>
					<input type="number"><br>
					<input type="number"><br>
					<input type="file"><br>
					<input type="text"><br>
					<button style="font-size: 13px;">취소</button>
				</span>	
			</div>
			
			<div class="category2" style="display: none;">
				<table>
			        <tr>
			          <th>등록 코드</th>
			          <th><input type="text"></th>
			        </tr>
			        <tr>
			          <th>상품 분류</th>
			          <td><select>
		                <option value="">대분류</option>
		                <option value="">대분류</option>
		                <option value="">대분류</option>
		                <option value="">대분류</option>
		                <option value="">대분류</option>
		                <option value="">대분류</option>  
					</select>
					<select>
		                <option value="">중분류</option>
		                <option value="">중분류</option>
		                <option value="">중분류</option>
		                <option value="">중분류</option>
		                <option value="">중분류</option>
		                <option value="">중분류</option>  
					</select>
					<select>
		                <option value="">소분류</option>
		                <option value="">소분류</option>
		                <option value="">소분류</option>
		                <option value="">소분류</option>
		                <option value="">소분류</option>
		                <option value="">소분류</option>     
					</select></td>
			        </tr>
			        <tr>
			          <th>등록 상품 명</th>
			          <td><input type="text"></td>
			        </tr>
			        <tr>
			          <th>가격</th>
			          <td><input type="number"></td>
			        </tr>
			        <tr>
			          <th>무게</th>
			          <td><input type="number"></td>
			        </tr>
			        <tr>
			          <th>단위</th>
			          <td><input type="text"></td>
			        </tr>
			        <tr>
			          <th>첨부 파일</th>
			          <td><input type="file"></td>
			        </tr>
			        
			    </table>
			</div>
			
			<div class="category3" style="display: none;">
				<table>
			        <tr>
			          <th>등록 코드<br>
			          	    상품 분류<br>
			          	    등록 상품 명<br>
			          	    가격<br>
			          	    무게<br>
			          	    단위<br>
			          	    첨부 파일<br>
			          </th>
			          <th>
			          	  <input type="text"><br>
			          	  <select>
		                <option value="">대분류</option>
		                <option value="">대분류</option>
		                <option value="">대분류</option>
		                <option value="">대분류</option>
		                <option value="">대분류</option>
		                <option value="">대분류</option>  
					</select>
					<select>
		                <option value="">중분류</option>
		                <option value="">중분류</option>
		                <option value="">중분류</option>
		                <option value="">중분류</option>
		                <option value="">중분류</option>
		                <option value="">중분류</option>  
					</select>
					<select>
		                <option value="">소분류</option>
		                <option value="">소분류</option>
		                <option value="">소분류</option>
		                <option value="">소분류</option>
		                <option value="">소분류</option>
		                <option value="">소분류</option>     
					</select><br>
						  <input type="number"><br>
						  <input type="number"><br>
					      <input type="text"><br>
					      <input type="file"><br>
					      <input type="text"><br>
					  </th>
			  </tr>
			    </table>
			</div>
			
	    </div>
    </section>
    
    <script>
   /*  $(document).ready(function() {
    	$('.news').show(); //페이지를 로드할 때 표시할 요소
    	$('.contact').hide(); //페이지를 로드할 때 숨길 요소
    	$('.about').hide();	//페이지를 로드할 때 숨길 요소
    	
    	$('.news').click(function(){
    		$ ('.news').show(); 
    		$('.contact').hide();
    		$('.about').hide();
    		return false; });
    	});
    
	    $('.contact').click(function(){
			$ ('.contact').show();
			$('.news').hide();
			$('.about').hide();
			return false; });
		});
		
		$('.about').click(function(){
    		$ ('.about').show(); //클릭 시 두 번째 요소 표시
    		$('.news').hide();
    		$('.contact').hide();
    		return false; });
    	}); */
    	
    	function menu1() {
    		$('.category1').show(); 
    		$('.category2').hide();
    		$('.category3').hide();
		}
    	
    	function menu2() {
    		$('.category2').show(); 
    		$('.category1').hide();
    		$('.category3').hide();
		}
    	
    	function menu3() {
    		$ ('.category3').show(); 
    		$('.category1').hide();
    		$('.category2').hide();
		}
    </script>
  
<br><br><br><br><br>
	<%@ include file="../common/footer.jsp" %>
</body>
</html>