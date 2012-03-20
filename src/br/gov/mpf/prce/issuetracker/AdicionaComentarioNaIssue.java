package br.gov.mpf.prce.issuetracker;

import br.gov.mpf.prce.issuetracker.dao.IssueDao;
import br.gov.mpf.prce.issuetracker.model.Comentario;
import br.gov.mpf.prce.issuetracker.spring.SpringUtils;

public class AdicionaComentarioNaIssue {

	public static void main(String[] args) {

		Comentario comentario = criaComentario("comentario");

		IssueDao issueDao = SpringUtils.getBean(IssueDao.class);
		issueDao.comenta(3L, comentario);
		
	}
	
	private static Comentario criaComentario(String descricao) {
		Comentario comentario = new Comentario();
		comentario.setDescricao(descricao);
		return comentario;
	}
	
}
