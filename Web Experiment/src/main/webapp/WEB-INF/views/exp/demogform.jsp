 <%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<!DOCTYPE html>
<html lang="en">
<head>
	
    <title>Informações básicas</title>

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
	
	.body-height{
		height: 800px;
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
		
			var radio=$("input[type='radio'][name=sexo]:checked", '#frmDemo').val();
			
			if (radio == null){
			
				//("Você precisa selecionar o sexo! ");
				swal("Campo obrigatório!", "Você precisa selecionar o sexo!", "error");
				
					return false;
			}
		
		
			radio=$("input[type='radio'][name=estadocivil]:checked", '#frmDemo').val();
			
			if (radio == null){
			
				//alert("Você precisa selecionar seu estado civil! ");
				
				swal("Campo obrigatório!", "Você precisa informar estado civil!", "error");	
				return false;
			}
			
			
			radio=$("input[type='radio'][name=radioidade]:checked", '#frmDemo').val();
			
			if (radio == null){
				//alert("Você precisa selecionar a idade! ");
				
				swal("Campo obrigatório!", "Você precisa informar sua idade!", "error");	
				return false;
			}
			
			
			
			radio=$("input[type='radio'][name=escolaridade]:checked", '#frmDemo').val();
			if (radio == null){
				//alert("Você precisa selecionar a escolaridade! ");
				
				swal("Campo obrigatório!", "Você precisa informar seu nível de escolaridade!", "error");	
				return false;
			}
			
			radio=$("input[type='radio'][name=renda]:checked", '#frmDemo').val();
			
			if (radio == null){
				//alert("Você precisa selecionar a faixa de renda! ");
				
				swal("Campo obrigatório!", "Você precisa informar sua faixa de renda!", "error");	
				
				return false;
			}
			return true;
				
			
		});
	
		
		
	});
</script>
</head>
<body>

<div class="container body-height">

