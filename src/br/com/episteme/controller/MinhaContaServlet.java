package br.com.episteme.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.episteme.dao.DataSource;
import br.com.episteme.dao.EmprestimoDAO;
import br.com.episteme.dao.UsuarioDAO;
import br.com.episteme.model.Emprestimo;
import br.com.episteme.model.Livro;
import br.com.episteme.model.Usuario;

@WebServlet("/minhaconta")
public class MinhaContaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario usuario = new Usuario();
		String pagina;
		
		DataSource datasource;
		datasource = new DataSource();
		
		usuario = (Usuario) (request.getSession().getAttribute("usuario"));
		if(!usuario.equals(null)) {
			// consulta os emprestimos no banco e boa!
			EmprestimoDAO emprestimoDAO = new EmprestimoDAO(datasource);
			ArrayList<Object> emp = new ArrayList<Object>();
			emp =  (ArrayList<Object>) emprestimoDAO.read(usuario, "");
			
			pagina = "/minha-conta.jsp";
			request.getSession().setAttribute("usuario", usuario);
			request.getSession().setAttribute("emprestimo", emp);
		}
		else {
			pagina = "/erro.jsp";
		}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
		dispatcher.forward(request, response);
	}
}
