package br.gov.mpf.prce.issuetracker;

import br.gov.mpf.prce.issuetracker.dao.IssueDao;

public class CarregaIssue {

	public static void main(String[] args) {
		
		IssueDao dao = new IssueDao();
		dao.carrega(3L);
		dao.carrega(3L);
		dao.carrega(3L);
		dao.carrega(3L);
		dao.carrega(3L);
		dao.carrega(3L);
		dao.carrega(3L);
		dao.carrega(3L);
		dao.carrega(3L);
	}
}
