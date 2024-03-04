package com.EverDev.Leilao.controller.form;

import com.EverDev.Leilao.model.Concorrente;

public class ConcorrenteForm {

	private String nome;
	private String cpf;
	
	public ConcorrenteForm() {
		
	}
	
	public ConcorrenteForm(String nome, String cpf) {
		setNome(nome);
		setCpf(cpf);
	}
	
	public Concorrente toConcorrente() {
		Concorrente concorrente = new Concorrente(getNome(), getCpf());
		concorrente.setId(null);
		return concorrente;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
}
