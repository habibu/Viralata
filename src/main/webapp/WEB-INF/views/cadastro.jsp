<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Cadastro</title>
	<script type="text/javascript" src="/viralata/resources/js/jquery-2.1.0.min.js"></script>
	<script type="text/javascript" src="/viralata/resources/js/bootstrap.js"></script>
	<script type="text/javascript" src="/viralata/resources/js/jquery.maskedinput.js"></script>
	<script type="text/javascript" src="/viralata/resources/js/cadastro.js"></script>
	<link rel="stylesheet" href="/viralata/resources/css/bootstrap.min.css"></link>
</head>
<body>
<h1>
	Cadastro 
</h1>
<!-- Mensagem de erro -->
<p id="mensagem" style="color: red;"></p>
<form id="cadastro" action="cadastro" method="post">
	<table>
		<tr>
			<td>
				<input type="text" id="nome" name="nome" placeholder="Nome Completo" value="${usuario.nome}"/></br>
				<input type="text" id="cpfCnpj" name="cpfCnpj" placeholder="Cpf/Cnpj" value="${usuario.cpfCnpj}"/></br>
				<input type="text" id="rg" name="rg" placeholder="RG" value="${usuario.rg}"/></br>
				<input type="text" id="email" name="email" placeholder="E-mail" value="${usuario.email}"/></br>
				<input type="date" id="dtNasc" name="dtNasc" placeholder="Data de Nascimento" value="${dtNasc}"/></br>
				<input type="text" id="tel" name="tel" placeholder="Telefone" value="${endereco.telefoneResidencial}"/></br>
				<td>
				<input type="text" id="bairro" name="bairro" placeholder="Bairro" value="${endereco.bairro}"/></br>
				<input type="text" id="cep" name="cep" placeholder="Cep" value="${endereco.cep}"/></br>
				<input type="text" id="rua" name="rua" placeholder="Rua" value="${endereco.rua}"/></br>
				<input type="text" id="numero" name="numero" placeholder="Número" value="${endereco.numero}"/></br>
				<select id="cidade" name="cidade" >
					<option value="2">Campo Largo</option>
					<option value="1">Curitiba</option>
				</select>
				<select id="estado" name="estado">
					<option value="AC">AC</option>
					<option value="AL">AL</option>
					<option value="AM">AM</option>
					<option value="AP">AP</option>
					<option value="BA">BA</option>
					<option value="CE">CE</option>
					<option value="DF">DF</option>
					<option value="ES">ES</option>
					<option value="GO">GO</option>
					<option value="MA">MA</option>
					<option value="MG">MG</option>
					<option value="MT">MT</option>
					<option value="MS">MS</option>
					<option value="PA">PA</option>
					<option value="PB">PB</option>
					<option value="PE">PE</option>
					<option value="PI">PI</option>
					<option value="PR">PR</option>
					<option value="RJ">RJ</option>
					<option value="RN">RN</option>
					<option value="RO">RO</option>
					<option value="RR">RR</option>
					<option value="RS">RS</option>
					<option value="SC">SC</option>
					<option value="SE">SE</option>
					<option value="SP">SP</option>
					<option value="TO">TO</option>
				</select>
<!-- 				<select id="tipoMoradia" name="tipoMoradia"> -->
<!-- 					<option value="0">Alvenaria</option> -->
<!-- 					<option value="1">Barracão</option> -->
<!-- 					<option value="2">Oca</option> -->
<!-- 					<option value="3">Palafita</option> -->
<!-- 					<option value="4">Prédio</option> -->
<!-- 					<option value="5">Tenda</option> -->
<!-- 				</select> -->
<!-- 					<input type="text" id="area" name="area" placeholder="Área da Moradia"/></br> -->
<!-- 				</td> -->
<!-- 				<td> -->
<!-- 					<input type="text" id="renda" name="renda" placeholder="Renda Familiar"/></br> -->
<!-- 					<input type="text" id="filhos" name="filhos" placeholder="Número de Filhos"/></br> -->
<!-- 					<input type="text" id="animais" name="animais" placeholder="Número de animais em casa"/></br> -->
<!-- 				</td> -->
				<td>
					<input type="text" id="login" name="login" placeholder="Login" value="${usuario.login}"/>
					<input type="password" id="senha" name="senha" placeholder="Senha" value="${usuario.senha}"/>
				</td>
		</tr>
	</table>
	<button id="botaoCadastro" class="btn btn-info" onclick="confirmCadastro();">Realizar Cadastro</button>
</form>

</body>
</html>
