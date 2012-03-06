package br.gov.mpf.prce.issuetracker;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtils {
	
	private static EntityManagerFactory factory;

	static {
		factory = Persistence.createEntityManagerFactory("IssueTracker");
	}

	public static EntityManager getEntityManager() {
		EntityManager entityManager = factory.createEntityManager();
		return entityManager;
	}
	
}
