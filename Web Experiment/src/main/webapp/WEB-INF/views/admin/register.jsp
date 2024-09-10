<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <html>
<head>
   <title>Registrar Usuário</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
	<h1>Registrar usuario</h1>
	
	<form name="frmRegister" action="${pageContext.request.contextPath}/admin/register" class="was-validated" method="post">
	
		<div class="form-group">
		<div class="row">
			<div class="col-sm-4">
			  <label for="username">Usuário:</label>
			  <input type="text" class="form-control" id="username" placeholder="Informa o usuário" name="username" required>
			  <div class="valid-feedback">Valid.</div>
			  <div class="invalid-feedback">Favor preencha esse campo.</div>
			</div>
		</div>
		<div class="row">
		<div class="col-sm-4">
		<div class="form-group">
		  <label for="password">SenhaPassword:</label>
		  <input type="password" class="form-control" id="password" placeholder="Informa a senha" name="password" required>
		  <div class="valid-feedback">Valid.</div>
		  <div class="invalid-feedback">Favor, informe a senha.</div>
		</div>
		</div>
		</div>
		<fieldset class="form-group">
		<div class="row">
        <legend class="col-form-label col-sm-2 pt-0">Perfis</legend>
			<c:forEach  var="role" items="${roles}" varStatus="row">																
								
				<div class="form-check">
				  <label class="form-check-label" for="checkb${role.id}">
					<input type="checkbox" class="form-check-input" name="role" value="${role.id}" id="checkb${role.id}">${role.role} &nbsp;&nbsp;&nbsp;
				  </label>
				</div>
			</c:forEach>
	    </div>
		</fieldset>
		<button type="submit" class="btn btn-primary">Registrar</button>
    </form>
	
	<br><br>
	<a href="${pageContext.request.contextPath}/home" class="btn btn-link">Página inicial</a>			     		
	</div>
</body>
 </html>