<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Área de Login</title>
	<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
	<script type="text/javascript">
function teste(){
	alert("Teste");
}

$(document).ready(
		
			function() {
				 teste();
			}
		);
		</script>
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
	<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
	<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
	
</body>
<html>
</html>
