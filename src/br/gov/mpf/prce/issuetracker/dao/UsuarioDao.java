package br.gov.mpf.prce.issuetracker.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.gov.mpf.prce.issuetracker.JpaUtils;
import br.gov.mpf.prce.issuetracker.model.Usuario;

public class UsuarioDao {
	
	private EntityManager entityManager;

	public UsuarioDao() {
		entityManager = JpaUtils.getEntityManager();
	}

	public void salva(Usuario usuario) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(usuario);
		tx.commit();
	}

	public void atualiza(Usuario usuario) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.merge(usuario);
		tx.commit();
	}

	public Usuario carrega(Long id) {
		Usuario usuario = entityManager.find(Usuario.class, id);
		return usuario;
	}

	public void remove(Usuario usuario) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.remove(usuario);
		tx.commit();
	}

}







