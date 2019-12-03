<jsp:useBean id="usuario" class="br.com.episteme.model.Usuario"	scope="session" />
<!DOCTYPE html>
<html lang="pt-br" dir="ltr">
<head>
<meta charset="utf-8">
<title>.: Login :.</title>
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
					<li class="nav-item"><a class="nav-link disabled" href="#">P�gina
							inicial</a></li>
					<li class="nav-item"><a class="nav-link disabled" href="#">Minha
							conta</a></li>
					<li class="nav-item"><a class="nav-link disabled" href="#">Cadastrar
							livro</a></li>
				</ul>
			</div>
			<div class="col-md-2">&nbsp;</div>
			<div class="col-md-8">
				<i class="material-icons"> account_box </i>
				<form role="form" action="home" method="post">
					<div class="form-group">

						<label for="exampleInputEmail1"> Email </label> <input
							type="email" class="form-control" id="exampleInputEmail1"
							name="txtEmail" />
					</div>
					<div class="form-group">

						<label for="exampleInputPassword1"> Senha </label> <input
							type="password" class="form-control" id="exampleInputPassword1"
							name="txtSenha" />
					</div>

					<button type="submit" class="btn btn-primary">Entrar</button>
				</form>

				<span>N�o possui cadastro? <a
					href="./cadastrarusuario">Cadastre-se
						agora</a></span>

			</div>
			<div class="col-md-1">&nbsp;</div>
		</div>
	</div>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/scripts.js"></script>
</body>
</html>
