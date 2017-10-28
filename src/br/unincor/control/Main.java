package br.unincor.control;

import java.util.ArrayList;
import java.util.List;

import br.unincor.exception.PrecoZeradoException;
import br.unincor.model.Midia;
import br.unincor.model.Musica;
import br.unincor.model.Video;
import br.unincor.view.Usuario;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Boolean flagPedido = false;
		//Boolean flagPagamento = false;
		
		Usuario gui = new Usuario();
		
		List<Midia> listaMidia = new ArrayList<Midia>();
		CalculaPrecos calc = new CalculaPrecos();
		
		while(flagPedido==false){
			
			switch (gui.menuMain()) {
			case 0:
				gui.exibeMsg("Musica");
				Musica mu = new Musica(gui.recebeString("Nome do Arquivo:"), 
									gui.recebeDouble("Preco Base:"), 
									gui.recebeString("Nome do artista:"), 
									gui.recebeBoolean("Dominio Publico:"));
				try {
					calc.calculaPrecoFinal(mu);					
				} catch (PrecoZeradoException e) {
					// TODO: handle exception
					e.getMessage();
				}
				listaMidia.add(mu);
				break;
			case 1:
				gui.exibeMsg("Video");
				Video vi = new Video(gui.recebeString("Nome do Arquivo:"),
							gui.recebeDouble("Preco Base:"), 
							gui.recebeString("nome do autor:"), 
							gui.recebeBoolean("Midia Digital"));
				try {
					calc.calculaPrecoFinal(vi);
				} catch (PrecoZeradoException e) {
					// TODO: handle exception
					e.getMessage();
				}
				break;
			case 2:
				gui.exibeMsg("Finalizar pedido");
				flagPedido=true;
				switch (gui.menuPagamento()) {
				case 0:
					gui.exibeMsg("Boleto");
					for (int i = 0; i < listaMidia.size(); i++) {
						try {
							calc.calculaPrecoFinal(listaMidia.get(i));							
						} catch (PrecoZeradoException e) {
							// TODO: handle exception
							e.getMessage();
						}						
					}					
					break;
					
				case 1:
					gui.exibeMsg("Cartão");
					for (int i = 0; i < listaMidia.size(); i++) {
						try {
							calc.calculaPrecoFinal(listaMidia.get(i));							
						} catch (PrecoZeradoException e) {
							// TODO: handle exception
							e.getMessage();
						}
						
					}
					break;
					
				case -1:
					gui.exibeMsg("Boleto");
					for (int i = 0; i < listaMidia.size(); i++) {
						try {
							calc.calculaPrecoFinal(listaMidia.get(i));							
						} catch (PrecoZeradoException e) {
							// TODO: handle exception
							e.getMessage();
						}						
					}
					break;

				default:
					break;
				}
				break;
			case -1:
				gui.exibeMsg("Finalizar pedido");
				flagPedido=true;
				switch (gui.menuPagamento()) {
				case 0:
					gui.exibeMsg("Boleto");
					for (int i = 0; i < listaMidia.size(); i++) {
						try {
							calc.calculaPrecoFinal(listaMidia.get(i));							
						} catch (PrecoZeradoException e) {
							// TODO: handle exception
							e.getMessage();
						}						
					}					
					break;
					
				case 1:
					gui.exibeMsg("Cartão");
					for (int i = 0; i < listaMidia.size(); i++) {
						try {
							calc.calculaPrecoFinal(listaMidia.get(i));							
						} catch (PrecoZeradoException e) {
							// TODO: handle exception
							e.getMessage();
						}
						
					}
					break;
					
				case -1:
					gui.exibeMsg("Boleto");
					for (int i = 0; i < listaMidia.size(); i++) {
						try {
							calc.calculaPrecoFinal(listaMidia.get(i));							
						} catch (PrecoZeradoException e) {
							// TODO: handle exception
							e.getMessage();
						}						
					}
					break;

				default:
					break;
				}
				break;

			default:
				break;
			}
			
			
			
		}
		Double total=0D;
		
		for (int i = 0; i < listaMidia.size(); i++) {
			total+=listaMidia.get(i).getPrecoFinal();
			
		}
		
		gui.exibeMsg("Total do pedido: R$:" + total);	
		
	}

}
