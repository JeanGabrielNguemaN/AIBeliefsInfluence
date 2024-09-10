 <%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<!DOCTYPE html>
<html lang="en">
<head>
	
    <title>Pesquisa</title>
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
	.headerh{
		height: 110px;
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
		
			var radio=$("input[type='radio'][name=topic1]:checked", '#frmAnchor').val();
			
			var msg="É necessário responder a todas as perguntas!";
			
			if (radio == null){
				//alert(msg);
				
				swal("Atenção!", msg, "error");
				return false;
			}	
		
			radio=$("input[type='radio'][name=topic2]:checked", '#frmAnchor').val();
			
			if (radio == null){
				//alert(msg);
				swal("Atenção!", msg, "error");
				return false;
			}
			
			
			radio=$("input[type='radio'][name=topic3]:checked", '#frmAnchor').val();
			
			if (radio == null){
				//alert(msg);
				
				swal("Atenção!", msg, "error");
				return false;
			}
						
			radio=$("input[type='radio'][name=topic4]:checked", '#frmAnchor').val();
			
			if (radio == null){
				//alert(msg);
				
				swal("Atenção!", msg, "error");
				return false;
			}
			
			radio=$("input[type='radio'][name=topic5]:checked", '#frmAnchor').val();
			
			if (radio == null){
				//alert(msg);
				
				swal("Atenção!", msg, "error");
				return false;
			}			
			
			radio=$("input[type='radio'][name=topic6]:checked", '#frmAnchor').val();
			
			if (radio == null){
				//alert(msg);
				
				swal("Atenção!", msg, "error");
				return false;
			}		
			
			radio=$("input[type='radio'][name=topic7]:checked", '#frmAnchor').val();
			
			if (radio == null){
				//alert(msg);
				
				swal("Atenção!", msg, "error");
				return false;
			}		
			
			radio=$("input[type='radio'][name=topic8]:checked", '#frmAnchor').val();
			
			if (radio == null){
				//alert(msg);
				
				swal("Atenção!", msg, "error");
				return false;
			}
		
			return true;
						
		});
		
	});
</script>
</head>
<body>

<div class="container" style="height: 800px;">

