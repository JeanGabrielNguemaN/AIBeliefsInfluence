<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<!DOCTYPE html>
<html lang="en">
<head>
<title>Registro de Participante</title>
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
	
	 <!-- Bootstrap icons -->
   <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
	

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
</head>
<body class="bg-light">

<div style="height: 600px;">

<div class="container h-100" >

	<div class="row  h-25 align-items-center">
	
	</div> 
	<div class="row h-25  row align-items-center">
		<div class="col-4">
		
		</div>
		
		<div class="col-auto text-center">	
			
			
			<div class="row-auto align-items-center">
			
				<form action="${pageContext.request.contextPath}/login" class="was-validated" method="post">
				
					<div class="row p-1">
						<div class="col-md-12">
						
							
							<div class="form-group">
							
								<div class="input-group mb-3">
									<span class="input-group-text" id="grp1"><i class="bi bi-envelope-at-fill"></i></span>
									<input type="text" class="form-control" id="username" name="username" 
									placeholder="Email do registro" 
									aria-label="Username" aria-describedby="grp1" required>
									<div class="invalid-feedback">Favor, informe o usuário.</div>
								</div>
								
								<div class="input-group mb-3">
									<span class="input-group-text" id="grp-password"><i class="bi bi-lock-fill"></i></span>
									<input type="password" class="form-control" id="password" name="password"   
										placeholder="Senha de acesso"  aria-label="Password"  
										aria-describedby="grp-password" required>
									<div class="invalid-feedback">Favor, informe a senha.</div>
								</div>
							  
							  
							</div>
						</div>
					</div>
						
					
					
					<c:if test="${not empty errorMessge}">
					<div class="row p-1" style="color:red; font-weight: bold; margin: 30px 0px;">${errorMessge}</div>
					</c:if>
					
					<div class="row ">
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
						
						<button type="submit" class="btn btn-primary">Enviar</button>
					
					</div>
			
				</form>
				
				<div class="row ">
					<p>Não possui conta? <span><a href="${pageContext.request.contextPath}/register">Registra-se!</a></span></p>
				
					
				</div>
			</div>
			
 
		</div>
		<div class="col-4">
		  
		</div>
	</div>
	
	<div class="row h-25  row align-items-center">
	
	</div>
</div>
</div>
</body>
</html>