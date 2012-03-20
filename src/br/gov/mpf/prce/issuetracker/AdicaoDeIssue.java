package br.gov.mpf.prce.issuetracker;

import java.util.Date;

import javax.persistence.EntityManager;

import br.gov.mpf.prce.issuetracker.dao.IssueDao;
import br.gov.mpf.prce.issuetracker.dao.ProjetoDao;
import br.gov.mpf.prce.issuetracker.dao.UsuarioDao;
import br.gov.mpf.prce.issuetracker.model.Comentario;
import br.gov.mpf.prce.issuetracker.model.Issue;
import br.gov.mpf.prce.issuetracker.model.Projeto;
import br.gov.mpf.prce.issuetracker.model.Status;
import br.gov.mpf.prce.issuetracker.model.TipoDaIssue;
import br.gov.mpf.prce.issuetracker.model.Usuario;

public class AdicaoDeIssue {

	public static void main(String[] args) {
		
		Date hoje = new Date();
		
		Projeto projeto = buscaProjetoPorId(1L);
		Usuario usuario = buscaUsuarioPorId(1L);

		Issue issue = criaIssue(hoje, projeto, usuario);
		
		// inserir um Comentario
		
//		Comentario comentario1 = criaComentario("comentario 01", hoje, usuario);
//		Comentario comentario2 = criaComentario("comentario 02", hoje, usuario);
//		
//		issue.getComentarios().add(comentario1);
//		issue.getComentarios().add(comentario2);
		
		salvaIssue(issue);
		
	}

	private static Comentario criaComentario(String descricao, Date hoje, Usuario usuario) {
		Comentario comentario = new Comentario();
		comentario.setDescricao(descricao);
		comentario.setAutor(usuario);
		comentario.setCriadaEm(hoje);
		return comentario;
	}

	private static void salvaIssue(Issue issue) {
		IssueDao issueDao = new IssueDao();
		issueDao.salva(issue);
	}

	private static Issue criaIssue(Date hoje, Projeto projeto, Usuario usuario) {
		Issue issue = new Issue();
		issue.setSumario("Bug no IE6");
		issue.setDescricao("Erro ao submeter formulario via ajax.");
		issue.setTipo(TipoDaIssue.BUG);
		issue.setReportadoEm(hoje);
//		issue.setAtualizadoEm(hoje);
		issue.setStatus(Status.ABERTA);
		issue.setProjeto(projeto);
		issue.setReportadoPor(usuario);
		issue.setAssinadoPara(usuario);
		return issue;
	}

	private static Usuario buscaUsuarioPorId(long id) {
		UsuarioDao usuarioDao = new UsuarioDao();
		return usuarioDao.carrega(id);
	}

	private static Projeto buscaProjetoPorId(long id) {
		EntityManager entityManager = JpaUtils.getEntityManager();
		ProjetoDao projetoDao = new ProjetoDao(entityManager);
		return projetoDao.carrega(id);
	}
	
}
