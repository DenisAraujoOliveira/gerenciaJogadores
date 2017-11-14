package br.com.gerenciaJogadores.model;

public enum Mercado {
	disponivel("disponivel"),escalado("escalado");
	
	private String status;
	private Mercado(String status){
		this.status = status;
	}
	
	public String getItem(){
		return this.status;
	}
}
