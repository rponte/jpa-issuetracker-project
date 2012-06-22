package br.com.triadworks.issuetracker.dao;

import java.util.List;

import br.com.triadworks.issuetracker.model.Projeto;

public interface ProjetoDao {

	public void salva(Projeto projeto);

	public void atualiza(Projeto projeto);

	public Projeto carrega(Long id);

	public void remove(Projeto projeto);

	public List<Projeto> listaTudo();

	public List<String> listaTodosOsNomes();

	public Long count();

}