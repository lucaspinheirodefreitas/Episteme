package br.com.episteme.model;

import java.util.List;

/*
	Em programação web é uma boa pratica que as classes dentro do 
	controller implementem java.io.Serializable por que quando essas
	classes forem enviadas da seção para o Servlet ou para o jsp's 
	as mesmas são enviadas de forma serializada.
*/
@SuppressWarnings("serial")
public class Usuario implements java.io.Serializable {
	public List<Emprestimo> getEmprestimos() {
		return emprestimos;
	}

	private int idUsuario;
	private String nome;
	private String email;
	private String senha;
	private List<Emprestimo> emprestimos;
	private Endereco endereco;
	
	/* 
		Pensar melhor em como relacionar a lista de emprestimos e endereço ao usuário 
	*/
	public Usuario(Endereco endereco) {
		this.endereco = endereco;
	}
	public Usuario() {
		this.endereco = new Endereco();
	}
	
	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	public String getEmail() {
		return email;
	}
	public String getNome() {
		return nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void setEmprestimos(List<Emprestimo> emprestimos) {
		this.emprestimos = emprestimos;
	}
	
}
