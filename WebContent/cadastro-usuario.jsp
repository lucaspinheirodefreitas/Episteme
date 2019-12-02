<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
<meta charset="utf-8">
<title>.: Cadastro de usuário :.</title>


<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">

</head>
<body>
	<script type="text/javascript">
		function buscaEndereco() {
			var cep = document.getElementById("cep").value;
			var xmlhttp = new XMLHttpRequest();
			var url = "http://cep.republicavirtual.com.br/web_cep.php?cep="
					+ cep + "&formato=json";
			xmlhttp.onreadystatechange = function() {
				if (xmlhttp.status === 200) {
					if (xmlhttp.readyState === 4) {
						var endereco = JSON.parse(xmlhttp.responseText);
						if (endereco.resultado == "1") {
							document.getElementById("tipo").value = endereco.tipo_logradouro;
							document.getElementById("logradouro").value = endereco.logradouro;
							document.getElementById("bairro").value = endereco.bairro;
							document.getElementById("cidade").value = endereco.cidade;
							document.getElementById("estado").value = endereco.uf;
						} else {
							alert("Endereco nao encontrado pelo CEP informado");
						}
					}
				}
			};
			xmlhttp.open("GET", url, true);
			xmlhttp.send();

		}
	</script>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<img alt="Logo biblioteca" src="imagens/episteme_1.jpg" width=120
					height=120 align="right">
			</div>
			<div class="col-md-2">&nbsp;</div>
			<div class="col-md-8">
				<i class="material-icons"> account_box </i>
				<form role="form" action="cadastrausuarioservlet" method="post">

					<div class="form-group">

						<label for="exampleInputName"> Nome </label> <input type="text"
							class="form-control" id="exampleInputName" name="txtNome" />
					</div>

					<div class="form-group">

						<label for="exampleInputEmail1"> Email </label> <input
							type="email" class="form-control" id="exampleInputEmail1"
							name="txtEmail" />
					</div>
					<div class="form-group">

						<label for="exampleInputPassword1"> Senha </label> <input
							type="password" class="form-control" id="exampleInputPassword1"
							name="txtSenha" />
					</div>

					<div class="form-group">

						<label for="exampleInputPassword1"> Confirme a Senha </label> <input
							type="password" class="form-control"
							id="exampleInputPasswordCheck" name="txtConfirmaSenha" />
					</div>

					<div class="form-group">
						<label for="cep"> Digite o CEP </label> <input type="text"
							class="form-control" id="cep" name="txtCep"
							onblur="buscaEndereco();" />
					</div>

					<div class="form-group">
						<label for="tipo"> Tipo do Logradouro </label> <input type="text"
							readonly="readonly" class="form-control" id="tipo" name="txtTipo" />
					</div>
					<div class="form-group">
						<label for="logradouro"> Logradouro </label> <input type="text"
							readonly="readonly" class="form-control" id="logradouro"
							name="txtLogradouro" />
					</div>
					<div class="form-group">
						<label for="numero"> Numero </label> <input type="number"
							class="form-control" id="numero" name="txtNumero" />
					</div>
					<div class="form-group">
						<label for="complemento"> Complemento </label> <input type="text"
							class="form-control" id="complemento" name="txtComplemento" />
					</div>
					<div class="form-group">
						<label for="bairro"> Bairro </label> <input type="text"
							readonly="readonly" class="form-control" id="bairro"
							name="txtBairro" />
					</div>
					<div class="form-group">
						<label for="cidade"> Cidade </label> <input type="text"
							readonly="readonly" class="form-control" id="cidade"
							name="txtCidade" />
					</div>
					<div class="form-group">
						<label for="estado"> Estado </label> <input type="text"
							readonly="readonly" class="form-control" id="estado"
							name="txtEstado" />
					</div>

					<button type="submit" class="btn btn-primary">Cadastrar</button>
				</form>

			</div>
			<div class="col-md-2">&nbsp;</div>
		</div>
	</div>

	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/scripts.js"></script>
</body>