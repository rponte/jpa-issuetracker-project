package br.gov.mpf.prce.issuetracker.spring;

import java.io.File;
import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.gov.mpf.prce.issuetracker.dao.UsuarioDao;
import br.gov.mpf.prce.issuetracker.spring.impl.UsuarioParser;

public class ExecutaImportacaoDeUsuarios {

	public static void main(String[] args) throws IOException {
		
		ApplicationContext ctx 
			= new ClassPathXmlApplicationContext("applicationContext.xml", "applicationContext-persistence.xml");
		
		ImportadorDeUsuarios importador 
			= ctx.getBean("importadorDeUsuarios", ImportadorDeUsuarios.class);
		
		importador.importa();
		
//		File arquivo = ctx.getBean("arquivo_txt", File.class);
//		UsuarioParser usuarioParser = ctx.getBean("usuarioParser", UsuarioParser.class);
//		UsuarioDao dao = ctx.getBean("usuarioDao", UsuarioDao.class);
//		
//		ImportadorDeUsuarios importador = new ImportadorDeUsuarios(arquivo, usuarioParser, dao);
//		importador.importa();
		
	}
	
}
//File arquivo = new File("/Users/rponte/Documents/Curso de JSF - TriadWorks/MPF/Workspace/issuetracker-jpa/src/usuarios.txt");
//UsuarioParser usuarioParser = new UsuarioParser();
//UsuarioDao dao = new UsuarioDao();
