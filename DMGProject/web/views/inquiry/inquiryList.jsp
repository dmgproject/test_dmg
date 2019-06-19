<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.dmg.jsp.inquiry.model.vo.*, java.util.*"%>
<% 
	ArrayList<Inquiry> list = (ArrayList<Inquiry>)request.getAttribute("list"); 
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	int listCount = pi.getListCount();
	int currentPage = pi.getCurrentPage();
	int maxPage = pi.getMaxPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
%>
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
<title>문의 사항</title>
<style>
.outer{
		width:900px;
		height:600px;
		/* background:black;  */
		color:black;
		margin-left:auto;
		margin-right:auto;
		margin-top:50px;
	}
	table {
		padding : 20px;
		border-top : 1px solid gray;
		text-align:center;
	}
	.tableArea {
		width:750px;
		height:350px;
		margin-left:auto;
		margin-right:auto;
	}
	.searchArea {
		width:650px;
		margin-left:auto;
		margin-right:auto;
	}
	#listArea{
	 border-bottom: 1px solid gray;
	}
	.pageBtn{
	border: 0px solid white;
	background: none;
	margin: 1px;
	}
	
	.searchArea div{
	border-bottom: 1px solid gray;
	}
	
	/* 플로팅 광고 css */
	.floating { 
	/* background-color:#ff6a00;  */
	border:2px solid #ff6a00; 
	position: fixed; 
	right: 50%; 
	top: 180px; 
	margin-right: -615px; 
	text-align:center; 
	width:70px; 
	border-radius: 8px; 
	-webkit-border-radius: 8px; 
	} 
	.floating div:nth-child(1){ 
	border:1px solid gray; 
	border-radius: 8px; 
	} 
	.floating div:nth-child(2){ 
	border:1px solid gray; 
	border-radius: 8px; 
	} 
	.floating div:nth-child(3){ 
	border:1px solid gray; 
	border-radius: 8px; 
	}

</style>
</head>
<body>
	<%@ include file="../common/header.jsp" %>
	<div class="outer">
		
		<h2 align="center"><%= request.getParameter("btnValue") %> 임시 게시판</h2>
		<div class="tableArea">
			<table align="center" id="listArea">
			<tr>
				<th width="100px">글번호</th>
				<th width="300px">글제목</th>
				<th width="100px">작성자</th>
				<th width="150px">작성일</th>
				<th width="100px">조회수</th>
	<!-- 		<th width="100px">첨부파일</th> -->
			</tr>
			<% for(Inquiry i : list){ %>
			<tr>
				<input type="hidden" value="<%= i.getIno() %>"/>
				<td><%= i.getIno() %></td>
				<td><%= i.getItitle() %></td>
				<td><%= i.getIwriter() %></td>
				<td><%= i.getIdate() %></td>
				<td><%= i.getIcount() %></td>
				<%-- <% if( i.getInquiryfile() != null) { %>
				<td></td>
				<%} else { %>
				<td> X </td>
				<% } %> --%>
			</tr>
			<% } %>
		</table>
		</div>
		
		
		<%-- 페이지 처리 --%>
		  
		<div class="pagingArea" align="center" style="border-bottom: 1px solid #ddd; padding-bottom: 10px; width:800px;
			margin-left: 70px;">
			<button class="pageBtn" onclick="location.href='<%= request.getContextPath() %>/selectList.iq?currentPage=1'"><<</button>
			<%  if(currentPage <= 1){  %>
			<button class="pageBtn" disabled><</button>
			<%  }else{ %>
			<button class="pageBtn" onclick="location.href='<%= request.getContextPath() %>/selectList.iq?currentPage=<%=currentPage - 1 %>'"><</button>
			<%  } %>
			
			<% for(int p = startPage; p <= endPage; p++){
					if(p == currentPage){	
			%>
				<button class="pageBtn" disabled><%= p %></button>
			<%      }else{ %>
				<button class="pageBtn" onclick="location.href='<%= request.getContextPath() %>/selectList.iq?currentPage=<%= p %>'"><%= p %></button>
			<%      } %>
			<% } %>
				
			<%  if(currentPage >= maxPage){  %>
			<button class="pageBtn" disabled>></button>
			<%  }else{ %>
			<button class="pageBtn" onclick="location.href='<%= request.getContextPath() %>/selectList.iq?currentPage=<%=currentPage + 1 %>'">></button>
			<%  } %>
			<button class="pageBtn" onclick="location.href='<%= request.getContextPath() %>/selectList.iq?currentPage=<%= maxPage %>'">>></button>
	
		
		<%-- <div class="searchArea" align="center">
			<select id="searchCondition" name="searchCondition">
				<option>---</option>
				<option value="writer">작성자</option>
				<option value="title">제목</option>
				<option value="content">내용</option>
			</select>
			<input type="search">
			<button type="submit">검색하기</button>
			<% if(m != null){ %>
				<button onclick="location.href='views/inquiry/inquiryInsertForm.jsp'">작성하기</button>
			<% } %> --%>
		
		</div>	
			
		<div class="ui action input searchArea" align="center" style=" margin-top: 20px; width: 1200px;" >
		<span>
		<select id="searchCondition" name="searchCondition" style="border-radius: 3px; 
				border: 1px solid rgba(34,36,38,.15); margin-left: 300px;">
				<option value="">---</option>
				<option value="writer">작성자</option>
				<option value="title">제목</option>
				<option value="content">내용</option>
		</select>
		<input type="search" style="border-radius: 3px; border: 1px solid rgba(34,36,38,.15);">
		<!-- <img src="/DMG/resources/images/search_icon.png" style="width: 18px; height: 18px; padding-top: 2px;"> -->
		<!-- <input type="text" style="width: 500px; " placeholder="Search..."> -->
		<i class="circular search link icon" onclick="searchInquiry()"></i>
		</span>
		</div>
		
		<!-- 플로팅 메뉴 -->
		<div class="floating"> 
			<div>광고1</div> 
			<div>광고2</div> 
			<div>광고3</div>
		</div>

			
	</div> 

	
	<script>
		$(function(){
			$("#listArea td").mouseenter(function(){
				$(this).parent().css({"background":"darkgray", "cursor":"pointer"});
			}).mouseout(function(){
				$(this).parent().css({"background":"black"});
			}).click(function(){
				var bno = $(this).parent().find("input").val();
				location.href="<%=request.getContextPath()%>/selectOne.iq?ino=" + ino;
			});
		});
	</script>
	
	<!-- 하단의 검색버튼 -->
	<script>
		function searchInquiry() {
			location.href="<%=request.getContextPath()%>/searchNotice.no?con=
				"+$('#searchCondition').val()+"&keyword="+$('#keyword').val();
		}
	</script>
	<%@ include file="../common/footer.jsp" %>
</body>
</html>