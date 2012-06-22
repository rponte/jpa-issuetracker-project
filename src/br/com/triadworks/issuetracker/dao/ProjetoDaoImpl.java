package br.com.triadworks.issuetracker.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.triadworks.issuetracker.JpaUtils;
import br.com.triadworks.issuetracker.model.Projeto;

@Transactional
@Component
public class ProjetoDaoImpl implements ProjetoDao {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void salva(Projeto projeto) {
		entityManager.persist(projeto);
	}

	@Override
	public void atualiza(Projeto projeto) {
		entityManager.merge(projeto);
	}


	@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
	@Override
	public Projeto carrega(Long id) {
		Projeto projeto = entityManager.find(Projeto.class, id);
		return projeto;
	}

	
	@Override
	public void remove(Projeto projeto) {
		entityManager.remove(projeto);
	}
	
	@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
	@Override
	public List<Projeto> listaTudo() {
		
		TypedQuery<Projeto> query = entityManager
			.createQuery("select new Projeto(p.id, upper(p.nome)) from Projeto p", Projeto.class);
		
		List<Projeto> projetos = query.getResultList();
		
		return projetos;
	}
	
	@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
	@Override
	public List<String> listaTodosOsNomes() {
		
		TypedQuery<String> query = entityManager
				.createQuery("select p.nome from Projeto p", String.class);
		
		List<String> nomes = query.getResultList();
		
		return nomes;
	}
	
	@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
	@Override
	public Long count() {
		
		TypedQuery<Long> query = entityManager
				.createQuery("select count(p) from Projeto p", Long.class);
		
		Long count = query.getSingleResult();
		
		return count;
	}

}







