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
							<h3>Ajouter Circuit accompagnés</h3>
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
									<form action="<%=request.getContextPath()%>/AddCircuit" method="post" enctype="multipart/form-data">
										
										<div class="item form-group">
											<label class="col-form-label col-md-3 col-sm-3 label-align" for="last-name">Nom complet :<span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 ">
												<input type="text" id="last-name" name="nom" required="required" class="form-control">
											</div>
										</div>
										
										<div class="field item form-group">
                                            <label class="col-form-label col-md-3 col-sm-3  label-align">email :<span class="required">*</span></label>
                                            <div class="col-md-6 col-sm-6">
                                                <input class="form-control" name="email" class='email' required="required" type="email" /></div>
                                        </div>
										
										<div class="field item form-group">
                                            <label class="col-form-label col-md-3 col-sm-3  label-align">Telephone<span class=""></span></label>
                                            <div class="col-md-6 col-sm-6">
                                                <input class="form-control" type="text" class='tel' name="telephone" data-validate-length-range="8,30" /></div>
                                        </div>
                                        
                                        <div class="item form-group">
											<label class="col-form-label col-md-3 col-sm-3 label-align" for="last-name">langues :<span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 ">
												<input type="text" id="last-name" name="langues" required="required" class="form-control">
											</div>
										</div>
										
										<div class="item form-group">
											<label class="col-form-label col-md-3 col-sm-3 label-align" for="first-name">Déscription :<span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 ">
												<textarea id="message" required="required" class="form-control" name="descrip" data-parsley-trigger="keyup"
										 data-parsley-minlength="5" data-parsley-maxlength="10000000000000000000000" 
										 data-parsley-minlength-message="Come on! You need to enter at least a 20 caracters long comment.."
										  data-parsley-validation-threshold="10"></textarea>
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
													<th style="width: 10% scope="row">Num</th>
													<th style="width: 15%">Image</th>
													<th style="width: 20%">Nom complet</th>
													<th style="width: 20%">Email</th>
													<th style="width: 15%">telephone</th>
													<th>Détails</th>
													<th>Voyages</th>
													<th>Supprimer</th>
												</tr>
											</thead>
											<tbody>
												
												<c:forEach items="${circuitA}" var="circuitA">
												<c:set var="count" value="${count + 1}" scope="page"/>
													<tr>
														<td>${count}</td>
														<td>${circuitA.getPhoto_circuit()} <img src="data:image/jpg;base64,${circuitA.getBase64Image()}" width="70" height="70"/></td>
														<td>${circuitA.getNom_circuit()}</td>
														<td>${circuitA.getEmail_circuit()}</td>
														<td>${circuitA.getTel_circuit()}</td>
														<td><a href="Details_circuit?idCircuit=${circuitA.getId_circuit()}" class="btn btn-info btn-xs"><i
																class="fa fa-info-circle"></i></a></td>
														<td><a href="VoyageCercuit?idCircuit=${circuitA.getId_circuit()}" class="btn btn-dark btn-xs"><i
																class="fa fa-plane"></i></a></td>
														<td><a href="DeleteCircuit?idCircuit=${circuitA.getId_circuit()}" class="btn btn-danger btn-xs"><i
																class="fa fa-trash-o"></i></a></td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
										<!-- end project list -->
										
									
									</div>
									
									<a href="pdfCircuit" class="btn btn-secondary btn-xs"><i
																class="fa fa-file-pdf-o"></i></a>
									
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
