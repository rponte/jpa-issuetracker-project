package br.gov.mpf.prce.issuetracker;

import br.gov.mpf.prce.issuetracker.dao.IssueDao;
import br.gov.mpf.prce.issuetracker.model.Comentario;
import br.gov.mpf.prce.issuetracker.model.Issue;

public class RemoveComentarioDaIssue {

	public static void main(String[] args) {
		IssueDao issueDao = new IssueDao();
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
