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
import br.com.episteme.dao.UsuarioDAO;


@WebServlet("/loginservlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pagina;
		DataSource datasource;
		datasource = new DataSource();
		UsuarioDAO userDAO = new UsuarioDAO(datasource);
		List<Object> res = userDAO.read(null);
		request.getSession().setAttribute("Usuario", res.get(0));
		pagina = "/minhaConta.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
		dispatcher.forward(request, response);
		
	}

}
