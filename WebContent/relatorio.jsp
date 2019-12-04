<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<jsp:useBean id="dados" type="br.com.episteme.model.Relatorio"
	scope="request" />
<jsp:useBean id="usuario" type="br.com.episteme.model.Usuario"
scope="session" />
<html lang="pt-br">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>.: Relatórios :.</title>

<meta name="description"
	content="Source code generated using layoutit.com">
<meta name="author" content="LayoutIt!">

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">

</head>
<body>

	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<ul class="nav">
					<li class="nav-item"><a class="nav-link" href="./pesquisar">Página
							inicial</a></li>
					<li class="nav-item"><a class="nav-link actived"
						href="./minhaconta">Minha conta</a></li>
					<li class="nav-item dropdown ml-md-auto"><a
						class="nav-link dropdown-toggle" href="http://example.com"
						id="navbarDropdownMenuLink" data-toggle="dropdown">Relatórios</a>
						<div class="dropdown-menu dropdown-menu-right"
							aria-labelledby="navbarDropdownMenuLink">
							<a class="dropdown-item" href="./relatorios?tipo=1">Top
								livros</a> <a class="dropdown-item" href="./relatorios?tipo=2">Top
								leitores</a> <a class="dropdown-item" href="./relatorios?tipo=3">Tempo
								medio de emprestimos - Top livros</a>
							<div class="dropdown-divider">Região</div>
							<a class="dropdown-item" href="./relatorios?tipo=4">Bairro
								com maior número de usuários</a> <a class="dropdown-item"
								href="./relatorios?tipo=5">Cidade com maior número de
								usuários</a> <a class="dropdown-item" href="./relatorios?tipo=6">Estado
								com maior número de usuários</a>
						</div></li>
				</ul>
			</div>
		</div>
		<div class="row" id="titulo">
			<div class="col-md-12" align="center">
				<h1 class="text-center">${dados.nomeRelatorio}</h1>
			</div>

		</div>
		<div class="row">
			<div class="col-md-12">
				<h3>Bem vindo, "${usuario.nome}"</h3>
			</div>
		</div>
		<div class="row">
			<div class="col-md-2">&nbsp;</div>
			<div class="col-md-8">
				<table class="table">
					<thead>
						<tr>
							<th></th>
							<th></th>
							<th></th>
							<th></th>
							<th>Item:</th>
							<th align="right">Quantidade:</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<c:forEach var="item" items="${dados.dado}">
								<tr class="table-active">
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td>${item.dado}</td>
									<td>${item.quantidade}</td>
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
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</body>
</html>