package academico;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(uniqueConstraints = {
	@UniqueConstraint(columnNames = "email"),
	@UniqueConstraint(columnNames = "matricula")
})
public class Estudante {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@ManyToOne
	@JoinColumn(name="id_curso")
	private Curso curso;
	private String nome;
	private String email;
	private String matricula;
	
	public Estudante() {
		
	}
	
	public Estudante(String nome, String email, String matricula, Curso curso) {
		this.id = null;
		setNome(nome);
		setEmail(email);
		setMatricula(matricula);
		setCurso(curso);
	}
	
	private void setCurso(Curso curso2) {
		this.curso = curso2;
	}
	
	public Curso getCurso() {
		return curso;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
		return "Estudante [id=" + id + ", nome=" + nome + ", email=" + email + ", matricula=" + matricula + "]";
	}
	
	public static void main(String[] args) {
//		Estudante estudante;
//
//		Estudante estudante1 = new Estudante("João", "joao@joao", "123");
//		Estudante estudante2 = new Estudante("Maria", "maria@maria", "456");
//		Estudante estudante3 = new Estudante("José", "jose@jose", "789");

//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit_academico");
//		EntityManager em = emf.createEntityManager();
//		ADD ESTUDANTE
//		em.getTransaction().begin();
//		em.persist(estudante1);
//		em.persist(estudante2);
//		em.persist(estudante3);
//		em.getTransaction().commit();
//		em.close();
//		emf.close();

//		BUSCAR ESTUDANTE
//		try {
//			estudante = em.find(Estudante.class, 3);
//			System.out.println(estudante);
//		}catch (Exception e) {
//			System.out.println("Erro:" + e.getMessage());
//		}
		
//		DELETAR ESTUDANTE
//		try {
//			estudante = em.find(Estudante.class, 3);
//			em.getTransaction().begin();
//			em.remove(estudante);
//			em.getTransaction().commit();
//			em.close();
//			emf.close();
//		}catch (Exception e) {
//			System.out.println("Erro:" + e.getMessage());
//		}
		
//		ATUALIZAR ESTUDANTE
//		try {
//			estudante = em.find(Estudante.class, 1);
//			em.getTransaction().begin();
//			estudante.setNome("João");
//			estudante.setEmail("joao@joao.com");
//			em.getTransaction().commit();
//			em.close();
//			emf.close();
//			
//		}catch (Exception e) {
//			System.out.println("Erro:" + e.getMessage());
//		}
		
//		Curso curso = new Curso("Engenharia de Software", 4);
//		Curso curso2 = new Curso("Linguagem de Programação 1", 4);
//		Curso curso3 = new Curso("Linguagem de Programação 2", 4);
	}
	
}
