package br.unincor.model;

import java.text.DecimalFormat;

public class Midia {
	
	private String nomeArquivo;
	private Double precoBase;
	private Double precoFinal;
	
	public Midia(String nomeArquivo, Double precoBase) {
		super();
		this.nomeArquivo = nomeArquivo;
		if(precoBase>=0){
			this.precoBase = precoBase;
		}else{
			this.precoBase = null;
		}
		this.precoFinal = 0D;
	}

	public String getNomeArquivo() {
		return nomeArquivo;
	}

	public void setNomeArquivo(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}

	public Double getPrecoBase() {
		return precoBase;
	}

	public void setPrecoBase(Double precoBase) {
		if(precoBase>=0){
			this.precoBase = precoBase;
		}else{
			this.precoBase = null;
		}
	}

	public Double getPrecoFinal() {
		return precoFinal;
	}

	public void setPrecoFinal(Double precoFinal) {
		if(precoFinal>=0){
			this.precoFinal = precoFinal;
		}else{
			this.precoFinal = null;
		}
	}
	
	public String verDados(){
		DecimalFormat df = new DecimalFormat("R$#,##0.00");
		return "Nome do arquivo: " + this.nomeArquivo +
				"\nPreço Base: " + df.format(this.precoBase) +
				"\nPreço Final: " + df.format(this.precoFinal);
	}
	
	
	
	
	
	

}
