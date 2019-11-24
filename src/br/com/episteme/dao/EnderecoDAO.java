package br.com.episteme.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import br.com.episteme.model.Endereco;

public class EnderecoDAO implements GenericDAO{
	private DataSource dataSource;
		
	public EnderecoDAO(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public void create(Object o) {
		try {
			if(o instanceof Endereco) { 
				Endereco cadastrarEndereco = (Endereco) o;
				
				String SQL = "INSERT INTO TBENDERECO(IdEndereco, CEP, Logradouro, Numero, Bairro, Cidade, Estado) "
						+ "VALUES((select nextval('autoIncrementEndereco'))," 
						+ cadastrarEndereco.getCep()          		+ ',' 
						+ cadastrarEndereco.getLogradouro()   		+ ',' 
						+ cadastrarEndereco.getNumeroImovel() 		+ ',' 
						+ cadastrarEndereco.getBairro()       		+ ',' 
						+ cadastrarEndereco.getCidade()       		+ ',' 
						+ cadastrarEndereco.getEstado()       		+ ')';
				PreparedStatement stm = dataSource.getConnection().prepareStatement(SQL);
				ResultSet rs = stm.executeQuery();
				System.out.println(rs);
				if(rs.next()) {
					cadastrarEndereco.setIdEndereco(rs.getInt("IdEndereco"));
				}
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
		// TODO Auto-generated method stub
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
