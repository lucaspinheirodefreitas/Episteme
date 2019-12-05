<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="usuario" class="br.com.episteme.model.Usuario"
	scope="session" />
<jsp:useBean id="listaLivros" class="java.util.ArrayList"
	scope="session"></jsp:useBean>

<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
<meta charset="utf-8">
<title>.: Pesquisar livro :.</title>
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
						href="./pesquisar">Página inicial</a></li>
					<li class="nav-item"><a class="nav-link active"
						href="./minhaconta">Minha conta</a></li>
					<li class="nav-item"><a class="nav-link active"
						href="./cadastrarlivro">Cadastrar livro</a></li>
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
				<table class="table">
					<thead>
						<tr>
						
							<th>Nome:</th>
							<th>Autor:</th>
							<th>Versao:</th>
							<th></th>
							<th></th>
							
						</tr>
					</thead>
					<tbody>
						<tr>
							<c:forEach var="livro" items="${listaLivros}" varStatus="loop">
								<tr class="table-active">

									<td>${livro.nome}</td>
									<td>${livro.autor}</td>
									<td>${livro.versao}</td>

									<td><a
										href="./solicitaremprestimo?pos=${loop.index}&tipo=1">{+}
											Pegar</a>
									</td>
									<td><a
										href="./solicitaremprestimo?pos=${loop.index}&tipo=2">{+}
											Renovar</a>
									</td>
								</tr>
							</c:forEach>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="col-md-2">&nbsp;</div>
		</div>
	</div>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/scripts.js"></script>
</body>
</html>
