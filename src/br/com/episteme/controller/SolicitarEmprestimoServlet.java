package br.com.episteme.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.episteme.model.Livro;
import br.com.episteme.model.Usuario;


@WebServlet("/solicitaremprestimo")
public class SolicitarEmprestimoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idLivro = Integer.parseInt(request.getParameter("id"));
		int posicaoLivro = Integer.parseInt(request.getParameter("pos"));
		Usuario usuario = (Usuario)request.getSession().getAttribute("usuario");
		ArrayList<Livro> livros = (ArrayList<Livro>)request.getSession().getAttribute("listaLivros");
		Livro livro = livros.get(posicaoLivro);
	}

}
