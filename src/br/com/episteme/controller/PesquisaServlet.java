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
import br.com.episteme.dao.LivroDAO;
import br.com.episteme.model.Livro;


@WebServlet("/pesquisar")
public class PesquisaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pagina, itemPesquisa, SQL;
		itemPesquisa = request.getParameter("txtPesquisa");
		if(itemPesquisa.isBlank()) {
			pagina = "/index.html";
		} else {
			DataSource datasource       = new DataSource();
			Livro      livroPesquisa 	= new Livro();
			LivroDAO   livroPesquisaDAO = new LivroDAO(datasource);
			livroPesquisa.setNome(itemPesquisa);
			SQL = livroPesquisaDAO.pesquisaLivro();
			ArrayList<Object> listaLivros    = (ArrayList<Object>) livroPesquisaDAO.read(livroPesquisa, SQL);
			request.setAttribute("listaLivros", listaLivros);
			pagina = "/PesquisaLivros.jsp"; // precisa ajustar essa pagina está dando erro.
		}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
		dispatcher.forward(request, response);
	}
	
	/*
	A ideia aqui é construir uma página que tenha tabela e enviar pra essa tabela todos os itens da lista de livros
	A tabela deve ter o nome do livro, o link pra sinopse e o link pro PDF.
 	request.setAttribute(,);
 	
 	while(rs.next())
    {
        PostData postdata = new PostData();

        postdata.setId(rs.getInt("id"));
        postdata.setOtkogo(rs.getString("otkogo"));
        postdata.setKomy(rs.getString("komy"));
        postdata.setText(rs.getString("text"));
        postdata.setDate(rs.getString("'date'"));
        posts.add(postdata);

    }
 					
	request.setAttribute("posts", posts);
	
	<table>
	  <c:forEach items="${posts}" var="post">
	   <tr>
	     <td>${post.id}</td>
	     ....
	   </tr>
	  </c:forEach>
	</table>
*/

}