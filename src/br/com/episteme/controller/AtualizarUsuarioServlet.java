package br.com.episteme.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.episteme.dao.DataSource;
import br.com.episteme.dao.UsuarioDAO;
import br.com.episteme.model.Usuario;

@WebServlet("/atualizarusuario")
public class AtualizarUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pagina="/erro.jsp";
		
		Usuario usuario = (Usuario)request.getSession().getAttribute("usuario");
		int funcionalidade = Integer.parseInt(request.getParameter("tipo"));
		
		DataSource datasource = new DataSource();
		UsuarioDAO usuarioDAO = new UsuarioDAO(datasource);
		
		if(!usuario.equals(null)) {
			if(funcionalidade == 1) {
				usuarioDAO.delete(usuario);
				pagina = "/login.jsp";
				request.getSession().setAttribute("usuario", null);
			} else if(funcionalidade == 2) { 
				pagina = "/atualizar-campo.jsp";
				request.getSession().setAttribute("campo", "nomeusuario");
				request.getSession().setAttribute("usuario", usuario);
			} else if(funcionalidade == 3) { 
				pagina = "/atualizar-campo.jsp";
				request.getSession().setAttribute("campo", "email");
				request.getSession().setAttribute("usuario", usuario);
				
			} else if(funcionalidade == 4) { 
				pagina = "/atualizar-endereco.jsp";
				request.getSession().setAttribute("usuario", usuario);
			}
		} else {
			pagina = "/erro.jsp";
		}
		
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
        dispatcher.forward(request, response);
		
	}

	

}
