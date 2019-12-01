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
		DataSource datasource = new DataSource();
		String SQL;
		if(idRelatorio == 1) {
			Relatorio relatorios = new Relatorio();
        	RelatorioDAO relatorioDAO = new RelatorioDAO(datasource);
        	SQL = relatorioDAO.topLivrosEmprestados();
        	ArrayList<Object> relatorio = (ArrayList<Object>) relatorioDAO.read(relatorios, SQL); 
        	Relatorio rel = (Relatorio) relatorio.get(0);
        	request.setAttribute("dados", rel);
		} else if(idRelatorio == 2) {
        	
        } else if(idRelatorio == 3) {
        	
        } else if(idRelatorio == 4) {
        	
        } else if(idRelatorio == 5) {
        	
        } else if(idRelatorio == 6) {
        	
        }
		
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/relatorio.jsp");
        dispatcher.forward(request, response);
	}

}
