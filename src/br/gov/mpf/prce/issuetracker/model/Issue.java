package br.gov.mpf.prce.issuetracker.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Issue {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_ISSUE")
	@SequenceGenerator(name="SEQ_ISSUE", sequenceName="SEQ_ISSUE", allocationSize=1)
	private Long id;
	private String sumario;
	@Column(length=1000)
	private String descricao;
	
	@ManyToOne
	private Projeto projeto;
	
	@Enumerated(EnumType.STRING)
	private TipoDaIssue tipo;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date reportadoEm;
	
	@ManyToOne
	@JoinColumn(name="USUARIO_REPORTADOR")
	private Usuario reportadoPor;
	@ManyToOne
	@JoinColumn(name="ASSINADO_PARA", 
		referencedColumnName="USU_LOGIN", unique=true)
	private Usuario assinadoPara;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date atualizadoEm;

	@OneToMany(mappedBy="issue")
	private List<Comentario> comentarios;
	
}








