<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>�rea de Login</title>
</head>
<body>
<h1>
	�rea de Login 
</h1>
<form action="login" method="get">

	<input type="text" id="login" name="login" placeholder="Usu�rio"/></br>
	<input type="password" id="senha" name="senha" placeholder="Senha"/></br>
	
	<input type="submit" value="Enviar">
</form>

</body>
</html>
