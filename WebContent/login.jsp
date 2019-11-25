<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Login</title>

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
				<i class="material-icons"> account_box </i>
				<form role="form" action="loginservlet" method="post">
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

				<span>Não possui cadastro? <a href="#">Cadastre-se agora</a></span>

			</div>
		</div>
	</div>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/scripts.js"></script>
</body>
</html>