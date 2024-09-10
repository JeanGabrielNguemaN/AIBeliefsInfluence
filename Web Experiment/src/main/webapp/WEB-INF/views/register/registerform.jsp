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
<body>
<div class="container text-center"">
	<main>
		   
	<hr>
	<br>
	<h3>Registro de usuário</h3>
			 
	<div class="row">
	
		<div class="col-4">
		
		</div>
		<div class="col-5">		 
			
			<form name="frmRegister" action="${pageContext.request.contextPath}/register/add" method="POST">
			 <table>
			 <tr>
				 <td>Nome: </td>
				 <td>
					<input id="username" name="username" value="" type="text" size="15">
				 </td>
				 
				 <td/>
				 <td/> 
			 </tr>
			  <tr>
				 <td>Email: </td>
				 <td>
					<input id="email" name="email" value="" type="text" size="25">
				 </td>
				 
				 <td/>
				 <td/> 
			 </tr>
			 
			  <tr>
				 <td>Password: </td>
				 <td>
					<input id="password" name="password" value="" type="password" size="10">
				 </td>
				 
				 <td/>
				 <td/> 
			 </tr>
			 
			 </table>
			 
			 <table>
				 <tr>
					 <td><input class="w-200 btn btn-primary btn-md"  type="submit" value="[Enviar]"></td>
					 <td></td>
					 <td></td>
				 </tr>
			 </table>
			 
			 </form>
		</div>
		
		<div class="col-3">
		
		</div>
	</div>
			
		 <div class="rodape">
		 <hr>
  		  
		 </div>
	</main>
</div>
</body>
 </html>