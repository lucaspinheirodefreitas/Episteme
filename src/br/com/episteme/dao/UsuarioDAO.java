package br.com.episteme.dao;


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
							+ "VALUES ((select nextval('autoIncrementUsuario')), ?, ?, ?, ?);";
				PreparedStatement stm = dataSource.getConnection().prepareStatement(SQL);
				stm.setString(1, cadastrarUsuario.getNome());
				stm.setString(2, cadastrarUsuario.getEmail());
				stm.setString(3, cadastrarUsuario.getSenha());
				int idEndereco = cadastrarUsuario.getEndereco().getIdEndereco();
				stm.setInt(4, idEndereco);
				stm.executeUpdate();
				
				/*
				 	funÃ§Ã£o MD5 inclui a senha jÃ¡ criptografada no banco, precisamos criar um metodo pra criptografar a senha de entrada e mandar pro
				 	select a senha que foi digitada tambÃ©m criptografada.
				 	Criar uma consistencia para verificar a quantidade de tuplas inseridas
					Pra atualizar o ID vou precisar executar uma operaÃ§Ã£o de select na base eu acho.
				*/
				
				stm.close();
			} else {
				throw new RuntimeException("Objeto invÃ¡lido");
			}
		} catch (SQLException ex) {
			if(ex.getErrorCode() == 0) {
				System.out.println("E-mail jÃ¡ cadastrado.");
				
			} else {
				System.out.println("Falha ao efetuar inserÃ§Ã£o!\n" + "Codigo de erro: " + ex.getErrorCode() 
				+ "\n" + "Mensagem de erro: " + ex.getMessage());
			}
			// pensar melhor em como garantir que deu certo a inserÃ§Ã£o.
		}
	}
	
	public List<Object> read(Object o, String SQ) {
		try {
			if(o instanceof Usuario) { 
				Usuario parcial = (Usuario) o;
				String SQL = "SELECT * FROM TBUSUARIO WHERE email = ? AND senha = ?";
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
				throw new RuntimeException("Objeto invÃ¡lido");
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
	Exemplo de operaÃ§Ãµes para realizar insert de novo usuÃ¡rio na base.
	
	//md5(senha) -- criptografar no insert do banco
	
	** Passo 1:
	INSERT INTO TBENDERECO(IdEndereco, CEP, Logradouro, Numero, Bairro, Cidade, Estado)
	VALUES((select nextval('autoIncrementEndereco')), 'XXXXXXXX', 'RUA DOS BOBOS', 0::int, 'KKKKK', 'XXXXX', 'YY');
	
	
	** Passo 2:
	
	INSERT INTO TBUSUARIO(IdUsuario, NomeUsuario, Email, Senha, IdEndereco)
		VALUES ((select nextval('autoIncrementUsuario')), 'LUCAS', 'LUCAS@LUCAS.COM.BR', MD5('12345'), (SELECT MAX(IdEndereco) FROM TBENDERECO));
	
		
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
	
	-- SEMPRE QUE DÃ� ERRO NO TIPO DE DADO A SER INSERIDO (Ex: NULL em campo NOT NULL), A SEQUENCIA INCREMENTA INDEVIDAMENTE POIS A OPERAÃ‡ÃƒO NÃƒO Ã‰ COMMITADA.
	-- Pensar em uma forma de sempre que der erro nesse ponto, restartar a sequencia do valor anterior.
	-- Exemplo: pegar o codigo de erro e executar o SQL abaixo.
	ALTER SEQUENCE autoincrementUsuario START WITH (select nextval('autoIncrementUsuario')-1);
	
	-- Ã‰ necessÃ¡rio manter a integridade:
	-- Obs.: Sempre que deletar um usuÃ¡rio, deletar tambÃ©m os dados do mesmo para as demais tabelas.
*/