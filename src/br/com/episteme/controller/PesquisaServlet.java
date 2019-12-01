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


@WebServlet("/pesquisar")
public class PesquisaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<String> nomeLivros = new ArrayList<String>();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pagina, itemPesquisa, SQL;

		itemPesquisa = request.getParameter("txtPesquisa");
		if(!itemPesquisa.isBlank()) {
			DataSource datasource       = new DataSource();
			Livro      livroPesquisa 	= new Livro();
			LivroDAO   livroPesquisaDAO = new LivroDAO(datasource);
			livroPesquisa.setNome(itemPesquisa);
			SQL = livroPesquisaDAO.pesquisaLivro();
			ArrayList<Object> listaLivros    = (ArrayList<Object>) livroPesquisaDAO.read(livroPesquisa, SQL);

			for(Object livros : listaLivros) {
				Livro livro = (Livro) livros;
				nomeLivros.add(livro.getNome());
			}

			request.setAttribute("listaLivros", nomeLivros);
			pagina = "/pesquisa.jsp";
		}
		else {
			pagina = "/index.html";
		}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
		dispatcher.forward(request, response);
	}
	
	public int tamanho(ArrayList<String> lista) {
		return lista.size();
	}
}