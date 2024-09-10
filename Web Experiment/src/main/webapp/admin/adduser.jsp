<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
 <c:url value="/jsp/inicio.jsp" var="cabecalho"/>
 
 <c:url value="/jsp/fim.jsp" var="rodape"/>

<html>
<head>
<title>Admin- ADD USER</title>
<script type="text/javascript">
<!--
// Form validation code will come here.
function validate()
{

   if( document.usuarioForm.txtLogin.value == "" )
   {
     alert( "Please provide your txtLogin!" );
     document.usuarioForm.txtLogin.focus() ;
     return false;
   }
   if( document.usuarioForm.txtEmail.value == "" )
   {
     alert( "Please provide your Email!" );
     document.usuarioForm.txtEmail.focus() ;
     return false;
   }
   if( document.usuarioForm.txtPassword.value == "" ||
           document.usuarioForm.txtPassword.value.length <= 5 )
   {
     alert( "Forneça uma senha com no mínimo 6 caracteres" );
     document.usuarioForm.txtPassword.focus() ;
     return false;
   }
   if( document.usuarioForm.perfil.value == "0" )
   {
     alert( "Selecione um perfil!" );
     return false;
   }
   return( true );
}
//-->
</script>


	
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
</head>
<body>

<center>
		    <c:import url="/jsp/inicio.jsp" />
		    <hr>
		    <br>
			 <h3>Novo Usuário - Formulário</h3>


 <form action="/mvcagenda04/admin/do/addUserForm" name="usuarioForm"   method="post" 
          onsubmit="return(validate());">
		  
 <table cellspacing="2" cellpadding="2" >
 <tr>
   <td align="right">Login</td>
   <td><input type="text" name="txtLogin" size="12"/></td>
   <td><input type="checkbox" name="chk_ativo" value="ativo"/>Habilitar</td>
 </tr>
 <tr>
   <td align="right">Email</td>
   <td colspan="2"><input type="text" name="txtEmail" /></td>
 </tr>
 <tr>
   <td align="right">Senha</td>
   <td><input type="password" name="txtPassword" size="10"/></td>
   <td/>
 </tr>
 <tr>
 <td align="right">Perfil</td>
 <td>
 <select name="perfil">
   <option value="0" selected="default">Selecione um perfil</option>
   <option value="1">Analista</option> 
   <option value="2">Programador</option>
   <option value="3">Testador</option>
   <option value="8">BI - Servidor</option>
   <option value="4">DBA</option>
    <option value="5">Gestor técnico</option> 
   <option value="6">Responsable validação</option>
   <option value="7">Gestor de Sistemas</option>  
   <option value="8">Adminsitador</option>
 </select>
 </td>
 <td/>
 </tr>
 <tr>
   <td align="right"></td>
   <td><input type="submit" value="Submit" /></td>
   <td/>
 </tr>
 </table>
 </form>
 
 
  <div class="rodape">
		 <hr>
  		  <p> <c:import url="/jsp/fim.jsp" /></p>
		 </div>
		</center>
 </body>
 </html>