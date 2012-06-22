package br.com.triadworks.issuetracker;

import br.com.triadworks.issuetracker.dao.UsuarioDao;
import br.com.triadworks.issuetracker.model.Usuario;
import br.com.triadworks.issuetracker.spring.SpringUtils;

public class ConsultaDeUsuarios {

	public static void main(String[] args) {
		
		UsuarioDao dao = SpringUtils.getBean("usuarioDaoImpl", UsuarioDao.class);
		
		Usuario usuario = dao.buscaPor("rponte", "1234");
		
	}
}
