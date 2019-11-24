package br.com.episteme.controller;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cadastralivro")
public class CadastraLivroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pagina, nomeLivro, autor, editora, linkPDF, sinopse;
		int ano;
		Double versao;
		Calendar publicacao = Calendar.getInstance();
		nomeLivro = request.getParameter("livro"); //criar o name do input no jsp como livro
		
		if(nomeLivro.isBlank()) {
			// Pensar em enviar algum alerta pra página quando vier vazio e redirecionar novamente pra mesma pagina.
			pagina = "/index.html";
		} else {
			request.setAttribute("teste", "você está pesquisando o livro: " + nomeLivro);
			pagina = "/minhaConta.jsp";
		}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
		dispatcher.forward(request, response);
	}

}
