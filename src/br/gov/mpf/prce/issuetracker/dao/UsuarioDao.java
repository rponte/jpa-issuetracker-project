package br.gov.mpf.prce.issuetracker.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import br.gov.mpf.prce.issuetracker.model.Usuario;

public interface UsuarioDao {

	public void salva(Usuario usuario);

	public void atualiza(Usuario usuario);

	public Usuario carrega(Long id);

	public void remove(Usuario usuario);

	public Usuario buscaPor(String login, String senha);

	public List<Usuario> listaTudo();

	public Usuario buscaPorLogin(String login);

}