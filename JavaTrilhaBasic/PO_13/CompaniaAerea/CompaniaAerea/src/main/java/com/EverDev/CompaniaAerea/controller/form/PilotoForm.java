package com.EverDev.CompaniaAerea.controller.form;

public class PilotoForm {

	private String nome;
	private String numBreve;
	
	public PilotoForm() {
		
	}
	
	public PilotoForm(String nome, String numBreve) {
		setNome(nome);
		setNumBreve(numBreve);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNumBreve() {
		return numBreve;
	}

	public void setNumBreve(String numBreve) {
		this.numBreve = numBreve;
	}
	
	
}
