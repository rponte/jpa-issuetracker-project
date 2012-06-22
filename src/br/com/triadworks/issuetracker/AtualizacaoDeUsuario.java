package br.com.triadworks.issuetracker;

import javax.persistence.EntityManager;

import br.com.triadworks.issuetracker.dao.UsuarioDao;
import br.com.triadworks.issuetracker.dao.UsuarioDaoImpl;
import br.com.triadworks.issuetracker.model.Usuario;
import br.com.triadworks.issuetracker.spring.SpringUtils;

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
