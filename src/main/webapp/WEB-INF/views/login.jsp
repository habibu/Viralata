<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Área de Login</title>
</head>
<body>
<h1>
	Área de Login
</h1>
<form action="login" method="post">

	<input type="text" id="login" name="login" placeholder="Usuário"/></br>
	<input type="password" id="senha" name="senha" placeholder="Senha"/></br>
	
	<input type="submit" id="botaologin" name="botaologin" value="Enviar">
</form>
<form action="cadastro" method="post">
	<input type="submit" value="Realizar Cadastro">
</form>
</html>
<html>
	<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
	<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
	<script type="text/javascript" language="javascript" src=".jquery-1.7.2.min.js">
function teste(){
	alert("Teste");
}

$(document).ready(
		
			function() {
				 $("#login").val("Teste");
				 teste();
			}
		);
</script>
</body>
</html>
