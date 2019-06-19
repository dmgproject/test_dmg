<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.dmg.jsp.inquiry.model.vo.*"%>
 <% Inquiry i = (Inquiry)request.getAttribute("inquiry"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
	.outer{
		width:800px;
		height:500px;
		background:black;
		color:white;
		margin-left:auto;
		margin-right:auto;
		margin-top:50px;
	}
	
	td {
		border:1px solid white;
	}

	.tableArea {
		border:1px solid white;
		width:800px;
		height:360px;
		margin-left:auto;
		margin-right:auto;
	}
	.tableArea table {
		width : 600px;
	}
	#content {
		height:230px;
	}
</style>
<title>게시글 수정 페이지</title>
</head>
<body>
<%@ include file="../common/header.jsp" %>
	<div class="outer">
		<br>
		<h2 align="center">게시글 수정 페이지</h2>
		<div class="tableArea">
			<form id="updateForm" method="post" enctype="multipart/form-data">
				<table align="center">
					<tr>
						<td>제목 </td>
						<td colspan="3">
							<input type="text" size="65" name="title" value="<%=i.getItitle() %>">
							<input type="hidden" name="ino" value="<%=i.getIno()%>">
						</td>
					</tr>
					<tr>
						<td>작성자 </td>
						<td colspan="3"><%= i.getIwriter() %></td>
					</tr>
					<% if(i.getInquiryfile() != null){ %>
					<tr>
						<td>기존 파일 </td>
						<td colspan="3">
							<a href="/myWeb/ifdown.iq?path=<%=i.getInquiryfile()%>">
							<%=i.getInquiryfile()%></a>	
						</td>
					</tr>
					<% } %>
					<tr>
						<td>새 파일 </td>
						<td colspan="3">
							<input type="file" name="file" id="file" />
						</td>
					</tr>
					<tr>
						<td>내용 </td>
						<td colspan="3">
							<textarea name="content" cols="67" rows="15" style="resize:none;"><%=i.getIcontent() %></textarea>
						</td>
					</tr>
				</table>
				<br>
				<div align="center">
					<button onclick="complete();">수정완료</button>
					<button onclick="deleteInquiry();">삭제하기</button>
				</div>
				<script>
					function complete(){
						$("#updateForm").attr("action","<%= request.getContextPath()%>/iUpdate.iq");
					}
					
					function deleteInquiry(){
						$("#updateForm").attr("action","<%= request.getContextPath()%>/iDelete.iq");
					}
				
				</script>
			</form>
	</div>
	</div>
	<%@ include file="../common/footer.jsp" %>
</body>
</html>