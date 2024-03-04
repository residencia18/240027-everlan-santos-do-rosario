package com.EverDev.Leilao.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Lance {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "id_leilao")
	private Leilao id_Leilao;
	@ManyToOne
	@JoinColumn(name = "id_concorrente")
	private Concorrente id_Concorrente;
	private Double valor;
	
	public Lance() {}
	
	public Lance(Leilao id_Leilao, Concorrente id_Concorrente, Double valor) {
		setLeilao(id_Leilao);
		setConcorrente(id_Concorrente);
		setValor(valor);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Leilao getLeilao() {
		return id_Leilao;
	}

	public void setLeilao(Leilao leilao) {
		this.id_Leilao = leilao;
	}

	public Concorrente getConcorrente() {
		return id_Concorrente;
	}

	public void setConcorrente(Concorrente concorrente) {
		this.id_Concorrente = concorrente;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
}
