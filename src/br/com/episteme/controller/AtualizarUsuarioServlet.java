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
import br.com.episteme.dao.EnderecoDAO;
import br.com.episteme.dao.UsuarioDAO;
import br.com.episteme.model.Endereco;
import br.com.episteme.model.Usuario;

@WebServlet("/atualizarusuario")
public class AtualizarUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pagina=null;
		
		Usuario usuario = (Usuario)request.getSession().getAttribute("usuario");
		int funcionalidade = Integer.parseInt(request.getParameter("tipo"));
		
		DataSource datasource = new DataSource();
		UsuarioDAO usuarioDAO = new UsuarioDAO(datasource);
		
		if(!usuario.equals(null)) {
			if(funcionalidade == 1) {
				usuarioDAO.delete(usuario);
				pagina = "/login.jsp";
				request.getSession().setAttribute("Usuario", null);
			} else if(funcionalidade == 2) { //atualiza nome
				pagina = "/atualizar-campo.jsp";
				request.getSession().setAttribute("campo", "nomeusuario");
				request.getSession().setAttribute("Usuario", usuario);
			} else if(funcionalidade == 3) { //atualiza email
				pagina = "/atualizar-campo.jsp";
				request.getSession().setAttribute("campo", "email");
				request.getSession().setAttribute("Usuario", usuario);
				
			} else if(funcionalidade == 4) { //atualiza endere�o
				pagina = "/atualiza-endereco.jsp";
				request.getSession().setAttribute("campo", "endereco");
				request.getSession().setAttribute("Usuario", usuario);
			}
			
			
			// incluir os if's aqui para tratar os demais tipos de alteração.
		} else {
			pagina = "/erro.jsp";
		}
		
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
        dispatcher.forward(request, response);
		
	}

	

}
