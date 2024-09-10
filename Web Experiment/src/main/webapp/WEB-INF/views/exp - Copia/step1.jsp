<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
	
    <title>Step 1</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/style.css">
	
	<!--bootstrap -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"  rel="stylesheet" 
			integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"  crossorigin="anonymous">
			
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" 
			integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" 
				crossorigin="anonymous"> </script>



    <!-- Bootstrap5 CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/css/bootstrap.min.css" integrity="sha384-r4NyP46KrjDleawBgD5tp8Y7UzmLA05oM1iAEQ17CSuDqnUK2+k9luXQOfXJCJ4I" crossorigin="anonymous">
    
	
	
    <!-- Bootstrap icons -->
   <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
	
	<style>
	
	.div-wrapper {
		height: 200px;
		margin-top: 40px;
		border: 2px dashed #ddd;
		border-radius: 8px;
	}
	 
	.div-to-align {
		width: 75%;
		padding: 40px 20px;
	}
    /* .... */
}
	</style>
	
	
	<!--
	Para costumizar alertas
	Fonte: https://sweetalert.js.org/guides/
	https://sweetalert.js.org/guides/
	-->
	 <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	
	
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" 
		crossorigin="anonymous"> </script>
		
		
		
<script>	
	$(document).ready(function(){
			
		$("#enviar").on("click", function(){
		
			
			
			var radio=$("input[type='radio'][name=opinion]:checked", '#frmStep1').val();
			
			if (radio == null){
				//alert("Você precisa opinar! ");
				//swal("Você precisa opinar!");
				//success, error or infor
				swal("Campo obrigatório!", "Você precisa opinar!", "error");
				return false;
			}
	
			radio=$("input[type='radio'][name=confianca]:checked", '#frmStep1').val();
			
			if (radio == null){
				//alert("Você precisa selecionar o quanto confia na sua opinião! ");
				swal("Campo obrigatório!", "Você precisa selecionar o quanto confia na sua opinião!", "error");
				return false;
			}
			
			return true;
			
		});
	});
</script>
</head>
<body>
<div style="height: 800px;">
<div class="container h-100" >
	<div class="row  h-25 align-items-center">
		<header class="p-3 mb-3 border-bottom">
			<%@ include file="../src/navbar.jsp" %>
		</header>
	</div>

	<div class="row h-25  row align-items-center">
		<div class="col-1">
		  
		</div>
		
		<div class="col-10">
			
			<form id="frmStep1" name="frmStep1" action="${pageContext.request.contextPath}/exp/fase1/save" method="get">
			
			<input type="hidden" id="sessioncode" name="sessioncode" value="${sessioncode}">
			
			<input type="hidden" id="stepid" name="stepid" value="1">
		
			<div class="row p-3 align-items-center">
				<div class="col-12">
					
					<h5>Etapa 1:&nbsp;Seu julgamento&nbsp;<span class="badge bg-secondary">Atividade ${quantity} de ${total}</span></h5>
					<div class="row p-3 align-items-center">
						<div class="col-12">
							<P></P>
							<div class="alert alert-secondary" role="alert">
							  <p>
							  ${newsstory}
							  </p>
							</div>				
						</div>
					</div>
							
				</div>
			</div>
			
			
			
			<div class="row p-3 align-items-center">
			
				<div class="col-1">
					<p>
					
					</p>
				</div>
				<div class="col-10">
				
				<div class="shadow-lg p-3 mb-5 bg-body rounded">
				<h5>Qual sua opinião sobre esta notícia?</h5>
				<hr>
				<div class="form-check">
				  <input class="form-check-input" type="radio" name="opinion" id="flexRadioDefault1" value="falsa">
				  <label class="form-check-label" for="flexRadioDefault1">
					Eu acho essa notícia falsa
				  </label>
				</div>
				<div class="form-check">
				  <input class="form-check-input" type="radio" name="opinion" value="verdadeira" id="flexRadioDefault2">
				  <label class="form-check-label" for="flexRadioDefault2" >
					Eu acho essa notícia verdadeira
				  </label>
				</div>
				</div>	
				</div>
				
				<div class="col-1">
					<p>
					
					</p>
				</div>
			</div>
			
			
			<div class="row p-1 align-items-center">
			
				<div class="col-1">
					<p>
					
					</p>
				</div>
				
				<div class="col-10">
					<div class="shadow-lg p-3 mb-5 bg-body rounded">
					<h5>Favor indica o quanto você confia na tua própria na resposta anterior</h5>
					<hr>
					
						<div class="form-check form-check-inline">
						  <input class="form-check-input" type="radio" name="confianca" id="inlineRadio1" value="1">
						  <label class="form-check-label" for="inlineRadio1">1</label>
						</div>
						<div class="form-check form-check-inline">
						  <input class="form-check-input" type="radio" name="confianca" id="inlineRadio2" value="2">
						  <label class="form-check-label" for="inlineRadio2">2</label>
						</div>
						<div class="form-check form-check-inline">
						  <input class="form-check-input" type="radio" name="confianca" id="inlineRadio3" value="3">
						  <label class="form-check-label" for="inlineRadio3">3</label>
						</div>
						
						<div class="form-check form-check-inline">
						  <input class="form-check-input" type="radio" name="confianca" id="inlineRadio4" value="4">
						  <label class="form-check-label" for="inlineRadio3">4</label>
						</div>
						
						<div class="form-check form-check-inline">
						  <input class="form-check-input" type="radio" name="confianca" id="inlineRadio5" value="5">
						  <label class="form-check-label" for="inlineRadio5">5</label>
						</div>
						<div class="form-check form-check-inline">
						  <input class="form-check-input" type="radio" name="confianca" id="inlineRadio6" value="6">
						  <label class="form-check-label" for="inlineRadio3">6</label>
						</div>
						
						<div class="form-check form-check-inline">
						  <input class="form-check-input" type="radio" name="confianca" id="inlineRadio7" value="7">
						  <label class="form-check-label" for="inlineRadio3">7</label>
						</div>
						
					</div>
					
					<div class="row p-2 align-items-center">
				
						<button id="enviar" type="submit" class="btn btn-primary btn-lg">Avançar</button>
				
					</div>					
				</div>
				
				<div class="col-1">
					<p>
					
					</p>
					</div>
				</div>
			
				
				
			</form>
		</div>
		
		<div class="col-1">
		  
		</div>
	</div>
	
	<div class="row h-25  row align-items-center">
	
	</div>
  
	
</div>
</div>
</body>
</html>