package br.com.episteme.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.episteme.dao.DataSource;
import br.com.episteme.dao.RelatorioDAO;
import br.com.episteme.model.Relatorio;


@WebServlet("/relatorios")
public class RelatorioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idRelatorio = Integer.parseInt(request.getParameter("tipo"));
		String nomeRelatorio = null;
		DataSource datasource = new DataSource();
		RelatorioDAO relatorioDAO = new RelatorioDAO(datasource);
		Relatorio relatorios = new Relatorio();
		String SQL=null;
		if(idRelatorio == 1) {
			nomeRelatorio = "TOP LIVROS - Mais emprestados!";
			relatorios.setNomeRelatorio(nomeRelatorio);
			relatorios.setColunaDado("nomelivro");
			relatorios.setColunaQuantidade("qtd_emprestimos");
			SQL = relatorioDAO.topLivrosEmprestados(); 
		} else if(idRelatorio == 2) {
			nomeRelatorio = "TOP LEITORES - Mais assíduos!";
			relatorios.setNomeRelatorio(nomeRelatorio);
			relatorios.setColunaDado("nomeusuario");
			relatorios.setColunaQuantidade("qtd_emprestimos");
			SQL = relatorioDAO.topLeitores();
		} else if(idRelatorio == 3) {
			nomeRelatorio = "TEMPO MEDIO EMPRÉSTIMO - Top livros!";
			relatorios.setNomeRelatorio(nomeRelatorio);
			relatorios.setColunaDado("nomelivro");
			relatorios.setColunaQuantidade("tempo_medio_emprestimo");
			SQL = relatorioDAO.tempoMedioEmprestimoTopLivros();
		} else if(idRelatorio == 4) {
			nomeRelatorio = "TOP BAIRROS - Maior número de usuários!";
			relatorios.setNomeRelatorio(nomeRelatorio);
			relatorios.setColunaDado("bairro");
			relatorios.setColunaQuantidade("qtd_usuarios");
			SQL = relatorioDAO.topBairros();
		} else if(idRelatorio == 5) {
			nomeRelatorio = "TOP CIDADES - Maior número de usuários!";
			relatorios.setNomeRelatorio(nomeRelatorio);
			relatorios.setColunaDado("cidade");
			relatorios.setColunaQuantidade("qtd_usuarios");
			SQL = relatorioDAO.topCidades();
		} else if(idRelatorio == 6) {
			nomeRelatorio = "TOP ESTADOS - Maior número de usuários!";
			relatorios.setNomeRelatorio(nomeRelatorio);
			relatorios.setColunaDado("estado");
			relatorios.setColunaQuantidade("qtd_usuarios");
			SQL = relatorioDAO.topEstados();
		}
		ArrayList<Object> relatorio = (ArrayList<Object>) relatorioDAO.read(relatorios, SQL);
		relatorios = (Relatorio) relatorio.get(0);
		request.setAttribute("dados", relatorios);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/relatorio.jsp");
		dispatcher.forward(request, response);
	}

}
