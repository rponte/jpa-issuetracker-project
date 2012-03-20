package br.gov.mpf.prce.issuetracker;

import javax.persistence.EntityManager;

import br.gov.mpf.prce.issuetracker.dao.IssueDao;
import br.gov.mpf.prce.issuetracker.dao.IssueDaoImpl;
import br.gov.mpf.prce.issuetracker.spring.SpringUtils;

public class ConsultaDeIssues {

	public static void main(String[] args) {
		
		IssueDao dao = SpringUtils.getBean("issueDao", IssueDaoImpl.class);
//		dao.listaTudo();
		dao.getIssuesComComentarios();
//		dao.getComentarios(1l);
//		dao.buscaPorSumario("bugs");
		
	}
}
