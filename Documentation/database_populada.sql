CREATE TABLE TBENDERECO (
  	IdEndereco 		SERIAL  		NOT NULL,
	CEP 			VARCHAR(15)		NOT NULL, -- motivos: usuário pode colocar ponto ou pode ser alguém de fora do Brasil.
  	Logradouro 		VARCHAR(100) 	NOT NULL,
	Numero 			INTEGER   		NOT NULL,
	Bairro	 		VARCHAR(30) 	NOT NULL,
	Cidade	 		VARCHAR(30) 	NOT NULL,
	Estado	 		VARCHAR(20) 	NOT NULL,
  	CONSTRAINT PK_endereco PRIMARY KEY(IdEndereco)
);

CREATE TABLE TBUSUARIO (
  	IdUsuario 		SERIAL	 		NOT NULL ,
  	NomeUsuario 	VARCHAR(100) 	NOT NULL,
	Email 			VARCHAR(255)	NOT NULL,
	Senha 			VARCHAR(30)		NOT NULL,
	IdEndereco 		INTEGER			NOT NULL,
  	CONSTRAINT PK_usuario PRIMARY KEY(IdUsuario),
	

	CONSTRAINT FK_endereco FOREIGN KEY (IdEndereco) REFERENCES TBEndereco(IdEndereco)
);

CREATE TABLE TBLIVRO (
  	IdLivro 			SERIAL  	NOT NULL,
	NomeLivro		VARCHAR(30)		NOT NULL, -- motivos: usuário pode colocar ponto ou pode ser alguém de fora do Brasil.
  	Autor	 		VARCHAR(100) 	NOT NULL,
	Ano 			DATE	   		NOT NULL,
	Versao	 		INTEGER		 	NOT NULL,
	Editora	 		VARCHAR(30) 	NOT NULL,
	LinkPDF	 		TEXT		 	NOT NULL,
	DataCadastro 	TIMESTAMP		NOT NULL,
	Sinopse			TEXT			NOT NULL,
  	CONSTRAINT PK_livro PRIMARY KEY(IdLivro)
);

CREATE TABLE TBEMPRESTIMO (
  	IdEmprestimo 	SERIAL			NOT NULL,
  	DataInicio	 	Date	 		NOT NULL,
	DataFim		 	Date	 		NOT NULL,
  	IdUsuario 		INTEGER  		NOT NULL,
	IdLivro 		INTEGER			NOT NULL,
  	CONSTRAINT PK_emprestimo 	PRIMARY KEY(IdEmprestimo),
	CONSTRAINT FK_usuario		FOREIGN KEY (idUsuario) 	REFERENCES TBUsuario(IdUsuario),
	CONSTRAINT FK_livro 	 		FOREIGN KEY (idLivro) 	REFERENCES TBLivro(IdLivro)
);

INSERT INTO TBENDERECO(IdEndereco, CEP, Logradouro, Numero, Bairro, Cidade, Estado)
VALUES (DEFAULT,'09270-470','rua apalaches', '244', 'Pq. Novo Oratório', 'Santo André', 'SP'),
		(DEFAULT,'0940-220','rua TONIO BASTOS', '77', 'VL BASTOS', 'Santo André', 'SP'),	
		(DEFAULT,'05653-070','praça gomes pedrosa', '001', 'Morumbi', 'diadema', 'SP'),
		(DEFAULT,'0123-123','marighella', '321', 'Pq. das nações', 'Santos', 'SP'),
		(DEFAULT,'09270-333','rua alemanha', '222', 'vl luzita', 'Santo André', 'SP');
		
INSERT INTO TBUSUARIO(IdUsuario, nomeusuario, email, senha, idendereco)
VALUES (default, 'raul', 'raul.tmachado@gmail.com', '1234',1),
		(default, 'ARTHUR', 'ARTHUR.tmachado@gmail.com', '123433',2),
		(default, 'lucas', 'lucas.tmachado@gmail.com', '123',3),
		(default, 'lucas dutra', 'dutra.tmachado@gmail.com', '123111',4),
		(default, 'luiz inácio', 'lula.tmachado@gmail.com', '12333',5),
		(default, 'joao amoedo', 'amoeda.hfernandes@gmail.com', '122342',6)
		
INSERT INTO TBLIVRO(idlivro, nomelivro, autor, ano, versao, editora, linkpdf, datacadastro, sinopse)
values (default, 'manifesto comunista', 'carlos marcos e frederico anjos', '07/08/1845', 1, 'boitempo', 'www.livrosgratis.com', '07/08/1998', '"um espectro ronda a europa"'),
		(default, 'don quixote', 'miguel de cervantes', '07/08/1333', 2, 'leya', 'www.livrosgratis.com', '01/02/1999', '"este cara eh mto loco"'),
		(default, 'bíblia sagrada', 'Jeová', '01/01/0001', 1, 'igreja católica', 'www.livrosquevcdeverialer.com', '07/08/1980', '"este livro conta a história do mundo"'),
		(default, 'A guerra dos tronos', 'Jorge R.R Martin', '07/08/1990', 4, 'leya', 'www.gameofthrones', '07/08/1990', '"um livro de ação, lobos e muita diversão"')

insert into tbemprestimo(idemprestimo, datainicio, datafim,idusuario,idlivro)
values(default,'01/01/2019','08/01/2019',1,1),
		(default,'08/01/2019','13/01/2019',2,2),
		(default,'01/02/2019','08/02/2019',3,3),
		(default,'01/03/2019','08/03/2019',4,4);