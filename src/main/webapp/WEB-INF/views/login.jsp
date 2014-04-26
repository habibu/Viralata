<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.tcc.viralata.utils.ConstantsViraLata" %>
<%@ page session="false" %>
<html>
<head>
	<title>Área de Login</title>
	<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
</head>
	<script type="text/javascript">
	
function valida(){
	if ($("#usuario").val()==""){
		$("#mensagem").text("Campo 'Usuário' não preenchido.");
		return false;
	}else if ($("#senha").val()==""){
		$("#mensagem").text("Campo 'Senha' não preenchido.");
		return false;
	}
	//Sucesso
	return true;
}
	
function verificaLogin(){
	var statusLogin = "${statusLogin}";
	var usuarioDigitado = "${usuarioDigitado}";
	
	if (statusLogin=="erro_login"){
		$("#mensagem").text("Dados incorretos. Verifique seu login e senha.");
		$("#usuario").val(usuarioDigitado);
	}else if (statusLogin=="erro_rede"){
		$("#mensagem").text("Erro. Por favor, tente novamente.");
		$("#usuario").val(usuarioDigitado);
	}
}

$(document).ready(
		
			function() {
				 verificaLogin();
			
			$("#botaologin").click(function () {
				if (valida()){
				}else{
					return false;
				}
			});	
		});
		</script>
</head>
<body>
<h1>
	Área de Login
</h1>

<!-- Mensagem de erro -->
<p id="mensagem" style="color: red;"></p>

<form action="login" method="post">

	<input type="text" id="usuario" name="usuario" placeholder="Usuário"/></br>
	<input type="password" id="senha" name="senha" placeholder="Senha"/></br>
	
	<input type="submit" id="botaologin" name="botaologin" value="Enviar">
</form>
<form action="cadastro" method="post">
	<input type="submit" value="Realizar Cadastro">
</form>
</html>
	<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
	<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
	
</body>
<html>
</html>
