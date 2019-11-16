package br.com.episteme.model;

import java.util.Date;
import java.util.List;

@SuppressWarnings("serial")
public class Emprestimo implements java.io.Serializable {
	private int id;
	private boolean atraso;
	private List<Livro> livros;
	private Date retirada = new Date();
	private Date devolucao = new Date();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isAtraso() {
		return atraso;
	}
	public void setAtraso(boolean atraso) {
		this.atraso = atraso;
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
	public List<Livro> getLivros() {
		return livros;
	}
	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

}
