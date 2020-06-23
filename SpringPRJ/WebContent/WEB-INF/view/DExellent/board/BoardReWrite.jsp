<%@page import="java.util.ArrayList"%>
<%@page import="poly.util.CmmUtil"%>
<%@page import="java.util.List"%>
<%@page import="poly.dto.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%
    BoardDTO pDTO = (BoardDTO) request.getAttribute("pDTO");
        
        if(pDTO ==null){
        	pDTO = new BoardDTO();
        }
        
    String content = CmmUtil.nvl(pDTO.getContent());
	%>
<html>


<head>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<link rel="stylesheet" href="/bootstrap/Board/css/bootstrap.min.css">
<link rel="stylesheet" href="/fonts/font-awesome.min.css">
<link rel="stylesheet" href="/css/Board/Forum---Thread-listing-1.css">
<link rel="stylesheet" href="/css/Board/Forum---Thread-listing.css">
<link rel="stylesheet" href="/css/Board/styles.css">


    <title>자유게시판 수정</title>
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
    <script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script>
    <!-- include summernote css/js-->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.11/summernote-bs4.css" rel="stylesheet">    
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Cookie">
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Nanum+Gothic">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.11/summernote-bs4.js"></script>
    <!-- include summernote-ko-KR -->
    <script src="/summernote/js/summernote-ko-KR.js"></script>
    <script>
	
        $(document).ready(function () {
        	document.querySelector('#summernote').value='<%=content%>';
            $('#summernote').summernote({
                placeholder: '내용을 입력해 주세요.',
                minHeight: 370,
                maxHeight: null,
                focus: true,
                lang: 'ko-KR',
                onImageUpload : function(files, editor, welEditable) {
                    sendFile(files[0], editor, welEditable);
                }
            });

            function sendFile(file, editor, welEditable) {
                data = new FormData();
                data.append("uploadFile", file);
                $.ajax({
                    data : data,
                    type : "POST",
                    url : "/imageUpload",
                    cache : false,
                    contentType : false,
                    processData : false,
                    success : function (data) {
                        editor.insertImage(welEditable, data.url);
                    }
                })
            }
        });

    </script>
</head>
<header>
<%
	String seq = CmmUtil.nvl((String)request.getAttribute("seq"));
	String user_name = CmmUtil.nvl((String)session.getAttribute("user_name"));
/* 	String upd_date = CmmUtil.nvl((String)request.getAttribute("upd_date")); */
%>

</header>
<body style="overflow-x: hidden">
	<form method="post" action="/DExellent/board/BoardReWriteTry">
	<input value="<%=seq %>" name="seq" hidden="hidden">
	<div>
	<div style="font-size: 20px; font-weight: 550; width:760px;">
	<div style="text-align:center;display: inline-block; padding: 10px 50px 10px 50px;">제 목</div>
	<div style="display: inline-block; padding: 10px 0px 10px 50px; width: 545px;">
	<div><input type="text" name="title" id="title" maxlength="100" style="width: 521px" placeholder="제목을 입력해주세요" value='<%=CmmUtil.nvl(pDTO.getTitle()) %>'></div>
	</div>
	</div>
	<div>
	<textarea id="summernote" name="content" style="width: 748px; height: 520px; margin-left: 5px; resize:none;"></textarea>
	</div>
	
	<div style="text-align:center;width:755px; padding-top: 5px;">
	<div class="form-group" id="submit"> <!-- submit이 input에 들어가면 유효성 검사가 실행이X -->
        <input type="submit" id="subBtn" class="btn btn-primary btn-block" readonly="readonly" style="cursor:pointer;" value="작성완료"></div>
        	<a class="forgot" href="/DExellent/board/BoardDelete.do?seq=<%=seq%>">이 게시글 삭제하기 /<font color="red"> (주의)클릭 시 즉시 삭제됩니다.</font></a><br>
   			 <a class="forgot" href="/DExellent/board/BoardList.do?Pno=1" >게시판으로 돌아가기</a>

	</div>
	</div>
  
	</form>

<script>
    $('#subBtn').click(function () {
        var title = $('#title').val();
        var content = $('#summernote').val();
  /*       var board_pw = $('#board_pw').val(); */

        if(title==""){
            alert("제목을 입력해 주세요.");
            return false;
            $('#title').focus();
        }
        else if(content==""){
            alert("내용을 입력해 주세요.");
            return false;
            $('#content').focus();
        }
/*         else if(board_pw==""){
            alert("비밀번호를 입력해 주세요.");
            return false;
            $('#board_pw').focus();
        } */
    });
</script>

</body>
</html>











