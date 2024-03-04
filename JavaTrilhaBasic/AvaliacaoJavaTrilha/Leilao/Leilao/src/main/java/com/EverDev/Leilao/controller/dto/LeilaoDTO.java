package com.EverDev.Leilao.controller.dto;

import com.EverDev.Leilao.model.Leilao;

public class LeilaoDTO {

	private Long id;
	private String descricao;
	private Double valorMinimo;
	private boolean status;
	
	
	public LeilaoDTO(Leilao leilao) {
		this.id = leilao.getId();
		this.descricao = leilao.getDescricao();
		this.valorMinimo = leilao.getValorMinimo();
		this.status = leilao.isStatus();
	}

	public Long getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	public Double getValorMinimo() {
		return valorMinimo;
	}

	public boolean isStatus() {
		return status;
	}
}
