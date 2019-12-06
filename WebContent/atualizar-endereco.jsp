<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<jsp:useBean id="usuario" class="br.com.episteme.model.Usuario" scope="session"></jsp:useBean>
<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
  <meta charset="utf-8">
  <title></title>


  <link href="https://fonts.googleapis.com/icon?family=Material+Icons"
      rel="stylesheet">

  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

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
        <i class="material-icons">
          account_box
        </i>
        <form role="form" action="atualizarendereco" method="post">

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

          <button type="submit" class="btn btn-primary">
            Salvar
          </button>

          
        </form>
		<a href="./minha-conta.jsp">  Voltar </a>
      </div>
     </div>
   </div>

   <!--SCRIPTS BOOTSTRAP-->
   <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
   <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>
