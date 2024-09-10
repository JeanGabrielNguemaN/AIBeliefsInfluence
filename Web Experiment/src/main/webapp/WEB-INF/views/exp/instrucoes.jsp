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
	.headerh{
		height: 110px;
	}
    /* .... */
}
	</style>
</head>
<body>
<div style="height: 800px;">
<div class="container h-100" >
	<div class="row    headerh align-items-center">
	<header class="p-1 mb-1 border-bottom">
		<%@ include file="../src/navbar.jsp" %>
	</header>
	</div>

	<div class="row align-items-center">
		<div class="col-1">
		  
		</div>
		
		<div class="col-10">
		
			<div class="row p-1 align-items-center">
				<div class="col-12">
					
					<p class="fs-3"><strong>Instruções</strong>: <small class="text-muted">Leia com atenção e clique em "continuar" para iniciar ou prosseguir por onde parou.</small>
					
					</p>
					<div class="bg-light text-justify fs-4 rounded lead">
					
					<p>
					  O experimento consiste em <strong> 2 fases</strong>:
					  <br>
					  <ul>
						  <li> <strong>Na primeira fase</strong>,você será convidado(a) a fornecer informações básicas de forma anônima, isto  é, sem necessidade de se identificar.</li>
						  <li> <strong>Na segunda fase </strong>, você será convidado(a) a participar de <strong> 2 atividades </strong>, que consistem em responder às perguntas sobre notícias falsas ou verdadeiras. 
						  Cada atividade possui uma história de notícia, onde você será convidado(a) a dar sua opinião sobre sua veracidade, através de 3 etapas:
					  <br>
					  <ul>
						  <li> <strong>Etapa 1</strong>: Você será convidado(a) a julgar se uma dada notícia é verdadeira ou falsa </li>
						  <li> <strong>Etapa 2</strong>: Apresentação da classificação de um modelo de IA sobre essa mesma notícia. Você será convidado(a) a julgar novamente, sabendo dessa previsão da AI</li>
						  <li> <strong>Etapa 3</strong>: Serão apresentadas julgamentos de outras pessoas sobre essa notícia (<strong>Crowdsourcing</strong>). Você será convidado(a) a julgar novamente, em função desses julgamentos </li>
					  
					  </ul>
					 </li>
					  </ul>
					  <strong>Observação</strong>: Sua particitação é totalmente anônima (sem registro de nome, email). Como consequência, 
					  você precisará participar de todas as etapas para que sua participação seja registrada.  Com isso tambem, 
					  se ficar mais de 5 minutos sem interagir com o sistema, suas respostas serão perdidas, sendo necessário reiniciar sua participação.			  
	
					  </p>
					</div>				
				</div>
			</div>
			
		
			
			<div class="row p-2 align-items-center">				
				<a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/exp/participe?sessioncode=${sessioncode}">Continuar</a>		
			</div>
				
		</div>
		
		<div class="col-1">
		  
		</div>
		
		
	</div>
	
	
	
	<div class="row align-items-center">
	
		<div class="col-1">
		  
		</div>
		
		<div class="col-auto align-items-center">
		  
		  
		  
		</div>
		
		
		<div class="col-1">
		  
		</div>
	</div>
  
	<footer class="py-3 my-4">
    <hr>
    <p class="text-center text-muted">&copy;2024 Todos os diretos reservados aos pesquisadores - Contato: mvojgnn@edu.unirio.br</p>
  </footer>
</div>
</div>
</body>
</html>