<%if(session.getAttribute("nom")==null){
	response.sendRedirect("loginAdmin.jsp");
}
%>

			<div class="profile clearfix">
              <div class="profile_pic">
                <img src="images/img.jpg" alt="..." class="img-circle profile_img">
              </div>
              <div class="profile_info">
                <span>Welcome,</span>
                <h2>${sessionScope.nom}</h2>
              </div>
            </div>
            <!-- /menu profile quick info -->
            
            
            <br />

            <!-- sidebar menu -->
            <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
              <div class="menu_section">
                <h3>General</h3>
                <ul class="nav side-menu">
                  <li><a href="Home"><i class="fa fa-home"></i> Home </a></li>
                  <li><a><i class="fa fa-edit"></i> Messages <span class="fa fa-chevron-down"></span></a>
                  <ul class="nav child_menu">
                      <li><a href="ListMessageNonVue"> Message non vue </a></li>
                      <li><a href="MessageVue"> Message vue </a></li>
                    </ul>
                  </li>
                  <li><a href="listClients"><i class="fa fa-edit"></i> Gestion de clients </a></li>
                  <li><a><i class="fa fa-edit"></i> Gestion de Voyage <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="ListVoyage"> Voyages en cours </a></li>
                      <li><a href="listVoyageExpir"> Voyages expirés </a></li>
                    </ul>
                  </li>
                  
                  
                  <li><a href="ListCircuit"><i class="fa fa-edit"></i> Circuit Accompagnés </a></li>
                  <li><a href="ListHeberg"><i class="fa fa-edit"></i> Type d'hebergements </a></li>
                  <li><a href="ListTheme"><i class="fa fa-edit"></i> Theme de Voyages </a></li>
                  <li><a href="ListType"><i class="fa fa-edit"></i> Type de Voyages </a></li>
                  
                  
                  
                  
                  
                              
                  
                </ul>
              </div>

            </div>