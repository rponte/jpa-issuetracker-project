package br.gov.mpf.prce.issuetracker.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

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
	
	public List<Projeto> listaTudo() {
		
		TypedQuery<Projeto> query = entityManager
			.createQuery("select new Projeto(p.id, upper(p.nome)) from Projeto p", Projeto.class);
		
		List<Projeto> projetos = query.getResultList();
		
		return projetos;
	}
	
	public List<String> listaTodosOsNomes() {
		
		TypedQuery<String> query = entityManager
				.createQuery("select p.nome from Projeto p", String.class);
		
		List<String> nomes = query.getResultList();
		
		return nomes;
	}
	
	public Long count() {
		
		TypedQuery<Long> query = entityManager
				.createQuery("select count(p) from Projeto p", Long.class);
		
		Long count = query.getSingleResult();
		
		return count;
	}

}







