package br.gov.mpf.prce.issuetracker;

import br.gov.mpf.prce.issuetracker.dao.IssueDao;

public class ConsultaDeIssues {

	public static void main(String[] args) {
		
		IssueDao dao = new IssueDao();
//		dao.listaTudo();
		dao.getIssuesComComentarios();
//		dao.getComentarios(1l);
//		dao.buscaPorSumario("bugs");
		
	}
}
