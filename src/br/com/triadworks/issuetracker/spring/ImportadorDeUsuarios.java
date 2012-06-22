package br.com.triadworks.issuetracker.spring;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.triadworks.issuetracker.dao.UsuarioDao;
import br.com.triadworks.issuetracker.model.Usuario;
import br.com.triadworks.issuetracker.spring.impl.UsuarioParser;

@Component("importadorDeUsuarios")
public class ImportadorDeUsuarios {
	
	private File arquivo;
	private UsuarioParser usuarioParser;
	private UsuarioDao usuarioDao;
	
	@Autowired
	public ImportadorDeUsuarios(
			@Value("classpath:usuarios.txt") File arquivo, 
			UsuarioParser usuarioParser, 
			@Qualifier("usuarioJdbcDao") UsuarioDao usuarioDao) {
		this.arquivo = arquivo;
		this.usuarioParser = usuarioParser;
		this.usuarioDao = usuarioDao;
	}

	public void importa() {
		Scanner scanner = null;
		try {
			scanner = new Scanner(arquivo);
			while (scanner.hasNextLine()) {
				String linha = scanner.nextLine();
				Usuario usuario = usuarioParser.parse(linha);
				usuarioDao.salva(usuario);
			}
		} catch (FileNotFoundException e) {
			throw new IllegalStateException("Arquivo de importação de usuários não encontrado no diretório padrão.", e);
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}

}










