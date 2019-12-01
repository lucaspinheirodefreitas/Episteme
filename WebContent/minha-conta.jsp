<!DOCTYPE html>
<html lang="pt">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Minha conta</title>

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
					<li class="nav-item"><a class="nav-link" href="./index.html">Home</a>
					</li>
					<li class="nav-item"><a class="nav-link active" href="./login.html">Sair</a>
					</li>
					<li class="nav-item"><a class="nav-link disabled" href="#">Minha conta</a>
					</li>
					<li class="nav-item dropdown ml-md-auto"><a
						class="nav-link dropdown-toggle" href="http://example.com"
						id="navbarDropdownMenuLink" data-toggle="dropdown">Relatórios</a>
						<div class="dropdown-menu dropdown-menu-right"
							aria-labelledby="navbarDropdownMenuLink">
							<a class="dropdown-item" href="./relatorios?tipo=1">Livros mais emprestados</a> 
							<a class="dropdown-item" href="./relatorios?tipo=2">Top 5 - leitores</a>
							<div class="dropdown-divider">Região</div>
							<a class="dropdown-item" href="./relatorios?tipo=3">Endereco com maior número de usuários</a>
							<a class="dropdown-item" href="./relatorios?tipo=4">Bairro com maior número de usuários</a>
							<a class="dropdown-item" href="./relatorios?tipo=5">Cidade com maior número de usuários</a>
							<a class="dropdown-item" href="./relatorios?tipo=6">Estado com maior número de usuários</a>
							<a class="dropdown-item" href="./relatorios?tipo=7">Pais com maior número de usuários</a>
						</div>
					</li>
				</ul>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<h3>Bem vindo, @ .</h3>
				<table class="table">
					<thead>
						<tr>
							<th>#</th>
							<th>Livro 1:</th>
							<th>Livro 2:</th>
							<th>Livro 3:</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>1</td>
							<td>TB - Monthly</td>
							<td>01/04/2012</td>
							<td>Default</td>
						</tr>
						<tr class="table-active">
							<td>1</td>
							<td>TB - Monthly</td>
							<td>01/04/2012</td>
							<td>Approved</td>
						</tr>
						<tr class="table-success">
							<td>2</td>
							<td>TB - Monthly</td>
							<td>02/04/2012</td>
							<td>Declined</td>
						</tr>
						<tr class="table-warning">
							<td>3</td>
							<td>TB - Monthly</td>
							<td>03/04/2012</td>
							<td>Pending</td>
						</tr>
						<tr class="table-danger">
							<td>4</td>
							<td>TB - Monthly</td>
							<td>04/04/2012</td>
							<td>Call in to confirm</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>

	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/scripts.js"></script>
</body>
</html>