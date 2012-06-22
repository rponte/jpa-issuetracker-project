package br.com.triadworks.issuetracker;

import java.util.Date;

import javax.persistence.EntityManager;

import br.com.triadworks.issuetracker.dao.IssueDao;
import br.com.triadworks.issuetracker.dao.IssueDaoImpl;
import br.com.triadworks.issuetracker.dao.ProjetoDao;
import br.com.triadworks.issuetracker.dao.ProjetoDaoImpl;
import br.com.triadworks.issuetracker.dao.UsuarioDao;
import br.com.triadworks.issuetracker.dao.UsuarioDaoImpl;
import br.com.triadworks.issuetracker.model.Comentario;
import br.com.triadworks.issuetracker.model.Issue;
import br.com.triadworks.issuetracker.model.Projeto;
import br.com.triadworks.issuetracker.model.Status;
import br.com.triadworks.issuetracker.model.TipoDaIssue;
import br.com.triadworks.issuetracker.model.Usuario;
import br.com.triadworks.issuetracker.spring.SpringUtils;

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
		IssueDao issueDao = SpringUtils.getBean(IssueDao.class);
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
		UsuarioDao usuarioDao = SpringUtils.getBean(UsuarioDao.class);
		return usuarioDao.carrega(id);
	}

	private static Projeto buscaProjetoPorId(long id) {
		ProjetoDao projetoDao = SpringUtils.getBean(ProjetoDao.class);
		return projetoDao.carrega(id);
	}
	
}
