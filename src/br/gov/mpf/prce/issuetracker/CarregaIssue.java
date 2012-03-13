package br.gov.mpf.prce.issuetracker;

import br.gov.mpf.prce.issuetracker.dao.IssueDao;
import br.gov.mpf.prce.issuetracker.model.Issue;

public class CarregaIssue {
	
	// @PrePersist
	// @PostPersist
	// @PreRemove
	// @PostRemove
	// @PreUpdate
	// @PostUpdate
	// @PostLoad
	

	public static void main(String[] args) {
		
		IssueDao dao = new IssueDao();
		Issue issue = dao.carrega(3L);
		
		issue.getComentarios().size();
	}
}
