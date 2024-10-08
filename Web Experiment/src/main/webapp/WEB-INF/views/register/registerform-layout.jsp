<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.101.0">
    <title>Checkout example · Bootstrap v5.2</title>
	
	<!--bootstrap -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"  rel="stylesheet" 
			integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"  crossorigin="anonymous">
			
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" 
			integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" 
				crossorigin="anonymous"> </script>


    <link rel="canonical" href="https://getbootstrap.com/docs/5.2/examples/checkout/">

    <link href="<c:url value = "/assets/dist/css/bootstrap.min.css"/>" rel="stylesheet">
	
    
    <!-- Custom styles for this template -->
    <!--
	<link href="offcanvas.css" rel="stylesheet">
	-->
	
	<link href="<c:url value = "/offcanvas.css"/>" rel="stylesheet">

    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }

      .b-example-divider {
        height: 3rem;
        background-color: rgba(0, 0, 0, .1);
        border: solid rgba(0, 0, 0, .15);
        border-width: 1px 0;
        box-shadow: inset 0 .5em 1.5em rgba(0, 0, 0, .1), inset 0 .125em .5em rgba(0, 0, 0, .15);
      }

      .b-example-vr {
        flex-shrink: 0;
        width: 1.5rem;
        height: 100vh;
      }

      .bi {
        vertical-align: -.125em;
        fill: currentColor;
      }

      .nav-scroller {
        position: relative;
        z-index: 2;
        height: 2.75rem;
        overflow-y: hidden;
      }

      .nav-scroller .nav {
        display: flex;
        flex-wrap: nowrap;
        padding-bottom: 1rem;
        margin-top: -1px;
        overflow-x: auto;
        text-align: center;
        white-space: nowrap;
        -webkit-overflow-scrolling: touch;
      }
    </style>

    
    <!-- Custom styles for this template -->
    <!--<link href="form-validation.css" rel="stylesheet">-->
	<link href="<c:url value = "/form-validation.css"/>" rel="stylesheet">
  </head>
  <body class="bg-light">
    
<div class="container text-center"">
  <main>
    <div class="py-5 text-center">
      
      <h2>Registro no sistema</h2>
      <p class="lead">É necessário criar uma conta para participar da pesquisa.</p>
    </div>

	<div class="row">
	
		<div class="col-3">
		
		</div>
		<div class="col-8">
		
			<div class="row g-5">
      
			  <div class="col-md-7 col-lg-6">
				
				<form class="needs-validation" novalidate>
				  <div class="row g-3">
				  
					<div class="col-12">
					  <label for="email" class="form-label">Email <span class="text-muted">(login)</span></label>
					  <input type="email" class="form-control" id="email" placeholder="exemplo@email.com">
					  <div class="invalid-feedback">
						Please enter a valid email address for shipping updates.
					  </div>
					</div>
					
					<div class="col-sm-7">
					  <label for="firstName" class="form-label">Senha</label>
					  <input type="password" class="form-control" id="firstName" placeholder="" value="" required>
					  <div class="invalid-feedback">
						Valid first name is required.
					  </div>
					</div>

					<div class="col-sm-7">
					  <label for="lastName" class="form-label">Nome</label>
					  <input type="text" class="form-control" id="lastName" placeholder="" value="" required>
					  <div class="invalid-feedback">
						Valid last name is required.
					  </div>
					</div>
		 
				  </div>
				  
				  </div>

				  <hr class="my-4">

				  <div class="row">
	
					
					<div class="col-5">
						<button class="w-100 btn btn-primary btn-lg" type="submit">Enviar</button>
					</div>
					<div class="col-7">
					
					</div>
				   </div>
				  
				</form>
			  </div>
		</div>
		<div class="col-1">
		
		</div>
	
	</div>

    
    </div>
  </main>

  <footer class="my-5 pt-5 text-muted text-center text-small">
    <p class="mb-1">&copy; 2023–2024 PPGI UNRIO</p>
    <ul class="list-inline">
      <li class="list-inline-item"><a href="#">Privacy</a></li>
      <li class="list-inline-item"><a href="#">Termos</a></li>
      <li class="list-inline-item"><a href="#">Suporte</a></li>
    </ul>
  </footer>
</div>


	  <script src="<c:url value = "/assets/dist/js/bootstrap.bundle.min.js"/>"></script>
	  <script src="<c:url value = "/form-validation.js"/>"></script>
  </body>
</html>
