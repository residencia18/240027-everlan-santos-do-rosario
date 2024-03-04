package com.EverDev.CompaniaAerea.controller.dto;

import com.EverDev.CompaniaAerea.model.ModeloAeronave;

public class ModeloAeronaveDTO {

	private Long id;
	private String fabricante;
	private String nome;
	
	public ModeloAeronaveDTO() {}
	
	public ModeloAeronaveDTO(ModeloAeronave modeloAeronave) {
		setId(modeloAeronave.getId());
		setFabricante(modeloAeronave.getFabricante());
		setNome(modeloAeronave.getNome());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
		
	
}
