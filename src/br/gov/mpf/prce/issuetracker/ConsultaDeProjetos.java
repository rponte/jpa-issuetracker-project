package br.gov.mpf.prce.issuetracker;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.gov.mpf.prce.issuetracker.dao.ProjetoDao;
import br.gov.mpf.prce.issuetracker.dao.ProjetoDaoImpl;
import br.gov.mpf.prce.issuetracker.model.Projeto;
import br.gov.mpf.prce.issuetracker.spring.SpringUtils;

public class ConsultaDeProjetos {

	public static void main(String[] args) {
		
		ProjetoDao dao = SpringUtils.getBean(ProjetoDao.class);
		
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






