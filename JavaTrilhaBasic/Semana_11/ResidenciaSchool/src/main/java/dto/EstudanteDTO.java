package dto;

public class EstudanteDTO {
	private String nome;
	private String matricula;
	private String email;
	private String curso;
	
	
	public EstudanteDTO(String nome, String email, String matricula, String curso) {
		setNome(nome);
		setMatricula(matricula);
		setEmail(email);
		setCurso(curso);
	}
	
	public EstudanteDTO() {
		
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCurso() {
		return curso;
	}
	
	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMatricula() {
		return matricula;
	}


	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}


	@Override
	public String toString() {
		return "EstudanteDTO [nome=" + nome + ", matricula=" + matricula + "]";
	}
	
	
}
