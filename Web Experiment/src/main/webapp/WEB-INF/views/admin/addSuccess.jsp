<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 


<html>
<head>
	<title>Registro com sucesso</title>
	 
 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>	
<body>

<div class="container">
  <h2>Registro de usuário</h2>
<hr>
<br><br>
  <p class="text-success">${message}</p>
  
  <br><br>
 
  <a href="${pageContext.request.contextPath}/home" class="btn btn-link">Página inicial</a>	

</div>
</body>
 </html>