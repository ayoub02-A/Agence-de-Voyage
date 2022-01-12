<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>

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

	
	<%@ include file="/include/header.jsp"%>
	
		<header id="gtco-header" class="gtco-cover gtco-cover-sm" role="banner" style="background-image: url(<%=request.getContextPath() %>/Template/images/img_bg_1.jpg)" data-stellar-background-ratio="0.5">
		<div class="overlay"></div>
		<div class="gtco-container">
			<div class="row">
				<div class="col-md-12 col-md-offset-0 text-center">
					

					<div class="row row-mt-15em">
						<div class="col-md-12 mt-text animate-box" data-animate-effect="fadeInUp">
							<!-- <span class="intro-text-small">Hand-crafted by <a href="http://gettemplates.co" target="_blank">GetTemplates.co</a></span> -->
							<h1 class="cursive-font">Have A Look On What We have !</h1>	
						</div>
						
					</div>
							
					
				</div>
			</div>
		</div>
	</header>
	
	
	<div class="gtco-section">
	<form action="#">
		<div class="gtco-container">
			<div class="row">
				<div class="col-md-8 col-md-offset-2 text-center gtco-heading">
					<h2 class="cursive-font primary-color">All Our Lodging </h2>
					
				</div>
			</div>
			<c:forEach var="e" items="${Hebergement}">
			<div class="row">

				<div class="col-lg-4 col-md-4 col-sm-6">
					<a href="AllVoyagehebergement?IdHeber=${e.getId_heberg()}" class="fh5co-card-item ">
						
						<div class="fh5co-text">
										<p class="cursive-font">Lodging</p>
										<h2 >${e.getNom_heberg()}</h2>
										
										<p></p>
										<p></p>
										
										
										
									
								
								<!-- <p>Far far away, behind the word mountains, far from the countries Vokalia..</p>
							<p><span class="price cursive-font">$19.15</span></p>-->
						</div>
					</a>
				</div>
				
			</c:forEach>
		</div>
		</form>
	</div>


	

		

	</div>

	<div class="gototop js-top">
		<a href="#" class="js-gotop"><i class="icon-arrow-up"></i></a>
	</div>

	<!-- jQuery -->
	<script src="<%=request.getContextPath()%>/Template/js/jquery.min.js"></script>
	<!-- jQuery Easing -->
	<script
		src="<%=request.getContextPath()%>/Template/js/jquery.easing.1.3.js"></script>
	<!-- Bootstrap -->
	<script
		src="<%=request.getContextPath()%>/Template/js/bootstrap.min.js"></script>
	<!-- Waypoints -->
	<script
		src="<%=request.getContextPath()%>/Template/js/jquery.waypoints.min.js"></script>
	<!-- Carousel -->
	<script
		src="<%=request.getContextPath()%>/Template/js/owl.carousel.min.js"></script>
	<!-- countTo -->
	<script
		src="<%=request.getContextPath()%>/Template/js/jquery.countTo.js"></script>

	<!-- Stellar Parallax -->
	<script
		src="<%=request.getContextPath()%>/Template/js/jquery.stellar.min.js"></script>

	<!-- Magnific Popup -->
	<script
		src="<%=request.getContextPath()%>/Template/js/jquery.magnific-popup.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/Template/js/magnific-popup-options.js"></script>

	<script src="<%=request.getContextPath() %>/Template/js/moment.min.js"></script>
	<script
		src="<%=request.getContextPath() %>/Template/js/bootstrap-datetimepicker.min.js"></script>


	<!-- Main -->
	<script src="<%=request.getContextPath() %>/Template/js/main.js"></script>

</body>
</html>

