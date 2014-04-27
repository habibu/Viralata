<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<form action="dadosCadastraisAdo" method="post">
	<input type="submit" value="Dados Cadastrais">
</form>
<P>${usuario.dataNascimento}</P>
</body>
</html>
