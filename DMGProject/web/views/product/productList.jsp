<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.* , com.dmg.jsp.product.model.vo.ProCategory , com.dmg.jsp.product.model.vo.Product,
	com.dmg.jsp.common.*"%>
<%
	ArrayList<Product> products = (ArrayList<Product>) request.getAttribute("products");
	
	String filePath = "resources/productUpload/";
	String category = (String) request.getAttribute("category");
	String keyword = (String) request.getAttribute("keyword");
	PageInfo pi = (PageInfo) request.getAttribute("pi");
	int listCount = pi.getListCount();
	int currentPage = pi.getCurrentPage();
	int maxPage = pi.getMaxPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
%>
<!DOCTYPE html>
<html>
<head>
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>

<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<meta charset="UTF-8">
<title>상품 리스트</title>
<style>
#page {
	text-align: center;
}

.thumbnail {
	width: 200px;
	height: 200px;
	align: center;
	background-color: #e6e6e6;
}

.body {
	margin-left: 10px;
}

.searchDiv {
	text-align: center;
	align: center;
}
.pagination{
	text-align:center;
	width:100%;
}
.btn-group {
	background-color : white;
	text-align:center;
	border : none;
	color:orange;
	font-size:18pt;
	padding-left:4%;
	
}

.product {
	border: 1px solid #E6E6E6;
	padding-top: 1%;
	width: 240px;
	height: 350px;
	text-align: left;
	align: center;
	margin-top: 20px;
	margin-right: 2%;
	margin-left: 2%;
	width: 240px;
	color: black;
}

#proHeader {
	padding-top: 10px;
	text-align: center;
}

.content {
	
}
</style>
</head>
<body>
	<%@ include file="../common/header.jsp"%>

	<section id="productListSec" class="container body col-10">
		<div class="col-lg-6 searchDiv">
			<div class="input-group">
				<input type="text" class="form-control" name="keyword" id="keyword"
					placeholder="Search for..."> <span class="input-group-btn ">
					<button class="btn btn-default" id="searchBtn">
						<span class="glyphicon glyphicon-search"></span>
					</button>
				</span>
			</div>
			<!-- /input-group -->
		</div>
		<br>
		<!-- /.col-lg-6 -->
		<div id="proHeader">
			<h2><%=category%></h2>
		</div>

		<%
			for (Product p : products) {
		%>
		<a href="#">
			<div class="product col-sm-3" id="product">
				<input type="hidden" value="<%= p.getPid() %>" id="pid" name="pid">
				<img class="thumbnail" src="<%=filePath + p.getPfile()%>">
				<div class="content">
					<h4>
						<%=p.getPid() %>
						<%=p.getPname()%>
					</h4>
					<h3><%=p.getPprice()%><small> 원</small>
					</h3>
				</div>
			</div> <%
 	}
 %>
		</a>
		<!-- 	<form id="pInfo" action="${pageContext.request.contextPath}/pInsert.do"
		method="post" enctype="multipart/form-data">
	</form>
 -->

	</section>
	<%-- 페이지 처리 --%>
	<div class="pagination" align="center">
		<button class="btn-group"
			onclick="location.href='<%=request.getContextPath()%>/pList.do?currentPage=1'"><<</button>
		<%
			if (currentPage <= 1) {
		%>
		<button disabled class="btn-group"><</button>
		<%
			} else {
		%>
		<button class="btn-group"
			onclick="location.href='<%=request.getContextPath()%>/pList.do?currentPage=<%=currentPage - 1%>'"><</button>
		<%
			}
			for (int p = startPage; p <= endPage; p++) {
				if (p == currentPage) {
		%>
		<button disabled class="btn-group"><%=p%></button>
		<%
			} else {
		%>
		<button class="btn-group"
			onclick="location.href='<%=request.getContextPath()%>/pList.do?currentPage=<%=p%>'"><%=p%></button>
		<%
			}

			}
			if (currentPage >= maxPage) {
		%>
		<button disabled class="btn-group">></button>
		<%
			} else {
		%>
		<button class="btn-group"
			onclick="location.href='<%=request.getContextPath()%>/pList.do?currentPage=<%=currentPage + 1%>'">></button>
		<%
			}
		%>
		<button class="btn-group"
			onclick="location.href='<%=request.getContextPath()%>/pList.do?currentPage=<%=maxPage%>'">>></button>

	</div>
	<script>
		$("#searchBtn").click(
						function() {
							var keyword = $("#keyword").val();
							location.href = '${pageContext.request.contextPath}/pList.do?keyword='
									+ keyword;
						});
		
		$(".product").click(function(){
			var pid = $(this).children().eq(0).val();
			console.log(pid);
			location.href="<%=request.getContextPath()%>/pSelectOne.do?pid="+pid;
		});
	</script>
	<%@ include file="../common/footer.jsp"%>
</body>
</html>