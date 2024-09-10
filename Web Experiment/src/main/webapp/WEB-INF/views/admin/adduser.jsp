<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
 <c:url value="/jsp/inicio.jsp" var="cabecalho"/>
 
 <c:url value="/jsp/fim.jsp" var="rodape"/>

	 <html>
	 <head>
	 <title>Contact - formulaire</title>
	 <meta name="viewport" content="width=device-width, initial-scale=1">
	 <style>
		.rodape {
		   position: fixed;
		   left: 0;
		   bottom: 0;
		   width: 100%;
		   color:black;
		   text-align: center;
		}
	</style>
	 
	 
	 
	 
	 	<script language="javascript">
 		// -------------------------------
		 function effacer(){
			// on efface les champs de saisie
			with(document.frmPersonne){
				txtNom.value="";
				txtAge.value="";
			}//with
		}//effacer
			// -------------------------------
		function enviar(){
			// vérification des paramètres avant de les envoyer
			with(document.frmUsuario){
				// le nom ne doit pas être vide
				champs=/^\s*$/.exec(txtLogin.value);
				if(champs!=null){
					// le nom est vide
					alert("Login não pode ser nulo");
					txtLogin.value="";
					txtLogin.focus();
					// retour à l'interface visuelle
					return;
				}//if
				// l'âge doit être un entier positif
		        champs=/^\s*$/.exec(txtEmail.value);;
				if(champs==null){
					// l'âge est incorrect
					alert("Email não pode ser nulo");
					txtEmail.value="";
					txtEmail.focus();
					// retour à l'interface visuelle
					return;	
				}//if
				
				 champs=/^\s*$/.exec(txtPassword.value);;
				if(champs==null){
					// l'âge est incorrect
					alert("Email não pode ser nulo");
					txtPassword.value="";
					txtPassword.focus();
					// retour à l'interface visuelle
					return;	
				}//if
				// les paramètres sont corrects - on les envoie au serveur
				submit();
			}//with
		 }//envoyer
	</script>
	 </head>
	<body>
		 <center>
		    <c:import url="/jsp/inicio.jsp" />
		    <hr>
		    <br>
			 <h3>Novo Usuário - Formulário</h3>
			 
			 <form name="frmUsuario" action="addUserForm" method="post">
			 <table>
			 <tr>
				 <td>Login: </td>
				 <td>
					<input name="txtLogin" value="" type="text" size="12">
				 </td>
				 
				 <td>
				
						
						<input type="checkbox" name="chk_ativo" value="ativo">Habilitar
				
				</td> 
			 </tr>
			 
			 <tr>
				 <td>Email: </td>
				 <td colspan="2">
					 <input name="txtEmail" value="" type="text" size="25">
				  </td>
			 </tr>
			 
			 
			 <tr>
				 <td>Passord: </td>
				 <td>
					 <input type="password" name="txtPassword" value="" type="text" size="12">
				 
				  </td>
				   <td></td>  
			 </tr>
			 
			<tr>
				 <td>Perfil: </td>
				 <td>
					<select  name="perfil">
						<option value="" selected="default">Selecione um perfil</option>
						<option value="admin">Adminsitador</option>
						<option value="qamanager">Mangager de QA</option>  
						<option value="lidertecnico">Lider técnico</option> 
						<option value="analista">Analista de Requisitos</option> 
					</select>
            
				 </td>
				 <td></td>
			 </tr>
			
			 </table>
			 
			 <table>
				 <tr>
					 <td><input type="submit" value="[Enviar]" onclick="envoyer()"></td>
					 <td></td>
					 <td></td>
				 </tr>
			 </table>
			 
			 </form>
			 
			 <table>
				 <tr>
					<td></td>
					<td></td> 
					<td></td>
					<td> 
						<a href="${pageContext.request.contextPath}/do/list">Todos os usuários</a> 
					</td> 
				 </tr>
			
		 </table>
	
		
		 
		 <div class="rodape">
		 <hr>
  		  <p> <c:import url="/jsp/fim.jsp" /></p>
		 </div>
		</center>
	</body>
 </html>