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
				Livro cadastrarLivro = (Livro) o;
				String SQL = "INSERT INTO TBLIVRO(IdUsuario, NomeUsuario, Email, Senha, IdEndereco) "
						+ "VALUES ((select nextval('autoIncrementUsuario')), ?, ?, ?, (SELECT MAX(IdEndereco) FROM TBENDERECO));";
				// o select MAX é meio que um gato >>> precisa ser ajustado ainda.
				PreparedStatement stm = dataSource.getConnection().prepareStatement(SQL);
				stm.setString(1, cadastrarLivro.getNome());
				stm.setString(2, cadastrarLivro.getAno());
				stm.setString(3, cadastrarLivro.getEditora());
				stm.setString(4, cadastrarLivro.getLingua());
				stm.setString(5, cadastrarLivro.getAutor());
				stm.setDouble(6, cadastrarLivro.getVersao());
				stm.setString(7, cadastrarLivro.getLinkPDF());
				stm.setString(8, cadastrarLivro.getSinopse());
				/*
					executar ALTER TABLE e modificar o tipo da colune sinopse
				*/
				ResultSet rs = stm.executeQuery();

				/*
				 	função MD5 inclui a senha já criptografada no banco, precisamos criar um metodo pra criptografar a senha de entrada e mandar pro
				 	select a senha que foi digitada também criptografada.
				 	Criar uma consistencia para verificar a quantidade de tuplas inseridas
					Pra atualizar o ID vou precisar executar uma operação de select na base eu acho.
				 */

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
			if(o instanceof Livro) { // entender como funciona o instanceof.
				Livro parcial = (Livro) o;
				String SQL = "SELECT * FROM TBUSUARIO WHERE email = ? AND senha = ?";
				PreparedStatement stm = dataSource.getConnection().prepareStatement(SQL);
				//stm.setString(1, parcial.getEmail());
				//stm.setString(2, parcial.getSenha());

				ResultSet rs = stm.executeQuery();
				ArrayList<Object> result = new ArrayList<Object>();

				if(rs.next()) {
					//Usuario usuario = new Usuario();
					//usuario.setIdUsuario(rs.getInt("IdUsuario"));
					//usuario.setNome(rs.getString("nomeUsuario"));
					//usuario.setEmail(rs.getString("Email"));
					//result.add(usuario);
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
