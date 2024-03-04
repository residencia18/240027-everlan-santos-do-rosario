package com.EverDev.CompaniaAerea.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Aeroporto {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	private String ICAO;
	private String nome;
	
	public Aeroporto() {}
	

	public Aeroporto(Long id, String ICAO, String nome) {
		setId(id);
		setICAO(ICAO);
		setNome(nome);
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getICAO() {
		return ICAO;
	}


	public void setICAO(String iCAO) {
		ICAO = iCAO;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
}
