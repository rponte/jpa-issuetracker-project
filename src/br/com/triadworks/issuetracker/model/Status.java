package br.com.triadworks.issuetracker.model;

public enum Status {

	FECHADA("Fechada"),
	ABERTA("Aberta");
	
	private final String descricao;

	private Status(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
}
