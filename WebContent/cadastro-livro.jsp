<!DOCTYPE html>
<html lang="pt-br" dir="ltr">
<head>
<meta charset="utf-8">
<title>.: Cadastrar livro :.</title>
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
						href="./pesquisar">P�gina inicial</a></li>
					<li class="nav-item"><a class="nav-link active"
						href="./minhaconta?tipo=1">Minha conta</a></li>
					<li class="nav-item"><a class="nav-link disabled"
						href="./cadastro-livro.jsp">Cadastrar livro</a></li>
				</ul>
			</div>
			<div class="col-md-12" align="center">
				<h3>
					<strong>Cadastro de livro</strong>
				</h3>
			</div>
		</div>
		<div class="row">
			<div class="col-md-2">&nbsp;</div>
			<div class="col-md-8">
				<form role="form" action="cadastrarlivro" method="post">
					<div class="form-group">
						<label for="inputNomeLivro"> Nome do livro </label> <input
							class="form-control" id="inputNomeLivro" type="text"
							name="txtNomeLivro">
					</div>

					<div class="form-group">
						<label for="inputNomeLivro"> Nome do Autor </label> <input
							class="form-control" id="inputAutor" type="text" name="txtAutor">
					</div>

					<div class="form-group">
						<label for="inputNomeLivro"> Vers�o </label> <input
							class="form-control" id="inputVersao" type="number"
							name="txtVersao">
					</div>

					<div class="form-group">
						<label for="inputIdiomaLivro"> Idioma </label> <input
							class="form-control" id="inputIdioma" type="text"
							name="txtIdioma">
					</div>

					<div class="form-group">
						<label for="inputEditoraLivro"> Editora </label> <input
							class="form-control" id="inputEditora" type="text"
							name="txtEditora">
					</div>

					<div class="form-group">
						<label for="inputSinopseLivro"> Sinopse </label> <input
							class="form-control" id="inputSinopse" type="text"
							name="txtSinopse">
					</div>

					<div class="form-group">
						<label for="inputLinkPDFLivro"> Link PDF </label> <input
							class="form-control" id="inputLinkPDF" type="url" name="txtUrl">
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
</html>
