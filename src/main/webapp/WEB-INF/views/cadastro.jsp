<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Cadastro</title>
</head>
<body>
<h1>
	Cadastro 
</h1>
<form action="cadastro" method="post">
	<table>
		<tr>
			<td>
				<input type="text" id="nome" name="nome" placeholder="Nome Completo"/></br>
				<input type="text" id="cpfCnpj" name="cpfCnpj" placeholder="Cpf/Cnpj"/></br>
				<input type="text" id="rg" name="rg" placeholder="RG"/></br>
				<input type="text" id="email" name="email" placeholder="E-mail"/></br>
				<input type="date" id="dtNasc" name="dtNasc" placeholder="Data de Nascimento"/></br>
				<input type="text" id="bairro" name="bairro" placeholder="Bairro"/></br>
				<input type="text" id="cep" name="cep" placeholder="Cep"/></br>
				<input type="text" id="rua" name="rua" placeholder="Rua"/></br>
				<input type="text" id="numero" name="numero" placeholder="Número"/></br>
				<input type="text" id="cidade" name="cidade" placeholder="Cidade"/></br>
				<input type="text" id="estado" name="estado" placeholder="Estado"/></br>
				<input type="text" id="tel" name="tel" placeholder="Telefone Residencial"/></br>
				<input type="text" id="cel" name="cel" placeholder="Celular"/></br>
			</td>
		</tr>
	</table>
	<input type="submit" value="Realizar Cadastro">
</form>

</body>
</html>
