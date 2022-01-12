<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
	<title>Savory &mdash; Free Website Template, Free HTML5 Template by GetTemplates.co</title>
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
							<li class="has-dropdown"><a href="services.jsp">Services</a>
								<ul class="dropdown">
									<li><a href="AllTypeVoyage">type of trip</a></li>
									<li><a href="VoyageTheme.jsp">Theme Trip</a></li>
									<li><a href="Hebergement.jsp">Lodging</a></li>
								</ul></li>
							<li class="has-dropdown"><a href="AboutUs.jsp">About us</a>
								<ul class="dropdown">
									<li><a href="contact.jsp">Contact us</a></li>

								</ul></li>

							<li><a href="Login.jsp">Sign in | Sign up</a></li>


						</ul>
					</div>
				</div>

			</div>
		</nav>
		
		

	<header id="gtco-header" class="gtco-cover gtco-cover-md"
			role="banner"
			style="background-image: url(<%=request.getContextPath()%>/Template/images/img_bg_1.jpg)"
			data-stellar-background-ratio="0.5">
			<div class="overlay"></div>
			<div class="gtco-container">
				<div class="row">
					<div class="col-md-12 col-md-offset-0 text-left">


						<div class="row row-mt-15em">
							<div class="col-md-7 mt-text animate-box"
								data-animate-effect="fadeInUp">
								<!-- <span class="intro-text-small">Hand-crafted by <a href="http://gettemplates.co" target="_blank">GetTemplates.co</a></span> -->
								<h1 class="cursive-font">Enjoy Our Trip !</h1>
							</div>
							<div class="col-md-4 col-md-push-1 animate-box"
								data-animate-effect="fadeInRight">
								<div class="form-wrap">
									<div class="tab">

										<div class="tab-content">
											<div class="tab-content-inner active" data-content="signup">
												<h3 class="cursive-font">Search Table</h3>
												<form action="RechercheParPlusieursMotsCles" method="post" >
													<div class="row form-group">

														<div class="col-md-12">

															<label for="activities">Destination</label> <select
																name="destination" id="activities" class="col-md-12">
																<option disabled="disabled" selected="selected">Destination</option>
																<c:forEach var="e" items="${Destination}">
																	<option value='<c:out value="${e.getDestination()}"/>'><c:out
																			value="${e.getDestination()}" /></option>
																	
																</c:forEach>
															</select>
														</div>


													</div>

													<div class="row form-group">

														<div class="col-md-12">
															<label for="activities">Type de voyage</label> 
															<select name="Id_Type_de_Voyage" id="activities"
																class="col-md-12" >
																<option disabled="disabled" selected="selected">Type</option>
																<c:forEach var="e" items="${Type_de_Voyage}">
																	
																	
																	<option value='<c:out value="${e.getId_typev()}"/>'><c:out
																			value="${e.getNom_typev()}" /></option>
																</c:forEach>
															</select>

														</div>

													</div>
													<div class="row form-group">
														<div class="col-md-12">
															<label>Date de depart</label> 
															<input type="date" name="date" class="col-md-12" min="<%= new java.sql.Date(System.currentTimeMillis()) %>" required>

														</div>
													</div>
												<div class="row form-group">
														<div class="col-md-12">

															<label for="activities">duree</label> <select
																name="duree" id="activities" class="col-md-12">
																<option disabled="disabled" selected="selected">Duree</option>
																<c:forEach var="e" items="${duree}">
																	<option value='<c:out value="${e.getDuree()}"/>'><c:out
																			value="${e.getDuree()}" /></option>

																</c:forEach>
															</select>
														</div>
													</div>
													<div class="row form-group">
														<div class="col-md-12">


															<label for="activities">budget</label> <select
																name="budget" id="activities" class="col-md-12">

																<option disabled="disabled" selected="selected">Budget</option>
																<option value="500">500</option>
																<option value="750">750</option>
																<option value="1000">1000</option>
																<option value="1000">1250</option>
																<option value="1000">1500</option>
																<option value="1000">2000</option>


															</select>
														</div>
													</div>


													<div class="row form-group">
														<div class="col-md-12">
															<input type="submit" class="btn btn-primary btn-block"
																value="Search Now">
														</div>
													</div>
												</form>
											</div>


										</div>
									</div>
								</div>
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
					<h2 class="cursive-font primary-color">All Our Trips</h2>
					<p>Try Us Once You Will Enjoy And Be Surprised </p>
				</div>
			</div>
			<c:forEach var="e" items="${Voyage}">
			<div class="row">

				<div class="col-lg-4 col-md-4 col-sm-6">
					<a href="AllDetailsTrip?Id_Voyage=${e.getId_voyage()}"
									class="fh5co-card-item ">
						<figure>
							<div class="overlay"><i class="ti-plus"></i></div>
							<!-- <img src="/Template/images/img_1.jpg" alt="Image" class="img-responsive"> -->
						   <img src="data:image/jpg;base64,${e.getBase64Image()}" width="350" height="350" value="${e.getPhoto_voyage()}"/>
						</figure>
						<div class="fh5co-text">
							
										<h2>${e.getNom_voyage()}</h2>
										<p>To ${e.getDestination()}</p>
										<p>Period of : ${e.getDuree()}</p>
										<p>Will begin at ${e.getDate_depart()}</p>
										<p>Number of participants : ${e.getNbr_participant()}</p>
										<p><span class="price cursive-font">From : ${e.getBudget()}DH</span></p>
										
										
									
								
								<!-- <p>Far far away, behind the word mountains, far from the countries Vokalia..</p>
							<p><span class="price cursive-font">$19.15</span></p>-->
						</div>
					</a>
				</div>
				
			</c:forEach>
		</div>
		</form>
	</div>

	<div class="gtco-cover gtco-cover-sm" style="background-image: url(<%=request.getContextPath() %>/Template/images/img_bg_1.jpg)"  data-stellar-background-ratio="0.5">
		<div class="overlay"></div>
		<div class="gtco-container text-center">
			<div class="display-t">
				<div class="display-tc">
					<h1>&ldquo; ~ Try Us First Then Judge !&rdquo;</h1>
				
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
							<li><a href="#"><i class="icon-phone"></i>+212 645482727</a></li>
						</ul>
					</div>
					<div class="gtco-widget">
						<h3>Get Social</h3>
						<ul class="gtco-social-icons">
							<li><a href="#"><i class="icon-twitter"></i></a></li>
							<li><a href="#"><i class="icon-facebook"></i></a></li>
							<li><a href="#"><i class="icon-linkedin"></i></a></li>
						</ul>
					</div>
				</div>

				<div class="col-md-12 text-center copyright">
					<p><small class="block">&copy; 2021 All Rights Reserved.</small> 
						<small class="block">Designed by <a href="http://gettemplates.co/" target="_blank">GetTemplates.co</a> </small></p>
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

