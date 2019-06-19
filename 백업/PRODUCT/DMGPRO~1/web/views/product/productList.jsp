<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.* , com.dmg.jsp.product.model.vo.ProCategory , com.dmg.jsp.product.model.vo.Product"%>
<%
	ArrayList<Product> products = (ArrayList<Product>) request.getAttribute("products");
	String filePath = "resources/productUpload/";
	String category = (String)request.getAttribute("category");
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
.thumbnail {
	width: 200px;
	height: 200px;
	align: center;
	background-color: #e6e6e6;
}

.body {
	margin-left: 10px;
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

#proHeader{
	padding-top:10px;
	text-align:center;
}
.content {
	
}
</style>
</head>
<body>
	<%@ include file="../common/header.jsp"%>

	<section id="productListSec" class="container body col-10">

		<div id="proHeader">
			<h2><%=category  %></h2>
		</div>

		<%
			for (Product p : products) {
		%>
		<a href="#">
			<div class="product col-sm-3" id="product">

				<img class="thumbnail" src="<%=filePath + p.getPfile()%>">
				<div class="content">
					<h4>
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
	<script>
		
	</script>






	<%@ include file="../common/footer.jsp"%>
</body>
</html>