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

@WebServlet("/atualizarcampo")

public class AtualizarCampoServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario atualizaUsuario;
		String pagina="/erro.jsp", campo, valor;
		DataSource datasource;
		datasource 				= new DataSource();
		UsuarioDAO  userDAO     = new UsuarioDAO(datasource);

		System.out.println("CAMPO PARA SER ATUALIZADO ATUALIZARCAMPOSERVLET " + request.getSession().getAttribute("campo"));
		campo = (String) request.getSession().getAttribute("campo");
		valor = request.getParameter("campoatt");		
		atualizaUsuario = (Usuario) (request.getSession().getAttribute("usuario"));
		System.out.println("UsuarioSessao: " + atualizaUsuario.getNome() );
		System.out.println("IDSessao: " + atualizaUsuario.getIdUsuario() );
		
		if(!atualizaUsuario.equals(null)) {
			userDAO.update(atualizaUsuario, campo, valor);
			pagina = "/login.jsp";
		}
		else {
			pagina = "/erro.jsp";
		}	
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
		dispatcher.forward(request, response);
	}

}
