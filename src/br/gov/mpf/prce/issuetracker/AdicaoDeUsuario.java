package br.gov.mpf.prce.issuetracker;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class AdicaoDeUsuario {

	// rponte@gmail.com
	
	public static void main(String[] args) {
		// obtenho o entitymanager
		EntityManager entityManager = getEntityManager();
		// crio usuario
		Usuario usuario = criaUsuario();
		// gravo usuario
		gravaUsuario(entityManager, usuario);
		// fecha
		entityManager.close();
		
	}

	private static EntityManager getEntityManager() {
		return JpaUtils.getEntityManager();
	}

	private static void gravaUsuario(EntityManager entityManager, Usuario usuario) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		
		entityManager.persist(usuario);
		
		tx.commit();
	}

	private static Usuario criaUsuario() {
		Usuario usuario = new Usuario();
		usuario.setLogin("rponte");
		usuario.setSenha("1234");
		usuario.setNome("Rafael Ponte");
		usuario.setEmail("rponte@triadworks.com.br");
		return usuario;
	}

}
