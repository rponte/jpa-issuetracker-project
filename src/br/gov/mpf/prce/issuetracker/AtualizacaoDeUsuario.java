package br.gov.mpf.prce.issuetracker;

import javax.persistence.EntityManager;

import br.gov.mpf.prce.issuetracker.dao.UsuarioDao;
import br.gov.mpf.prce.issuetracker.dao.UsuarioDaoImpl;
import br.gov.mpf.prce.issuetracker.model.Usuario;
import br.gov.mpf.prce.issuetracker.spring.SpringUtils;

public class AtualizacaoDeUsuario {

	public static void main(String[] args) {
		
		UsuarioDao usuarioDao = SpringUtils.getBean("usuarioDao", UsuarioDaoImpl.class);
		// busca usuario
		Usuario usuario = usuarioDao.carrega(3L);
		usuario.setNome("Rafael M C Ponte");
		// atualiza usuario
		usuarioDao.atualiza(usuario);
		
	}
	
}
