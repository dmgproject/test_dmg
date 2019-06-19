<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- include libraries(jQuery, bootstrap) -->
<link
	href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css"
	rel="stylesheet">
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
<script
	src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script>

<!-- include summernote css/js -->
<link
	href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote.css"
	rel="stylesheet">
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote.js"></script>


<title>Insert title here</title>
<style>
#test {
	width: 700px;
	height: 700px;
	position: absolute;
	top: 10%;
	left: 50%;
}
</style>
</head>
<body>
	<form action="<%=request.getContextPath()%>/rInsert.re" method="post"
		enctype="multipart/form-data">
		<tr>
			<td width="100px">제목</td>
			<td colspan="3"><input type="text" size="45" name="rename"></td>
		</tr>
		<tr>
			<td>주재료</td>
			<td><input type="text" name="remain"></td>
			<br />
			<td>부재료</td>
			<td><input type="text" name="resub"></td>
			<br />
			<td>수량</td>
			<td><input type="text" name="recount"></td>
			<br />
		</tr>
		<tr>
			<td>대표 이미지</td>
			<td colspan="3">
				<div id="titleImgArea">
					<img id="titleImg" width="350" height="200">
				</div>
			</td>
		</tr>
		<input type="file" id="file" name="file" onchange="LoadImg(this);" />
		<button class="ui primary button" type="submit">추가 고고</button>
		<button class="ui button" onclick="location.href='<%= request.getContextPath() %>/rList.re'">추가 노노</button>

		<div id="test">
			<textarea id="summernote" name="recipe"></textarea>
		</div>
	</form>
	
	<script>
		// 파일 업로드 시 이미지 미리 보기 스크립트
	function readURL(input) {
		 
	    if (input.files && input.files[0]) {
	        var reader = new FileReader();
	 
	        reader.onload = function (e) {
	            $('#titleImg').attr('src', e.target.result);
	        }
	 
	        reader.readAsDataURL(input.files[0]);
	    }
	}
	 
	$("#file").change(function(){
	    readURL(this);
	});
	
	</script>

	<script>
		
	

	
	
	
		$(document).ready(function() {
			$('#summernote').summernote();
		});
		$('#summernote').summernote(
				{
					height : 700, // set editor height
					minHeight : null, // set minimum height of editor
					maxHeight : null, // set maximum height of editor
					focus : true,
					callbacks : {
						onImageUpload : function(files, editor, welEditorble) {
							console.log(files);
							console.log(files[0]);
							data = new FormData();
							data.append("file", files[0]);
							var $note = $(this);
							$.ajax({
								data : data,
								type : "post",
								url : '/DMG/rImage.re', // servlet url
								cache : false,
								contentType : false,
								processData : false,
								success : function(url) {
									//alert(url);
									console.log($note);
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
		
		
		
	</script>

</body>
</html>