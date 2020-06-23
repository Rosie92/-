<%@page import="java.util.ArrayList"%>
<%@page import="poly.util.CmmUtil"%>
<%@page import="java.util.List"%>
<%@page import="poly.dto.BoardDTO"%>
<%@page import="poly.dto.CommentDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    BoardDTO bDTO = (BoardDTO)request.getAttribute("bDTO");
    List<CommentDTO> cList = (List<CommentDTO>) request.getAttribute("cList");
    if(bDTO ==null){
    	bDTO = new BoardDTO();
    }
    %>
<!DOCTYPE html>
<html>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
<title>게시판디테일</title>
<head>
</head>

<header>
<%
	//CmmUtil 붙이기 수정
	String session_id = CmmUtil.nvl((String)session.getAttribute("SS_USER_ID"));
	String seq = CmmUtil.nvl((String)request.getAttribute("seq"));
%>
</header>
<body style="overflow-x: hidden">



	<div style="font-size: 20px; font-weight: 550; width:760px;">
	<div style="text-align:center;display: inline-block; padding: 10px 10px 10px 20px;">제 목</div>
	<div style="display: inline-block; padding: 10px 0px 10px 10px; width: 245px;">
	<div><input type="text" readonly="readonly" name="title" maxlength="100" style="width: 520px; border:none;" value='<%=bDTO.getTitle()%>'></div>
	</div>
	</div>
	<div>
	<div name="content" style="overflow: auto; width: 330px; height: 520px; margin-left: 10px; resize: none; border: 1px solid black; padding:5px 5px 5px 5px"><%=bDTO.getContent() %></div>
	</div>
	
	<!-- ================================================== -->
    <% for(CommentDTO cDTO : cList) { %>
    <div style="background-color: lightyellow;">
             <span>
             	<input type="hidden" value="<%=CmmUtil.nvl(cDTO.getBoard_seq()) %>">
                <input type="hidden" value="<%=CmmUtil.nvl(cDTO.getRno()) %>">
            </span>
            <span style="margin-left:10px;">
            <div style=" width:85px; text-align:center; display:inline-block;">
            <%=CmmUtil.nvl(cDTO.getWriter()) %>
            </div>            
            </span>
            <span style="margin-left:10px">
            <div style="width:350px; text-align:center; display:inline-block;">
            <%=CmmUtil.nvl(cDTO.getContent()).replaceAll("<","&lt;").replaceAll(">","&gt;") %></div>
            </span>
            <span style="margin-left:10px">
            <div style="width:100px; text-align:center; display:inline-block;">
            <%if (session.getAttribute("user_name").equals("조정규")) { %>
            　		<a href="/DExellent/board/BoardReWrite.do?rno=<%=cDTO.getRno() %>">관리</a>	
            <%} else { %>
            <a href="/DExellent/board/BoardReWrite.do?rno=<%=cDTO.getRno() %>">수정/삭제</a>
            <%} %>
            </div>
            </span>
    </div>
          <%} %>

    <div style="overflow-x: hidden">
    <div style="width: 740px; margin: left;">
        <div class="row">
            <div class="col-md-12">

    <div style="width: 750px; margin: auto;">
	<form id="gogo" name="gogo" method="post" action="/DExellent/board/CommentProc.do?seq=<%=CmmUtil.nvl(bDTO.getBoard_seq()) %>">
	<div>
	<textarea id="content" name="content" style="width: 335px; height: 50px; margin-left: 10px; margin-top:10px; resize:none;" placeholder="댓글을 입력해주세요"></textarea>
	</div>
	<div class="form-group" style="width:155px; padding-top: 5px;">
	<div>
    <input type="button" id="submitA" class="btn btn-primary btn-block" readonly="readonly" style="cursor:pointer; margin-left:140px;" value="댓글쓰기"></div>
	</div>
	</form>
	</div>
	</div>
	</div>
	</div>
	</div> 
	<!-- ================================================== -->
	<hr>
	<div style="text-align:center;width:300px; padding-top: 5px;">
	<div>
	<!-- submit이 input에 들어가면 유효성 검사가 실행이X -->
	<% if (session.getAttribute("user_name").equals("조정규")) { %>
	<input type="button" onclick="location.href='/DExellent/board/BoardReWrite.do?seq=<%=seq%>'" class="btn btn-primary btn-block" value="관리자 수정/삭제하기"><br>
	<%} else {%>
	<input type="button" onclick="location.href='/DExellent/board/BoardReWrite.do?seq=<%=seq%>'" class="btn btn-primary btn-block" value="수정/삭제하기"><br>
	<%} %>
	<a href="/DExellent/board/BoardList.do?Pno=1">돌아가기</a>
	</div>
	</div>

<!--     <script src="/js/Board/jquery.min.js"></script> -->
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
 	<script type="text/javascript">
	$(function(){ //window.onload
		var submit = 0;
		console.log(submit);
		
		var rePw = /^[a-zA-Z0-9]{4,12}$/; // userid

		    $("#submitA").click(function() {

		        //userid 를 param.
		        var content =  $("#content").val();
		        console.log(content);

		        if(content == ""){
		            alert("내용을 입력해 주세요.");
		            return false;
		        } /*  
		        else if($("#pw").val()==""){
			    	alert("댓글 비밀번호를 입력해주세요");
			    	$("#pw").focus();
			    	return false;
			    }
		        else if(!rePw.test($("#pw").val())){
			    	alert("비밀번호 형식이 옳지 않습니다.");
			    	$("#pw").focus();
			    	return false;
			    }  */else{
		        //유효성 검사가 끝나면 아이디 f를 찾아서 액션을 실행해라.
		        document.getElementById('gogo').submit();		        
		        }
		        

		 });


	});
	</script> 
</body>
</html>