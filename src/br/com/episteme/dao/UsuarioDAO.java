package br.com.episteme.dao;

/* Assisti até 1h05 min o video modelando e implementando o banco de dados. */


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.episteme.model.Usuario;

public class UsuarioDAO implements GenericDAO {
	private DataSource dataSource;
	
	public UsuarioDAO (DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public void create(Object o) {
		try {
			if(o instanceof Usuario) { 
				Usuario cadastrarUsuario = (Usuario) o;
				String SQL = "INSERT INTO TBUSUARIO(IdUsuario, NomeUsuario, Email, Senha, IdEndereco) "
						+ "VALUES ((select nextval('autoIncrementUsuario'))," 
						+ cadastrarUsuario.getNome()        + ',' 
						+ cadastrarUsuario.getEmail()   	+ ',' 
						+ cadastrarUsuario.getSenha() 		+ ',' 
						+ "(SELECT MAX(IdEndereco) FROM TBENDERECO))";
				PreparedStatement stm = dataSource.getConnection().prepareStatement(SQL);
				ResultSet rs = stm.executeQuery();
				System.out.println(rs);
				/*
					Pra atualizar o ID vou precisar executar uma operação de select na base eu acho.
				
				if(rs.next()) {
					cadastrarUsuario.setIdUsuario(rs.getInt("IdUsuario"));
				}
				
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
	
	public List<Object> read(Object o) {
		try {
			if(o instanceof Usuario) { // entender como funciona o instanceof.
				Usuario parcial = (Usuario) o;
				String SQL = "SELECT * FROM TBUSUARIO WHERE email = lucas@lucas.com.br";
				PreparedStatement stm = dataSource.getConnection().prepareStatement(SQL);
				stm.setString(1, parcial.getEmail());
				stm.setString(2, parcial.getSenha());
				ResultSet rs = stm.executeQuery();
				ArrayList<Object> result = new ArrayList<Object>();
				
				if(rs.next()) {
					Usuario usuario = new Usuario();
					usuario.setIdUsuario(rs.getInt("IdUsuario"));
					usuario.setNome(rs.getString("nomeUsuario"));
					usuario.setEmail(rs.getString("Email"));
					result.add(usuario);
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
	
	public void update(Object o) {
		
	}
	
	public void delete(Object o) {
		
	}
}

/*
	Exemplo de operações para realizar insert de novo usuário na base.
	
	** Passo 1:
	INSERT INTO TBENDERECO(IdEndereco, CEP, Logradouro, Numero, Bairro, Cidade, Estado)
	VALUES((select nextval('autoIncrementEndereco')), 'XXXXXXXX', 'RUA DOS BOBOS', 0::int, 'KKKKK', 'XXXXX', 'YY');
	
	
	** Passo 2:
	
	INSERT INTO TBUSUARIO(IdUsuario, NomeUsuario, Email, Senha, IdEndereco)
		VALUES ((select nextval('autoIncrementUsuario')), 'LUCAS', 'LUCAS@LUCAS.COM.BR', '12345', (SELECT MAX(IdEndereco) FROM TBENDERECO));
	
		
	DELETE FROM TBENDERECO;
	
	SELECT * FROM TBUSUARIO;
	SELECT * FROM TBENDERECO;
	
	
	-- CRIAR SEQUENCIA:
	CREATE SEQUENCE autoIncrementEndereco 	START 1;
	CREATE SEQUENCE autoIncrementUsuario 	START 1;
	CREATE SEQUENCE autoIncrementLivro 		START 1;
	CREATE SEQUENCE autoIncrementEmprestimo START 1;
	
	-- REINICIAR SEQUENCIA:
	ALTER SEQUENCE autoIncrementUsuario RESTART;
	ALTER SEQUENCE autoIncrementEndereco RESTART;
	
	-- DELETAR SEQUENCIA:
	DROP SEQUENCE IF EXISTS autoincrementEndereco;
	
	-- SEMPRE QUE DÁ ERRO NO TIPO DE DADO A SER INSERIDO (Ex: NULL em campo NOT NULL), A SEQUENCIA INCREMENTA INDEVIDAMENTE POIS A OPERAÇÃO NÃO É COMMITADA.
	-- Pensar em uma forma de sempre que der erro nesse ponto, restartar a sequencia do valor anterior.
	-- Exemplo: pegar o codigo de erro e executar o SQL abaixo.
	ALTER SEQUENCE autoincrementUsuario START WITH (select nextval('autoIncrementUsuario')-1);
	
	-- É necessário manter a integridade:
	-- Obs.: Sempre que deletar um usuário, deletar também os dados do mesmo para as demais tabelas.
*/