package br.gov.mpf.prce.issuetracker;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GeraBanco {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("IssueTracker");
		factory.close();
	}
	
}
