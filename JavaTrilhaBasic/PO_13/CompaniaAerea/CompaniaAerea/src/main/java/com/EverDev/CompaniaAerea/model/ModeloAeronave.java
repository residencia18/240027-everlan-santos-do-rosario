package com.EverDev.CompaniaAerea.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ModeloAeronave {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	private String fabricante;
	private String nome;
	
	public ModeloAeronave() {}
	
	
	public ModeloAeronave(Long id, String fabricante, String nome) {
		setId(id);
		setFabricante(fabricante);
		setNome(nome);
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
	
	@Override
	public String toString() {
		return "ModeloAeronave [id=" + id + ", fabricante=" + fabricante + ", nome=" + nome + "]";
	}
}
