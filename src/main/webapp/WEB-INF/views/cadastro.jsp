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
				<input type="text" id="tel" name="tel" placeholder="Telefone"/></br>
				<td>
				<input type="text" id="bairro" name="bairro" placeholder="Bairro"/></br>
				<input type="text" id="cep" name="cep" placeholder="Cep"/></br>
				<input type="text" id="rua" name="rua" placeholder="Rua"/></br>
				<input type="text" id="numero" name="numero" placeholder="Número"/></br>
				<input type="text" id="cidade" name="cidade" placeholder="Cidade"/></br>
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
		</tr>
	</table>
	<input type="submit" value="Realizar Cadastro">
</form>

</body>
</html>
