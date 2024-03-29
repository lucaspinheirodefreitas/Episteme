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
import br.com.episteme.dao.LivroDAO;
import br.com.episteme.model.Livro;
import br.com.episteme.model.Usuario;


@WebServlet("/pesquisar")
public class PesquisaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pagina="/erro.jsp";
		Usuario usuario;
		usuario = (Usuario) request.getSession().getAttribute("usuario");

		if(!usuario.equals(null)) {
			request.getSession().setAttribute("usuario", usuario);
			pagina = "/index.jsp";
		}
		else {
			pagina = "/erro.jsp";
		}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pagina="/index.jsp", itemPesquisa, SQL;
		Usuario usuario = new Usuario();
		usuario = (Usuario) request.getSession().getAttribute("usuario");
		itemPesquisa = request.getParameter("txtPesquisa");

		if(!itemPesquisa.isEmpty()) {
			if(!usuario.equals(null)) {
				DataSource datasource       = new DataSource();
				Livro      livroPesquisa 	= new Livro();
				LivroDAO   livroPesquisaDAO = new LivroDAO(datasource);
				livroPesquisa.setNome(itemPesquisa);
				SQL = livroPesquisaDAO.pesquisaLivro();
				ArrayList<Object> listaLivros    = (ArrayList<Object>) livroPesquisaDAO.read(livroPesquisa, SQL);
				request.getSession().setAttribute("usuario", usuario);
				request.getSession().setAttribute("listaLivros", listaLivros);
				pagina = "/pesquisa.jsp";
			}
			else {
				pagina = "/erro.jsp";
			}
		}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
		dispatcher.forward(request, response);
	}
}