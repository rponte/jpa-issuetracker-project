package br.gov.mpf.prce.issuetracker.dao;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.gov.mpf.prce.issuetracker.JpaUtils;
import br.gov.mpf.prce.issuetracker.model.Comentario;
import br.gov.mpf.prce.issuetracker.model.Issue;
import br.gov.mpf.prce.issuetracker.model.Status;

public class IssueDao {
	
	private EntityManager entityManager;

	public IssueDao() {
		entityManager = JpaUtils.getEntityManager();
	}

	public void salva(Issue issue) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(issue);
		tx.commit();
	}

	public void atualiza(Issue issue) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.merge(issue);
		tx.commit();
	}

	public Issue carrega(Long id) {
		Issue issue = entityManager.find(Issue.class, id);
		return issue;
	}

	public void remove(Issue issue) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.remove(issue);
		tx.commit();
	}

	public void comenta(Long idDaIssue, Comentario comentario) {
		
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		
		Issue issue = carrega(idDaIssue);
		issue.adicionaComentario(comentario);
		
		tx.commit();
//		atualiza(issue);
	}
	
	public void fecha(Long idDaIssue, Comentario comentario) {
		
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		
		Issue issue = carrega(idDaIssue);
		issue.fecha(comentario);
		
		tx.commit();
	}

}







