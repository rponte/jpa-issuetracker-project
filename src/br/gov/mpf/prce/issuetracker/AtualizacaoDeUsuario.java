package br.gov.mpf.prce.issuetracker;

import br.gov.mpf.prce.issuetracker.dao.UsuarioDao;
import br.gov.mpf.prce.issuetracker.model.Usuario;

public class AtualizacaoDeUsuario {

	public static void main(String[] args) {
		
		UsuarioDao usuarioDao = new UsuarioDao();
		// busca usuario
		Usuario usuario = usuarioDao.carrega(3L);
		usuario.setNome("Rafael M C Ponte");
		// atualiza usuario
		usuarioDao.atualiza(usuario);
		
	}
	
}
