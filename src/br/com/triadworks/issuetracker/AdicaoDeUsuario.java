package br.com.triadworks.issuetracker;

import javax.persistence.EntityManager;

import br.com.triadworks.issuetracker.dao.UsuarioDao;
import br.com.triadworks.issuetracker.dao.UsuarioDaoImpl;
import br.com.triadworks.issuetracker.model.Usuario;
import br.com.triadworks.issuetracker.spring.SpringUtils;

public class AdicaoDeUsuario {

	// rponte@gmail.com
	
	public static void main(String[] args) {
		// crio usuario
		Usuario usuario = criaUsuario();
		// gravo usuario
		UsuarioDao usuarioDao = SpringUtils.getBean("usuarioDao", UsuarioDaoImpl.class);
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
