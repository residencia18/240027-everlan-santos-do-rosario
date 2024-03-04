package com.EverDev.Leilao.controller.form;

public class LeilaoForm {

	private String descricao;
	private Double valorMinimo;
	private boolean status;
	
	public LeilaoForm() {}
	
	public LeilaoForm(String descricao, Double valorMinimo, boolean status) {
		setDescricao(descricao);
		setValorMinimo(valorMinimo);
		setStatus(status);
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getValorMinimo() {
		return valorMinimo;
	}

	public void setValorMinimo(Double valorMinimo) {
		this.valorMinimo = valorMinimo;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
}
