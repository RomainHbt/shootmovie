<!DOCTYPE html>
<html lang="fr">
	<head>
		<!-- Bonjour -->
		<title>ShootMovie</title>
		<meta charset='utf-8'>
		<!-- jQuery -->
		<script src="//code.jquery.com/jquery-1.11.2.min.js"></script>
		<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
		
		<!-- bootstrap -->
		<link rel="stylesheet" href="css/bootstrap.css">
		<script src="js/bootstrap.min.js"></script>
		
		<!-- Code local -->
		<script src="all.js"></script>
	</head>
	<body>

<!-- ----------------- MENU HAUT ------------------- -->
<%@ include file="/elements/menu.jsp" %>
<!-- ----------------- FIN MENU HAUT ------------------- -->
		<div class="container">
			<form class="form-inline" style="float:right; padding-bottom:5px" role="search">
	        	<div class="input-group">
	        		<span class="input-group-addon" id="loupe-recherche"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></span>
	          		<input type="text" class="form-control" aria-describedby="loupe-recherche">
	        	</div>
	      	</form>
	      	<div style="clear:both"></div>
	      	
	      	<!-- DEBUT CAROUSEL -->
	      	<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
			  <!-- Indicators -->
			  <ol class="carousel-indicators">
			    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
			    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
			  </ol>
			
			  <!-- Wrapper for slides -->
			  <div class="carousel-inner" role="listbox">
			    <div class="item active">
			      <img src="http://placehold.it/1170x300">
			      <div class="carousel-caption">
			       	Slide 1
			      </div>
			    </div>
			    <div class="item">
			      <img src="http://placehold.it/1170x300">
			      <div class="carousel-caption">
			        Slide 2
			      </div>
			    </div>
			  </div>
			</div>
	      	<!-- FIN CAROUSEL -->
	      	
			<div class="row">
				<div class="col-md-4">
					<div class="panel panel-default">
					  <div class="panel-heading">Acc�der au contenu</div>
					  <div class="panel-body">
					  	<p><a href="inscription.html">Inscrivez-vous</a> pour pouvoir acc�der aux r�alisations post�es sur ShootMovie.</p>
					   	<img src="http://placehold.it/200x150" width="100%" />
					   	<hr>
					   	<a href="login.html" role="button" class="btn btn-block btn-default">Se connecter</a>
					   	<a href="inscription.html" role="button" class="btn btn-block btn-danger">S'inscrire</a>
					  </div>
					</div>
					<div class="panel panel-default">
					  <div class="panel-body">
					  	<a href="mailto:romain.hembert@gmail.com">Contacter l'administrateur</a> - <a href="#">A propos</a>
					  </div>
					</div>
				</div>
				<div class="col-md-8">
					<div class="panel panel-default">
					  <div class="panel-heading">R�alisations du moment</div>
					  <div class="panel-body">
					    Liste de vid�o
					  </div>
					</div>
					<div class="panel panel-default">
					  <div class="panel-heading">Dernières r�alisations</div>
					  <div class="panel-body">
					    Liste de vid�os
					  </div>
					</div>
					<div class="row">
						<div class="col-md-6">
							<div class="panel panel-default">
							  <div class="panel-heading">Meilleures s�ries</div>
							  <div class="panel-body">
							    Liste de vid�os
							  </div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="panel panel-default">
							  <div class="panel-heading">Derniers �pidoses</div>
							  <div class="panel-body">
							    Liste
							  </div>
							</div>
						</div>
					</div>
				</div>
				
			</div>
			
		</div>
	</body>
</html>
