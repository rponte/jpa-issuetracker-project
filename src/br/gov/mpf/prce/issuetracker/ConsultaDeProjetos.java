package br.gov.mpf.prce.issuetracker;

import java.util.List;

import br.gov.mpf.prce.issuetracker.dao.ProjetoDao;
import br.gov.mpf.prce.issuetracker.model.Projeto;

public class ConsultaDeProjetos {

	public static void main(String[] args) {
		
		ProjetoDao dao = new ProjetoDao();
		
		List<Projeto> projetos = dao.listaTudo();
		for (Projeto projeto : projetos) {
			System.out.println("----");
			System.out.println("id=" + projeto.getId());
			System.out.println("nome=" + projeto.getNome());
		} 
		
		Long count = dao.count();
		System.out.println(">> count=" + count);
		
	}
	
}






