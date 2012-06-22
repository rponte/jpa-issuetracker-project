package br.com.triadworks.issuetracker;

import javax.persistence.EntityManager;

import br.com.triadworks.issuetracker.dao.IssueDao;
import br.com.triadworks.issuetracker.dao.IssueDaoImpl;
import br.com.triadworks.issuetracker.spring.SpringUtils;

public class ConsultaDeIssues {

	public static void main(String[] args) {
		
		IssueDao dao = SpringUtils.getBean("issueDao", IssueDaoImpl.class);
//		dao.listaTudo();
		dao.getIssuesComComentarios();
//		dao.getComentarios(1l);
//		dao.buscaPorSumario("bugs");
		
	}
}
