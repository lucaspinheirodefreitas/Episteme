package br.com.episteme.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.episteme.dao.DataSource;
import br.com.episteme.dao.EmprestimoDAO;
import br.com.episteme.model.Emprestimo;
import br.com.episteme.model.Livro;
import br.com.episteme.model.Usuario;


@WebServlet("/solicitaremprestimo")
public class SolicitarEmprestimoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//passar o tipo de solicitação, emprestimo=1, renovação=2
		int posicaoLivro = Integer.parseInt(request.getParameter("pos"));
		Usuario usuario = (Usuario)request.getSession().getAttribute("usuario");
		ArrayList<Livro> livros = (ArrayList<Livro>) request.getSession().getAttribute("listaLivros");
		Livro livro = livros.get(posicaoLivro);
		Emprestimo emprestimo = new Emprestimo(usuario, livro);
		DataSource datasource = new DataSource();
		EmprestimoDAO emprestimoDAO = new EmprestimoDAO(datasource);
		emprestimoDAO.create(emprestimo);
	}

}
