<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page import="org.jgnn.study.web.securejpa.model.util.Participant" %>

<!DOCTYPE html>
<html lang="en">
<head>
	
    <title>Etapa 3</title>
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
			
			<div class="row p-3 align-items-center">
				<div class="col-12">
					
					<h3><span class="badge bg-secondary">Etapa 3:&nbsp;Julgamentos de outros participantes&nbsp;<span class="badge bg-secondary">Atividade ${quantity} de ${total}</span></h3>
					<P>Observe abaixo julgamentos de outros participantes sobre esta notícia.</P>
					<div class="alert alert-primary" role="alert">
					  <p>
					  ${newsstory}
					  </p>
					</div>				
				</div>
			</div>
			
			<div class="row p-3 align-items-center">
			
				<div class="col-1">
					
				</div>
				<div class="col-10">
					
					<c:choose>
							<%--Comentário: aportes já foram cadastrados?  --%>
								<c:when test="${empty requestScope.participants}">
									<br> Até momento você é a primeira pessoa a julgar esta notícia.&nbsp;  
									<br>
										
								</c:when>
										
								<c:otherwise>
									
									
									<div class="row">
										<div class="col-2">
										</div>
										<div class="col-8">
											<table class="table table-striped  table-sm table-borderless">
											
												<thead>
													<tr>
														<th/>
														<th>Nome</th> 
														<th>Julgamento</th> 
														<th></th> 
													</tr>
									 
												</thead>
											<tbody>
											 
												<%--Comentário: Apresentar ...--%>
												<c:forEach  var="item" items="${requestScope.participants}" varStatus="status"> 

													<tr class="align-items-center"> 
														<td/>
														<td>
															<div class="p-1 mb-1 align-text-middle">
																<p><i class="bi bi-person-fill"></i><span> &nbsp;<c:out value="${item.nome}"/></span></p>
															</div>
														</td>

														<td>
															<div class="p-1 mb-1 align-text-middle">
																<c:out value="${item.julgamento}"/> 
															</div>
														</td> 
														
														<td/>
													</tr> 
													
												</c:forEach>
												
													
											</tbody>
											</table>
											
											
											<br>
											

										</div>
										<div class="col-2">
										</div>
									</div>
								</c:otherwise>
					</c:choose>
					
				</div>
				
				<div class="col-1">
				
				</div>
			</div>
			
			
			<div class="row p-1 align-items-center">
			
				<div class="col-1">
					<p>
					
					</p>
				</div>
				<div class="col-10">
					
				</div>
				
				<div class="col-1">
					<p>
					
					</p>
				</div>
			</div>
		
			<div class="row h-25  row align-items-center">
			
				<div class="row h-25  row align-items-center">
					<a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/exp/fase4">Avançar</a> 
				</div>
			
			</div>
				
			
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