package br.com.triadworks.issuetracker;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.com.triadworks.issuetracker.dao.ProjetoDao;
import br.com.triadworks.issuetracker.dao.ProjetoDaoImpl;
import br.com.triadworks.issuetracker.model.Projeto;
import br.com.triadworks.issuetracker.spring.SpringUtils;

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






