package br.gov.mpf.prce.issuetracker;

import br.gov.mpf.prce.issuetracker.dao.UsuarioDao;
import br.gov.mpf.prce.issuetracker.model.Usuario;
import br.gov.mpf.prce.issuetracker.spring.SpringUtils;

public class ConsultaDeUsuarios {

	public static void main(String[] args) {
		
		UsuarioDao dao = SpringUtils.getBean("usuarioDaoImpl", UsuarioDao.class);
		
		Usuario usuario = dao.buscaPor("rponte", "1234");
		
	}
}
