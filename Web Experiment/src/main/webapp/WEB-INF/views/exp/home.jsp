 <%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<!DOCTYPE html>
<html lang="en">
<head>
	
    <title>Home</title>
    <meta charset="UTF-8">
	<meta name="description" content="Estudo de como as opiniões das pessoas podem ser influenciadas por interações sociais e assistentes virtuais inteligentes ao julgar a autenticidade de informações online. ">
	<meta name="keywords" content="IA, fake news, experimento">
	<meta name="author" content="Jean Gabriel Nguema Ngomo">
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
	
	.headerh{
		height: 110px;
	}
    /* .... */
}
	</style>
</head>
<body>
<div class="container body-height">

<div class="container h-100" >
	<div class="row  headerh align-items-center">
		<header class="p-3 mb-3 border-bottom">
			<%@ include file="../src/navbar.jsp" %>
		</header>
	</div>

	<div class="row align-items-center">
		<div class="col-1">
		  
		</div>
		
		<div class="col-10">
		
			<div class="row p-1 align-items-center text-justify">
				<div class="col-12">
					<h2 class="text-center"><strong>Bem-vindo ao nosso experimento interativo!</strong></h2>
				
					<div class="bg-light text-justify">
					
					<p class="lead text-justify fs-4">
					Neste estudo, exploramos como as opiniões das pessoas podem ser influenciadas por interações sociais e assistentes virtuais inteligentes ao julgar a autenticidade de informações online. Sua participação é crucial! Você será exposto a uma série de postagens e terá a tarefa de classificar cada uma como 'Verdadeira' ou 'Falsa'. Durante o processo, você também receberá insights gerados por um modelo avançado de linguagem, semelhante ao ChatGPT, e verá as opiniões de outros participantes. Seu feedback ajudará a entender melhor como essas tecnologias e dinâmicas sociais impactam nossa percepção da verdade. Participe agora e ajude-nos a desvendar os mistérios da desinformação na era digital!
					</p>
					<p class="fs-4">
					<strong>Pesquisadores</strong> </p>
					<p class="fs-5">Os pesquisadores deste experimento pertencem ao PPGI (Programa de Pós-Graduação em Informática) da Universidade Federal do estado do Rio de Janeiro (UNIRIO), na linha de Pesquisa Sistemas Inteligentes Aplicados e Otimização. </p>
					<p class="fs-5">
					<ul class="fs-5">
					  <li><strong>Jean Gabriel Nguema Ngomo</strong>
					  <ul>
					  <li>Candidato ao doutorado no PPGI da UNIRIO</li>
					  <li>Contato:mvojgnn@edu.unirio.br</li>
					  <li>Orientadora: Ana Cristina Bicharra Garcia</li>
					  </ul>
					  </li>
					  <li><strong>Ana Cristina Bicharra Garcia</strong>
					  <ul>
					  <li>PhD, Professora Titular do Departamento de Informática Aplicada da UNIRIO</li>
					  <li>Professora permanente do PPGI da UNIRIO</li>
					  <li>Áreas de interesse: Inteligência Artificial, Inteligência Coletiva, Inteligência Ambiental e Interação Humano-Computador.</li>
					  </ul>
					  </li>
					</ul> 
					
					<br>
					
					</p>
					</div>				
				</div>
			</div>
			
			<div class="row p-2 align-items-center">				
				<a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/exp/participe?sessioncode=${sessioncode}">Participar</a>		
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