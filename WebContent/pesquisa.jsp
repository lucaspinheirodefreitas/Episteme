<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="listaLivros"
	class="br.com.episteme.controller.PesquisaServlet" scope="session"></jsp:useBean>

<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
<meta charset="utf-8">
<title></title>
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
					<li class="nav-item"><a class="nav-link active"
						href="./index.html">Página inicial</a></li>
					<li class="nav-item"><a class="nav-link active"
						href="./minha-conta.jsp">Minha conta</a></li>
					<li class="nav-item"><a class="nav-link active"
						href="./cadastro-livro.html">Cadastrar livro</a></li>
				</ul>
			</div>
			<div class="col-md-2">&nbsp;</div>
			<div class="col-md-8">
				<i class="material-icons"> book </i>
				<form role="form" method="post" action="pesquisar">

					<div class="form-group">
						<label for="searchInputNameBook"> Nome do livro </label> <input
							type="text" class="form-control" id="searchInputNameBook"
							name="txtPesquisa" />
					</div>

					<button type="submit" class="btn btn-primary">Buscar</button>
				</form>

			</div>
		</div>
		<div class="col-md-2">&nbsp;</div>
		<div class="row">
			<div class="col-md-2">&nbsp;</div>
			<div class="col-md-8">
				<h3>Você está buscando por:</h3>
				<ul>
					<li class="list-item">${listaLivros.get(0)}
						<div class="row">
							<div class="col-md-10">&nbsp;</div>
							<div class="col-md-2" align="right">
								<a class="dropdown-item" href="./relatorios?tipo=1"></a>
								<button type="submit" class="btn btn-primary">Detalhes</button>
							</div>
						</div>
					</li>
					<li class="list-item">${listaLivros.get(1)}
						<div class="row" align="right">
							<div class="col-md-10">&nbsp;</div>
							<div class="col-md-2">
								<button type="submit" class="btn btn-primary">Detalhes</button>
							</div>
						</div>
					</li>
					<li class="list-item">${listaLivros.get(2)}
						<div class="row" align="right">
							<div class="col-md-10">&nbsp;</div>
							<div class="col-md-2">
								<button type="submit" class="btn btn-primary">Detalhes</button>
							</div>
						</div>
					</li>
					<li class="list-item">${listaLivros.get(3)}
						<div class="row" align="right">
							<div class="col-md-10">&nbsp;</div>
							<div class="col-md-2">
								<button type="submit" class="btn btn-primary">Detalhes</button>
							</div>
						</div>
					</li>
				</ul>
			</div>
			<div class="col-md-2">&nbsp;</div>
		</div>
	</div>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/scripts.js"></script>
</body>
</html>
