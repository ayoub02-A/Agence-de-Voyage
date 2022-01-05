<%@page import="java.sql.Date"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
  <head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<!-- Meta, title, CSS, favicons, etc. -->
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="icon" href="images/favicon.ico" type="image/ico" />

	<title>Agence de Voyage | </title>
	<link rel="icon" type="image/png" sizes="96x96" href="assets/img/favicon.png">

	<!-- Bootstrap -->
	<link href="vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
	<!-- Font Awesome -->
	<link href="vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
	<!-- NProgress -->
	<link href="vendors/nprogress/nprogress.css" rel="stylesheet">
	<!-- iCheck -->
	<link href="vendors/iCheck/skins/flat/green.css" rel="stylesheet">
	<!-- bootstrap-wysiwyg -->
	<link href="vendors/google-code-prettify/bin/prettify.min.css" rel="stylesheet">
	<!-- Select2 -->
	<link href="vendors/select2/dist/css/select2.min.css" rel="stylesheet">
	<!-- Switchery -->
	<link href="vendors/switchery/dist/switchery.min.css" rel="stylesheet">
	<!-- starrr -->
	<link href="vendors/starrr/dist/starrr.css" rel="stylesheet">
	<!-- bootstrap-daterangepicker -->
	<link href="vendors/bootstrap-daterangepicker/daterangepicker.css" rel="stylesheet">

	<link href="build/css/custom.min.css" rel="stylesheet">
  </head>

  <body class="nav-md">
    <div class="container body">
      <div class="main_container">
        <div class="col-md-3 left_col">
          <div class="left_col scroll-view">
            <div class="navbar nav_title" style="border: 0;">
              <a href="indexAdmin.jsp" class="site_title"><i class="fa fa-paw"></i> <span>Agencia !</span></a>
            </div>

            <div class="clearfix"></div>

            <!-- menu profile quick info -->
            
				<%@ include file="/sideMenuAdmin.jsp" %>
            <!-- /sidebar menu -->
		</div>
	</div>

			<!-- top navigation -->
			<%@ include file="/top_nav.jsp" %>
			<!-- /top navigation -->

			<!-- page content -->
			<div class="right_col" role="main">
				<div class="">
					<div class="page-title">
						<div class="title_left">
							<h3>Ajouter Voyage</h3>
						</div>
						
					</div>
					<div class="clearfix"></div>
					<div class="row">
						<div class="col-md-12 col-sm-12 ">
							<div class="x_panel">
								<div class="x_title">
									<h2>Form</h2>
									<div class="clearfix"></div>
									
								</div>
								<div class="x_content">
									<br />
									<form action="<%=request.getContextPath()%>/AddVoyage" method="post" enctype="multipart/form-data">
										
										<div class="item form-group">
											<label class="col-form-label col-md-3 col-sm-3 label-align" for="last-name">Titre Voyage :<span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 ">
												<input type="text" id="last-name" name="nom" required="required" class="form-control">
											</div>
										</div>
										
										<div class="item form-group">
											<label class="col-form-label col-md-3 col-sm-3 label-align" for="last-name">Destination :<span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 ">
												<input type="text" id="last-name" name="destination" required="required" class="form-control">
											</div>
										</div>
										
										<div class="item form-group">
											<label class="col-form-label col-md-3 col-sm-3  label-align" for="last-name">Duree :<span class="required">*</span></label>
											<div class="col-md-6 col-sm-6">
												<select name="Duree" class="form-control">
													<option disabled="disabled" selected="selected"></option>
													<option>Week-end</option>
													<option>1 semaine</option>
													<option>2 semaine</option>
													<option>long séjour</option>
												</select>
											</div>
										</div>
                                        
                                        <div class="field item form-group">
                                            <label class="col-form-label col-md-3 col-sm-3  label-align">Date de voyage :<span class="required">*</span></label>
                                            <div class="col-md-6 col-sm-6">
                                                <input class="form-control" class='date' type="date" name="date" required='required' min="<%= new java.sql.Date(System.currentTimeMillis()) %>"></div>
                                        </div>
										
										
										<div class="item form-group">
											<label class="col-form-label col-md-3 col-sm-3  label-align" for="last-name">Budget (dhs) :<span class="required">*</span></label>
											<div class="col-md-6 col-sm-6">
												<select name="Budget" class="form-control">
													<option disabled="disabled" selected="selected"></option>
													<option>500</option>
													<option>750</option>
													<option>1000</option>
													<option>1250</option>
													<option>1500</option>
													<option>2000</option>
												</select>
											</div>
										</div>
										
                                       <div class="item form-group">
											<label class="col-form-label col-md-3 col-sm-3 label-align" for="last-name">nombre de participant :<span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 ">
												<input type="number" id="last-name" name="number" required="required" class="form-control">
											</div>
										</div>
										
										 <div class="item form-group">
											<label class="col-form-label col-md-3 col-sm-3 label-align" for="last-name">prix :<span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 ">
												<input type="number" id="last-name" name="prix" required="required" class="form-control" placeholder="(dhs)">
											</div>
										</div>
										
										<div class="item form-group">
											<label class="col-form-label col-md-3 col-sm-3 label-align" for="last-name">Circuit accompagés :<span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 ">
												<select class="form-control"
													name="Circuit" required>
													<c:forEach items="${circuitA}" var="circuitA">
													<option value="${circuitA.getId_circuit()}">${circuitA.getNom_circuit()}</option>
													</c:forEach>
												</select>
											</div>
										</div>
										
										<div class="item form-group">
											<label class="col-form-label col-md-3 col-sm-3 label-align" for="last-name">Type de voyage :<span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 ">
												<select class="form-control"
													name="Type" required>
													<c:forEach items="${vType}" var="vType">
													<option value="${vType.getId_typev()}">${vType.getNom_typev()}</option>
													</c:forEach>
												</select>
											</div>
										</div>
										
										<div class="item form-group">
											<label class="col-form-label col-md-3 col-sm-3 label-align" for="last-name">Type d'hebergement :<span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 ">
												<select class="form-control"
													name="hebergement" required>
													<c:forEach items="${hebergement}" var="hebergement">
													<option value="${hebergement.getId_heberg()}">${hebergement.getNom_heberg()}</option>
													</c:forEach>
												</select>
											</div>
										</div>
										
										<div class="item form-group">
											<label class="col-form-label col-md-3 col-sm-3 label-align" for="last-name">Theme de voyage :<span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 ">
												<select class="form-control"
													name="Theme" required>
													<c:forEach items="${vThemes}" var="vThemes">
													<option value="${vThemes.getId_vtheme()}">${vThemes.getNom_theme()}</option>
													</c:forEach>
												</select>
											</div>
										</div>
										
										<div class="item form-group">
											<label class="col-form-label col-md-3 col-sm-3 label-align">Photo personnelle :<span class="">*</span>
											</label>
											<div class="col-md-6 col-sm-6 ">
												<input required="required" type="file" id="last-name" name="photo" class="form-control">
											</div>
										</div>
										
										
										
										<div class="ln_solid"></div>
										<div class="item form-group">
											<div class="col-md-6 col-sm-6 offset-md-3">
												<button class="btn btn-primary" type="reset">Réinitialiser</button>
												<button type="submit" class="btn btn-success">Ajouter</button>
											</div>
										</div>
									</form>
								</div>
							</div>
							
							
							<div class="page-title">
						<div class="title_left">
							<h3>
								Gestion <small>Voyage</small>
							</h3>
						</div>
						<div></div>
						<div></div>
						<div></div>
						<div></div>
						<div class="title_right">
							<div class="col-md-5 col-sm-5   form-group pull-right top_search">
								<form action="<%=request.getContextPath()%>/VoyageParDate" method="post" >
									<div class="input-group">
										<input type="date" name="mc" class="form-control"
											placeholder="" min="<%= new java.sql.Date(System.currentTimeMillis()) %>"> <span
											class="input-group-btn">
											<button class="btn btn-secondary" type="submit">Go!</button>
										</span>
									</div>
								</form>
								<form action="<%=request.getContextPath()%>/VoyageParDest" method="post" >
									<div class="input-group">
												<select class="form-control" name="Dest" required>
													<option disabled="disabled" selected="selected">Destination voyage...</option>
													<c:forEach items="${Destination}" var="Destination">
														<option>${Destination}</option>
													</c:forEach>
												</select>
												<span class="input-group-btn">
												<button class="btn btn-secondary" type="submit">Go!</button>
										</span>
									</div>
								</form>
							</div>
							<div class="col-md-5 col-sm-5   form-group pull-right top_search">
								<form action="<%=request.getContextPath()%>/VoyageParTheme" method="post" >
									<div class="input-group">
												<select class="form-control" name="Theme" required>
												<option disabled="disabled" selected="selected">Theme voyage...</option>
													<c:forEach items="${vThemes}" var="vThemes">
														<option value="${vThemes.getId_vtheme()}">${vThemes.getNom_theme()}</option>
													</c:forEach>
												</select>
												<span class="input-group-btn">
												<button class="btn btn-secondary" type="submit">Go!</button>
										</span>
									</div>
								</form>
								<form action="<%=request.getContextPath()%>/VoyageParType" method="post" >
									<div class="input-group">
												<select class="form-control" name="Type" required>
												<option disabled="disabled" selected="selected">Type voyage...</option>
													<c:forEach items="${vType}" var="vType">
														<option value="${vType.getId_typev()}">${vType.getNom_typev()}</option>
													</c:forEach>
												</select> <span class="input-group-btn">
											<button class="btn btn-secondary" type="submit">Go!</button>
										</span>
									</div>
								</form>
							</div>
						</div>
						
					</div>
							
							<div class="x_panel">
									<div class="x_title">
										<h2>Gestion</h2>
										
										
										<ul class="nav navbar-right panel_toolbox">
											<li><a class="collapse-link"><i
													class="fa fa-chevron-up"></i></a></li>
										</ul>
										
										<div class="clearfix"></div>
									
								</div>
									<div class="x_content">
										<!-- start project list -->
										<table class="table table-striped projects">
											<thead>
												<tr>
													<th style="width: 5% scope="row">Num</th>
													<th style="width: 25%">Titree</th>
													<th style="width: 20%">destination</th>
													<th style="width: 15%">Date de départ</th>
													<th style="width: 15%">max nombre</th>
													<th style="width: 15%">places restant</th>
													<th>Détails</th>
													<th>Participant</th>
													<th>Supprimer</th>
												</tr>
											</thead>
											<tbody>
												
												<c:forEach items="${lvoyage}" var="lvoyage">
												<c:set var="count" value="${count + 1}" scope="page"/>
													<tr>
														<td>${count}</td>
														<td>${lvoyage.nom_voyage}</td>
														<td>${lvoyage.getDestination()}</td>
														<td>${lvoyage.getDate_depart()}</td>
														<td>${lvoyage.getNbr_participant()}</td>
														
														<td>${lvoyage.getNbrPlace()}</td>
														<td><a href="Details_voyage?idVoyage=${lvoyage.getId_voyage() }" 
															class="btn btn-info btn-xs"><i
																	class="fa fa-info-circle"></i></a></td>
														<td><a href="DeleteThemes?idVoyage=${lvoyage.getId_voyage() }" class="btn btn-dark btn-xs"><i
																class="fa fa-group"></i></a></td>
														<td><a href="deleteVoyage?idVoyage=${lvoyage.getId_voyage() }" class="btn btn-danger btn-xs"><i
																class="fa fa-trash-o"></i></a></td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
										<!-- end project list -->
										
									
									</div>
									
									
									
								</div>
							
							
							
							
							
						</div>
					</div>
				</div>
			</div>
			<!-- /page content -->

			<!-- footer content -->
			<footer>
				<div class="pull-right">
					Agencia - Admin
				</div>
				<div class="clearfix"></div>
			</footer>
			<!-- /footer content -->
		</div>
	</div>

	<!-- jQuery -->
	<script src="vendors/jquery/dist/jquery.min.js"></script>
	<!-- Bootstrap -->
	<script src="vendors/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
	<!-- FastClick -->
	<script src="vendors/fastclick/lib/fastclick.js"></script>
	<!-- NProgress -->
	<script src="vendors/nprogress/nprogress.js"></script>
	<!-- bootstrap-progressbar -->
	<script src="vendors/bootstrap-progressbar/bootstrap-progressbar.min.js"></script>
	<!-- iCheck -->
	<script src="vendors/iCheck/icheck.min.js"></script>
	<!-- bootstrap-daterangepicker -->
	<script src="vendors/moment/min/moment.min.js"></script>
	<script src="vendors/bootstrap-daterangepicker/daterangepicker.js"></script>
	<!-- bootstrap-wysiwyg -->
	<script src="vendors/bootstrap-wysiwyg/js/bootstrap-wysiwyg.min.js"></script>
	<script src="vendors/jquery.hotkeys/jquery.hotkeys.js"></script>
	<script src="vendors/google-code-prettify/src/prettify.js"></script>
	<!-- jQuery Tags Input -->
	<script src="vendors/jquery.tagsinput/src/jquery.tagsinput.js"></script>
	<!-- Switchery -->
	<script src="vendors/switchery/dist/switchery.min.js"></script>
	<!-- Select2 -->
	<script src="vendors/select2/dist/js/select2.full.min.js"></script>
	<!-- Parsley -->
	<script src="vendors/parsleyjs/dist/parsley.min.js"></script>
	<!-- Autosize -->
	<script src="vendors/autosize/dist/autosize.min.js"></script>
	<!-- jQuery autocomplete -->
	<script src="vendors/devbridge-autocomplete/dist/jquery.autocomplete.min.js"></script>
	<!-- starrr -->
	<script src="vendors/starrr/dist/starrr.js"></script>
	<!-- Custom Theme Scripts -->
	<script src="build/js/custom.min.js"></script>

</body></html>
