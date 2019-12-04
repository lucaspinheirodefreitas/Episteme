package br.com.episteme.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.episteme.model.Usuario;

@WebServlet("/minhaconta")
public class MinhaContaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario usuario;
		String pagina;
		usuario = (Usuario) (request.getSession().getAttribute("usuario"));
		
		if(usuario != null) {
			pagina = "/minha-conta.jsp";
			request.getSession().setAttribute("usuario", usuario);
		}
		else {
			pagina = "/erro.jsp";
		}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
		dispatcher.forward(request, response);
	}
}
