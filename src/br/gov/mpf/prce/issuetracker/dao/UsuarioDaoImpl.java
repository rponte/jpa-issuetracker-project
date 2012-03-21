package br.gov.mpf.prce.issuetracker.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.gov.mpf.prce.issuetracker.model.Usuario;

@Primary
@Transactional
@Repository
@Scope("singleton")
public class UsuarioDaoImpl implements UsuarioDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@PostConstruct
	public void init() {
		System.out.println("CRIADO!!");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("MORREU!");
	}
	
	@Override
	public void salva(Usuario usuario) {
		entityManager.persist(usuario);
	}

	@Override
	public void atualiza(Usuario usuario) {
		entityManager.merge(usuario);
	}

	@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
	@Override
	public Usuario carrega(Long id) {
		Usuario usuario = entityManager.find(Usuario.class, id);
		return usuario;
	}

	@Override
	public void remove(Usuario usuario) {
		entityManager.remove(usuario);
	}

	@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
	@Override
	public Usuario buscaPor(String login, String senha) {
		
		TypedQuery<Usuario> query = entityManager
			.createQuery("select u from Usuario u " +
					"where u.login = :login and u.senha = :senha", Usuario.class);
		
		query.setParameter("login", login);
		query.setParameter("senha", senha);
		
		Usuario usuario = query.getSingleResult();
		
		return usuario;
	}
	
	@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
	@Override
	public List<Usuario> listaTudo() {
		TypedQuery<Usuario> query = entityManager
				.createQuery("select u from Usuario u", Usuario.class);
		
		List<Usuario> usuarios = query.getResultList();
		return usuarios;
	}
	
	@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
	@Override
	public Usuario buscaPorLogin(String login) {
		
		TypedQuery<Usuario> query = entityManager
			.createNamedQuery("Usuario.buscaPorLogin", Usuario.class);
		
		query.setParameter("login", login);
		
		Usuario usuario = query.getSingleResult();
		
		return usuario;
		
	}
	
}







