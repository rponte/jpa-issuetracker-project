package br.com.triadworks.issuetracker;

import javax.persistence.EntityManager;

import br.com.triadworks.issuetracker.dao.IssueDao;
import br.com.triadworks.issuetracker.dao.IssueDaoImpl;
import br.com.triadworks.issuetracker.model.Comentario;
import br.com.triadworks.issuetracker.model.Issue;
import br.com.triadworks.issuetracker.spring.SpringUtils;

public class RemoveComentarioDaIssue {

	public static void main(String[] args) {
		IssueDao issueDao = SpringUtils.getBean("issueDao", IssueDao.class);
		// busca a issue
		Issue issue = issueDao.carrega(3L);
		
		// remove comentario
		Comentario comentario = new Comentario();
		comentario.setId(3L);
		
		boolean removido = issue.getComentarios().remove(comentario);
		if (removido)
			System.out.println(">> REMOVIDO!");
		
		// salva a issue
		issueDao.atualiza(issue);
		
	}
	
	
}
