package com.EverDev.CompaniaAerea.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Piloto {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String numBreve;
	
	public Piloto() {}
	
	
	public Piloto(Long id, String nome, String numBreve) {
		setId(id);
		setNome(nome);
		setNumBreve(numBreve);
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


	public String getNumBreve() {
		return numBreve;
	}


	public void setNumBreve(String numBreve) {
		this.numBreve = numBreve;
	}
	
	
}
