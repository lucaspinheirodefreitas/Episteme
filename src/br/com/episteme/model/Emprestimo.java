package br.com.episteme.model;

import java.util.Date;

@SuppressWarnings("serial")
public class Emprestimo implements java.io.Serializable {


	private int id;
	private Usuario usuario;
	private Livro livro;
	private Date retirada = new Date();
	private Date devolucao = new Date();
	private String nomeLivro;
	
	
	public Emprestimo(Usuario usuario, Livro livro) {
		this.usuario = usuario;
		this.livro = livro;
	}
	
	public Emprestimo(Usuario usuario, String nomeLivro) {
		this.usuario = usuario;
		this.nomeLivro = nomeLivro;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Livro getLivro() {
		return livro;
	}
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Date getRetirada() {
		return retirada;
	}
	public void setRetirada(Date retirada) {
		this.retirada = retirada;
	}
	public Date getDevolucao() {
		return devolucao;
	}
	public void setDevolucao(Date devolucao) {
		this.devolucao = devolucao;
	}
	
	public String getNomeLivro() {
		return this.nomeLivro;		
	}

}
