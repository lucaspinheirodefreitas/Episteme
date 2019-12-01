package br.com.episteme.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.episteme.model.Emprestimo;
import br.com.episteme.model.Livro;
import br.com.episteme.model.Relatorio;
import br.com.episteme.model.Usuario;

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
				ArrayList<String> topLivros = new ArrayList<String>();
				ArrayList<Integer> quantidade = new ArrayList<Integer>();
				while(rs.next()) {
					topLivros.add(rs.getString("nomeLivro"));
					quantidade.add(rs.getInt("qtd_emprestimos"));
				}
				relatorio.setQtdLivrosEmp(quantidade);
				relatorio.setTopLivros(topLivros);
				/*
				SQL = "chamaParte2";
				stm = dataSource.getConnection().prepareStatement(SQL);
				rs = stm.executeQuery();
				ArrayList<String> topLeitores = new ArrayList<String>();
				ArrayList<Integer> quantidade = new ArrayList<Integer>();
				if(rs.next()) {
					topLeitores.add(rs.getString("nomeLivro"));
					quantidade.add(rs.getInt("qtd_emprestimos"));
				}
				
				SQL = "chamaParte2";
				stm = dataSource.getConnection().prepareStatement(SQL);
				rs = stm.executeQuery();
				ArrayList<String> topLeitores = new ArrayList<String>();
				ArrayList<Integer> quantidade = new ArrayList<Integer>();
				if(rs.next()) {
					topLeitores.add(rs.getString("nomeLivro"));
					quantidade.add(rs.getInt("qtd_emprestimos"));
				}
				
				SQL = "chamaParte2";
				stm = dataSource.getConnection().prepareStatement(SQL);
				rs = stm.executeQuery();
				ArrayList<String> topLeitores = new ArrayList<String>();
				ArrayList<Integer> quantidade = new ArrayList<Integer>();
				if(rs.next()) {
					topLeitores.add(rs.getString("nomeLivro"));
					quantidade.add(rs.getInt("qtd_emprestimos"));
				}
				
				SQL = "chamaParte2";
				stm = dataSource.getConnection().prepareStatement(SQL);
				rs = stm.executeQuery();
				ArrayList<String> topLeitores = new ArrayList<String>();
				ArrayList<Integer> quantidade = new ArrayList<Integer>();
				if(rs.next()) {
					topLeitores.add(rs.getString("nomeLivro"));
					quantidade.add(rs.getInt("qtd_emprestimos"));
				}
				
				SQL = "chamaParte2";
				stm = dataSource.getConnection().prepareStatement(SQL);
				rs = stm.executeQuery();
				ArrayList<String> topLeitores = new ArrayList<String>();
				ArrayList<Integer> quantidade = new ArrayList<Integer>();
				if(rs.next()) {
					topLeitores.add(rs.getString("nomeLivro"));
					quantidade.add(rs.getInt("qtd_emprestimos"));
				}
				*/
				result.add(relatorio);
				stm.close();
				rs.close();
				System.out.println("item 1 do relatório obtido com sucesso.");
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
	public void create(Object o) {
		
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
