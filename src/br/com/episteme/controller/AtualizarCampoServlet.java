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

@WebServlet("/atualizarcampo")

public class AtualizarCampoServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario atualizaUsuario;
		String pagina, campo, valor;
		DataSource datasource;
		datasource 				= new DataSource();
		UsuarioDAO  userDAO     = new UsuarioDAO(datasource);
		//EnderecoDAO enderecoDAO = new EnderecoDAO(datasource);
		//Endereco    endereco 	= new Endereco();
		System.out.println("CAMPO PARA SER ATUALIZADO ATUALIZARCAMPOSERVLET " + request.getSession().getAttribute("campo"));
		campo = (String) request.getSession().getAttribute("campo");
		valor = request.getParameter("campoatt");		
		atualizaUsuario = (Usuario) (request.getSession().getAttribute("usuario"));
		
		
		
		/*endereco.setCep((request.getParameter("txtCep")));
		endereco.setLogradouro((request.getParameter("txtLogradouro")));
		endereco.setNumeroImovel((Integer.parseInt(request.getParameter("txtNumero"))));
		endereco.setBairro((request.getParameter("txtBairro")));
		endereco.setCidade((request.getParameter("txtCidade")));
		endereco.setEstado((request.getParameter("txtEstado")));
		enderecoDAO.create(endereco);
		
		//SQL = enderecoDAO.buscaEndereco();
		//List <Object> enderecos = enderecoDAO.read(endereco, SQL);
		//Endereco ultimoEnderecoCadastrado = (Endereco) enderecos.get(0);
		
		//if(enderecos.equals(null) || enderecos.isEmpty()) {
			//pagina = "erro.jsp"; 
		}*/
		
		
		//cadastroUsuario.setNome(request.getParameter("txtNome"));
		//cadastroUsuario.setEmail(request.getParameter("txtEmail"));
		//cadastroUsuario.setSenha(request.getParameter("txtSenha"));
		//confirmaSenha = (request.getParameter("txtConfirmaSenha"));
		System.out.println("UsuarioSessao: " + atualizaUsuario.getNome() );
		System.out.println("IDSessao: " + atualizaUsuario.getIdUsuario() );
		
		if(!atualizaUsuario.equals(null)) {
			userDAO.update(atualizaUsuario, campo, valor);
			pagina = "/login.jsp";
		}
		else {
			// enviar a informação mencionando qual foi o erro...
			pagina = "/erro.jsp";
		}	
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
		dispatcher.forward(request, response);
	}

}
