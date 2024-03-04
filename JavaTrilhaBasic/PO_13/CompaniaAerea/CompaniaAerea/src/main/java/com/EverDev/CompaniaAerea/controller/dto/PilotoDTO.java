package com.EverDev.CompaniaAerea.controller.dto;

import com.EverDev.CompaniaAerea.model.Piloto;

public class PilotoDTO {
	private Long id;
	private String nome;
	private String numBreve;
	
	public PilotoDTO() {
		
	}
	
	public PilotoDTO(Piloto piloto) {
		this.id = piloto.getId();
		this.nome = piloto.getNome();
		this.numBreve = piloto.getNumBreve();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getNumBreve() {
		return numBreve;
	}

	@Override
	public String toString() {
		return "PilotoDTO [id=" + id + ", nome=" + nome + ", numBreve=" + numBreve + "]";
	}
	
	
}
