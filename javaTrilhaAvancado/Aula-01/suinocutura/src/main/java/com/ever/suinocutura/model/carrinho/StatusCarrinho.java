package com.ever.suinocutura.model.carrinho;

public enum StatusCarrinho {
	EM_ANDAMENTO("Em andamento"),
	FINALIZADO("Finalizado"),
	CANCELADO("Cancelado");
	
	private String status;
	
	StatusCarrinho(String status){
		this.status = status;
	}
	
	public String getStatus() {
		return status;
	}
}
