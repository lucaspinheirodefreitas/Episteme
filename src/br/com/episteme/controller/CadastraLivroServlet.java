package br.com.episteme.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.episteme.model.Livro;

@WebServlet("/cadastralivro")
public class CadastraLivroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pagina;
		Livro livro = new Livro();
		livro.setNome(request.getParameter("txtlivro"));
		livro.setAno(request.getParameter("txtAno"));
		livro.setAutor(request.getParameter("txtAutor"));
		livro.setEditora(request.getParameter("txtEditora"));
		livro.setLingua(request.getParameter("txtLingua"));
		livro.setLinkPDF(request.getParameter("txtLinkPDF"));
		livro.setSinopse(request.getParameter("txtSinopse"));
		livro.setVersao(Double.parseDouble((request.getParameter("txtVersao"))));
		
		
		pagina = "/index.html";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
		dispatcher.forward(request, response);
	}

}
