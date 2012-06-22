package br.com.triadworks.issuetracker;

import br.com.triadworks.issuetracker.dao.IssueDao;
import br.com.triadworks.issuetracker.model.Comentario;
import br.com.triadworks.issuetracker.spring.SpringUtils;

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
