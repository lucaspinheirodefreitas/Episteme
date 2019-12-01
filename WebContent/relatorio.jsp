<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<jsp:useBean id="dados" type="br.com.episteme.model.Relatorio"
	scope="request" />
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
		<div class="row" id="titulo">

			<div class="col-md-8">
				<h1 class="text-center">TOP FIVE - Livros mais emprestados!</h1>
			</div>
			<div class="col-md-2">
				<!--  <a href="./meuCarrinho"><img src="./icons/cart.png" id="iconCarrinho"></a>-->
			</div>
			<div class="col-md-2">
				<!--<a href="./newUser"><img src="./icons/avatar.png" id="iconCarrinho"></a>-->
			</div>
		</div>
		<div class="row">
			<div class="col-md-2">&nbsp;</div>
			<div class="col-md-2">
				<strong>Nome</strong>
			</div>
			<div class="col-md-4">&nbsp;</div>
			<div class="col-md-2">
				<strong>Qtde</strong>
			</div>
			<div class="col-md-2">&nbsp;</div>
		</div>


		<div class="row">
			<div class="col-md-2">&nbsp;</div>
			<div class="col-md-4">
				<c:forEach var="item" items="${dados.topLivros}">
					<div class="col-md-4">&nbsp;</div>
					<div class="col-md-4">
						<h4>${item}</h4>
					</div>
					<div class="col-md-4">&nbsp;</div>
				</c:forEach>
			</div>
			<div class="col-md-2">&nbsp;</div>
			<div class="col-md-2">&nbsp;</div>
			<div class="col-md-4">
				<c:forEach var="item" items="${dados.qtdLivrosEmp}">
					<div class="col-md-4">&nbsp;</div>
					<div class="col-md-4">
						<h4>${item}</h4>
					</div>
					<div class="col-md-4">&nbsp;</div>
				</c:forEach>
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