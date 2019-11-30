package br.com.episteme.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
				
				String SQL =  "INSERT INTO TBENDERECO(IdEndereco, CEP, Logradouro, Numero, Bairro, Cidade, Estado) "
							+ "VALUES((select nextval('autoIncrementEndereco')), ?, ?, ?, ?, ?, ?)";
				PreparedStatement stm = dataSource.getConnection().prepareStatement(SQL);
				stm.setString(1, cadastrarEndereco.getCep());
				stm.setString(2, cadastrarEndereco.getLogradouro());
				stm.setInt(3, cadastrarEndereco.getNumeroImovel());
				stm.setString(4, cadastrarEndereco.getBairro());
				stm.setString(5, cadastrarEndereco.getCidade());
				stm.setString(6, cadastrarEndereco.getEstado());
				int qtdRegistrosInseridos = stm.executeUpdate();
				if (qtdRegistrosInseridos == 0) {
					System.out.println("Endereço já cadastrado na base.");
				}
				else {
					System.out.println("Endereço cadastrado com sucesso.");
				}
				stm.close();
			} else {
				throw new RuntimeException("Objeto inválido");
			}
		} catch (SQLException ex) {
			if(ex.getErrorCode() == 0) {
				System.out.println("Endereço já cadastrado na base de clientes.");
			}
			else {
				System.out.println("Falha ao efetuar inserção!\n" + "Codigo de erro: " + ex.getErrorCode() 
				+ "\n" + "Mensagem de erro: " + ex.getMessage());
			}
		}
		
	}

	@Override
	public List<Object> read(Object o, String SQL) {
		try {
			if(o instanceof Endereco) { 
				Endereco buscaEndereco = (Endereco) o;
				PreparedStatement stm = dataSource.getConnection().prepareStatement(SQL);
				stm.setString(1, buscaEndereco.getCep());
				stm.setInt(2, buscaEndereco.getNumeroImovel());
				ResultSet rs = stm.executeQuery();
				ArrayList<Object> result = new ArrayList<Object>();

				while(rs.next()) {
					Endereco endereco = new Endereco();
					endereco.setIdEndereco(rs.getInt("IdEndereco"));
					endereco.setCep(rs.getString("cep"));
					endereco.setLogradouro(rs.getString("logradouro"));
					endereco.setNumeroImovel(rs.getInt("numero"));
					endereco.setBairro(rs.getString("bairro"));
					endereco.setCidade(rs.getString("cidade"));
					endereco.setEstado(rs.getString("estado"));
					result.add(endereco);
				}
				stm.close();
				rs.close();
				return result;
			} else {
				throw new RuntimeException("Objeto inválido");
			}
		} catch (SQLException ex) {
			System.out.println("Falha ao efetuar inserção!\n" + "Codigo de erro: " + ex.getErrorCode() 
			+ "\n" + "Mensagem de erro: " + ex.getMessage());
		}
		return null;
	}

	@Override
	public void update(Object o) {
		
		
	}

	@Override
	public void delete(Object o) {
		
		
	}
	
	public String buscaUltimaInsercao() {
		// ajustar essa query para considerar timestamt e pegar a ultima inclusão
		String SQL = "SELECT * FROM TBENDERECO WHERE  CEP = ? AND NUMERO = ? FETCH FIRST 1 ROWS ONLY;";
		return SQL;
	}
	
	public String buscaEndereco() {
		// ajustar essa query
		String SQL = "SELECT * FROM TBENDERECO WHERE  CEP = ? AND NUMERO = ? FETCH FIRST 1 ROWS ONLY;";
		return SQL;
	}

}
