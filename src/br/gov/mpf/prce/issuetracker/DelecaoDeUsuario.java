package br.gov.mpf.prce.issuetracker;

import javax.persistence.EntityManager;

import br.gov.mpf.prce.issuetracker.dao.UsuarioDao;
import br.gov.mpf.prce.issuetracker.dao.UsuarioDaoImpl;
import br.gov.mpf.prce.issuetracker.model.Usuario;
import br.gov.mpf.prce.issuetracker.spring.SpringUtils;

public class DelecaoDeUsuario {

	public static void main(String[] args) {
		UsuarioDao usuarioDao = SpringUtils.getBean("usuarioDao", UsuarioDaoImpl.class);
		
		Usuario usuario = usuarioDao.carrega(2L);
		
		usuarioDao.remove(usuario);
	}

}
