<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script src="/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
	$(window).on("load", function() {
		//페이지 로딩 완료 후, 크롤링 정보 가져오기 함수 실행함
		getTitle();
	});

	// 크롤링 정보 가져오기
	function getTitle() {

		//Ajax 호출
		$.ajax({
			url : "/DExellent/getTitle.do",
			type : "post",
			dataType : "JSON",
			contentType : "application/json; charset=UTF-8",
			success : function(json) {

				$.ajax({

					url : "/DExellent/getContent.do",
					type : "post",
					dataType : "JSON",
					contentType : "application/json; charset=UTF-8",
					success : function(data) {

						var title = "";
						var content = "";

						for (var i = 0; i < json.length; i++) { // 이미지 더 구하거나 10개까지 제한으로 변경 필요함
							title += "<div>";
							title += "<img src='../../assets/img/DEIMG/PP" + i + ".jpg' width='60px' height='60px'></div>"; 
							title += "<div  style='display:inline-block'><a href='" + data[i].content + " ' target='_black'>";
							title += (json[i].title + "<br><hr>");
							title += "</a></div>";
						}
						$('#title').html(title);
					}
				})
			}
		})
	}
</script>
 
<title>동물공감</title>

</head>
<body style="overflow-x: hidden">

	<div id="title"></div>
	<br />
	<hr />

</body>

</html>