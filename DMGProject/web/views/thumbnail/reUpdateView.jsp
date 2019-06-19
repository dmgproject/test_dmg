<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.*, com.dmg.jsp.recipe.model.vo.*" %>
<% 
	Recipe r = (Recipe)request.getAttribute("recipe");

	Attachment file = (Attachment)request.getAttribute("file");
	
	ArrayList<RecipeSub> list = (ArrayList<RecipeSub>)request.getAttribute("list");
	
	String resub = "";
	String resubCount = "";
	
	for(int i = 0 ; i < list.size() ; i++ ) {
		
		if(i == list.size()-1) {	
			
			resub += list.get(i).getResub();
			resubCount += list.get(i).getRecount();
			
			} else { 
				
				resub += list.get(i).getResub() + ", "; 
				resubCount += list.get(i).getRecount() + ", ";
				
			}
		
	}
		
		
	
	// ArrayList<BoardComment> clist = (ArrayList<BoardComment>)request.getAttribute("clist");
%>
<!DOCTYPE html>
<html>

<head>
  <meta charset="UTF-8">
  <title>레시피 수정</title>
  <link rel="stylesheet" type="text/css"
  href="../resources/semantic/semantic.min.css">
  <script src="https://code.jquery.com/jquery-3.1.1.min.js"
  integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
  crossorigin="anonymous"></script>
  <script src="../resources/semantic/semantic.min.js"></script>

<!-- include libraries(jQuery, bootstrap) -->
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script> 
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script> 

<!-- include summernote css/js-->
<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.js"></script>
</head>
<style>
  #test {
    width: 700px;
    height: 700px;
    position: absolute;
    top: 10%;
    left: 50%;
  }
  </style>

<body>

    <form action="<%=request.getContextPath()%>/rUpdate.re" method="post"
        enctype="multipart/form-data">
      <tr>
        <td width="100px">레시피명</td>
        <td colspan="3"><input type="text" size="45" name="rename" value="<%= r.getRename() %>"></td>
        <input type="hidden" id="renum" name="renum" value="<%= r.getRenum() %>"/>
      </tr>
      <br /><br />
      <tr>
        <td>주재료</td>
        <td><input type="text" name="remain" value="<%= r.getRemain() %>"></td>
        <br /><br />
        <td>부재료</td>
        <td><input type="text" size= "80" name="resub" value="<%= resub %>"></td>
        <br /><br />
        <td>부재료 수량</td>
        <td><input type="text" size= "80" name="resubcount" value="<%= resubCount %>"></td>
      </tr>
      <br>
      <br>
      <tr>
        <td>대표 이미지</td>
        <td colspan="3">
          <div id="titleImgArea">
            <img id="titleImg" width="350" height="200" src="<%= request.getContextPath() %>/resources/recipeUpload/<%= file.getChangename() %>">
          </div>
        </td>
      </tr>
      <input type="file" id="file" name="file" 
        onchange="loadImg(this);" />
        <br /><br />
        <div id="test">
          <textarea id="summernote" name="recipe"><%= r.getRecipe() %></textarea>
        </div>
        <br /><br />
        
        <button class="ui primary button" type="submit">수정궈궈</button>
        <button class="ui button" onclick="location.href='<%= request.getContextPath() %>/rUpdateView.re?renum='+<%= r.getRenum() %>">수정노노</button>
    
        
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