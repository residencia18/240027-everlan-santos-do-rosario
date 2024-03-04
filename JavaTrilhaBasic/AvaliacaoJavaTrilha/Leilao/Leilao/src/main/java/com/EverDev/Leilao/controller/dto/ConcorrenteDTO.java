package com.EverDev.Leilao.controller.dto;

import com.EverDev.Leilao.model.Concorrente;

public class ConcorrenteDTO {

	private Long id;
	private String nome;
	private String cpf;
			
	public ConcorrenteDTO(Concorrente concorrente) {
		this.id = concorrente.getId();
		this.nome = concorrente.getNome();
		this.cpf = concorrente.getCpf();
	}
	
	public Long getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getCpf() {
		return cpf;
	}
}
