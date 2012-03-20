package br.gov.mpf.prce.issuetracker.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.gov.mpf.prce.issuetracker.JpaUtils;
import br.gov.mpf.prce.issuetracker.model.Comentario;
import br.gov.mpf.prce.issuetracker.model.Issue;

public class IssueDao {
	
	private EntityManager entityManager;

	public IssueDao() {}
	
	public IssueDao(EntityManager entityManager) {
		this.entityManager = entityManager;
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
		
		Issue issue = carrega(idDaIssue);
		issue.adicionaComentario(comentario);
		
//		atualiza(issue);
	}
	
	
	public void fecha(Long idDaIssue, Comentario comentario) {
		
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		
		Issue issue = carrega(idDaIssue);
		issue.fecha(comentario);
		
		tx.commit();
	}
	
	
	public List<Issue> listaTudo() {
		
		Session session = JpaUtils.getSession(entityManager);
		
		Criteria criteria = session.createCriteria(Issue.class);
		List issues = criteria.list();
		
		return issues;
	}
	
//	@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
	
	public List<Issue> getIssuesComComentarios() {
		
		Session session = JpaUtils.getSession(entityManager);
		
		Criteria criteria = session.createCriteria(Issue.class);
		criteria.add(Restrictions.isNotEmpty("comentarios"));
		
		criteria.setProjection(
				Projections.projectionList()
					.add(Property.forName("id"), "id")
					.add(Property.forName("sumario"), "sumario")
					.add(Property.forName("descricao"), "descricao")
					.add(Property.forName("projeto"), "projeto")
				);
		
		criteria.setResultTransformer(Transformers.aliasToBean(Issue.class));
		
//		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		
		return criteria.list();
		
//		TypedQuery<Issue> query = entityManager
//				.createQuery("select distinct(issue) from Issue issue " +
//						"join fetch issue.comentarios " + // força EAGER via join
//						"where issue.comentarios is not empty", Issue.class);
//		
//		List<Issue> issues = query.getResultList();
//		
//		return issues;
	}
	
	
	public List<Comentario> getComentarios(Long idDaIssue) {
		
		TypedQuery<Comentario> query = entityManager
				.createQuery("select comentario from Issue issue " +
						"join issue.comentarios as comentario " + 
							"with comentario.criadaEm < CURRENT_DATE " +
						"where issue.id = :id", Comentario.class);
		
		query.setParameter("id", idDaIssue);
		
		List<Comentario> comentarios = query.getResultList();
		
		return comentarios;
	}
	

	public List<Issue> buscaPorSumario(String sumario) {
		
		Session session = JpaUtils.getSession(entityManager);
		
		Criteria criteria = session.createCriteria(Issue.class);
		criteria.add(Restrictions.ilike("sumario", sumario, MatchMode.ANYWHERE));
		criteria.setFetchMode("projeto", FetchMode.SELECT); // == FetchMode.LAZY
		criteria.setFetchMode("reportadoPor", FetchMode.SELECT);
		criteria.setFetchMode("assinadoPara", FetchMode.SELECT);
		
		return criteria.list();
		
	}
	
	
}







