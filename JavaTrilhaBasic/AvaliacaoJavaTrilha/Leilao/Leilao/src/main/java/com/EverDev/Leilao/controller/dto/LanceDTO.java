package com.EverDev.Leilao.controller.dto;

import com.EverDev.Leilao.model.Lance;

public class LanceDTO {

	private Long id;
	private Long id_Leilao;
	private Long id_Concorrente;
	private Double valor;
	
	public LanceDTO(Lance lance) {
		this.id = lance.getId();
		this.id_Leilao = lance.getLeilao().getId();
		this.id_Concorrente = lance.getConcorrente().getId();
		this.setValor(lance.getValor());
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdLeilao() {
		return id_Leilao;
	}

	public void setIdLeilao(Long idLeilao) {
		this.id_Leilao = idLeilao;
	}

	public Long getIdConcorrente() {
		return id_Concorrente;
	}

	public void setIdConcorrente(Long idConcorrente) {
		this.id_Concorrente = idConcorrente;
	}
	
	private void setValor(Double valorMinimo) {
		this.valor = valorMinimo;
	}
	
	public Double getValor() {
		return valor;
	}
}
