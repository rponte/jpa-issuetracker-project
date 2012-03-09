package br.gov.mpf.prce.issuetracker;

import javax.persistence.EntityManager;

import br.gov.mpf.prce.issuetracker.dao.UsuarioDao;
import br.gov.mpf.prce.issuetracker.model.Usuario;

public class AdicaoDeUsuario {

	// rponte@gmail.com
	
	public static void main(String[] args) {
		// crio usuario
		Usuario usuario = criaUsuario();
		// gravo usuario
		UsuarioDao usuarioDao = new UsuarioDao();
		usuarioDao.salva(usuario);
		
	}

	private static EntityManager getEntityManager() {
		return JpaUtils.getEntityManager();
	}

	private static Usuario criaUsuario() {
		Usuario usuario = new Usuario();
		usuario.setLogin("rponte_2");
		usuario.setSenha("1234");
		usuario.setNome("Rafael Ponte");
		usuario.setEmail("rponte@triadworks.com.br");
		return usuario;
	}

}
