package br.com.episteme.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.episteme.dao.DataSource;
import br.com.episteme.dao.LivroDAO;
import br.com.episteme.model.Livro;

@WebServlet("/cadastralivro")
public class CadastraLivroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pagina, SQL;
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
		
		// validando inserção e atualizando id do objeto livro.
		SQL = livroDAO.pesquisaLivro();
		List <Object> livros = livroDAO.read(livro, SQL);
		Livro ultimoLivroCadastrado = (Livro) livros.get(0);
		if(livros.isEmpty() || ultimoLivroCadastrado.getDataCadastro() != dataDeHoje) {
			// significa que o registro não foi inserido na base.
			pagina = "Erro.jsp"; 
		}
		else {
			livro.setId(ultimoLivroCadastrado.getId());
			pagina = "/minha-conta.html";
		}
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
		dispatcher.forward(request, response);
	}

}
