<jsp:useBean id="usuario" type="br.com.episteme.model.Usuario"
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
					<li class="nav-item"><a class="nav-link disabled"
						href="#">Página inicial</a></li>
					<li class="nav-item"><a class="nav-link active"
						href="./minhaconta">Minha conta</a></li>
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
				<h3 align="left"><strong>Episteme</strong></h3>
				<img alt="Fotografia biblioteca" src="imagens/predio.jpeg" width=400
					height=300 align="middle">
				<div class="row">
					<div class="col-md-6">
						<p>
							O Departamento de Física da Faculdade de Filosofia, Ciências e Letras de Ribeirão Preto (FFCLRP), 
							cidade a 320 km de São Paulo, guarda um acervo de mais de 1.200 livros de literatura de ficção científica e 
							divulgação de ciência em um de seus prédios.
							A Biblioteca Roberto C. Nascimento, localizada dentro de um laboratório do departamento, foi criada em 2013.
							Segundo o diretor da biblioteca, o físico e professor da USP Osame Kinouchi, o acervo começou com os cerca de 
							400 livros que pertenciam ao Clube de Leitores de Ficção Científica (CLFC). Graças a doações da comunidade 
							acadêmica e de entusiastas da literatura sci-fi, mais volumes foram acrescentados à coleção.
							Hoje, qualquer pessoa pode fazer o empréstimo de livros que vão desde clássicos brasileiros do gênero, como 
							“A Filha do Inca”, de Menotti del Picchia, publicado originalmente em 1930 com o título “A República 3000”, 
							até edições mais recentes lançadas no país.
							Estão disponíveis ainda cerca de 500 livros da Colecção Argonautas, que publicou autores como Philip K. Dick, 
							Robert A. Heinlein e Ursula K. Le Guin em língua portuguesa entre os anos 1950 e 2000. <em>Escrever
							mais.</em> Proin massa magna, vulputate nec bibendum nec, posuere nec
							lacus. <small>Aliquam mi erat, aliquam vel luctus eu,
							pharetra quis elit. Nulla euismod ultrices massa, et feugiat
							ipsum consequat eu.</small>
						</p>
					</div>
					<div class="col-md-6">
						<dl>
							<dt>Lista de alguma coisa interessante</dt>
							<dd>A descripSADSAASSDAtion list is perfect for defining
								terms.</dd>
							<dt>Euismod</dt>
							<dd>Vestibulum id ligula porta felis euismod semper eget
								lacinia odio sem nec elit.</dd>
							<dd>Donec id elit non mi porta gravida at eget metus.</dd>
							<dt>Malesuada porta</dt>
							<dd>Etiam porta sem malesuada magna mollis euismod.</dd>
							<dt>Felis euismod semper eget lacinia</dt>
							<dd>Fusce dapibus, tellus ac cursus commodo, tortor mauris
								condimentum nibh, ut fermentum massa justo sit amet risus.</dd>
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
					<p class="mb-0">O primeiro dever da inteligência é desconfiar dela mesma.</p>
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