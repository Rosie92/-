<%@page import="java.util.List"%>
<%@page import="poly.dto.InformationDTO"%>
<%
	List<InformationDTO> aList = (List<InformationDTO>) request.getAttribute("aList");
	List<InformationDTO> bList = (List<InformationDTO>) request.getAttribute("bList");
	List<InformationDTO> cList = (List<InformationDTO>) request.getAttribute("cList");
	List<InformationDTO> dList = (List<InformationDTO>) request.getAttribute("dList");
	List<InformationDTO> eList = (List<InformationDTO>) request.getAttribute("eList");
	List<InformationDTO> fList = (List<InformationDTO>) request.getAttribute("fList");
	List<InformationDTO> gList = (List<InformationDTO>) request.getAttribute("gList");
	List<InformationDTO> hList = (List<InformationDTO>) request.getAttribute("hList");
	List<InformationDTO> iList = (List<InformationDTO>) request.getAttribute("iList");
	List<InformationDTO> jList = (List<InformationDTO>) request.getAttribute("jList");

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
		<!-- @@@@@@@@@@@@@@@@@@@@@@@@@@ 버튼 @@@@@@@@@@@@@@@@@@@@@ -->
		<!-- 골든리트리버 -->
		<div style='display: inline-block; width: 100%; line-height: 10px;'>
			<button data-toggle='modal' data-target='#intro0'
				style="background-color: white; border: 0px;">
				<img src='../../assets/img/DEIMG/dog/a0.jpg' width='330px'
					height='210px'
					style='display: inline-block; vertical-align: middle;'>
				<div
					style="display: inline-block; font-size: 20px; font-weight: bolder; line-height: 40px; width: 235px; vertical-align: middle;">
					골든 리트리버
				</div>
				<hr>
			</button>
		</div>
		<!-- 래브라도 리트리버 -->
			<div style='display: inline-block; width: 100%; line-height: 10px;'>
			<button data-toggle='modal' data-target='#intro1'
				style="background-color: white; border: 0px;">
				<img src='../../assets/img/DEIMG/dog/a1.jpg' width='330px'
					height='210px'
					style='display: inline-block; vertical-align: middle;'>
				<div
					style="display: inline-block; font-size: 20px; font-weight: bolder; line-height: 40px; width: 235px; vertical-align: middle;">
					래브라도 리트리버
				</div>
				<hr>
			</button>
		</div>
		<!-- 말티즈 -->
			<div style='display: inline-block; width: 100%; line-height: 10px;'>
			<button data-toggle='modal' data-target='#intro2'
				style="background-color: white; border: 0px;">
				<img src='../../assets/img/DEIMG/dog/a2.jpg' width='330px'
					height='210px'
					style='display: inline-block; vertical-align: middle;'>
				<div
					style="display: inline-block; font-size: 20px; font-weight: bolder; line-height: 40px; width: 235px; vertical-align: middle;">
					말티즈
				</div>
				<hr>
			</button>
		</div>
		<!-- 보더콜리 -->
			<div style='display: inline-block; width: 100%; line-height: 10px;'>
			<button data-toggle='modal' data-target='#intro3'
				style="background-color: white; border: 0px;">
				<img src='../../assets/img/DEIMG/dog/a3.jpg' width='330px'
					height='210px'
					style='display: inline-block; vertical-align: middle;'>
				<div
					style="display: inline-block; font-size: 20px; font-weight: bolder; line-height: 40px; width: 235px; vertical-align: middle;">
					보더콜리
				</div>
				<hr>
			</button>
		</div>
		<!-- 비숑 -->
			<div style='display: inline-block; width: 100%; line-height: 10px;'>
			<button data-toggle='modal' data-target='#intro4'
				style="background-color: white; border: 0px;">
				<img src='../../assets/img/DEIMG/dog/a4.jpg' width='330px'
					height='210px'
					style='display: inline-block; vertical-align: middle;'>
				<div
					style="display: inline-block; font-size: 20px; font-weight: bolder; line-height: 40px; width: 235px; vertical-align: middle;">
					비숑 프리체
				</div>
				<hr>
			</button>
		</div>
		<!-- 사모예드 -->
			<div style='display: inline-block; width: 100%; line-height: 10px;'>
			<button data-toggle='modal' data-target='#intro5'
				style="background-color: white; border: 0px;">
				<img src='../../assets/img/DEIMG/dog/a5.jpg' width='330px'
					height='210px'
					style='display: inline-block; vertical-align: middle;'>
				<div
					style="display: inline-block; font-size: 20px; font-weight: bolder; line-height: 40px; width: 235px; vertical-align: middle;">
					사모예드
				</div>
				<hr>
			</button>
		</div>
		<!-- 셔틀랜드 -->
			<div style='display: inline-block; width: 100%; line-height: 10px;'>
			<button data-toggle='modal' data-target='#intro6'
				style="background-color: white; border: 0px;">
				<img src='../../assets/img/DEIMG/dog/a6.jpg' width='330px'
					height='210px'
					style='display: inline-block; vertical-align: middle;'>
				<div
					style="display: inline-block; font-size: 20px; font-weight: bolder; line-height: 40px; width: 235px; vertical-align: middle;">
					셔틀랜드 쉽독
				</div>
				<hr>
			</button>
		</div>
		<!-- 요크셔테리어 -->
			<div style='display: inline-block; width: 100%; line-height: 10px;'>
			<button data-toggle='modal' data-target='#intro7'
				style="background-color: white; border: 0px;">
				<img src='../../assets/img/DEIMG/dog/a7.jpg' width='330px'
					height='210px'
					style='display: inline-block; vertical-align: middle;'>
				<div
					style="display: inline-block; font-size: 20px; font-weight: bolder; line-height: 40px; width: 235px; vertical-align: middle;">
					요크 셔테리어
				</div>
				<hr>
			</button>
		</div>
		<!-- 스피츠 -->
			<div style='display: inline-block; width: 100%; line-height: 10px;'>
			<button data-toggle='modal' data-target='#intro8'
				style="background-color: white; border: 0px;">
				<img src='../../assets/img/DEIMG/dog/a8.jpg' width='330px'
					height='210px'
					style='display: inline-block; vertical-align: middle;'>
				<div
					style="display: inline-block; font-size: 20px; font-weight: bolder; line-height: 40px; width: 235px; vertical-align: middle;">
					재패니즈 스피츠
				</div>
				<hr>
			</button>
		</div>
		<!-- 치와와 -->
			<div style='display: inline-block; width: 100%; line-height: 10px;'>
			<button data-toggle='modal' data-target='#intro9'
				style="background-color: white; border: 0px;">
				<img src='../../assets/img/DEIMG/dog/a9.jpg' width='330px'
					height='210px'
					style='display: inline-block; vertical-align: middle;'>
				<div
					style="display: inline-block; font-size: 20px; font-weight: bolder; line-height: 40px; width: 235px; vertical-align: middle;">
					치와와
				</div>
				<hr>
			</button>
		</div>
		
		<!-- @@@@@@@@@@@@@@@@@@@@@@@@@ 팝업 @@@@@@@@@@@@@@@@@@@@@@@@@@@ -->
		<!-- 골든 리트리버 -->
		<div class="modal fade" id="intro0" role="dialog"
			aria-labelledby="introHeader" aria-hidden="true" tabindex="-1">
			<div class="modal-dialog">
				<div class="modal-content" style="height: 650px;">
					<div class="modal-header">
						<h4 class="modal-title" style="height: 10px; display: inline;">견종백과</h4>
						<button type="button" class="btn btn-default" data-dismiss="modal" style="margin-left: 170px;">Ⅹ</button>
					</div>
					<div class="modal-body" style="height: 550px;">
						<img src='../../assets/img/DEIMG/dog/a0.jpg' width='293px'
							height='200px'
							style='display: inline-block; vertical-align: middle;'>
						<hr>
						<div style="overflow: scroll; height: 310px; background-attachment:fixed; background-image: URL(../../assets/img/DEIMG/title2.jpg);">
							<%for (int a = 0; a < aList.size(); a++) {%>
							<%=aList.get(a).getInformation()%><hr>
							<%} %>
						</div>
					</div>		
				</div>
			</div>
		</div>
		<!-- 래브라도 리트리버 -->
				<div class="modal fade" id="intro1" role="dialog"
			aria-labelledby="introHeader" aria-hidden="true" tabindex="-1">
			<div class="modal-dialog">
				<div class="modal-content" style="height: 650px;">
					<div class="modal-header">
						<h4 class="modal-title" style="height: 10px; display: inline;">견종백과</h4>
						<button type="button" class="btn btn-default" data-dismiss="modal" style="margin-left: 170px;">Ⅹ</button>
					</div>
					<div class="modal-body" style="height: 550px;">
						<img src='../../assets/img/DEIMG/dog/a1.jpg' width='293px'
							height='200px'
							style='display: inline-block; vertical-align: middle;'>
						<hr>
						<div style="overflow: scroll; height: 310px; background-attachment:fixed; background-image: URL(../../assets/img/DEIMG/title2.jpg);">
							<%for (int a = 0; a < bList.size(); a++) {%>
							<%=bList.get(a).getInformation()%><hr>
							<%} %>
						</div>
					</div>		
				</div>
			</div>
		</div>
		<!-- 말티즈 -->
				<div class="modal fade" id="intro2" role="dialog"
			aria-labelledby="introHeader" aria-hidden="true" tabindex="-1">
			<div class="modal-dialog">
				<div class="modal-content" style="height: 650px;">
					<div class="modal-header">
						<h4 class="modal-title" style="height: 10px; display: inline;">견종백과</h4>
						<button type="button" class="btn btn-default" data-dismiss="modal" style="margin-left: 170px;">Ⅹ</button>
					</div>
					<div class="modal-body" style="height: 550px;">
						<img src='../../assets/img/DEIMG/dog/a2.jpg' width='293px'
							height='200px'
							style='display: inline-block; vertical-align: middle;'>
						<hr>
						<div style="overflow: scroll; height: 310px; background-attachment:fixed; background-image: URL(../../assets/img/DEIMG/title2.jpg);">
							<%for (int a = 0; a < cList.size(); a++) {%>
							<%=cList.get(a).getInformation()%><hr>
							<%} %>
						</div>
					</div>		
				</div>
			</div>
		</div>
		<!-- 보더콜리 -->
				<div class="modal fade" id="intro3" role="dialog"
			aria-labelledby="introHeader" aria-hidden="true" tabindex="-1">
			<div class="modal-dialog">
				<div class="modal-content" style="height: 650px;">
					<div class="modal-header">
						<h4 class="modal-title" style="height: 10px; display: inline;">견종백과</h4>
						<button type="button" class="btn btn-default" data-dismiss="modal" style="margin-left: 170px;">Ⅹ</button>
					</div>
					<div class="modal-body" style="height: 550px;">
						<img src='../../assets/img/DEIMG/dog/a3.jpg' width='293px'
							height='200px'
							style='display: inline-block; vertical-align: middle;'>
						<hr>
						<div style="overflow: scroll; height: 310px; background-attachment:fixed; background-image: URL(../../assets/img/DEIMG/title2.jpg);">
							<%for (int a = 0; a < dList.size(); a++) {%>
							<%=dList.get(a).getInformation()%><hr>
							<%} %>
						</div>
					</div>		
				</div>
			</div>
		</div>
		<!-- 비숑 -->
				<div class="modal fade" id="intro4" role="dialog"
			aria-labelledby="introHeader" aria-hidden="true" tabindex="-1">
			<div class="modal-dialog">
				<div class="modal-content" style="height: 650px;">
					<div class="modal-header">
						<h4 class="modal-title" style="height: 10px; display: inline;">견종백과</h4>
						<button type="button" class="btn btn-default" data-dismiss="modal" style="margin-left: 170px;">Ⅹ</button>
					</div>
					<div class="modal-body" style="height: 550px;">
						<img src='../../assets/img/DEIMG/dog/a4.jpg' width='293px'
							height='200px'
							style='display: inline-block; vertical-align: middle;'>
						<hr>
						<div style="overflow: scroll; height: 310px; background-attachment:fixed; background-image: URL(../../assets/img/DEIMG/title2.jpg);">
							<%for (int a = 0; a < eList.size(); a++) {%>
							<%=eList.get(a).getInformation()%><hr>
							<%} %>
						</div>
					</div>		
				</div>
			</div>
		</div>
		<!-- 사모예드 -->
				<div class="modal fade" id="intro5" role="dialog"
			aria-labelledby="introHeader" aria-hidden="true" tabindex="-1">
			<div class="modal-dialog">
				<div class="modal-content" style="height: 650px;">
					<div class="modal-header">
						<h4 class="modal-title" style="height: 10px; display: inline;">견종백과</h4>
						<button type="button" class="btn btn-default" data-dismiss="modal" style="margin-left: 170px;">Ⅹ</button>
					</div>
					<div class="modal-body" style="height: 550px;">
						<img src='../../assets/img/DEIMG/dog/a5.jpg' width='293px'
							height='200px'
							style='display: inline-block; vertical-align: middle;'>
						<hr>
						<div style="overflow: scroll; height: 310px; background-attachment:fixed; background-image: URL(../../assets/img/DEIMG/title2.jpg);">
							<%for (int a = 0; a < fList.size(); a++) {%>
							<%=fList.get(a).getInformation()%><hr>
							<%} %>
						</div>
					</div>		
				</div>
			</div>
		</div>
		<!-- 셔틀랜드 -->
				<div class="modal fade" id="intro6" role="dialog"
			aria-labelledby="introHeader" aria-hidden="true" tabindex="-1">
			<div class="modal-dialog">
				<div class="modal-content" style="height: 650px;">
					<div class="modal-header">
						<h4 class="modal-title" style="height: 10px; display: inline;">견종백과</h4>
						<button type="button" class="btn btn-default" data-dismiss="modal" style="margin-left: 170px;">Ⅹ</button>
					</div>
					<div class="modal-body" style="height: 550px;">
						<img src='../../assets/img/DEIMG/dog/a6.jpg' width='293px'
							height='200px'
							style='display: inline-block; vertical-align: middle;'>
						<hr>
						<div style="overflow: scroll; height: 310px; background-attachment:fixed; background-image: URL(../../assets/img/DEIMG/title2.jpg);">
							<%for (int a = 0; a < gList.size(); a++) {%>
							<%=gList.get(a).getInformation()%><hr>
							<%} %>
						</div>
					</div>		
				</div>
			</div>
		</div>
		<!-- 요크셔테리어 -->
				<div class="modal fade" id="intro7" role="dialog"
			aria-labelledby="introHeader" aria-hidden="true" tabindex="-1">
			<div class="modal-dialog">
				<div class="modal-content" style="height: 650px;">
					<div class="modal-header">
						<h4 class="modal-title" style="height: 10px; display: inline;">견종백과</h4>
						<button type="button" class="btn btn-default" data-dismiss="modal" style="margin-left: 170px;">Ⅹ</button>
					</div>
					<div class="modal-body" style="height: 550px;">
						<img src='../../assets/img/DEIMG/dog/a7.jpg' width='293px'
							height='200px'
							style='display: inline-block; vertical-align: middle;'>
						<hr>
						<div style="overflow: scroll; height: 310px; background-attachment:fixed; background-image: URL(../../assets/img/DEIMG/title2.jpg);">
							<%for (int a = 0; a < hList.size(); a++) {%>
							<%=hList.get(a).getInformation()%><hr>
							<%} %>
						</div>
					</div>		
				</div>
			</div>
		</div>
		<!-- 스피츠 -->
				<div class="modal fade" id="intro8" role="dialog"
			aria-labelledby="introHeader" aria-hidden="true" tabindex="-1">
			<div class="modal-dialog">
				<div class="modal-content" style="height: 650px;">
					<div class="modal-header">
						<h4 class="modal-title" style="height: 10px; display: inline;">견종백과</h4>
						<button type="button" class="btn btn-default" data-dismiss="modal" style="margin-left: 170px;">Ⅹ</button>
					</div>
					<div class="modal-body" style="height: 550px;">
						<img src='../../assets/img/DEIMG/dog/a8.jpg' width='293px'
							height='200px'
							style='display: inline-block; vertical-align: middle;'>
						<hr>
						<div style="overflow: scroll; height: 310px; background-attachment:fixed; background-image: URL(../../assets/img/DEIMG/title2.jpg);">
							<%for (int a = 0; a < iList.size(); a++) {%>
							<%=iList.get(a).getInformation()%><hr>
							<%} %>
						</div>
					</div>		
				</div>
			</div>
		</div>
		<!-- 치와와 -->
				<div class="modal fade" id="intro9" role="dialog"
			aria-labelledby="introHeader" aria-hidden="true" tabindex="-1">
			<div class="modal-dialog">
				<div class="modal-content" style="height: 650px;">
					<div class="modal-header">
						<h4 class="modal-title" style="height: 10px; display: inline;">견종백과</h4>
						<button type="button" class="btn btn-default" data-dismiss="modal" style="margin-left: 170px;">Ⅹ</button>
					</div>
					<div class="modal-body" style="height: 550px;">
						<img src='../../assets/img/DEIMG/dog/a9.jpg' width='293px'
							height='200px'
							style='display: inline-block; vertical-align: middle;'>
						<hr>
						<div style="overflow: scroll; height: 310px; background-attachment:fixed; background-image: URL(../../assets/img/DEIMG/title2.jpg);">
							<%for (int a = 0; a < jList.size(); a++) {%>
							<%=jList.get(a).getInformation()%><hr>
							<%} %>
						</div>
					</div>		
				</div>
			</div>
		</div>



	</div>
</body>

</html>