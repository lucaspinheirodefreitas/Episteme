<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="usuario" class="br.com.episteme.model.Usuario"
	scope="session" />
<jsp:useBean id="emprestimo" class="java.util.ArrayList" scope="session" />

<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>.: Minha conta :.</title>

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
					<li class="nav-item"><a class="nav-link disabled" href="#">Minha
							conta</a></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#"
						id="navbarDropdownMenuLink" data-toggle="dropdown">Alterar
							dados</a>
						<div class="dropdown-menu dropdown-menu-right"
							aria-labelledby="navbarDropdownMenuLink">
							<a class="dropdown-item" href="./atualizarusuario?tipo=2">Nome</a> <a
								class="dropdown-item" href="./atualizarusuario?tipo=3">Email</a> <a
								class="dropdown-item" href="./atualizarusuario?tipo=1">Deletar
								conta</a>
							<div class="dropdown-divider">Região</div>
							<a class="dropdown-item" href="./atualizarusuario?tipo=4">Endereço</a>
						</div></li>
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
		<div class="row">
			<div class="col-md-12">
				<h3>Olá, ${usuario.nome}!</h3>
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
							<th>Livro:</th>
							<th>Data inicio:</th>
							<th>Data fim</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<c:forEach var="item" items="${emprestimo}">
								<tr class="table-active">
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td>${item.livro.nome}</td>
									<td>${item.retirada}</td>
									<td>${item.devolucao}</td>
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