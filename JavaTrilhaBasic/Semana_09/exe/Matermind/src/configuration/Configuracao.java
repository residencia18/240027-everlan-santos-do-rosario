package configuration;

import utilit.Utilit;

public class Configuracao {
	private String nome;
	private String alfabeto;
	private int tamanhoSenha;
	private int maxTentativas;

	public Configuracao(String nome, String alfabeto, int tamanhoSenha, int maxTentativas) {
		setNome(nome);
		setAlfabeto(alfabeto);
		setTamanhoSenha(tamanhoSenha);
		setMaxTentativas(maxTentativas);
	}

	public Configuracao() {

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if (nome == null || nome.isEmpty()) {
			throw new IllegalArgumentException("Nome não pode ser nulo ou vazio");
		}
		this.nome = nome;
	}

	public String getAlfabeto() {
		return alfabeto;
	}

	public void setAlfabeto(String alfabeto) {
		if (alfabeto == null) {
			throw new IllegalArgumentException("Alfabeto não pode ser nulo");
		}
		if (alfabeto.length() < 4) {
			throw new IllegalArgumentException("Alfabeto deve ter pelo menos 5 caracteres");
		}
		if (Utilit.verificarRepeticaoCaracteres(alfabeto)) {
			throw new IllegalArgumentException("Alfabeto não deve conter caracteres repetidos");
		}
		if (Utilit.verificarTemNumero(alfabeto)) {
			throw new IllegalArgumentException("Alfabeto não deve conter números");
		}
		this.alfabeto = alfabeto;
	}

	public int getTamanhoSenha() {
		return tamanhoSenha;
	}

	public void setTamanhoSenha(int tamanhoSenha) {
		if (tamanhoSenha < 1) {
			throw new IllegalArgumentException("Senha deve ter ao menos 1 caracter");
		}
		if (tamanhoSenha > this.alfabeto.length()) {
			throw new IllegalArgumentException("Senha não pode ser maior que o alfabeto");
		}
		this.tamanhoSenha = tamanhoSenha;
	}

	public int getMaxTentativas() {
		return maxTentativas;
	}

	public void setMaxTentativas(int maxTentativas) {
		if (maxTentativas < 1) {
			throw new IllegalArgumentException("Número máximo de tentativas deve ser maior que 0");
		}
		if (maxTentativas > this.alfabeto.length()) {
			throw new IllegalArgumentException("Número máximo de tentativas deve ser menor que o tamanho do alfabeto");
		}
		this.maxTentativas = maxTentativas;
	}

	@Override
	public String toString() {
		return "Configuracao [nome=" + nome + ", alfabeto=" + alfabeto + ", tamanhoSenha=" + tamanhoSenha
				+ ", maxTentativas=" + maxTentativas + "]";
	}

}
