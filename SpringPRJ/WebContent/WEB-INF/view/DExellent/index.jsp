<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<!--         <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" /> -->
<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<meta name="description" content="" />
<meta name="author" content="" />
<title>강아지는 훌륭하다</title>
<style type="text/css">
</style>
<link rel="icon" type="image/x-icon" href="/assets/img/DEIMG/title.png" />
<!-- Font Awesome icons (free version)-->
<script src="https://use.fontawesome.com/releases/v5.12.1/js/all.js"
	crossorigin="anonymous"></script>
<!-- Google fonts-->
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700"
	rel="stylesheet" type="text/css" />
<link
	href="https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic"
	rel="stylesheet" type="text/css" />
<link
	href="https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700"
	rel="stylesheet" type="text/css" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="/css/styles.css" rel="stylesheet" />
<link
	href="http://fonts.googleapis.com/earlyaccess/nanumbrushscript.css"
	rel="stylesheet" type="text/css">

<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>


</head>
<body id="page-top">
	<!-- Navigation-->
	<nav class="navbar navbar-expand-lg navbar-dark fixed-top" id="mainNav">
		<div class="container">
			<a class="navbar-brand js-scroll-trigger" href="#page-top"
				style="margin-left: 10px;"> <img
				src="/assets/img/DEIMG/title.png" width="50" height="50" />
				<div class="title"
					style="display: inline; font-family: 'Nanum Brush Script', serif; margin-left: 5px;">
					강아지는 훌륭하다</div>
			</a>
			<button class="navbar-toggler navbar-toggler-right" type="button"
				data-toggle="collapse" data-target="#navbarResponsive"
				aria-controls="navbarResponsive" aria-expanded="false"
				aria-label="Toggle navigation"
				style="font-family: 'Nanum Brush Script', serif; font-size: 20px;">
				Menu<i class="fas fa-bars ml-1"></i>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav text-uppercase ml-auto">


					<%
						if (session.getAttribute("user_name") == null) {
					%>


					<a
						href="https://kauth.kakao.com/oauth/authorize?client_id=928bbb3f0e2b7934f85c85beaa13b7ea&redirect_uri=http://localhost:8080/kakaologin.do&response_type=code">
						<img src="/assets/img/DEIMG/kakaologin.png"
						style="width: 260px; margin-left: 40px; margin-top: 10px;">
					</a>
					<%
						} else {
					%>
					<li class="nav-item"><a class="nav-link js-scroll-trigger"
						href="#services">NEWS</a></li>
					<li class="nav-item"><a class="nav-link js-scroll-trigger"
						href="#portfolio">YOUTUBE</a></li>
					<li class="nav-item"><a class="nav-link js-scroll-trigger"
						href="#about">INFORMATION</a></li>
					<li class="nav-item"><a class="nav-link js-scroll-trigger"
						href="#team">KINDERGARTEN</a></li>
					<li class="nav-item"><a class="nav-link js-scroll-trigger"
						href="#contact">BOARD</a></li>
					<li class="nav-item"><a class="nav-link js-scroll-trigger"
						href="#mypage">MYPAGE</a></li>
					<li class="nav-item"><a class="nav-link js-scroll-trigger"
						href="/kakaologout.do">LOGOUT</a></li>
					<%
						}
					%>
				</ul>
			</div>
		</div>
	</nav>
	<!-- Masthead-->
	<header class="masthead">
		<div class="container">
			<%-- 
			<div class="masthead-heading text-uppercase">
				강아지는<%="&nbsp&nbsp&nbsp&nbsp&nbsp"%>
				<br>
				<%="&nbsp&nbsp&nbsp&nbsp&nbsp"%>훌륭하다
			</div> --%>
			<%
				if (session.getAttribute("user_name") == null) {
			%>
			<input type="button" value="W E L C O M E"
				class="btn btn-primary btn-xl text-uppercase js-scroll-trigger"
				onclick="alert('먼저 로그인 해주세요')">
			<%
				} else {
			%>
			<a class="btn btn-primary btn-xl text-uppercase js-scroll-trigger"
				href="#services">W&nbspE&nbspL&nbspC&nbspO&nbspM&nbspE</a>
			<%
				}
			%>
		</div>
	</header>
	<%
		if (session.getAttribute("user_name") == null) {
	%>
	<hr>
	<!-- Footer-->
	<footer class="footer py-4">
		<div class="container">
			<div class="row align-items-center">
				<div class="col-lg-4 text-lg-left">Copyright © Your Website
					2020</div>
				<div class="col-lg-4 my-3 my-lg-0">
					<a class="btn btn-dark btn-social mx-2" href="#!"><i
						class="fab fa-twitter"></i></a><a class="btn btn-dark btn-social mx-2"
						href="#!"><i class="fab fa-facebook-f"></i></a><a
						class="btn btn-dark btn-social mx-2" href="#!"><i
						class="fab fa-linkedin-in"></i></a>
				</div>
				<div class="col-lg-4 text-lg-right">
					<a class="mr-3" href="#!">Privacy Policy</a><a href="#!">Terms
						of Use</a>
				</div>
			</div>
		</div>
	</footer>
	<!-- Portfolio Modals-->
	<!-- Modal 1-->
	<div class="portfolio-modal modal fade" id="portfolioModal1"
		tabindex="-1" role="dialog" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="close-modal" data-dismiss="modal">
					<img src="/assets/img/close-icon.svg" />
				</div>
				<div class="container">
					<div class="row justify-content-center">
						<div class="col-lg-8">
							<div class="modal-body">
								<!-- Project Details Go Here-->
								<h2 class="text-uppercase">Project Name</h2>
								<p class="item-intro text-muted">Lorem ipsum dolor sit amet
									consectetur.</p>
								<img class="img-fluid d-block mx-auto"
									src="/assets/img/portfolio/01-full.jpg" alt="" />
								<p>Use this area to describe your project. Lorem ipsum dolor
									sit amet, consectetur adipisicing elit. Est blanditiis dolorem
									culpa incidunt minus dignissimos deserunt repellat aperiam
									quasi sunt officia expedita beatae cupiditate, maiores
									repudiandae, nostrum, reiciendis facere nemo!</p>
								<ul class="list-inline">
									<li>Date: January 2020</li>
									<li>Client: Threads</li>
									<li>Category: Illustration</li>
								</ul>
								<button class="btn btn-primary" data-dismiss="modal"
									type="button">
									<i class="fas fa-times mr-1"></i>Close Project
								</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Modal 2-->
	<div class="portfolio-modal modal fade" id="portfolioModal2"
		tabindex="-1" role="dialog" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="close-modal" data-dismiss="modal">
					<img src="/assets/img/close-icon.svg" />
				</div>
				<div class="container">
					<div class="row justify-content-center">
						<div class="col-lg-8">
							<div class="modal-body">
								<!-- Project Details Go Here-->
								<h2 class="text-uppercase">Project Name</h2>
								<p class="item-intro text-muted">Lorem ipsum dolor sit amet
									consectetur.</p>
								<img class="img-fluid d-block mx-auto"
									src="/assets/img/portfolio/02-full.jpg" alt="" />
								<p>Use this area to describe your project. Lorem ipsum dolor
									sit amet, consectetur adipisicing elit. Est blanditiis dolorem
									culpa incidunt minus dignissimos deserunt repellat aperiam
									quasi sunt officia expedita beatae cupiditate, maiores
									repudiandae, nostrum, reiciendis facere nemo!</p>
								<ul class="list-inline">
									<li>Date: January 2020</li>
									<li>Client: Explore</li>
									<li>Category: Graphic Design</li>
								</ul>
								<button class="btn btn-primary" data-dismiss="modal"
									type="button">
									<i class="fas fa-times mr-1"></i>Close Project
								</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Modal 3-->
	<div class="portfolio-modal modal fade" id="portfolioModal3"
		tabindex="-1" role="dialog" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="close-modal" data-dismiss="modal">
					<img src="/assets/img/close-icon.svg" />
				</div>
				<div class="container">
					<div class="row justify-content-center">
						<div class="col-lg-8">
							<div class="modal-body">
								<!-- Project Details Go Here-->
								<h2 class="text-uppercase">Project Name</h2>
								<p class="item-intro text-muted">Lorem ipsum dolor sit amet
									consectetur.</p>
								<img class="img-fluid d-block mx-auto"
									src="/assets/img/portfolio/03-full.jpg" alt="" />
								<p>Use this area to describe your project. Lorem ipsum dolor
									sit amet, consectetur adipisicing elit. Est blanditiis dolorem
									culpa incidunt minus dignissimos deserunt repellat aperiam
									quasi sunt officia expedita beatae cupiditate, maiores
									repudiandae, nostrum, reiciendis facere nemo!</p>
								<ul class="list-inline">
									<li>Date: January 2020</li>
									<li>Client: Finish</li>
									<li>Category: Identity</li>
								</ul>
								<button class="btn btn-primary" data-dismiss="modal"
									type="button">
									<i class="fas fa-times mr-1"></i>Close Project
								</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Modal 4-->
	<div class="portfolio-modal modal fade" id="portfolioModal4"
		tabindex="-1" role="dialog" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="close-modal" data-dismiss="modal">
					<img src="/assets/img/close-icon.svg" />
				</div>
				<div class="container">
					<div class="row justify-content-center">
						<div class="col-lg-8">
							<div class="modal-body">
								<!-- Project Details Go Here-->
								<h2 class="text-uppercase">Project Name</h2>
								<p class="item-intro text-muted">Lorem ipsum dolor sit amet
									consectetur.</p>
								<img class="img-fluid d-block mx-auto"
									src="/assets/img/portfolio/04-full.jpg" alt="" />
								<p>Use this area to describe your project. Lorem ipsum dolor
									sit amet, consectetur adipisicing elit. Est blanditiis dolorem
									culpa incidunt minus dignissimos deserunt repellat aperiam
									quasi sunt officia expedita beatae cupiditate, maiores
									repudiandae, nostrum, reiciendis facere nemo!</p>
								<ul class="list-inline">
									<li>Date: January 2020</li>
									<li>Client: Lines</li>
									<li>Category: Branding</li>
								</ul>
								<button class="btn btn-primary" data-dismiss="modal"
									type="button">
									<i class="fas fa-times mr-1"></i>Close Project
								</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Modal 5-->
	<div class="portfolio-modal modal fade" id="portfolioModal5"
		tabindex="-1" role="dialog" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="close-modal" data-dismiss="modal">
					<img src="/assets/img/close-icon.svg" />
				</div>
				<div class="container">
					<div class="row justify-content-center">
						<div class="col-lg-8">
							<div class="modal-body">
								<!-- Project Details Go Here-->
								<h2 class="text-uppercase">Project Name</h2>
								<p class="item-intro text-muted">Lorem ipsum dolor sit amet
									consectetur.</p>
								<img class="img-fluid d-block mx-auto"
									src="/assets/img/portfolio/05-full.jpg" alt="" />
								<p>Use this area to describe your project. Lorem ipsum dolor
									sit amet, consectetur adipisicing elit. Est blanditiis dolorem
									culpa incidunt minus dignissimos deserunt repellat aperiam
									quasi sunt officia expedita beatae cupiditate, maiores
									repudiandae, nostrum, reiciendis facere nemo!</p>
								<ul class="list-inline">
									<li>Date: January 2020</li>
									<li>Client: Southwest</li>
									<li>Category: Website Design</li>
								</ul>
								<button class="btn btn-primary" data-dismiss="modal"
									type="button">
									<i class="fas fa-times mr-1"></i>Close Project
								</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Modal 6-->
	<div class="portfolio-modal modal fade" id="portfolioModal6"
		tabindex="-1" role="dialog" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="close-modal" data-dismiss="modal">
					<img src="/assets/img/close-icon.svg" />
				</div>
				<div class="container">
					<div class="row justify-content-center">
						<div class="col-lg-8">
							<div class="modal-body">
								<!-- Project Details Go Here-->
								<h2 class="text-uppercase">Project Name</h2>
								<p class="item-intro text-muted">Lorem ipsum dolor sit amet
									consectetur.</p>
								<img class="img-fluid d-block mx-auto"
									src="/assets/img/portfolio/06-full.jpg" alt="" />
								<p>Use this area to describe your project. Lorem ipsum dolor
									sit amet, consectetur adipisicing elit. Est blanditiis dolorem
									culpa incidunt minus dignissimos deserunt repellat aperiam
									quasi sunt officia expedita beatae cupiditate, maiores
									repudiandae, nostrum, reiciendis facere nemo!</p>
								<ul class="list-inline">
									<li>Date: January 2020</li>
									<li>Client: Window</li>
									<li>Category: Photography</li>
								</ul>
								<button class="btn btn-primary" data-dismiss="modal"
									type="button">
									<i class="fas fa-times mr-1"></i>Close Project
								</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Bootstrap core JS-->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
	<!-- Third party plugin JS-->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.min.js"></script>
	<!-- Contact form JS-->
	<script src="/assets/mail/jqBootstrapValidation.js"></script>
	<script src="/assets/mail/contact_me.js"></script>
	<!-- Core theme JS-->
	<script src="/js/scripts.js"></script>
	<%
		} else {
	%>
	<!-- Services-->
	<hr style="margin-top: 50px;">
	<section class="page-section" id="services">
		<div class="container">
			<div class="text-center">
				<h2 class="section-heading text-uppercase">NEWS</h2>
				<hr style="width: 60%; margin-top: 30px; margin-bottom: 30px;">
			</div>

			<p style="text-align: center">
				<img class="img-fluid" src="../../assets/img/DEIMG/news.jpg"
					style="width: 350px; height: 300px;">
			</p>
			<div class="portfolio-caption">
				<h3 class="section-subheading text-muted"
					style="text-align: center; line-height: 30px;">
					동물전문매체 Happy Pet에서 <br>강아지와 관련된 뉴스를 제공합니다.
				</h3>
			</div>


			<iframe src="/DExellent/Title.do" width="100%" height="600px"
				name="Title" id="Title" frameborder="1" scrolling="yes"
				style="overflow-x: hidden" /></iframe>
		</div>
	</section>
	<!-- Portfolio Grid-->
	<section class="page-section bg-light" id="portfolio">
		<div class="container">
			<div class="text-center">
				<h2 class="section-heading text-uppercase">YOUTUBE</h2>
				<hr style="width: 60%; margin-top: 30px; margin-bottom: 30px;">
				<p style="text-align: center">
					<img class="img-fluid" src="../../assets/img/DEIMG/youtubeimg.jpg"
						style="width: 350px; height: 210px;">
				</p>
				<div class="portfolio-caption">
					<h3 class="section-subheading text-muted"
						style="text-align: center; line-height: 30px;">
						Youtube에서 <br>강아지와 관련된 영상을 제공받습니다.
					</h3>
				</div>

				<iframe src="/DExellent/Youtube.do" width="100%" height="600px"
					name="Youtube" id="Youtube" frameborder="1" scrolling="yes"
					style="overflow-x: hidden" /></iframe>
			</div>
		</div>
	</section>
	<!-- About-->
	<section class="page-section" id="about">
		<div class="container">
			<div class="text-center">
				<h2 class="section-heading text-uppercase">INFORMATION</h2>
				<hr style="width: 60%; margin-top: 30px; margin-bottom: 30px;">
				<p style="text-align: center">
					<img class="img-fluid" src="../../assets/img/DEIMG/qwerqwer.jpg"
						style="width: 350px; height: 210px;">
				</p>
				<div class="portfolio-caption">
					<h3 class="section-subheading text-muted"
						style="text-align: center; line-height: 30px;">
						BeMyPet에서 <br>강아지와 관련된 정보를 제공받습니다.
					</h3>
				</div>

				<iframe src="/DExellent/Information.do" width="100%" height="600px"
					name="Information" id="Information" frameborder="1" scrolling="yes"
					style="overflow-x: hidden" target="" /></iframe>
			</div>
		</div>
	</section>
	<!-- Team-->
	<section class="page-section bg-light" id="team">
		<div class="container">
			<div class="text-center">
				<h2 class="section-heading text-uppercase">KINDERGARTEN</h2>
				<hr style="width: 60%; margin-top: 30px; margin-bottom: 30px;">
				<p style="text-align: center">
					<img class="img-fluid" src="../../assets/img/DEIMG/kinder.jpg"
						style="width: 350px; height: 210px;">
				</p>
				<div class="portfolio-caption">
					<h3 class="section-subheading text-muted"
						style="text-align: center; line-height: 30px;">
						KakaoMap에서 <br>강아지 유치원 위치 정보를 제공받습니다.
					</h3>
				</div>

				<iframe src="/DExellent/Kindergarten.do" width="100%" height="600px"
					name="Kindergarten" id="Kindergarten" frameborder="1"
					scrolling="yes" style="overflow-x: hidden" target="" /></iframe>
			</div>
		</div>
	</section>
	<!-- Contact-->
	<section class="page-section" id="contact">
		<div class="container">
			<div class="text-center">
				<h2 class="section-heading text-uppercase">BOARD</h2>
				<hr style="width: 60%; margin-top: 30px; margin-bottom: 30px;">
				<p style="text-align: center">
					<img class="img-fluid" src="../../assets/img/DEIMG/board.jpg"
						style="width: 350px; height: 210px;">
				</p>
				<div class="portfolio-caption">
					<h3 class="section-subheading text-muted"
						style="text-align: center; line-height: 30px;">
						자유롭게 의견을 나눌 수 있는 <br> 자유게시판 입니다.
					</h3>
				</div>
				
	</section>
	<!-- mypage-->
	<section class="page-section" id="mypage">
		<div class="container">
			<div class="text-center">
				<h2 class="section-heading text-uppercase">MYPAGE</h2>
				<h3 class="section-subheading text-muted">Displays Kakao member
					information.</h3>
			</div>
			<iframe src="/DExellent/mypage.do" width="330px" height="750px"
				name="mypage1" id="mypage1"></iframe>
		</div>
	</section>
	<!-- Footer-->
	<footer class="footer py-4">
		<div class="container">
			<div class="row align-items-center">
				<div class="col-lg-4 text-lg-left">Copyright © Your Website
					2020</div>
				<div class="col-lg-4 my-3 my-lg-0">
					<a class="btn btn-dark btn-social mx-2" href="#!"><i
						class="fab fa-twitter"></i></a><a class="btn btn-dark btn-social mx-2"
						href="#!"><i class="fab fa-facebook-f"></i></a><a
						class="btn btn-dark btn-social mx-2" href="#!"><i
						class="fab fa-linkedin-in"></i></a>
				</div>
				<div class="col-lg-4 text-lg-right">
					<a class="mr-3" href="#!">Privacy Policy</a><a href="#!">Terms
						of Use</a>
				</div>
			</div>
		</div>
	</footer>
	<!-- Portfolio Modals-->
	<!-- Modal 1-->
	<div class="portfolio-modal modal fade" id="portfolioModal1"
		tabindex="-1" role="dialog" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="close-modal" data-dismiss="modal">
					<img src="/assets/img/close-icon.svg" />
				</div>
				<div class="container">
					<div class="row justify-content-center">
						<div class="col-lg-8">
							<div class="modal-body">
								<!-- Project Details Go Here-->
								<h2 class="text-uppercase">Project Name</h2>
								<p class="item-intro text-muted">Lorem ipsum dolor sit amet
									consectetur.</p>
								<img class="img-fluid d-block mx-auto"
									src="/assets/img/portfolio/01-full.jpg" alt="" />
								<p>Use this area to describe your project. Lorem ipsum dolor
									sit amet, consectetur adipisicing elit. Est blanditiis dolorem
									culpa incidunt minus dignissimos deserunt repellat aperiam
									quasi sunt officia expedita beatae cupiditate, maiores
									repudiandae, nostrum, reiciendis facere nemo!</p>
								<ul class="list-inline">
									<li>Date: January 2020</li>
									<li>Client: Threads</li>
									<li>Category: Illustration</li>
								</ul>
								<button class="btn btn-primary" data-dismiss="modal"
									type="button">
									<i class="fas fa-times mr-1"></i>Close Project
								</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Modal 2-->
	<div class="portfolio-modal modal fade" id="portfolioModal2"
		tabindex="-1" role="dialog" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="close-modal" data-dismiss="modal">
					<img src="/assets/img/close-icon.svg" />
				</div>
				<div class="container">
					<div class="row justify-content-center">
						<div class="col-lg-8">
							<div class="modal-body">
								<!-- Project Details Go Here-->
								<h2 class="text-uppercase">Project Name</h2>
								<p class="item-intro text-muted">Lorem ipsum dolor sit amet
									consectetur.</p>
								<img class="img-fluid d-block mx-auto"
									src="/assets/img/portfolio/02-full.jpg" alt="" />
								<p>Use this area to describe your project. Lorem ipsum dolor
									sit amet, consectetur adipisicing elit. Est blanditiis dolorem
									culpa incidunt minus dignissimos deserunt repellat aperiam
									quasi sunt officia expedita beatae cupiditate, maiores
									repudiandae, nostrum, reiciendis facere nemo!</p>
								<ul class="list-inline">
									<li>Date: January 2020</li>
									<li>Client: Explore</li>
									<li>Category: Graphic Design</li>
								</ul>
								<button class="btn btn-primary" data-dismiss="modal"
									type="button">
									<i class="fas fa-times mr-1"></i>Close Project
								</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Modal 3-->
	<div class="portfolio-modal modal fade" id="portfolioModal3"
		tabindex="-1" role="dialog" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="close-modal" data-dismiss="modal">
					<img src="/assets/img/close-icon.svg" />
				</div>
				<div class="container">
					<div class="row justify-content-center">
						<div class="col-lg-8">
							<div class="modal-body">
								<!-- Project Details Go Here-->
								<h2 class="text-uppercase">Project Name</h2>
								<p class="item-intro text-muted">Lorem ipsum dolor sit amet
									consectetur.</p>
								<img class="img-fluid d-block mx-auto"
									src="/assets/img/portfolio/03-full.jpg" alt="" />
								<p>Use this area to describe your project. Lorem ipsum dolor
									sit amet, consectetur adipisicing elit. Est blanditiis dolorem
									culpa incidunt minus dignissimos deserunt repellat aperiam
									quasi sunt officia expedita beatae cupiditate, maiores
									repudiandae, nostrum, reiciendis facere nemo!</p>
								<ul class="list-inline">
									<li>Date: January 2020</li>
									<li>Client: Finish</li>
									<li>Category: Identity</li>
								</ul>
								<button class="btn btn-primary" data-dismiss="modal"
									type="button">
									<i class="fas fa-times mr-1"></i>Close Project
								</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Modal 4-->
	<div class="portfolio-modal modal fade" id="portfolioModal4"
		tabindex="-1" role="dialog" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="close-modal" data-dismiss="modal">
					<img src="/assets/img/close-icon.svg" />
				</div>
				<div class="container">
					<div class="row justify-content-center">
						<div class="col-lg-8">
							<div class="modal-body">
								<!-- Project Details Go Here-->
								<h2 class="text-uppercase">Project Name</h2>
								<p class="item-intro text-muted">Lorem ipsum dolor sit amet
									consectetur.</p>
								<img class="img-fluid d-block mx-auto"
									src="/assets/img/portfolio/04-full.jpg" alt="" />
								<p>Use this area to describe your project. Lorem ipsum dolor
									sit amet, consectetur adipisicing elit. Est blanditiis dolorem
									culpa incidunt minus dignissimos deserunt repellat aperiam
									quasi sunt officia expedita beatae cupiditate, maiores
									repudiandae, nostrum, reiciendis facere nemo!</p>
								<ul class="list-inline">
									<li>Date: January 2020</li>
									<li>Client: Lines</li>
									<li>Category: Branding</li>
								</ul>
								<button class="btn btn-primary" data-dismiss="modal"
									type="button">
									<i class="fas fa-times mr-1"></i>Close Project
								</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Modal 5-->
	<div class="portfolio-modal modal fade" id="portfolioModal5"
		tabindex="-1" role="dialog" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="close-modal" data-dismiss="modal">
					<img src="/assets/img/close-icon.svg" />
				</div>
				<div class="container">
					<div class="row justify-content-center">
						<div class="col-lg-8">
							<div class="modal-body">
								<!-- Project Details Go Here-->
								<h2 class="text-uppercase">Project Name</h2>
								<p class="item-intro text-muted">Lorem ipsum dolor sit amet
									consectetur.</p>
								<img class="img-fluid d-block mx-auto"
									src="/assets/img/portfolio/05-full.jpg" alt="" />
								<p>Use this area to describe your project. Lorem ipsum dolor
									sit amet, consectetur adipisicing elit. Est blanditiis dolorem
									culpa incidunt minus dignissimos deserunt repellat aperiam
									quasi sunt officia expedita beatae cupiditate, maiores
									repudiandae, nostrum, reiciendis facere nemo!</p>
								<ul class="list-inline">
									<li>Date: January 2020</li>
									<li>Client: Southwest</li>
									<li>Category: Website Design</li>
								</ul>
								<button class="btn btn-primary" data-dismiss="modal"
									type="button">
									<i class="fas fa-times mr-1"></i>Close Project
								</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Modal 6-->
	<div class="portfolio-modal modal fade" id="portfolioModal6"
		tabindex="-1" role="dialog" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="close-modal" data-dismiss="modal">
					<img src="/assets/img/close-icon.svg" />
				</div>
				<div class="container">
					<div class="row justify-content-center">
						<div class="col-lg-8">
							<div class="modal-body">
								<!-- Project Details Go Here-->

								<button class="btn btn-primary" data-dismiss="modal"
									type="button">
									<i class="fas fa-times mr-1"></i>Close
								</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Bootstrap core JS-->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
	<!-- Third party plugin JS-->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.min.js"></script>
	<!-- Contact form JS-->
	<script src="/assets/mail/jqBootstrapValidation.js"></script>
	<script src="/assets/mail/contact_me.js"></script>
	<!-- Core theme JS-->
	<script src="/js/scripts.js"></script>
</html>
<%
	}
%>