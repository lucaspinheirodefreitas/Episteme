package br.com.episteme.model;

import java.util.ArrayList;

@SuppressWarnings("serial")
public class Livro implements java.io.Serializable {
	private int id;
	private String nome;
	private ArrayList<String> autor = new ArrayList<String>();
	private int versao;
	private String lingua;
	private String ano;
	private String categoria;
	private String editora;
	private String linkPDF;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public ArrayList<String> getAutor() {
		return autor;
	}
	public void setAutor(ArrayList<String> autor) {
		this.autor = autor;
	}
	public int getVersao() {
		return versao;
	}
	public void setVersao(int versao) {
		this.versao = versao;
	}
	public String getLingua() {
		return lingua;
	}
	public void setLingua(String lingua) {
		this.lingua = lingua;
	}
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getEditora() {
		return editora;
	}
	public void setEditora(String editora) {
		this.editora = editora;
	}
	public String getLinkPDF() {
		return linkPDF;
	}
	public void setLinkPDF(String linkPDF) {
		this.linkPDF = linkPDF;
	}
	
}
