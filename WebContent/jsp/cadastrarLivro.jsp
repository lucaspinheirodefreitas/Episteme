<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Cadastro de livro</title>

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
				<h3>Cadastro de livro</h3>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<form role="form" action="cadastralivro" method="post">
					<div class="form-group">
						<input class="form-control" id="inputNomeLivro" type="text"
							name="txtNomeLivro">
					</div>
					
					<div class="form-group">
						<input class="form-control" id="inputAutor" type="text"
							name="txtAutor">
					</div>
					
					<div class="form-group">
						<input class="form-control" id="inputAno" type="date"
							name="txtAno">
					</div>
					
					<div class="form-group">
						<input class="form-control" id="inputVersao" type="number"
							name="txtVersao">
					</div>
					
					<div class="form-group">
						<input class="form-control" id="inputEditora" type="text"
							name="txtEditora">
					</div>
					
					<div class="form-group">
						<input class="form-control" id="inputLinkPDF" type="url"
							name="txtUrl">
					</div>
					
					<div class="form-group">
						<input class="form-control" id="inputSinopse" type="text"
							name="txtSinopse">
					</div>
					
					<div class="form-group">
						<!-- PENSAR MELHOR NESSA PARTE -->
						<input class="form-control" id="exampleInputPassword1"
							type="image" name="txtCapa">
					</div>
					<button type="submit" class="btn btn-primary">Cadastrar</button>
				</form>
			</div>
		</div>
	</div>

	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/scripts.js"></script>
</body>
</html>