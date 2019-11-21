package br.com.episteme.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/pesquisarservlet")
public class PesquisarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PesquisarServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pagina, itemPesquisa;
		itemPesquisa = request.getParameter("livroPesquisar");
		if(itemPesquisa.isBlank()) {
			// Pensar em enviar algum alerta pra página quando vier vazio e redirecionar novamente pra mesma pagina.
			pagina = "/index.html";
		} else {
			pagina = "/index.jsp";
		}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
		dispatcher.forward(request, response);
	}

}
