package br.gov.mpf.prce.issuetracker;

import br.gov.mpf.prce.issuetracker.dao.UsuarioDao;
import br.gov.mpf.prce.issuetracker.model.Usuario;

public class DelecaoDeUsuario {

	public static void main(String[] args) {
		UsuarioDao usuarioDao = new UsuarioDao();
		
		Usuario usuario = usuarioDao.carrega(2L);
		
		usuarioDao.remove(usuario);
	}

}
