<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.* , com.dmg.jsp.product.model.vo.ProCategory"%>
<!-- include libraries(jQuery, bootstrap) -->
<%
	ArrayList<ProCategory> llist = (ArrayList<ProCategory>) request.getAttribute("llist");
	ArrayList<ProCategory> mlist = (ArrayList<ProCategory>) request.getAttribute("mlist");
	ArrayList<ProCategory> slist = (ArrayList<ProCategory>) request.getAttribute("slist");
%>
<!DOCTYPE html>
<html>
<head>
<style>
#body {
}

.list-group {
	font-size: 12pt;
}

.btn-md {
	width: 120px;
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<link
	href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css"
	rel="stylesheet">
<script
	src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script>

<!-- include summernote css/js-->
<link
	href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.css"
	rel="stylesheet" type="text/css">
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.js"></script>



</head>
<body>
	<%@ include file="../common/header.jsp"%>

	<section class="container" id="body">
		<div class="page-header">
			<h1>상품 추가 페이지</h1>
		</div>
		<form id="pInfo"
			action="${pageContext.request.contextPath}/pInsert.do" method="post"
			enctype="multipart/form-data">
			<!-- enctype="multipart/form-data"> -->
			<div id="category" class="list-group">
				상품 분류 <select name="categoryL" id="categoryL">
					<option value="init">대분류</option>
					<%
						for (int i = 0; i < llist.size(); i++) {
					%>
					<option value="<%=llist.get(i).getPcid()%>"><%=llist.get(i).getPcname()%></option>
					<%
						}
					%>

				</select> <select name="categoryM" id="categoryM">
					<option value="init">중분류</option>

				</select> <select name="categoryS" id="categoryS">
					<option value="init">소분류</option>
				</select>

			</div>


			<div id="divPname" class="list-group">
				상품 이름 <input type="text" name="pname" id="pname">
			</div>
			<div id="divPprice" class="list-group">
				가격  <input type="number" name="pprice" id="pprice">
			</div>
			<div id="divWeight" class="list-group">
				무게 <input type="number" name="pweight" id="pweight">
			</div>
			<div id="divUnit" class="list-group">
				단위  <input type="text" name="punit" id="punit">
			</div>

			<div id="pfile" class="list-group">
				메인 사진 <input type="file" name="mfile" id="mSfile">
			</div>

			<textarea class="summernote" id="summernote" name="summernote"></textarea>

			<div class="btns" align="center">
				<button id="resetBtn" type="reset" class="btn btn-md btn-default">취소하기</button>

				<button id="insertBtn" type="submit" class="btn btn-md btn-warning">저장</button>
			</div>
		</form>
	</section>
	<script>
		var $note = $('#summernote').summernote();
		$('#summernote').summernote(
				{
					height : 700, // set editor height
					width : 1200,
					minHeight : null, // set minimum height of editor
					maxHeight : null, // set maximum height of editor
					focus : true,
					callbacks : {
						onImageUpload : function(files, editor, welEditorble) {
							data = new FormData();
							data.append("file", files[0]);
							//var $note = $(this);
							$.ajax({
								data : data,
								type : "post",
								url : "/DMG/pImgUpload.do", // servlet url
								cache : false,
								contentType : false,
								processData : false,
								success : function(url) {
									alert(url);
									$note.summernote('insertImage', url);
								},
								error : function(request, status, error) {
									alert("code:" + request.status + "\n"
											+ "message:" + request.responseText
											+ "\n" + "error:" + error);
								}
							});
						}
					}
				});

		$(document).on("click", "#splus", function() {
			$("#sdiv").css("color", "red");
			var copySdiv = $("#sdiv").clone();
			$("#sdivWrap").append(copySdiv).val("");
			console.log($("#sdiv").length);
		});
		$(document).on("click", "#sdelete", function() {
			$(this).parent().remove();
		});

		$(document).on("click", "#pplus", function() {
			$("#pdiv").css("color", "red");
			var copySdiv = $("#pdiv").clone();
			$("#pdivWrap").append(copySdiv).val("");
			console.log($("#pdiv").length);
		});
		$(document).on("click", "#pdelete", function() {
			$(this).parent().remove();
		});

		$(document).ready(function() {

		})
		$("#categoryL").change(function() {
			$.ajax({
				url : "/DMG/cMselect.do",
				type : "get",
				data : {
					selectedL : $("#categoryL option:selected").val()
				},
				success : function(data) {
					console.log("성공");
					console.log(data);
					$select = $('#categoryM');
					$select.find('option').remove();
					$select.append('<option>중분류</option>');
					for ( var index in data) {
						console.log(data[index].pcid);
						console.log(index);
						var $option = $('<option>');
						$option.val(data[index].pcid);
						$option.text(data[index].pcname);
						$select.append($option);
					}
				},
				error : function() {
					console.log("실패");
				}
			});
		});

		$("#categoryM").change(function() {
			$.ajax({
				url : "/DMG/cSselect.do",
				type : "get",
				data : {
					selectedL : $("#categoryL option:selected").val(),
					selectedM : $("#categoryM option:selected").val()
				},
				success : function(data) {
					console.log("성공");
					console.log(data);
					$select = $('#categoryS');
					$select.find('option').remove();
					$select.append('<option>소분류</option>');
					for ( var index in data) {
						console.log(data[index].pcid);
						console.log(index);
						var $option = $('<option>');
						$option.val(data[index].pcid);
						$option.text(data[index].pcname);
						$select.append($option);
					}
				},
				error : function() {
					console.log("실패");
				}
			});
		});
		function goMain() {

		}
	</script>






	<%@ include file="../common/footer.jsp"%>
</body>
</html>