package br.com.episteme.model;

import java.util.Calendar;

@SuppressWarnings("serial")
public class Livro implements java.io.Serializable {
	public Calendar getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public String getSinopse() {
		return Sinopse;
	}
	public void setSinopse(String sinopse) {
		Sinopse = sinopse;
	}
	private int id;
	private String nome;
	private String autor;
	private Double versao;
	private String lingua;
	private String ano;
	private String editora;
	private String linkPDF;
	private String Sinopse;
	private Calendar dataCadastro = Calendar.getInstance();;
	
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
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public Double getVersao() {
		return versao;
	}
	public void setVersao(Double versao) {
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
