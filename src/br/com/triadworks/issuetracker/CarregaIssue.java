package br.com.triadworks.issuetracker;

import javax.persistence.EntityManager;

import br.com.triadworks.issuetracker.dao.IssueDao;
import br.com.triadworks.issuetracker.dao.IssueDaoImpl;
import br.com.triadworks.issuetracker.model.Issue;
import br.com.triadworks.issuetracker.spring.SpringUtils;

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








