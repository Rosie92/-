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
		getYoutube();
	});

	// 크롤링 정보 가져오기
	function getYoutube() {

		//Ajax 호출
		$.ajax({
			url : "/DExellent/getYoutube.do",
			type : "post",
			dataType : "JSON",
			contentType : "application/json; charset=UTF-8",
			success : function(json) {
				
				console.log(json.length);

				var Youtube = "";

				for (var i = 0; i < json.length; i++) {
					Youtube += (json[i].youtube);
				}
				$('#Youtube').html(Youtube);
			}
		})
	}
</script>

<title>Youtube</title>

</head>
<body style="overflow-x: hidden">

	<div id="Youtube"></div>
	<br />
	<hr />


</body>

</html>