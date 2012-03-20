package br.gov.mpf.prce.issuetracker.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringUtils {

	private static ApplicationContext ctx;
	
	static {
		ctx 	= new ClassPathXmlApplicationContext("applicationContext.xml", 
				"applicationContext-persistence.xml");
	}
	
	public static <T> T getBean(Class<T> clazz) {
		return ctx.getBean(clazz);
	}
	
	public static <T> T getBean(String nome, Class<T> clazz) {
		return ctx.getBean(nome, clazz);
	}
	
}
