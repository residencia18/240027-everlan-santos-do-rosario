package academico;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Curso {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String nome;
	private int numSemestres;
	@OneToMany(mappedBy="curso")
	private List<Estudante> estudantes;
	
	public Curso() {
		
	}
	
	public Curso(String nome, int numSemestres) {
		this.id = null;
		setNome(nome);
		setNumSemestres(numSemestres);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNumSemestres() {
		return numSemestres;
	}

	public void setNumSemestres(int numSemestres) {
		this.numSemestres = numSemestres;
	}

	@Override
	public String toString() {
		return "Curso [id=" + id + ", nome=" + nome + ", numSemestres=" + numSemestres + "]";
	}
	
	
	

}
