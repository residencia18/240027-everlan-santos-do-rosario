package com.EverDev.CompaniaAerea.controller.form;

public class ModeloAeronaveForm {

	private String fabricante;
	private String nome;
	
	public ModeloAeronaveForm() {
		
	}
	
	public ModeloAeronaveForm(String fabricante, String nome) {
		setFabricante(fabricante);
		setNome(nome);
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
