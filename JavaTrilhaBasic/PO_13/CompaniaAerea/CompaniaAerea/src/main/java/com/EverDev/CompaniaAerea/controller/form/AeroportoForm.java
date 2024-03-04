package com.EverDev.CompaniaAerea.controller.form;

public class AeroportoForm {

	private String nome;
	private String ICAO;
	
	public AeroportoForm() {
		
	}
	
	public AeroportoForm(String nome, String ICAO) {
		setNome(nome);
		setICAO(ICAO);
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

	public void setICAO(String iCAO) {
		ICAO = iCAO;
	}
	
	
}
