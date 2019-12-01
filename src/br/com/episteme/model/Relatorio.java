package br.com.episteme.model;

import java.util.ArrayList;

public class Relatorio {

	private ArrayList<DadosRelatorio> dado; 
	private String nomeRelatorio, colunaDado, colunaQuantidade;
	
	public Relatorio (String nomeRelatorio) {
		this.nomeRelatorio = nomeRelatorio;
	}
	
	public Relatorio() {
		
	}
	
	public String getColunaDado() {
		return colunaDado;
	}

	public void setColunaDado(String colunaDado) {
		this.colunaDado = colunaDado;
	}

	public String getColunaQuantidade() {
		return colunaQuantidade;
	}

	public void setColunaQuantidade(String colunaQuantidade) {
		this.colunaQuantidade = colunaQuantidade;
	}
	
	public String getNomeRelatorio() {
		return nomeRelatorio;
	}

	public void setNomeRelatorio(String nomeRelatorio) {
		this.nomeRelatorio = nomeRelatorio;
	}
	
	public ArrayList<DadosRelatorio> getDado() {
		return dado;
	}

	public void setDado(ArrayList<DadosRelatorio> dado) {
		this.dado = dado;
	}

	
	
}
