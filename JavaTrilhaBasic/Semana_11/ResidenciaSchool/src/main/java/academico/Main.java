package academico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import testesDAO.TesteDAO;

public class Main {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit_academico");
		EntityManager em = emf.createEntityManager();
//		try {
//			TesteDAO.populaBD(em);
//		}catch (Exception e) {
//			System.out.println("Erro ao popular o banco:" + e.getMessage());
//		}
		
//		TesteDAO.ListarEstudantes(em);
		
//		TesteDAO.BuscarEstudante(em, 8);
		
//		TesteDAO.ListarNomeEstudantes(em);
		
//		TesteDAO.gerarEstudanteDTO(em);
		
		TesteDAO.estudantePorCurso(em, "Engenharia de Software");
		
		em.close();
		emf.close();
	}
}

