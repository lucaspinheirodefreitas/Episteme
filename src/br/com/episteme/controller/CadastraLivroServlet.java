package br.com.episteme.controller;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.episteme.dao.DataSource;
import br.com.episteme.dao.LivroDAO;
import br.com.episteme.model.Livro;
import br.com.episteme.model.Usuario;

@WebServlet("/cadastrarlivro")
public class CadastraLivroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario usuario = new Usuario();
		String pagina="/erro.jsp";
		usuario = (Usuario) (request.getSession().getAttribute("usuario"));
		if(!usuario.equals(null)) {
			pagina = "/cadastro-livro.jsp";
			request.getSession().setAttribute("usuario", usuario);
		}
		else {
			pagina = "/erro.jsp";
		}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pagina;
		DataSource datasource = new DataSource();
		LivroDAO livroDAO = new LivroDAO(datasource);
		Livro livro = new Livro();
		livro.setNome(request.getParameter("txtNomeLivro"));
		livro.setAutor(request.getParameter("txtAutor"));
		livro.setEditora(request.getParameter("txtEditora"));
		livro.setLinkPDF(request.getParameter("txtUrl"));
		livro.setSinopse(request.getParameter("txtSinopse"));
		livro.setIdioma(request.getParameter("txtIdioma"));
		livro.setVersao(Double.parseDouble(request.getParameter("txtVersao")));
		Timestamp dataDeHoje = new Timestamp(System.currentTimeMillis()); 
		livro.setDataCadastro(dataDeHoje);
		livroDAO.create(livro);
		pagina="/index.jsp";
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
		dispatcher.forward(request, response);
	}

}
