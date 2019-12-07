<jsp:useBean id="usuario" class="br.com.episteme.model.Usuario"
	scope="session" />
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>.: Home - Episteme :.</title>

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
					<li class="nav-item"><a class="nav-link disabled" href="#">Página
							inicial</a></li>
					<li class="nav-item"><a class="nav-link active"
						href="./minhaconta?tipo=1">Minha conta</a></li>
					<li class="nav-item"><a class="nav-link active"
						href="./cadastrarlivro">Cadastrar livro</a></li>
				</ul>
				<div class="row">
					<div class="col-md-5">&nbsp;</div>
					<div class="col-md-7" align="center">
						<form class="form-inline" role="form" action="pesquisar"
							method="post">
							<div class="form-group" align="center">
								<input type="search" class="form-control" id="pesquisar"
									name="txtPesquisa">
							</div>
							<button type="submit" class="btn btn-primary">pesquisar</button>
						</form>
					</div>
				</div>
			</div>
		</div>

		<!-- #INICIO DO DESCRITIVO SOBRE A BIBLIOTECA -->
		<div class="row">
			<div class="col-md-2">&nbsp;</div>
			<div class="col-md-8">
				<h3 align="left">
					<strong>Episteme</strong>
				</h3>
				<img alt="Fotografia biblioteca" src="imagens/predio.jpeg" width=400
					height=300 align="middle">
				<div class="row">
					<div class="col-md-6">
						<p>The Department of Physics of the Faculty of Philosophy,
							Sciences and Letters of Ribeirao Preto (FFCLRP), 320 km from SP,
							it houses a collection of more than 1,200 books of literature,
							romance and scientific dissemination in one of its buildings. The
							Roberto C. Nascimento Library, located within a department
							laboratory, was established in 2013. According to the library
							director, USP physicist and teacher Osame Kinouchi, the
							collection began with about 400 books that belonged to the
							Science Fiction Readers Club (CLFC). Thanks to community
							donations academic and literature enthusiasts, more volumes have
							been added to the collection. Today, anyone can borrow books
							ranging from Brazilian classics like The Daughter of the
							Inca by Menotti del Picchia, originally published in 1930 with
							the title "The Republic" , to latest issues released in
							the country. About 500 books are available from the Argonauts
							Collection, which has published authors such as Philip K. Dick,
							Robert A. Heinlein and Ursula K. Le Guin in Portuguese between
							1950 and 2000. Writing more. Proin massa magna, vulputate nec
							bibendum nec, posuere nec lacus</p>
					</div>
					<div class="col-md-6">
						<dl>
							<dd>.</dd>
							<dt>Come check out all the books we have! </dt>
							<dd>.</dd>
							<dd>Our library has one of the largest collections on the planet.</dd>
							<dd>.</dd>
							<dt>addition we are also sustainable because
								we do not use paper! </dt>
							<dd>.</dd>
							<dd></dd>
							<dd></dd>
							<dt></dt>
							<dd>The first library with digital links in the world</dd>
							<dd>.</dd>
							<dt>developed by UFABC students</dt>
							<dd>.</dd>
						</dl>
					</div>
				</div>
			</div>
			<div class="col-md-2">&nbsp;</div>
		</div>
		<!-- #FIM DO DESCRITIVO SOBRE A BIBLIOTECA -->

		<!-- #INICIO DO RODAPÉ DA PÁGINA -->
		<div class="row">
			<div class="col-md-2">&nbsp;</div>
			<div class="col-md-2" align="justify">
				<address>
					<strong>Episteme, Inc.</strong><br> Rua dos bobos, Nº 0.<br>
					SP, CEP:000000-000<br> <abbr title="Telefone">P:</abbr> (11)
					9999-9999
				</address>
			</div>
			<div class="col-md-2">&nbsp;</div>

			<div class="col-md-4" align="justify">
				<blockquote class="blockquote">
					<p class="mb-0">The first duty of intelligence is to doubt itself.</p>
					<footer class="blockquote-footer">
						<cite>Einstein, Albert.</cite>
					</footer>
				</blockquote>
			</div>
			<div class="col-md-2">&nbsp;</div>
		</div>
		<!-- #FIM DO RODAPÉ DA PÁGINA -->
	</div>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/scripts.js"></script>
</body>
</html>