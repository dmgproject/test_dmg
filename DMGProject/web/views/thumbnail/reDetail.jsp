<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.dmg.jsp.recipe.model.vo.*" %>
<% 
	Recipe r = (Recipe)request.getAttribute("recipe");

	Attachment file = (Attachment)request.getAttribute("file");
	
	ArrayList<RecipeSub> list = (ArrayList<RecipeSub>)request.getAttribute("list");
	
	// ArrayList<BoardComment> clist = (ArrayList<BoardComment>)request.getAttribute("clist");
%>
<!DOCTYPE html>



<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" type="text/css"
    href="<%= request.getContextPath() %>/resources/semantic/semantic.min.css">
<script src="https://code.jquery.com/jquery-3.1.1.min.js"
    integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
    crossorigin="anonymous"></script>
<script src="<%= request.getContextPath() %>/resources/semantic/semantic.min.js"></script>


</head>
<body>


    <div class="remain1" style="position:relative; left: 250px; margin-top: 2%; margin-bottom: 2%;">
    
	<!-- 대표이미지 불러오기 -->
    <div  style="margin-bottom: 1%">
        <img class="ui big bordered rounded image" src="<%= request.getContextPath() %>/resources/recipeUpload/<%= file.getChangename() %>" style="width: 700px; border-radius: 50px; padding: 2px">

    </div>
    
    
    <div>
    	<!-- 영양 정보 테이블 시작 -->
        <table class="ui yellow table" style="position: relative;  text-align: center; width: 700px;" >
            <thead>
              <tr>
              <th><font style="vertical-align: inherit;">영양정보</font></th>
              <th><font style="vertical-align: inherit;">(하루 적정섭취량, 1인분 기준)</font></th>
              
                </tr></thead><tbody>

              <tr>
                <td><font style="vertical-align: inherit;">칼로리</font></td>
                <td><font style="vertical-align: inherit;">136.7kal</font></td>
               
              </tr>
              
              <tr>
                <td><font style="vertical-align: inherit;">탄수화물</font></td>
                <td><font style="vertical-align: inherit;">12.6%</font></td>
                   
              </tr>
                  
              <tr>
                <td><font style="vertical-align: inherit;">단백질</font></td>
                <td><font style="vertical-align: inherit;">45.9%</font></td>
               
              </tr>
              
              <tr>
                <td><font style="vertical-align: inherit;">지질</font></td>
                <td><font style="vertical-align: inherit;">48.1%</font></td>
                   
                </tr>


            <tr>
                <td><font style="vertical-align: inherit;">나트륨</font></td>
                <td><font style="vertical-align: inherit;">52.1%</font></td>
                       
            </tr>
             
            <tr>
                <td><font style="vertical-align: inherit;">콜레스테롤</font></td>
                <td><font style="vertical-align: inherit;">33.0%</font></td>
                           
            </tr>                
            <tr>
                <td><font style="vertical-align: inherit;">식이섬유</font></td>
                <td><font style="vertical-align: inherit;">13.4%</font></td>
                           
            </tr>
            <tr>
                <td><font style="vertical-align: inherit;">칼슘</font></td>
                <td><font style="vertical-align: inherit;">52.1%</font></td>
                           
            </tr>
            <tr>
                <td><font style="vertical-align: inherit;">비타민c</font></td>
                <td><font style="vertical-align: inherit;">52.1%</font></td>
                           
            </tr>
            </tbody>
        </table> <!-- 영양 정보 테이블 끝 -->
    </div>
    
    <br>
    
    <!-- RECIPE 내용 들어가는 곳 -->
    <div class="ui segment" style="width: 700px;">
        <%= r.getRecipe() %>
    </div>
    <br>

    <div>
        <h3>한줄 댓글</h3>
        <div class="ui action input" style="width: 700px;">
            <input type="text" placeholder="한 줄 댓글을 남겨주세요." style="width: 580px; height:200% ">
            <button class="ui orange button"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">댓글남기기</font></font></button>
        </div>
        <div class="ui olive message" style="width : 700px;">김삿갓 : 댓글 내용  <button class="mini ui button" style="position: relative; left: 500px;">삭제</button>
        </div>

        

    </div>
    
    <div>
    <br />
    
    	<button class="ui medium teal button"
    		onclick="location.href='<%= request.getContextPath() %>/rList.re'">
    		<font style="vertical-align: inherit;">목록으로</font></button>
    
    </div>
   
    
    <!-- 수정/삭제 버튼 관리자 로그인 시 보이도록 해야함. -->
    <div>
    <br />
    <button class="ui inverted orange button" style="position: absolute; left:250px;"
    		onclick="location.href='<%= request.getContextPath() %>/rUpdateView.re?renum='+<%= r.getRenum() %>">수정하기</button>
    <button class="ui inverted red button" style="position: absolute; left:360px;" 
    		onclick="delModal();">삭제하기</button>
    <br />
	</div>
	
	
	<!-- 삭제하기 모달 부분 -->
	<div class="ui mini modal">
  <div class="header">
	게시글 삭제
  </div>
    <div class="content">
      <p>정말 게시글을 삭제하시겠습니까?</p>
      <p>삭제한 글은 되돌릴 수 없다!!</p>
    </div>
  <div class="actions">
    <div class="ui black deny button">
		안삭
    </div>
    <div class="ui positive right labeled icon button" onclick="location.href='<%= request.getContextPath() %>/rDelete.re?renum='+<%= r.getRenum() %>">
		삭제하자
      <i class="checkmark icon"></i>
    </div>
  </div>
</div>
	<script>
	 function delModal(){$('.mini.modal').modal('show');}
	 
	 
	 
	</script>
	
	
    </div>


	<!-- 페이지 우측  -->
    <div class="remain1" style="position: fixed; top:0px; left: 1000px; width:300px; height: 1000px; overflow:auto; background-color: rgb(251, 253, 226);  ">
        <div>
        <!-- 로고 -->
        <img src="<%= request.getContextPath() %>/resources/images/dmgBIps.png" style="width: 250px; height: 250px; margin-top: 30px; margin-bottom: 0px; margin-left: 25px;" alt="">
        </div>
        
        <!-- 부재료 테이블 div -->
        <div style="position: relative; top: 25px; overflow: auto;">
            
            <table class="ui inverted yellow table" style="text-align: center;" >
                <thead>
                    <tr>
                    <th>재료명</th>
                    <th>사용량</th>
	                </tr>
                </thead>
                <tbody id="resub-tbody">
                
                <% for(int i = 0 ; i < list.size() ; i ++ ) { %>
                
                <tr>
                <td><%= list.get(i).getResub() %></td>
                <td><%= list.get(i).getRecount() %></td>
                </tr>
                
                <% } %>
                
                </tbody>
                
                
            </table>

        </div>
        
        
        
        
        
    </div>

	


    
   




</body>
</html>