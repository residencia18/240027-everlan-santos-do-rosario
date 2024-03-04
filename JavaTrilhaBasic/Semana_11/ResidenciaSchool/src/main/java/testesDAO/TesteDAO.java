package testesDAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;

import academico.Curso;
import academico.Estudante;
import dto.EstudanteDTO;

public class TesteDAO {
	
	public static void estudantePorCurso(EntityManager em, String nomecurso) {
		String sql = "SELECT c FROM Curso c WHERE c.nome = :nome";
		TypedQuery<Curso> query = em.createQuery(sql, Curso.class);
		query.setParameter("nome", nomecurso);
		Curso c = query.getSingleResult();
		String sql2 = "SELECT e FROM Estudante e WHERE e.curso = :curso";
		TypedQuery<Estudante> query2 = em.createQuery(sql2, Estudante.class);
		query2.setParameter("curso", c);
		List<Estudante> estudantes = query2.getResultList();
		
		JOptionPane.showMessageDialog(null, estudantes);
		
	}
	
	public static void gerarEstudanteDTO(EntityManager em) {
		String sql = "SELECT new dto.EstudanteDTO(e.nome, e.email, e.matricula, e.curso.nome) FROM Estudante e";
		TypedQuery<EstudanteDTO> query = em.createQuery(sql, EstudanteDTO.class);
		List<EstudanteDTO> estudantes = query.getResultList();
		
		JOptionPane.showMessageDialog(null, estudantes);
		
	}
	
	public static void ListarEstudantes(EntityManager em) {
		String sql = "SELECT e FROM Estudante e";
		TypedQuery<Estudante> query = em.createQuery(sql, Estudante.class);
		List<Estudante> estudantes = query.getResultList();
		
		
		JOptionPane.showMessageDialog(null, estudantes);
		
	}
	
	public static void ListarNomeEstudantes(EntityManager em) {
		String sql = "SELECT e.nome FROM Estudante e";
		TypedQuery<String> query = em.createQuery(sql, String.class);
		List<String> nomes = query.getResultList();
		
		JOptionPane.showMessageDialog(null, nomes);
		
	}
	
	public static void BuscarEstudante(EntityManager em, int id) {
		String sql = "SELECT e FROM Estudante e WHERE e.id = :id";
		TypedQuery<Estudante> query = em.createQuery(sql, Estudante.class);
		Estudante estudante = query.setParameter("id", id).getSingleResult();
		
		JOptionPane.showMessageDialog(null, estudante);
		
	}
	
	public static void populaBD(EntityManager em) {

		Curso curso = new Curso("Engenharia de Software", 3);
		Curso curso2 = new Curso("Linguagem de Programação 1", 1);
		Curso curso3 = new Curso("Linguagem de Programação 2", 2);
		Curso curso4 = new Curso("Analise e Desenvolvimento de Sistemas", 2);
		Curso curso5 = new Curso("Introdução à Ciência da Computação", 3);
		Curso curso6 = new Curso("Introdução à Bancos de Dados", 2);
		Curso curso7 = new Curso("Introdução à Programação Orientada a Objetos", 2);

		Estudante estudante1 = new Estudante("João", "joao@joao", "123", curso);
		Estudante estudante2 = new Estudante("Maria", "maria@maria", "456", curso2);
		Estudante estudante3 = new Estudante("José", "jose@jose", "789", curso3);
		Estudante estudante4 = new Estudante("Pedro", "pedro@pedro", "321", curso4);
		Estudante estudante5 = new Estudante("Ana", "ana@ana", "654", curso);
		Estudante estudante6 = new Estudante("Carlos", "carlos@carlos", "987", curso2);
		Estudante estudante7 = new Estudante("Mariana", "mariana@mariana", "741", curso3);
		Estudante estudante8 = new Estudante("Lucas", "lucas@lucas", "854", curso4);
		Estudante estudante9 = new Estudante("Julia", "julia@julia", "963", curso6);
		Estudante estudante10 = new Estudante("Rafael", "rafael@rafael", "747", curso2);
		Estudante estudante11 = new Estudante("Gabriela", "gabriela@gabriela", "859", curso3);
		Estudante estudante12 = new Estudante("Gustavo", "gustavo@gustavo", "966", curso4);
		Estudante estudante13 = new Estudante("Juliana", "juliana@juliana", "744", curso5);
		Estudante estudante14 = new Estudante("Vinicius", "vinicius@vinicius", "852", curso6);
		Estudante estudante15 = new Estudante("Gabriel", "gabriel@gabriel", "979", curso7);

		em.getTransaction().begin();
		em.persist(curso);
		em.persist(curso2);
		em.persist(curso3);
		em.persist(curso4);
		em.persist(curso5);
		em.persist(curso6);
		em.persist(curso7);
		em.persist(estudante1);
		em.persist(estudante2);
		em.persist(estudante3);
		em.persist(estudante4);
		em.persist(estudante5);
		em.persist(estudante6);
		em.persist(estudante7);
		em.persist(estudante8);
		em.persist(estudante9);
		em.persist(estudante10);
		em.persist(estudante11);
		em.persist(estudante12);
		em.persist(estudante13);
		em.persist(estudante14);
		em.persist(estudante15);
		em.getTransaction().commit();

	}
}
