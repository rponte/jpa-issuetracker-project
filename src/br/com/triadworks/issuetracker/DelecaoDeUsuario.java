package br.com.triadworks.issuetracker;

import javax.persistence.EntityManager;

import br.com.triadworks.issuetracker.dao.UsuarioDao;
import br.com.triadworks.issuetracker.dao.UsuarioDaoImpl;
import br.com.triadworks.issuetracker.model.Usuario;
import br.com.triadworks.issuetracker.spring.SpringUtils;

public class DelecaoDeUsuario {

	public static void main(String[] args) {
		UsuarioDao usuarioDao = SpringUtils.getBean("usuarioDao", UsuarioDaoImpl.class);
		
		Usuario usuario = usuarioDao.carrega(2L);
		
		usuarioDao.remove(usuario);
	}

}
