package br.gov.mpf.prce.issuetracker;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class AtualizacaoDeUsuario {

	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("IssueTracker");
		
		EntityManager entityManager = factory.createEntityManager();
		
		Usuario usuario = entityManager.find(Usuario.class, 3L);
		usuario.setNome("Rafael M C Ponte");
		
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		
		entityManager.merge(usuario);
		
		tx.commit();
		entityManager.close();
		
	}
	
}
