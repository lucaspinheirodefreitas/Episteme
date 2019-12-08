package br.com.episteme.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.episteme.dao.DataSource;
import br.com.episteme.dao.EmprestimoDAO;
import br.com.episteme.model.Emprestimo;
import br.com.episteme.model.Livro;
import br.com.episteme.model.Usuario;


@WebServlet("/solicitaremprestimo")
public class SolicitarEmprestimoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pagina, SQL;
		LocalDate localDate = LocalDate.now();
		DataSource datasource = new DataSource();
		String dataAtual = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(localDate);
		int posicaoLivro = Integer.parseInt(request.getParameter("pos"));
		int tipoSolicitacao = Integer.parseInt(request.getParameter("tipo"));
		Usuario usuario = (Usuario)request.getSession().getAttribute("usuario");
		@SuppressWarnings("unchecked")
		ArrayList<Livro> livros = (ArrayList<Livro>) request.getSession().getAttribute("listaLivros");

		if(!livros.equals(null) && !usuario.equals(null)) {
			Livro livro = livros.get(posicaoLivro);
			Emprestimo emprestimo = new Emprestimo (usuario, livro);

			EmprestimoDAO emprestimoDAO = new EmprestimoDAO(datasource);
			ArrayList<Object> emp = new ArrayList<Object>();

			if(tipoSolicitacao == 1) {
				SQL = "SELECT * FROM TBEMPRESTIMO WHERE idUsuario = "+ emprestimo.getUsuario().getIdUsuario() +
						" AND idLivro = " + emprestimo.getLivro().getId() + " AND DATE(dataFim) >= " + "'" + dataAtual + "'";
				emp = (ArrayList<Object>) emprestimoDAO.read(emprestimo, SQL);
				if(emp.isEmpty()) {
					emprestimoDAO.create(emprestimo);
				}
			}
			else if(tipoSolicitacao == 2) {
				SQL = "SELECT * FROM TBEMPRESTIMO"
						+ " WHERE idUsuario = "+ emprestimo.getUsuario().getIdUsuario()
						+ " AND idLivro = " + emprestimo.getLivro().getId() 
						+ " AND DATE(dataFim) <= " + "'" + dataAtual + "'" 
						+ " AND DATE(dataInicio) = (SELECT MAX(dataInicio) FROM TBEMPRESTIMO"
						+ " WHERE idUsuario = " + emprestimo.getUsuario().getIdUsuario() 
						+ " AND idLivro = " + emprestimo.getLivro().getId() 
						+ " AND DATE(dataFim) <= " + "'" + dataAtual + "');";
				emp = (ArrayList<Object>) emprestimoDAO.read(emprestimo, SQL);
				if(!emp.isEmpty()) {
					emprestimoDAO.update(emprestimo);
				}	
			}
			emp = (ArrayList<Object>) emprestimoDAO.read(usuario, " ");
			pagina = "/minha-conta.jsp";
			request.getSession().setAttribute("usuario", usuario);
			request.getSession().setAttribute("emprestimo", emp);
		} else {
			pagina = "/erro.jsp";
		}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
		dispatcher.forward(request, response);
	}

}