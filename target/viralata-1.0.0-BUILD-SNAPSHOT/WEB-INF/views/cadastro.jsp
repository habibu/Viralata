<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Cadastro</title>
	<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
</head>
<script type="text/javascript">
	
function confirmCadastro(){
	if (valida()){
	 if (confirm("Deseja confirmar seu cadastro?")) {
		 document.forms["cadastro"].submit();
	   }
	}else{
		return false;
	}
}	

function valida(){
	if ($("#nome").val()==""){
		$("#mensagem").text("Campo 'Nome' não preenchido.");
		return false;
	}else if ($("#cpfCnpj").val()==""){
		$("#mensagem").text("Campo 'Cpf/Cnpj' não preenchido.");
		return false;
	}else if ($("#email").val()==""){
		$("#mensagem").text("Campo 'E-Mail' não preenchido.");
		return false;
	}else if ($("#dtNasc").val()==""){
		$("#mensagem").text("Verifique o preenchimento do campo 'Data de Nascimento'.");
		return false;
	}else if ($("#tel").val()==""){
		$("#mensagem").text("Campo 'Telefone' não preenchido.");
		return false;
	}else if ($("#bairro").val()==""){
		$("#mensagem").text("Campo 'Bairro' não preenchido.");
		return false;
	}else if ($("#cep").val()==""){
		$("#mensagem").text("Campo 'Cep' não preenchido.");
		return false;
	}else if ($("#rua").val()==""){
		$("#mensagem").text("Campo 'Rua' não preenchido.");
		return false;
	}else if ($("#numero").val()==""){
		$("#mensagem").text("Campo 'Número' não preenchido.");
		return false;
	}else if ($("#login").val()==""){
		$("#mensagem").text("Campo 'Login' não preenchido.");
		return false;
	}else if ($("#senha").val()==""){
		$("#mensagem").text("Campo 'Senha' não preenchido.");
		return false;
	}
	//Sucesso
	return true;
}

function verificaCadastro(){
	var statusCadastro = "${statusCadastro}";
	
	if (statusCadastro=="login_ja_existente"){
		$("#mensagem").text("Login já existente. Por favor, informe um novo login.");
		recuperaDados();
		return false;
	}else if (statusCadastro=="usuario_ja_existente"){
		$("#mensagem").text("Usuário já existente no sistema.");
		recuperaDados();
		return false;
	}else if (statusCadastro=="erro_rede"){
		$("#mensagem").text("Erro. Por favor, tente novamente.");
		recuperaDados();
		return false;
	}else if (statusCadastro=="sucesso_cadastro"){
		$("#mensagem").text("Cadastro realizado com sucesso!");
		$("#mensagem").css('color', 'green');
		recuperaDados();
	}
	return true;
}

$(document).ready(
		
		function() {
			 verificaCadastro();
	});
</script>
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
	<input id="botaoCadastro" type="button" value="Realizar Cadastro" onclick="confirmCadastro();">
</form>

</body>
</html>
