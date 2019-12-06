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


@WebServlet("/cadastrarusuario")
public class CadastraUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pagina;
		
		// NÃO TEM MUITO MAIS SOBRE O QUE OBTER REFERENTE A SEÇÃO NESSE PONTO.
		if(!request.getSession().equals(null)) {
			pagina = "/cadastro-usuario.jsp";
		} else {
			pagina = "erro.jsp";
		}
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pagina, confirmaSenha, SQL;
		DataSource datasource;
		datasource 				= new DataSource();
		UsuarioDAO  userDAO     = new UsuarioDAO(datasource);
		EnderecoDAO enderecoDAO = new EnderecoDAO(datasource);
		Endereco    endereco 	= new Endereco();

		endereco.setCep((request.getParameter("txtCep")));
		endereco.setLogradouro((request.getParameter("txtLogradouro")));
		endereco.setNumeroImovel((Integer.parseInt(request.getParameter("txtNumero"))));
		endereco.setBairro((request.getParameter("txtBairro")));
		endereco.setCidade((request.getParameter("txtCidade")));
		endereco.setEstado((request.getParameter("txtEstado")));
		enderecoDAO.create(endereco);
		
		SQL = enderecoDAO.buscaEndereco();
		List <Object> enderecos = enderecoDAO.read(endereco, SQL);
		Endereco ultimoEnderecoCadastrado = (Endereco) enderecos.get(0);
		
		if(enderecos.equals(null) || enderecos.isEmpty()) {
			pagina = "/erro.jsp"; 
		}
		
		Usuario cadastroUsuario = new Usuario(ultimoEnderecoCadastrado);
		cadastroUsuario.setNome(request.getParameter("txtNome"));
		cadastroUsuario.setEmail(request.getParameter("txtEmail"));
		cadastroUsuario.setSenha(request.getParameter("txtSenha"));
		confirmaSenha = (request.getParameter("txtConfirmaSenha"));
		
		if(!cadastroUsuario.equals(null) && confirmaSenha.equals(cadastroUsuario.getSenha())) {
			userDAO.create(cadastroUsuario);
			pagina = "/index.jsp";
			request.getSession().setAttribute("usuario", cadastroUsuario);
		}
		else {
			// enviar a informação mencionando qual foi o erro...
			pagina = "/erro.jsp";
		}	
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
		dispatcher.forward(request, response);
	}
}
