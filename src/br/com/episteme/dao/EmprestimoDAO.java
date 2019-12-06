package br.com.episteme.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.episteme.model.Emprestimo;
import br.com.episteme.model.Livro;
import br.com.episteme.model.Usuario;

public class EmprestimoDAO implements GenericDAO {
	private DataSource dataSource;
	LocalDate localDate = LocalDate.now();
    String dataAtual = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(localDate);
	public EmprestimoDAO(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void create(Object o) {
		try {
			if(o instanceof Emprestimo) { 
				Emprestimo emprestimo = (Emprestimo) o;
				System.out.println("aqui");
				String SQL =  "INSERT INTO TBEMPRESTIMO(dataInicio, dataFim, IdUsuario, IdLivro) "
							+ "VALUES(current_date, (current_date+10), ?, ?);";
				PreparedStatement stm = dataSource.getConnection().prepareStatement(SQL);
				System.out.println("aqui1");
				stm.setInt(1, emprestimo.getUsuario().getIdUsuario());
				System.out.println();
				stm.setInt(2, emprestimo.getLivro().getId());
				stm.executeUpdate();
				stm.close();
				System.out.println("Emprestimo realizado com sucesso.");
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
				while(rs.next()) {
					Usuario usuario = new Usuario();
					Livro livro = new Livro();
					livro.setId(rs.getInt("idLivro"));
					usuario.setIdUsuario(rs.getInt("idUsuario"));
					emprestimo.setDevolucao(rs.getDate("dataFim"));
					emprestimo.setRetirada(rs.getDate("dataInicio"));
					emprestimo.setId(rs.getInt("idEmprestimo"));
					result.add(emprestimo);
				}
				stm.close();
				rs.close();
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
					livro.setId(rs.getInt("idLivro"));
					Emprestimo emp = new Emprestimo(usuario, livro);
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
		try {
			if(o instanceof Emprestimo) {
				Emprestimo emprestimo = (Emprestimo) o;
				String SQL = renovaLivro(emprestimo);
				System.out.println(SQL);
				PreparedStatement stm = dataSource.getConnection().prepareStatement(SQL);
				stm.executeUpdate();
				stm.close();
			}
		} catch(SQLException ex) {
			System.out.println("Falha ao efetuar consulta!\n" + "Codigo de erro: " + ex.getErrorCode() 
			+ "\n" + "Mensagem de erro: " + ex.getMessage());
		}
	}

	@Override
	public void delete(Object o) {
		
	}
	
	public String topLivrosEmprestados() {
		String SQL = "SELECT L.*, COUNT(E.IDLIVRO) as QTD_EMPRESTIMOS FROM TBEMPRESTIMO E INNER JOIN TBLIVRO L ON E.IDLIVRO = L.IDLIVRO GROUP BY L.NOMELIVRO, E.IDLIVRO;";
		return SQL;
	}
	
	public String renovaLivro(Emprestimo emprestimo) {
		String SQL = "UPDATE TBEMPRESTIMO SET dataFim = CURRENT_DATE + INTERVAL '10 day'" 
				+ " WHERE idUsuario = " + emprestimo.getUsuario().getIdUsuario() 
				+ " AND idLivro = " + emprestimo.getLivro().getId() 
				+ " AND DATE(dataFim) <= " + "'" + dataAtual + "'";
		return SQL;
	}
}
