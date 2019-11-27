package br.com.episteme.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.episteme.model.Endereco;
import br.com.episteme.model.Usuario;

public class EmprestimoDAO implements GenericDAO {
	private DataSource dataSource;
	
	public EmprestimoDAO(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void create(Object o) {
		try {
			if(o instanceof Endereco) { 
				Endereco cadastrarEndereco = (Endereco) o;
				
				String SQL =  "INSERT INTO TBENDERECO(IdEndereco, CEP, Logradouro, Numero, Bairro, Cidade, Estado) "
							+ "VALUES((select nextval('autoIncrementEndereco')), ?, ?, ?, ?, ?, ?)";
				
				PreparedStatement stm = dataSource.getConnection().prepareStatement(SQL);
				stm.setString(1, cadastrarEndereco.getCep());
				stm.setString(2, cadastrarEndereco.getLogradouro());
				stm.setInt(3, cadastrarEndereco.getNumeroImovel());
				stm.setString(4, cadastrarEndereco.getBairro());
				stm.setString(5, cadastrarEndereco.getCidade());
				stm.setString(6, cadastrarEndereco.getEstado());
				ResultSet rs = stm.executeQuery();
				stm.close();
				rs.close();
				System.out.println("Endereço cadastradao com sucesso.");
			} else {
				throw new RuntimeException("Objeto inválido");
			}
		} catch (SQLException ex) {
			System.out.println("Falha ao efetuar inserção!\n" + "Codigo de erro: " + ex.getErrorCode() 
			+ "\n" + "Mensagem de erro: " + ex.getMessage());
		}
		
	}

	@Override
	public List<Object> read(Object o, String SQ) {
		try {
			if(o instanceof Usuario) { // entender como funciona o instanceof.
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
