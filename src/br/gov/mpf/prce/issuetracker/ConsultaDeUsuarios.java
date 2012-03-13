package br.gov.mpf.prce.issuetracker;

import br.gov.mpf.prce.issuetracker.dao.UsuarioDao;
import br.gov.mpf.prce.issuetracker.model.Usuario;

public class ConsultaDeUsuarios {

	public static void main(String[] args) {
		
		UsuarioDao dao = new UsuarioDao();
		
		Usuario usuario = dao.buscaPor("rponte", "1234");
		
	}
}
