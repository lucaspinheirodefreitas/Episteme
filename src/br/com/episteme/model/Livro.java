package br.com.episteme.model;

import java.util.Calendar;
import java.util.Date;

@SuppressWarnings("serial")
public class Livro implements java.io.Serializable {
	private int id;
	private String nome;
	private String autor;
	private Double versao;
	private String idioma;
	private Date dataPublicacao;
	private String editora;
	private String linkPDF;
	private String Sinopse;
	private Calendar dataCadastro = Calendar.getInstance();
	
	public String getIdioma() {
		return idioma;
	}
	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}
	
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

	public Date getDataPublicacao() {
		return dataPublicacao;
	}
	public void setDataPublicacao(Date ano) {
		this.dataPublicacao = ano;
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
