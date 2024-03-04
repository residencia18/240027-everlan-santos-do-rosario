package com.EverDev.Leilao.controller.form;

import com.EverDev.Leilao.model.Lance;

public class LanceForm {
	
	private Long id_Leilao;
	private Long id_Concorrente;
	private Double valor;
	
	public LanceForm(Long idLeilao, Long idConcorrente, Double valor) {
		setId_Leilao(idLeilao);
		setId_Concorrente(idConcorrente);
		setValor(valor);
	}

	public Long getId_Leilao() {
		return id_Leilao;
	}

	public void setId_Leilao(Long id_Leilao) {
		this.id_Leilao = id_Leilao;
	}

	public Long getId_Concorrente() {
		return id_Concorrente;
	}

	public void setId_Concorrente(Long id_Concorrente) {
		this.id_Concorrente = id_Concorrente;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
}
