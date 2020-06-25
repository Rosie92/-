<%@page import="java.util.List"%>
<%@page import="poly.dto.InformationDTO"%>
<%
	List<InformationDTO> aList = (List<InformationDTO>) request.getAttribute("aList");
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="/js/jquery-3.4.1.min.js"></script>
<!-- <script type="text/javascript">
	$(window).on("load", function() {
		//페이지 로딩 완료 후, 크롤링 정보 가져오기 함수 실행함
		getInformation();
	});

	// 크롤링 정보 가져오기
	function getInformation() {

		//Ajax 호출
		$.ajax({
			url : "/DExellent/getInformation.do",
			type : "post",
			dataType : "JSON",
			contentType : "application/json; charset=UTF-8",
			success : function(json) {
				
				console.log(json.length);

				var Information = "";

				for (var i = 0; i < json.length; i++) {
					Information += (json[i].information);
				}
				$('#Information').html(Information);
			}
		})
	}
</script> -->
<title>Information</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body style="width: 347px;">
	<div style="overflow-x: hidden">
		<br>
		<%
			for (int i = 0; i < 14; i++) {
		%>
		<div style='display: inline-block; width: 100%; line-height: 10px;'>
			<button data-toggle='modal' data-target='#intro<%=i%>'
				style="background-color: white; border: 0px;">
				<img src='../../assets/img/DEIMG/dog/a<%=i%>.jpg' width='330px'
					height='210px'
					style='display: inline-block; vertical-align: middle;'>
				<%
					String a = "";
				if (i == 0) {
					a = "골든 리트리버";
				} else if (i == 1) {
					a = "래브라도 리트리버";
				} else if (i == 2) {
					a = "말티즈";
				} else if (i == 3) {
					a = "보더콜리";
				} else if (i == 4) {
					a = "비숑 프리제";
				} else if (i == 5) {
					a = "사모예드";
				} else if (i == 6) {
					a = "셔틀랜드 쉽독";
				} else if (i == 7) {
					a = "요크셔테리어";
				} else if (i == 8) {
					a = "재패니스 스피츠";
				} else if (i == 9) {
					a = "치와와";
				} else if (i == 10) {
					a = "펨브로크 웰시코기";
				} else if (i == 11) {
					a = "포메라니안";
				} else if (i == 12) {
					a = "폼피츠";
				} else if (i == 13) {
					a = "푸들";
				}
				%>
				<div
					style="display: inline-block; font-size: 20px; font-weight: bolder; line-height: 40px; width: 235px; vertical-align: middle;">
					<%=a%>
				</div>
				<hr>
			</button>
		</div>
		<%
			}
		%>

		<%
			for (int i = 0; i < 14; i++) {
		%>

		<div class="modal fade" id="intro<%=i%>" role="dialog"
			aria-labelledby="introHeader" aria-hidden="true" tabindex="-1">
			<div class="modal-dialog">
				<div class="modal-content" style="height: 650px;">
					<div class="modal-header">
						<h4 class="modal-title" style="height: 10px; display: inline;">견종백과</h4>
						<button type="button" class="btn btn-default" data-dismiss="modal" style="margin-left: 170px;">Ⅹ</button>
					<!-- 	<div class="modal-footer" style="display: inline;">
					</div> -->
					</div>
					<div class="modal-body" style="height: 550px;">

						<img src='../../assets/img/DEIMG/dog/a<%=i%>.jpg' width='293px'
							height='200px'
							style='display: inline-block; vertical-align: middle;'>
						<hr>

						<div style="overflow: scroll; height: 310px; background-attachment:fixed; background-image: URL(../../assets/img/DEIMG/title2.jpg);">
							<%if (i==0) { %>
							
							<%
								for (int a = 0; a <= aList.size(); a++) {
							%>
							
							<%=aList.get(a).getInformation()%><hr>
							
							<%
								}
							%>
							
							<%} %>
						</div>
					</div>

					
				</div>
			</div>
		</div>
		<%
			}
		%>


	</div>
</body>

</html>