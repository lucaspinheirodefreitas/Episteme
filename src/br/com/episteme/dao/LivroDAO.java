package br.com.episteme.dao;

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
						+ "VALUES ((select nextval('autoIncrementUsuario')), ?, ?, ?, ?, ?, ?, ?, ?);";
				PreparedStatement stm = dataSource.getConnection().prepareStatement(SQL);
				stm.setString(1, cadastrarLivro.getNome());
				stm.setString(2, cadastrarLivro.getAutor());
				stm.setDouble(3, cadastrarLivro.getVersao());
				stm.setString(4, cadastrarLivro.getEditora());
				stm.setString(5, cadastrarLivro.getLinkPDF());
				stm.setTimestamp(6, cadastrarLivro.getDataCadastro());
				stm.setString(7, cadastrarLivro.getSinopse());
				stm.setString(8, cadastrarLivro.getIdioma());
				stm.executeQuery();
				stm.close();
				// questionar por que está entrando no exception e montando codigo de erro = 0.

			} else {
				throw new RuntimeException("Objeto inválido");
			}

		} catch (SQLException ex) {
			System.out.println("Falha ao efetuar inserção!\n" + "Codigo de erro: " + ex.getErrorCode() 
			+ "\n" + "Mensagem de erro: " + ex.getMessage());
		}

	}

	@Override
	public List<Object> read(Object o, String SQL) {
		System.out.println(SQL);
		try {
			if(o instanceof Livro) { 
				Livro livroPesquisa = (Livro) o;
				
				/*
					select * from tblivro where nomelivro like ('%teste%');
				*/
				PreparedStatement stm = dataSource.getConnection().prepareStatement(SQL);
				//stm.setString(1, livroPesquisa.getNome());
				ResultSet rs = stm.executeQuery();
				ArrayList<Object> result = new ArrayList<Object>();

				while(rs.next()) {
					Livro livro = new Livro();
					livro.setId(rs.getInt("IdLivro"));
					livro.setNome(rs.getString("nomeLivro"));
					livro.setAutor(rs.getString("autor"));
					livro.setVersao(rs.getDouble("versao"));
					livro.setEditora(rs.getString("editora"));
					livro.setLinkPDF(rs.getString("linkpdf"));
					livro.setDataCadastro(rs.getTimestamp("datacadastro"));
					livro.setSinopse(rs.getString("sinopse"));
					livro.setIdioma(rs.getString("idioma"));
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
	
	public String pesquisaLivro() {
		/*
		 	Precisa ajustar isso, estava dando erro ao substituir o campo teste por ?
		*/
		String SQL = "SELECT * FROM TBLIVRO WHERE nomeLivro like('%" + "?" + "%');";
		return SQL;
	}
	
	public String buscaUltimaInsercao() {
		String SQL = "SELECT * FROM TBLIVRO WHERE nomeLivro = ? ORDER BY DESC dataCadastro FETCH FIRST 1 ROWS ONLY;";
		return SQL;
	}

}
