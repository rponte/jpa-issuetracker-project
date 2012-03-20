package br.gov.mpf.prce.issuetracker;

import javax.persistence.EntityManager;

import br.gov.mpf.prce.issuetracker.dao.UsuarioDao;
import br.gov.mpf.prce.issuetracker.dao.UsuarioDaoImpl;
import br.gov.mpf.prce.issuetracker.model.Usuario;
import br.gov.mpf.prce.issuetracker.spring.SpringUtils;

public class ConsultaDeUsuarios {

	public static void main(String[] args) {
		
		UsuarioDao dao = SpringUtils.getBean("usuarioDao", UsuarioDaoImpl.class);
		
		Usuario usuario = dao.buscaPor("rponte", "1234");
		
	}
}
