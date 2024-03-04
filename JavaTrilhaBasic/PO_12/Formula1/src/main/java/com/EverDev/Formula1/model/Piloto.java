package com.EverDev.Formula1.model;

public class Piloto {

	private String nome;
	private String pais;
	private int vitorias;
	
	public Piloto(String nome, String pais, int vitorias) {
		setNome(nome);
		setPais(pais);
		setVitorias(vitorias);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public int getVitorias() {
		return vitorias;
	}

	public void setVitorias(int vitorias) {
		this.vitorias = vitorias;
	}
	
	@Override
	public String toString() {
		return "Piloto: Nome = " + nome + ", Pais = " + pais + ", Vitorias = " + vitorias;
	}
}
