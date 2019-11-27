package br.com.episteme.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.episteme.model.Livro;


public class LivroDAO implements GenericDAO{
	private DataSource dataSource;

	public LivroDAO(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void create(Object o) {
		try {
			if(o instanceof Livro) { 
				/*
					INSERT INTO TBLIVRO(idlivro, nomelivro, autor, ano, versao, editora, linkpdf, datacadastro, sinopse, idioma) 
					VALUES((select nextval('autoIncrementLivro')), 'livro de teste', 'teste@teste.com.br', '1500-01-01', '0.0', 'editora de teste', 'http://www.argen.com.br/arquivos/servico/pdfServico_57952bf8ca7af_24-07-2016_17-58-32.pdf', '1999-01-08 04:05:06
					', 'este livro refere-se a história de um teste', 'português');
				*/
				Livro cadastrarLivro = (Livro) o;
				String SQL = "INSERT INTO TBLIVRO(idlivro, nomelivro, autor, versao, editora, linkpdf, datacadastro, sinopse, idioma) "
						+ "VALUES ((select nextval('autoIncrementUsuario')), ?, ?, ?, ?, ?, ?, ?, ?;";
				PreparedStatement stm = dataSource.getConnection().prepareStatement(SQL);
				stm.setString(1, cadastrarLivro.getNome());
				stm.setString(2, cadastrarLivro.getAutor());
				stm.setDouble(4, cadastrarLivro.getVersao());
				stm.setString(5, cadastrarLivro.getEditora());
				stm.setString(6, cadastrarLivro.getLinkPDF());
				stm.setString(7, "'1500-01-01 01:01:01'");
				stm.setString(8, cadastrarLivro.getSinopse());
				stm.setString(9, cadastrarLivro.getIdioma());
				ResultSet rs = stm.executeQuery();
				stm.close();
				rs.close();

			} else {
				throw new RuntimeException("Objeto inválido"); // entender como funciona o throw.
			}

		} catch (SQLException ex) {
			System.out.println("Falha ao efetuar inserção!\n" + "Codigo de erro: " + ex.getErrorCode() 
			+ "\n" + "Mensagem de erro: " + ex.getMessage());
		}

	}

	@Override
	public List<Object> read(Object o) {
		try {
			if(o instanceof Livro) { 
				Livro livroPesquisa = (Livro) o;
				
				/*
					select * from tblivro where nomelivro like ('%teste%');
				*/
				
				String SQL = "SELECT * FROM TBULIVRO WHERE nomeLivro like('%?%')";
				PreparedStatement stm = dataSource.getConnection().prepareStatement(SQL);
				stm.setString(1, livroPesquisa.getNome());
				ResultSet rs = stm.executeQuery();
				ArrayList<Object> result = new ArrayList<Object>();

				if(rs.next()) {
					/* 
						Pensar em como implementar aqui... Talvez criar um laço até o fim dos resultados e ir adicionando 
						no arrayList de livros. 
					*/
					
					Livro livro = new Livro();
					livro.setId(rs.getInt("IdLivro"));
					livro.setNome(rs.getString("nomeLivro"));
					livro.setAutor(rs.getString("autor"));
					result.add(livro);
				}

				stm.close();
				rs.close();
				return result;

			} else {
				throw new RuntimeException("Objeto inválido"); // entender como funciona o throw.
			}

		} catch (SQLException ex) {
			System.out.println("Falha ao efetuar consulta!\n" + "Codigo de erro: " + ex.getErrorCode() 
			+ "\n" + "Mensagem de erro: " + ex.getMessage());
		}
		return null;
	}

	@Override
	public void update(Object o) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Object o) {
		// TODO Auto-generated method stub

	}

}
