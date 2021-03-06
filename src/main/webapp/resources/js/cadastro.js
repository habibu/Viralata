$(document).ready(function(){
	$('#tel').mask('9999-9999');
	$('#dtNasc').mask('99/99/9999');
	verificaCadastro();
});

function confirmCadastro(){
	if (valida()){
		if (confirm("Deseja confirmar seu cadastro?")) {
			if(verificaCadastro()){
				$("cadastro").submit();
			}
		}
	}
	else{
		return false;
	}
}	

function valida(){
	if ($("#nome").val()==""){
		$("#mensagem").text("Campo 'Nome' n�o preenchido.");
		return false;
	}
	else if ($("#cpfCnpj").val()==""){
		$("#mensagem").text("Campo 'Cpf/Cnpj' n�o preenchido.");
		return false;
	}
	else if ($("#email").val()==""){
		$("#mensagem").text("Campo 'E-Mail' n�o preenchido.");
		return false;
	}
	else if ($("#dtNasc").val()==""){
		$("#mensagem").text("Verifique o preenchimento do campo 'Data de Nascimento'.");
		return false;
	}
	else if ($("#tel").val()==""){
		$("#mensagem").text("Campo 'Telefone' n�o preenchido.");
		return false;
	}
	else if ($("#bairro").val()==""){
		$("#mensagem").text("Campo 'Bairro' n�o preenchido.");
		return false;
	}
	else if ($("#cep").val()==""){
		$("#mensagem").text("Campo 'Cep' n�o preenchido.");
		return false;
	}
	else if ($("#rua").val()==""){
		$("#mensagem").text("Campo 'Rua' n�o preenchido.");
		return false;
	}
	else if ($("#numero").val()==""){
		$("#mensagem").text("Campo 'N�mero' n�o preenchido.");
		return false;
	}
	else if ($("#login").val()==""){
		$("#mensagem").text("Campo 'Login' n�o preenchido.");
		return false;
	}
	else if ($("#senha").val()==""){
		$("#mensagem").text("Campo 'Senha' n�o preenchido.");
		return false;
	}
	//Sucesso
	return true;
}

function verificaCadastro(){
	var statusCadastro = "${statusCadastro}";
	
	if (statusCadastro=="login_ja_existente"){
		$("#mensagem").text("Login j Ħ existente. Por favor, informe um novo login.");
		recuperaDados();
		return false;
	}
	else if (statusCadastro=="usuario_ja_existente"){
		$("#mensagem").text("Usu Ħrio j Ħ existente no sistema.");
		recuperaDados();
		return false;
	}
	else if (statusCadastro=="erro_rede"){
		$("#mensagem").text("Erro. Por favor, tente novamente.");
		recuperaDados();
		return false;
	}
	else if (statusCadastro=="sucesso_cadastro"){
		$("#mensagem").text("Cadastro realizado com sucesso!");
		$("#mensagem").css('color', 'green');
		recuperaDados();
	}
	return true;
}