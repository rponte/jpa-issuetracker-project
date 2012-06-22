package br.com.triadworks.issuetracker.spring.impl;

import org.springframework.stereotype.Component;

import br.com.triadworks.issuetracker.model.Usuario;

@Component
public class UsuarioParser {

	public Usuario parse(String linha) {
		String[] valores = linha.split(";");
		
		Usuario usuario = new Usuario();
		usuario.setNome(valores[0]);
		usuario.setLogin(valores[1]);
		usuario.setSenha(valores[2]);
		usuario.setEmail(valores[3]);
		
		return usuario;
	}
	
}
