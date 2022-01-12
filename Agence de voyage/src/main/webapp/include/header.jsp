	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

	
	<!-- <div class="page-inner"> -->
	<nav class="gtco-nav" role="navigation">
		<div class="gtco-container">
			
			<div class="row">
				<div class="col-sm-4 col-xs-12">
					<div id="gtco-logo"><a href="listFormulaireDeRecherche">Agencia <em>!</em></a></div>
				</div>
				<div class="col-xs-8 text-right menu-1">
					<ul>
						<li><a href="AllTrip">Menu</a></li>
						<li class="has-dropdown">
							<a >Services</a>
							<ul class="dropdown">
								<li><a href="AllTypeVoyage">type of trip</a></li>
								<li><a href="AllThemeVoyage">Theme Trip</a></li>
								<li><a href="AllHebergement">Lodging</a></li>
							</ul>
						</li>
						<li class="has-dropdown">
							<a href="AboutUs.jsp">About us</a>
							<ul class="dropdown">
								<li><a href="contact.jsp">Contact us</a></li>
								
							</ul>
						</li>

					<c:if test="${empty sessionScope.client}">
						<li><a href="Login.jsp">Sign in | Sign up</a></li>
					</c:if>


					<c:if test="${!empty sessionScope.client}">
						<li><a href="VoyageDuPanier?idClient=${client.id_client}"><span>Panier</span></a></li>
						<li><a href="ProfilClient?idClient=${client.id_client}"><span>Profil</span></a></li>
						<li><a href="logout">Log Out</a><i class="icon-logout"></i></li>
						
						
					</c:if>
				</ul>	
				</div>
			</div>
			
		</div>
	</nav>
	