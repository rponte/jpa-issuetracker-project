package br.gov.mpf.prce.issuetracker.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.gov.mpf.prce.issuetracker.model.Usuario;

@Repository("usuarioJdbcDao")
public class UsuarioJdbcDao implements UsuarioDao {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public UsuarioJdbcDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void salva(Usuario usuario) {
		int id = jdbcTemplate.queryForInt("select nextval ('SEQ_USUARIO')");
		jdbcTemplate.update("insert into " +
				"USUARIO (id, email, USU_LOGIN, USU_NOME, senha)" +
				" values (?, ?, ?, ?, ?)", 
										id,
										usuario.getEmail(),
										usuario.getLogin() + "-jdcb",
										usuario.getNome(),
										usuario.getSenha());
	}

	@Override
	public void atualiza(Usuario usuario) {
		// TODO Auto-generated method stub

	}

	@Override
	public Usuario carrega(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(Usuario usuario) {
		// TODO Auto-generated method stub

	}

	@Override
	public Usuario buscaPor(String login, String senha) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> listaTudo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario buscaPorLogin(String login) {
		// TODO Auto-generated method stub
		return null;
	}

}
