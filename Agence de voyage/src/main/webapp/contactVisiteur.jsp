<!DOCTYPE HTML>
<%
	if (session.getAttribute("client") == null) {
	response.sendRedirect("indexvisit.jsp");
}
%>
<!--
	Aesthetic by gettemplates.co
	Twitter: http://twitter.com/gettemplateco
	URL: http://gettemplates.co
-->
<html>
	<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Agencia!</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="Free HTML5 Website Template by GetTemplates.co" />
	<meta name="keywords" content="free website templates, free html5, free template, free bootstrap, free website template, html5, css3, mobile first, responsive" />
	<meta name="author" content="GetTemplates.co" />

  	<!-- Facebook and Twitter integration -->
	<meta property="og:title" content=""/>
	<meta property="og:image" content=""/>
	<meta property="og:url" content=""/>
	<meta property="og:site_name" content=""/>
	<meta property="og:description" content=""/>
	<meta name="twitter:title" content="" />
	<meta name="twitter:image" content="" />
	<meta name="twitter:url" content="" />
	<meta name="twitter:card" content="" />

	<link href="https://fonts.googleapis.com/css?family=Lato:300,400,700" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Kaushan+Script" rel="stylesheet">
	
	<!-- Animate.css -->
	<link rel="stylesheet" href="<%=request.getContextPath() %>/Template/css/animate.css">
	<!-- Icomoon Icon Fonts-->
	<link rel="stylesheet" href="<%=request.getContextPath() %>/Template/css/icomoon.css">
	<!-- Themify Icons-->
	<link rel="stylesheet" href="<%=request.getContextPath() %>/Template/css/themify-icons.css">
	<!-- Bootstrap  -->
	<link rel="stylesheet" href="<%=request.getContextPath() %>/Template/css/bootstrap.css">

	<!-- Magnific Popup -->
	<link rel="stylesheet" href="<%=request.getContextPath() %>/Template/css/magnific-popup.css">

	<!-- Bootstrap DateTimePicker -->
	<link rel="stylesheet" href="<%=request.getContextPath() %>/Template/css/bootstrap-datetimepicker.min.css">



	<!-- Owl Carousel  -->
	<link rel="stylesheet" href="<%=request.getContextPath() %>/Template/css/owl.carousel.min.css">
	<link rel="stylesheet" href="<%=request.getContextPath() %>/Template/css/owl.theme.default.min.css">

	<!-- Theme style  -->
	<link rel="stylesheet" href="<%=request.getContextPath() %>/Template/css/style.css">

	<!-- Modernizr JS -->
	<script src="<%=request.getContextPath() %>/Template/js/modernizr-2.6.2.min.js"></script>
	<!-- FOR IE9 below -->
	<!--[if lt IE 9]>
	<script src="js/respond.min.js"></script>
	<![endif]-->

	</head>
	<body>
		
	<div class="gtco-loader"></div>
	
	<div id="page">

	
	<nav class="gtco-nav" role="navigation">
			<div class="gtco-container">

				<div class="row">
					<div class="col-sm-4 col-xs-12">
						<div id="gtco-logo">
							<a href="AllTripVisiteur">Agencia <em>!</em></a>
						</div>
					</div>
					<div class="col-xs-8 text-right menu-1">
						<ul>
							<li><a href="AllTripVisiteur">Menu</a></li>
							<li class="has-dropdown"><a href="#">Services</a>
								<ul class="dropdown">
									<li><a href="AllTypeVoyage">type of trip</a></li>
									<li><a href="AllThemeVoyage">Theme Trip</a></li>
									<li><a href="AllHebergement">Lodging</a></li>
								</ul></li>
							<li class="has-dropdown"><a href="AboutUsVisiteur.jsp">About us</a>
								<ul class="dropdown">
									<li><a href="contactVisiteur.jsp">Contact us</a></li>

								</ul></li>

							<li><a href="Login.jsp">Sign in | Sign up</a></li>


						</ul>
					</div>
				</div>

			</div>
		</nav>
		
	
	<header id="gtco-header" class="gtco-cover gtco-cover-sm" role="banner" style="background-image: url(<%=request.getContextPath() %>/Template/images/img_bg_3.jpg)">
		<div class="overlay"></div>
		<div class="gtco-container">
			<div class="row">
				<div class="col-md-12 col-md-offset-0 text-center">

					<div class="row row-mt-15em">
						<div class="col-md-12 mt-text animate-box" data-animate-effect="fadeInUp">
							<!-- <span class="intro-text-small">Hand-crafted by <a href="http://gettemplates.co" target="_blank">GetTemplates.co</a></span> -->
							<h1 class="cursive-font">Contact us !</h1>	
						</div>
						
					</div>
					
				</div>
			</div>
		</div>
	</header>
	
	
	<div class="gtco-section">
		<div class="gtco-container">
			<div class="row">
				<div class="col-md-12">
					<div class="col-md-6 animate-box">
					<h3>Get In Touch</h3>
					<form action="#">
						<div class="row form-group">
							<div class="col-md-12">
								<label class="sr-only" for="name">Name</label>
								<input type="text" id="name" class="form-control" placeholder="Your firstname">
							</div>
							
						</div>

						<div class="row form-group">
							<div class="col-md-12">
								<label class="sr-only" for="email">Email</label>
								<input type="text" id="email" class="form-control" placeholder="Your email address">
							</div>
						</div>
						<div class="row form-group">
							<div class="col-md-12">
								<label class="sr-only" for="message">Message</label>
								<textarea name="message" id="message" cols="30" rows="10" class="form-control" placeholder="Write us something"></textarea>
							</div>
						</div>
						<div class="form-group">
							<input type="submit" value="Send Message" class="btn btn-primary">
						</div>

					</form>		
				</div>
				<div class="col-md-5 col-md-push-1 animate-box">
					
					<div class="gtco-contact-info">
						<h3>Contact Information</h3>
						<ul>
							<li class="address">198 West 21th Street, <br> Suite 721 New York NY 10016</li>
							<li class="phone"><a href="tel://1234567920">+ 1235 2355 98</a></li>
							<li class="email"><a href="mailto:info@yoursite.com">info@yoursite.com</a></li>
							<li class="url"><a href="http://FreeHTML5.co">FreeHTML5.co</a></li>
						</ul>
					</div>


				</div>
				</div>
			</div>
		</div>
	</div>

	<footer id="gtco-footer" role="contentinfo" style="background-image: url(<%=request.getContextPath() %>/Template/images/img_bg_1.jpg)" data-stellar-background-ratio="0.5">
		<div class="overlay"></div>
		<div class="gtco-container">
			<div class="row row-pb-md">

				

				
				<div class="col-md-12 text-center">
					<div class="gtco-widget">
						<h3>Get In Touch</h3>
						<ul class="gtco-quick-contact">
							<li><a href="#"><i class="icon-phone"></i> +1 234 567 890</a></li>
							<li><a href="#"><i class="icon-mail2"></i> info@GetTemplates.co</a></li>
							<li><a href="#"><i class="icon-chat"></i> Live Chat</a></li>
						</ul>
					</div>
					<div class="gtco-widget">
						<h3>Get Social</h3>
						<ul class="gtco-social-icons">
							<li><a href="#"><i class="icon-twitter"></i></a></li>
							<li><a href="#"><i class="icon-facebook"></i></a></li>
							<li><a href="#"><i class="icon-linkedin"></i></a></li>
							<li><a href="#"><i class="icon-dribbble"></i></a></li>
						</ul>
					</div>
				</div>

				<div class="col-md-12 text-center copyright">
					<p><small class="block">&copy; 2016 Free HTML5. All Rights Reserved.</small> 
						<small class="block">Designed by <a href="http://gettemplates.co/" target="_blank">GetTemplates.co</a> Demo Images: <a href="http://unsplash.com/" target="_blank">Unsplash</a></small></p>
				</div>

			</div>

			

		</div>
	</footer>
	<!-- </div> -->

	</div>

	<div class="gototop js-top">
		<a href="#" class="js-gotop"><i class="icon-arrow-up"></i></a>
	</div>
	
	<!-- jQuery -->
	<script src="<%=request.getContextPath() %>/Template/js/jquery.min.js"></script>
	<!-- jQuery Easing -->
	<script src="<%=request.getContextPath() %>/Template/js/jquery.easing.1.3.js"></script>
	<!-- Bootstrap -->
	<script src="<%=request.getContextPath() %>/Template/js/bootstrap.min.js"></script>
	<!-- Waypoints -->
	<script src="<%=request.getContextPath() %>/Template/js/jquery.waypoints.min.js"></script>
	<!-- Carousel -->
	<script src="<%=request.getContextPath() %>/Template/js/owl.carousel.min.js"></script>
	<!-- countTo -->
	<script src="<%=request.getContextPath() %>/Template/js/jquery.countTo.js"></script>

	<!-- Stellar Parallax -->
	<script src="<%=request.getContextPath() %>/Template/js/jquery.stellar.min.js"></script>

	<!-- Magnific Popup -->
	<script src="<%=request.getContextPath() %>/Template/js/jquery.magnific-popup.min.js"></script>
	<script src="<%=request.getContextPath() %>/Template/js/magnific-popup-options.js"></script>
	
	<script src="<%=request.getContextPath() %>/Template/js/moment.min.js"></script>
	<script src="<%=request.getContextPath() %>/Template/js/bootstrap-datetimepicker.min.js"></script>


	<!-- Main -->
	<script src="<%=request.getContextPath() %>/Template/js/main.js"></script>

	</body>
</html>

