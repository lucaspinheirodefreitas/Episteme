<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:useBean id="campo" class="java.lang.String" scope="session"></jsp:useBean>
<jsp:useBean id="usuario" class="br.com.episteme.model.Usuario"
	scope="session"></jsp:useBean>
<!DOCTYPE html>
<html lang="pt-br" dir="ltr">
<head>
<meta charset="utf-8">
<title>.: Atualizar dados :.</title>


<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">

</head>
<body>

	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<img alt="Logo biblioteca" src="imagens/episteme_1.jpg" width=120
					height=120 align="right">

				<ul class="nav">
					<li class="nav-item"><a class="nav-link active" href="./index.jsp">Página
							inicial</a></li>
					<li class="nav-item"><a class="nav-link active"
						href="./minha-conta.jsp">Voltar</a></li>
				</ul>
			</div>
		</div>
		<div class="row">
		<div class="col-md-2">&nbsp;</div>
			<div class="col-md-8">
				<i class="material-icons"> account_box </i>
				<form role="form" action="atualizarcampo" method="post">

					<div class="form-group">

						<label for="inputName"> ${campo} </label> <input type="text"
							class="form-control" id="inputAtualiza" name="campoatt" />
					</div>

					<button type="submit" class="btn btn-primary">Salvar</button>


				</form>
			</div>
			<div class="col-md-2">&nbsp;</div>
		</div>
	</div>
</body>
</html>
