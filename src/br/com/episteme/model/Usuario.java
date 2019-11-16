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
	private int id;
	private String nome;
	private String email;
	private String senha;
	private List<Emprestimo> emprestimos;
	
	public Usuario() {
		// TODO Auto-generated constructor stub
	}
	public String getEmail() {
		return email;
	}
	public int getId() {
		return id;
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
	public void setId(int id) {
		this.id = id;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public List<Emprestimo> getEmprestimos() {
		return emprestimos;
	}
	public void setEmprestimos(List<Emprestimo> emprestimos) {
		this.emprestimos = emprestimos;
	}
}
