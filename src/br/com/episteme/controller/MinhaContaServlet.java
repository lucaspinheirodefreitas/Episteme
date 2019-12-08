package br.com.episteme.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.episteme.dao.DataSource;
import br.com.episteme.dao.EmprestimoDAO;
import br.com.episteme.model.Usuario;

@WebServlet("/minhaconta")
public class MinhaContaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario usuario;
		String pagina="/erro.jsp";
		DataSource datasource = new DataSource();
		String sair = request.getParameter("tipo");
		usuario = (Usuario) (request.getSession().getAttribute("usuario"));
		
		if(sair.equals("x")) {
			pagina = "/login.jsp";
			request.getSession().setAttribute("usuario", null);
			request.getSession().setAttribute("emprestimo", null);
		}
		else {
			if(!usuario.equals(null)) {
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
		}
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
		dispatcher.forward(request, response);
	}
}
