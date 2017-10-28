package br.unincor.exception;

import br.unincor.model.Midia;

public class PrecoZeradoException extends Exception{

	private static final long serialVersionUID = 1L;
	
	private Midia m;

	public PrecoZeradoException(Midia m) {
		super();
		this.m = m;
	}
	
	public String getMessage(){
		return "A midia " + m.getNomeArquivo() + "não tem valor valido!!";
	}

}
