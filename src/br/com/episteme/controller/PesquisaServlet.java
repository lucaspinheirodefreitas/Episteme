package br.com.episteme.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.episteme.dao.DataSource;
import br.com.episteme.dao.LivroDAO;
import br.com.episteme.model.Livro;


@WebServlet("/pesquisar")
public class PesquisaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pagina, itemPesquisa;
		itemPesquisa = request.getParameter("txtPesquisa");
		if(itemPesquisa.isBlank()) {
			pagina = "/index.html";
		} else {
			DataSource datasource = new DataSource();
			Livro livroPesquisa = new Livro();
			LivroDAO livroDAO = new LivroDAO(datasource);
			livroPesquisa.setNome(itemPesquisa);
			List<Object> listaLivros = livroDAO.read(livroPesquisa);
			/*
				A ideia aqui é construir uma página que tenha tabela e enviar pra essa tabela todos os itens da lista de livros
				A tabela deve ter o nome do livro, o link pra sinopse e o link pro PDF.
			 	request.setAttribute(,);
			*/
			pagina = "/listaLivros.jsp";
		}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
		dispatcher.forward(request, response);
		
		
	}

}