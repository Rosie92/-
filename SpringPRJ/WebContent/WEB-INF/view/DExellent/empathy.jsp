<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="/css/empathy.css" rel="stylesheet" />

<script src="/js/jquery-3.4.1.min.js"></script>

<script type="text/javascript">
	$(window).on("load", function() {

		//페이지 로딩 완료 후, 크롤링 정보 가져오기 함수 실행함
		getEmpathy();
	});

	// 크롤링 정보 가져오기
	function getEmpathy() {

		//Ajax 호출
		$.ajax({
			url : "/DExellent/getEmpathy.do",
			type : "post",
			dataType : "JSON",
			contentType : "application/json; charset=UTF-8",
			success : function(json) {

				var crawling = "";

				for (var i = 0; i < json.length; i++){
					crawling += (json[i].empathy);
				}
				console.log(crawling);
				$('#crawling').html(crawling);
			}
		})
	}
</script>
<title>동물공감</title>

</head>
<body class="contw-787" style="overflow-x:hidden">
	<div id="crawling"></div>



</body>
</html>