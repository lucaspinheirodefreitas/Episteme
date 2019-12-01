package br.com.episteme.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.episteme.model.DadosRelatorio;
import br.com.episteme.model.Relatorio;

public class RelatorioDAO implements GenericDAO {
	private DataSource dataSource;
	
	public RelatorioDAO(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public List<Object> read(Object o, String SQL) {
		try {
			if(o instanceof Relatorio) { 
				ArrayList<Object> result = new ArrayList<Object>();
				
				Relatorio relatorio = (Relatorio) o;
				PreparedStatement stm = dataSource.getConnection().prepareStatement(SQL);
				ResultSet rs = stm.executeQuery();
				ArrayList<DadosRelatorio> auxiliar = new ArrayList<DadosRelatorio>();
				while(rs.next()) {
					DadosRelatorio dadoRelatorio = new DadosRelatorio();
					dadoRelatorio.setDado(rs.getString(relatorio.getColunaDado()));
					dadoRelatorio.setQuantidade(rs.getInt(relatorio.getColunaQuantidade()));
					auxiliar.add(dadoRelatorio);
				}
				relatorio.setDado(auxiliar);
				result.add(relatorio);
				
				stm.close();
				rs.close();
				System.out.println("item 1 do relatório obtido com sucesso.");
				return result;
				
			} else {
				throw new RuntimeException("Objeto inválido");
			}
			
		} catch (SQLException ex) {
			System.out.println("Falha ao efetuar consulta!\n" + "Codigo de erro: " + ex.getErrorCode() 
			+ "\n" + "Mensagem de erro: " + ex.getMessage());
		}
		return null;
	}

	@Override
	public void create(Object o) {
		
	}
	
	@Override
	public void update(Object o) {
		
	}

	@Override
	public void delete(Object o) {
		
	}
	
	public String topLivrosEmprestados() {
		String SQL = "SELECT L.NOMELIVRO, COUNT(E.IDLIVRO) as QTD_EMPRESTIMOS "
				+ "FROM TBEMPRESTIMO E INNER JOIN TBLIVRO L "
				+ "ON E.IDLIVRO = L.IDLIVRO "
				+ "GROUP BY L.NOMELIVRO, E.IDLIVRO "
				+ "ORDER BY QTD_EMPRESTIMOS DESC "
				+ "FETCH FIRST 10 ROWS ONLY;";
		return SQL;
	}
	public String topLeitores() {
		String SQL = "SELECT U.NOMEUSUARIO, COUNT(E.IDLIVRO) as QTD_EMPRESTIMOS "
				+ "FROM TBEMPRESTIMO E INNER JOIN TBUSUARIO U "
				+ "ON E.IDUSUARIO = U.IDUSUARIO "
				+ "GROUP BY U.NOMEUSUARIO, U.IDUSUARIO "
				+ "ORDER BY QTD_EMPRESTIMOS DESC "
				+ "FETCH FIRST 10 ROWS ONLY;";
		return SQL;
	}
	public String topBairros() {
		String SQL = "SELECT ENDER.BAIRRO, COUNT(U.IDUSUARIO) as QTD_USUARIOS "
				+ "FROM TBENDERECO ENDER INNER JOIN TBUSUARIO U "
				+ "ON ENDER.IDENDERECO = U.IDENDERECO "
				+ "GROUP BY ENDER.BAIRRO "
				+ "ORDER BY QTD_USUARIOS DESC "
				+ "FETCH FIRST 10 ROWS ONLY;";
		return SQL;
	}
	public String topCidades() {
		String SQL = "SELECT ENDER.CIDADE, COUNT(U.IDUSUARIO) as QTD_USUARIOS "
				+ "FROM TBENDERECO ENDER INNER JOIN TBUSUARIO U "
				+ "ON ENDER.IDENDERECO = U.IDENDERECO "
				+ "GROUP BY ENDER.CIDADE "
				+ "ORDER BY QTD_USUARIOS DESC "
				+ "FETCH FIRST 10 ROWS ONLY;";
		return SQL;
	}
	public String topEstados() {
		String SQL = "SELECT ENDER.ESTADO, COUNT(U.IDUSUARIO) as QTD_USUARIOS "
				+ "FROM TBENDERECO ENDER INNER JOIN TBUSUARIO U "
				+ "ON ENDER.IDENDERECO = U.IDENDERECO GROUP BY ENDER.ESTADO "
				+ "ORDER BY QTD_USUARIOS DESC "
				+ "FETCH FIRST 10 ROWS ONLY;";
		return SQL;
	}
	public String tempoMedioEmprestimoTopLivros() {
		String SQL = "SELECT L.NOMELIVRO,  AVG(E.DATAFIM - E.DATAINICIO) as TEMPO_MEDIO_EMPRESTIMO "
				+ "FROM TBEMPRESTIMO E INNER JOIN TBLIVRO L "
				+ "ON E.IDLIVRO = L.IDLIVRO GROUP BY L.NOMELIVRO, E.IDLIVRO "
				+ "ORDER BY TEMPO_MEDIO_EMPRESTIMO DESC "
				+ "FETCH FIRST 10 ROWS ONLY";
		return SQL;
	}
}