<div class="container h-100" >

	<div class="row  headerh  align-items-center">
		<header class="p-3 mb-3 border-bottom">
			<%@ include file="../src/navbar.jsp" %>
		</header>
		
	</div>
	<div class="row align-items-center bg-light">
		<div class="col-1">
		  
		</div>
		
		<div class="col-10">
		
			<div class="row p-1 align-items-center">
				<div class="col-12 text-center">
					
					<h3>Precisamos de sua opinião sobre alguns tópicos &nbsp;</h3>		
				</div>
			</div>
		
		<form id="frmAnchor" name="frmAnchor" action="${pageContext.request.contextPath}/exp/anchoradd" method="get">	
					<input type="hidden" id="sessioncode" name="sessioncode" value="${sessioncode}">
			
			
			<div class="my-1 p-1 bg-body rounded shadow-sm text-center">

                
						<div class="row"> 
						<div class="col-6 fs-4 text-left"> 
							Legalização do aborto
						</div> 
						
				
						<div class="col-6"> <div class="text-muted pt-1 text-center">
						   <p class="pb-1 mb-0 small lh-sm">
						   
							<div class="form-check form-check-inline text-center" >
								<input class="form-check-input" type="radio" name="topic1" id="topic1opt1" value="favor">
								<label class="form-check-label" for="topic1opt1">CONCORDO</label>
							</div>
											
							
											
							<div class="form-check form-check-inline">
								<input class="form-check-input" type="radio" name="topic1" id="topic1opt3" value="contra">
								<label class="form-check-label" for="topic1opt3">DISCORDO</label>
							</div>
							
							<div class="form-check form-check-inline">
								<input class="form-check-input" type="radio" name="topic1" id="topic1opt2" value="neutro">
								<label class="form-check-label" for="topic1opt2">SEM OPINIÃO</label>
							</div>
											
							</p>
						</div>
						</div> 
					</div>
			
			
					<div class="row"> 
						<div class="col-6 fs-4 text-left">Porte de armas por cidadãos comuns</div> 
						
						<div class="col-6"> <div class="text-muted pt-1 text-center">
							<div class="text-muted pt-1 text-center">
						   <p class="pb-1 mb-0 small lh-sm">
						   
							<div class="form-check form-check-inline">
								<input class="form-check-input" type="radio" name="topic2" id="topic2opt1" value="favor">
								<label class="form-check-label" for="topic2opt1">CONCORDO</label>
							</div>
											
							
											
							<div class="form-check form-check-inline">
								<input class="form-check-input" type="radio" name="topic2" id="topic2opt3" value="contra">
								<label class="form-check-label" for="topic2opt3">DISCORDO</label>
							</div>	


							<div class="form-check form-check-inline">
								<input class="form-check-input" type="radio" name="topic2" id="topic2opt2" value="neutro">
								<label class="form-check-label" for="topic2opt2">SEM OPINIÃO</label>
							</div>
							</p>
						</div>
						</div>
						</div> 
					</div>
		
					<div class="row"> 
						<div class="col-6 fs-4 text-left">Privatização das empresas públicas</div> 
						
						
						<div class="col-6"> <div class="text-muted pt-1 text-center">
						   <div class="text-muted pt-1 text-center">
						   <p class="pb-1 mb-0 small lh-sm ">			   
							<div class="form-check form-check-inline">
								<input class="form-check-input" type="radio" name="topic3" id="topic3opt1" value="favor">
								<label class="form-check-label" for="topic3opt1">CONCORDO</label>
							</div>
							
							<div class="form-check form-check-inline">
								<input class="form-check-input" type="radio" name="topic3" id="topic3opt3" value="contra">
								<label class="form-check-label" for="topic3opt3">DISCORDO</label>
							</div>
											
							<div class="form-check form-check-inline">
								<input class="form-check-input" type="radio" name="topic3" id="topic3opt2" value="neutro">
								<label class="form-check-label" for="topic3opt2">SEM OPINIÃO</label>
							</div>
														
							</p>
						</div>
						</div>
						</div> 
					</div>
			
			
			
					<div class="row"> 
						<div class="col-6 fs-4 text-left">Preservação do meio ambiente</div> 
						
						
						<div class="col-6"> <div class="text-muted pt-1 text-center">
							
							<div class="text-muted pt-1 text-center">
						   <p class="pb-1 mb-0 small lh-sm">
						   
							<div class="form-check form-check-inline">
								<input class="form-check-input" type="radio" name="topic4" id="topic4opt1" value="favor">
								<label class="form-check-label" for="topic4opt1">CONCORDO</label>
							</div>
											
							
											
							<div class="form-check form-check-inline">
								<input class="form-check-input" type="radio" name="topic4" id="topic4opt3" value="contra">
								<label class="form-check-label" for="topic4opt3">DISCORDO</label>
							</div>
							
							<div class="form-check form-check-inline">
								<input class="form-check-input" type="radio" name="topic4" id="topic4opt2" value="neutro">
								<label class="form-check-label" for="topic4opt2">SEM OPINIÃO</label>
							</div>
											
							</p>
						</div>
						   
						</div>
						</div> 
					</div>
					
					
					
					<div class="row"> 
						<div class="col-6 fs-4 text-left">Casamento gay</div> 
						
						
						<div class="col-6"> <div class="text-muted pt-1 text-center">
							
							<div class="text-muted pt-1 text-center">
						   <p class="pb-1 mb-0 small lh-sm">
						   
							<div class="form-check form-check-inline">
								<input class="form-check-input" type="radio" name="topic5" id="topic5opt1" value="favor">
								<label class="form-check-label" for="topic5opt1">CONCORDO</label>
							</div>
											
							
											
							<div class="form-check form-check-inline">
								<input class="form-check-input" type="radio" name="topic5" id="topic5opt3" value="contra">
								<label class="form-check-label" for="topic5opt3">DISCORDO</label>
							</div>
							
							<div class="form-check form-check-inline">
								<input class="form-check-input" type="radio" name="topic5" id="topic5opt2" value="neutro">
								<label class="form-check-label" for="topic5opt2">SEM OPINIÃO</label>
							</div>
											
							</p>
						</div>
						   
						</div>
						</div> 
					</div>
					
					
					
					<div class="row"> 
						<div class="col-6 fs-4 text-left">Mineração em terras indígenas</div> 
						
						
						<div class="col-6"> <div class="text-muted pt-1 text-center">
							
							<div class="text-muted pt-1 text-center">
						   <p class="pb-1 mb-0 small lh-sm">
						   
							<div class="form-check form-check-inline">
								<input class="form-check-input" type="radio" name="topic6" id="topic6opt1" value="favor">
								<label class="form-check-label" for="topic6opt1">CONCORDO</label>
							</div>
											
							
											
							<div class="form-check form-check-inline">
								<input class="form-check-input" type="radio" name="topic6" id="topic6opt3" value="contra">
								<label class="form-check-label" for="topic6opt3">DISCORDO</label>
							</div>
							
							<div class="form-check form-check-inline">
								<input class="form-check-input" type="radio" name="topic6" id="topic6opt2" value="neutro">
								<label class="form-check-label" for="topic6opt2">SEM OPINIÃO</label>
							</div>
											
							</p>
						</div>
						   
						</div>
						</div> 
					</div>
					
					
					
					<div class="row"> 
						<div class="col-6 fs-4 text-left"> Política de cotas raciais</div> 
						
						
						<div class="col-6"> <div class="text-muted pt-1 text-center">
							
							<div class="text-muted pt-1 text-center">
						   <p class="pb-1 mb-0 small lh-sm">
						   
							<div class="form-check form-check-inline">
								<input class="form-check-input" type="radio" name="topic7" id="topic7opt1" value="favor">
								<label class="form-check-label" for="topic7opt1">CONCORDO</label>
							</div>											
											
							<div class="form-check form-check-inline">
								<input class="form-check-input" type="radio" name="topic7" id="topic7opt3" value="contra">
								<label class="form-check-label" for="topic7opt3">DISCORDO</label>
							</div>
							
							<div class="form-check form-check-inline">
								<input class="form-check-input" type="radio" name="topic7" id="topic7opt2" value="neutro">
								<label class="form-check-label" for="topic7opt2">SEM OPINIÃO</label>
							</div>
											
							</p>
						</div>
						   
						</div>
						</div> 
					</div>
					
					
					
					<div class="row"> 
						<div class="col-6 fs-4 text-left">Legalização das drogas</div> 
						
						
						<div class="col-6"> <div class="text-muted pt-1 text-center">
							
							<div class="text-muted pt-1 text-center">
						   <p class="pb-1 mb-0 small lh-sm">
						   
							<div class="form-check form-check-inline">
								<input class="form-check-input" type="radio" name="topic8" id="topic8opt1" value="favor">
								<label class="form-check-label" for="topic8opt1">CONCORDO</label>
							</div>
											
							
											
							<div class="form-check form-check-inline">
								<input class="form-check-input" type="radio" name="topic8" id="topic8opt3" value="contra">
								<label class="form-check-label" for="topic8opt3">DISCORDO</label>
							</div>
							
							<div class="form-check form-check-inline">
								<input class="form-check-input" type="radio" name="topic8" id="topic8opt2" value="neutro">
								<label class="form-check-label" for="topic8opt2">SEM OPINIÃO</label>
							</div>
											
							</p>
						</div>
						   
						</div>
						</div> 
					</div>
			  
			    
				
								
			
				
			</div>
				<!------------------------------------------------------------->
			
		
			<div class="row p-2 align-items-center">				
					
					<button id="enviar" type="submit" class="btn btn-primary btn-lg">Avançar</button>
					
			</div>
			
			</form>
		
		
		</div>
		
		<div class="col-1">
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