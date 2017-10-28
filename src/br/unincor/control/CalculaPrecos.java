package br.unincor.control;

import br.unincor.exception.PrecoZeradoException;
import br.unincor.model.Midia;
import br.unincor.model.Musica;
import br.unincor.model.Video;

public class CalculaPrecos {
	
	public void calculaPrecoFinal(Midia m) throws PrecoZeradoException{
		if(m.getPrecoBase()!=null){
			if(m instanceof Musica){
				if(((Musica) m).getDominioPublico()){
					m.setPrecoFinal(m.getPrecoBase()-(m.getPrecoBase()*0.3));
				}else if(!((Musica) m).getDominioPublico()){
					m.setPrecoFinal(m.getPrecoBase()+(m.getPrecoBase()*0.1));	
				}
				
			}else if(m instanceof Video){
				if(((Video) m).getMidiaDigital()){
					m.setPrecoFinal(m.getPrecoBase()-(m.getPrecoBase()*0.1));
				}else if(!((Video) m).getMidiaDigital()){
					m.setPrecoFinal(m.getPrecoBase()+(m.getPrecoBase()*0.2));
				}
				
			}	
		}else{
			throw new PrecoZeradoException(m);
		}	
	}
	
	public Double pagtoBoleto(Midia m){
		return (m.getPrecoFinal()-(m.getPrecoFinal()*0.1));
	}
	
	public Double pagtoCartao(Midia m){
		return(m.getPrecoFinal()+(m.getPrecoFinal()*0.15));
	}

}
