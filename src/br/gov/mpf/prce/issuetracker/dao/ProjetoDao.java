package br.gov.mpf.prce.issuetracker.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.gov.mpf.prce.issuetracker.JpaUtils;
import br.gov.mpf.prce.issuetracker.model.Projeto;

public class ProjetoDao {
	
	private EntityManager entityManager;

	public ProjetoDao() {
		entityManager = JpaUtils.getEntityManager();
	}

	public void salva(Projeto projeto) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(projeto);
		tx.commit();
	}

	public void atualiza(Projeto projeto) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.merge(projeto);
		tx.commit();
	}

	public Projeto carrega(Long id) {
		Projeto projeto = entityManager.find(Projeto.class, id);
		return projeto;
	}

	public void remove(Projeto projeto) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.remove(projeto);
		tx.commit();
	}

}







