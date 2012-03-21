package br.gov.mpf.prce.issuetracker;

import javax.persistence.EntityManager;

import br.gov.mpf.prce.issuetracker.dao.IssueDao;
import br.gov.mpf.prce.issuetracker.dao.IssueDaoImpl;
import br.gov.mpf.prce.issuetracker.model.Issue;
import br.gov.mpf.prce.issuetracker.spring.SpringUtils;

public class CarregaIssue {
	
	// @PrePersist
	// @PostPersist
	// @PreRemove
	// @PostRemove
	// @PreUpdate
	// @PostUpdate
	// @PostLoad
	

	public static void main(String[] args) {
		
		IssueDao dao = SpringUtils.getBean(IssueDao.class);
		Issue issue = dao.carrega(1L);
		
		issue.getComentarios().size();
	}
}








