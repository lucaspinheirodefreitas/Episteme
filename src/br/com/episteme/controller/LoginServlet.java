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
import br.com.episteme.model.Usuario;


@WebServlet("/home")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pagina;
		DataSource datasource;
		datasource = new DataSource();
		UsuarioDAO userDAO = new UsuarioDAO(datasource);
		Usuario usuario = new Usuario();
		
		usuario.setEmail((request.getParameter("txtEmail")));
		usuario.setSenha((request.getParameter("txtSenha")));
		
		List<Object> usuarios = userDAO.read(usuario, ""); // ajustar isso.
		
		if(!request.getSession().equals(null) && !usuarios.equals(null) && !usuarios.isEmpty()) {
			pagina = "/index.jsp";
			usuario = (Usuario) usuarios.get(0);
			request.getSession().setAttribute("usuario", usuario);
			pagina = "/index.jsp";
		}
		else {
			pagina = "/erro.jsp";
		}
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
		dispatcher.forward(request, response);
		
	}
}