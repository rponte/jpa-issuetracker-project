package br.gov.mpf.prce.issuetracker.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.gov.mpf.prce.issuetracker.JpaUtils;
import br.gov.mpf.prce.issuetracker.model.Usuario;

public class UsuarioDao {
	
	private EntityManager entityManager;

	public UsuarioDao() {
//		entityManager = JpaUtils.getEntityManager();
	}
	
	public UsuarioDao(EntityManager entityManager) {
		this.entityManager = entityManager;
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

	public Usuario buscaPor(String login, String senha) {
		
		TypedQuery<Usuario> query = entityManager
			.createQuery("select u from Usuario u " +
					"where u.login = :login and u.senha = :senha", Usuario.class);
		
		query.setParameter("login", login);
		query.setParameter("senha", senha);
		
		Usuario usuario = query.getSingleResult();
		
		return usuario;
	}
	
	public List<Usuario> listaTudo() {
		TypedQuery<Usuario> query = entityManager
				.createQuery("select u from Usuario u", Usuario.class);
		
		List<Usuario> usuarios = query.getResultList();
		return usuarios;
	}
	
	public Usuario buscaPorLogin(String login) {
		
		TypedQuery<Usuario> query = entityManager
			.createNamedQuery("Usuario.buscaPorLogin", Usuario.class);
		
		query.setParameter("login", login);
		
		Usuario usuario = query.getSingleResult();
		
		return usuario;
		
	}
	
}







