/*
	Script criação relações:
*/

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
	Senha 			TEXT			NOT NULL,
	IdEndereco 		INTEGER			NOT NULL,
	UNIQUE 			(IdUsuario),
	UNIQUE			(email),		
  	CONSTRAINT PK_usuario PRIMARY KEY(email),
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
	Sinopse			JSON			NOT NULL,
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
