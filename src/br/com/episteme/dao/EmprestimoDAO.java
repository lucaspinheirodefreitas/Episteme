package br.com.episteme.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.episteme.model.Emprestimo;
import br.com.episteme.model.Endereco;
import br.com.episteme.model.Livro;
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
							+ "VALUES((select nextval('autoIncrementEndereco')), ?, ?, ?, ?, ?, ?);";
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
	public List<Object> read(Object o, String SQL) {
		try {
			if(o instanceof Emprestimo) { 
				Emprestimo emprestimo = (Emprestimo) o;
				PreparedStatement stm = dataSource.getConnection().prepareStatement(SQL);
				ResultSet rs = stm.executeQuery();
				ArrayList<Object> result = new ArrayList<Object>();
				
				if(rs.next()) {
					// ainda não pensei em como implementar isso, só estou pensando no relatório por enquanto.
					Usuario usuario = new Usuario();
					Livro livro = new Livro();
					livro.setNome(rs.getString("nomeLivro"));
					Emprestimo emp = new Emprestimo(usuario, livro);
					result.add(emp);
				}
				stm.close();
				rs.close();
				System.out.println("item 1 do relatório obtido com sucesso.");
				return result;
				
			} else if (o instanceof Usuario){
				Usuario usuario = (Usuario) o;
				SQL = "select * from tbemprestimo emp inner join tblivro liv on (liv.idlivro = emp.idlivro and idusuario = ?)";
				
				PreparedStatement stm = dataSource.getConnection().prepareStatement(SQL);
				stm.setInt(1, usuario.getIdUsuario());
				ResultSet rs = stm.executeQuery();
				ArrayList<Object> result = new ArrayList<Object>();
								
				while(rs.next()) {
					Date devolucao = rs.getDate("datafim");
					Date retirada = rs.getDate("datainicio");
					
					Livro livro = new Livro();
					
					livro.setNome(rs.getString("nomeLivro"));
					Emprestimo emp = new Emprestimo(usuario, livro.getNome());
					emp.setDevolucao(devolucao);
					emp.setRetirada(retirada);
					result.add(emp);

				}
				
				stm.close();
				rs.close();
				return result;
			}	
			else {
				
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
		
	}

	@Override
	public void delete(Object o) {
		
	}
	
	public String topLivrosEmprestados() {
		String SQL = "SELECT L.NOMELIVRO, COUNT(E.IDLIVRO) as QTD_EMPRESTIMOS FROM TBEMPRESTIMO E INNER JOIN TBLIVRO L ON E.IDLIVRO = L.IDLIVRO GROUP BY L.NOMELIVRO, E.IDLIVRO;";
		return SQL;
	}
}