<div class="container h-100" >

	<div class="row h-25 align-items-center">
		<header class="p-3 mb-3 border-bottom">
			<%@ include file="../src/navbar.jsp" %>
		</header>
		
	</div>
	<div class="row align-items-center bg-light">
		
		
		<div class="col-12">
		
			<div class="row p-1 align-items-center">
				<div class="col-12 text-center">
					
					<h3>Precisamos de algumas informações básicas suas, que são totalmente anônimas&nbsp;</h3>
					
					<P></P>
							
				</div>
			</div>
			
			<div class="my-3 p-3 bg-body rounded shadow-sm card-body text-center">
			
				<form class="row g-3" id="frmDemo" name="frmDemo" action="${pageContext.request.contextPath}/exp/demoadd" method="get">		
			
					 <input type="hidden" id="sessioncode" name="sessioncode" value="${sessioncode}">
					 
				<div class="col-5 text-muted pt-1 text-center border">
				  
				   	<span class="fs-4"> <strong>Sexo:&nbsp;</strong></span>
					<div class="form-check form-check-inline text-center" >
				
						<input class="form-check-input" type="radio" name="sexo" id="topic1opt1" value="F">
						<label class="form-check-label fs-5" for="topic1opt1">F</label>
					</div>
									
					<div class="form-check form-check-inline">
						<input class="form-check-input" type="radio" name="sexo" id="topic1opt2" value="M">
						<label class="form-check-label fs-5" for="topic1opt2">M</label>
					</div>
					
					<div class="form-check form-check-inline">
						<input class="form-check-input" type="radio" name="sexo" id="topic1opt3" value="O">
						<label class="form-check-label fs-5" for="topic1opt3">Outro</label>
					</div>
				</div>
				
				<div class="col-1 p-1">
				
				</div>
				
				<div class="col-5 text-muted pt-1 text-center border">
				  
				   	<span class="fs-5"><strong>Estado civil:&nbsp; </strong></span>
					<div class="form-check form-check-inline text-center" >
				
						<input class="form-check-input" type="radio" name="estadocivil" id="topic1opt1" value="casado(a)">
						<label class="form-check-label fs-5" for="topic1opt1">Casado(a)</label>
					</div>
									
					<div class="form-check form-check-inline">
						<input class="form-check-input" type="radio" name="estadocivil" id="topic1opt2" value="solteiro(a)">
						<label class="form-check-label fs-5" for="topic1opt2">Solteiro(a)</label>
					</div>
					
				</div>
				
				
				
				<div class="col-3 border">
					
					<fieldset class="form-group row text-left">
							<legend class="sm-12 text-left"><strong>Idade</strong></legend>
							<div class="col-sm-12">
							  <div class="form-check">
								<input class="form-check-input" type="radio" name="radioidade" id="radioidade1" value="option1">
								<label class="form-check-label fs-5" for="radioidade1">
								  18 a 25 anos
								</label>
							  </div>
							 
							  <div class="form-check">
								<input class="form-check-input" type="radio" name="radioidade" id="radioidade2" value="option2">
								<label class="form-check-label fs-5" for="renda2">
								  26 a 35 anos
								</label>
							  </div>
							  
							  <div class="form-check">
								<input class="form-check-input" type="radio" name="radioidade" id="radioidade3" value="option3">
								<label class="form-check-label fs-5" for="radioidade3">
								  36 a 45 anos
								</label>
							  </div>
							  
							  <div class="form-check">
								<input class="form-check-input" type="radio" name="radioidade" id="radioidade4" value="option4">
								<label class="form-check-label fs-5" for="radioidade4">
								  46 a 55 anos
								</label>
							  </div>
							  
							  <div class="form-check">
								<input class="form-check-input" type="radio" name="radioidade" id="radioidade5" value="option5">
								<label class="form-check-label fs-5" for="radioidade5">
								  56 a 70 anos
								</label>
							  </div>
							  
							 
							  
							  <div class="form-check">
								<input class="form-check-input" type="radio" name="radioidade" id="radioidade6" value="option6">
								<label class="form-check-label fs-5" for="radioidade6">
								  71 a 85 anos
								</label>
							  </div>
							  
							  <div class="form-check">
								<input class="form-check-input" type="radio" name="radioidade" id="radioidade7" value="option7">
								<label class="form-check-label fs-5" for="radioidade7">
								  Acima de 86 anos								
								</label>
							</div>
						</div>
					</fieldset>
						
				</div>
				
  
				<div class="col-1 p-1">
				
				</div>
			 
				<div class="col-3 border">
					
					<fieldset class="form-group row text-left">
							<legend class="sm-12 text-left"><strong>Escolaridade</strong></legend>
							<div class="col-sm-12">
							  <div class="form-check">
								<input class="form-check-input" type="radio" name="escolaridade" id="escolaridade1" value="option1">
								<label class="form-check-label fs-5" for="escolaridade1">
								  2º grau incompleto
								</label>
							  </div>
							  <div class="form-check">
								<input class="form-check-input" type="radio" name="escolaridade" id="escolaridade2" value="option2">
								<label class="form-check-label fs-5" for="escolaridade2">
								  2º grau completo
								</label>
							  </div>
							 
							  <div class="form-check">
								<input class="form-check-input" type="radio" name="escolaridade" id="escolaridade3" value="option3">
								<label class="form-check-label fs-5" for="escolaridade3">
								  Graduação incompleta
								</label>
							  </div>
							  
							  <div class="form-check">
								<input class="form-check-input" type="radio" name="escolaridade" id="escolaridade4" value="option4">
								<label class="form-check-label fs-5" for="escolaridade4">
								  Graduação completa
								</label>
							  </div>
							  
							  <div class="form-check">
								<input class="form-check-input" type="radio" name="escolaridade" id="escolaridade5" value="option5">
								<label class="form-check-label fs-5" for="escolaridade5">
								  Pós-Graduação
								</label>
							  </div>
						</div>
					</fieldset>
						
				</div>
				 
				
				<div class="col-1 p-1">
				</div>
				 
				
				<div class="col-4 border">			
					<fieldset class="form-group row">
							<legend class="sm-10 text-left"><strong>Renda</strong></legend>
							<div class="col-sm-12 text-left">
							
							  <div class="form-check">
								<input class="form-check-input" type="radio" name="renda" id="renda0" value="option0">
								<label class="form-check-label fs-5" for="renda0">
								  Nenhuma renda
								</label>
							  </div>
							  <div class="form-check">
								<input class="form-check-input" type="radio" name="renda" id="renda1" value="option1">
								<label class="form-check-label fs-5" for="renda1">
								  Até 2 salários mínimos
								</label>
							  </div>
							  <div class="form-check">
								<input class="form-check-input" type="radio" name="renda" id="renda2" value="option2">
								<label class="form-check-label fs-5" for="renda2">
								  Entre 2 e 5 salários mínimos
								</label>
							  </div>
							 
							  <div class="form-check">
								<input class="form-check-input" type="radio" name="renda" id="renda3" value="option3">
								<label class="form-check-label fs-5" for="renda3">
								   Entre 5 a 10 salários mínimos
								</label>
							  </div>
							  
							  <div class="form-check">
								<input class="form-check-input" type="radio" name="renda" id="renda4" value="option4">
								<label class="form-check-label fs-5" for="renda4">
									Acima de 10 salários mínimos
								</label>
							  </div>
							  
							 
							  
						</div>
					</fieldset>
						
				</div>
				
			</div>
				
			<div class="row p-2 align-items-center">				
				
				<button id="enviar" type="submit" class="btn btn-primary btn-lg">Avançar</button>
				
			</div>
			
			</form>	
		</div>
				


	</div>
	
	<div class="row align-items-center">
	</div>
  
  <footer class="py-3 my-4">
    <hr>
    <p class="text-center text-muted">&copy;2024 Todos os diretos reservados aos pesquisadores - Contato: mvojgnn@edu.unirio.br</p>
  </footer>
</div>
</div>
</body>
</html>