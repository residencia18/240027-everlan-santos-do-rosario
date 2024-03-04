package com.EverDev.CompaniaAerea.controller.dto;

import com.EverDev.CompaniaAerea.model.Aeroporto;

public class AeroportoDTO {

	private Long id;
	private String nome;
	private String ICAO;
	
	public AeroportoDTO() {}
	
	public AeroportoDTO(Aeroporto aeroporto) {
		setId(aeroporto.getId());
		setNome(aeroporto.getNome());
		setSigla(aeroporto.getICAO());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getICAO() {
		return ICAO;
	}

	public void setSigla(String ICAO) {
		this.ICAO = ICAO;
	}
	
	
}
