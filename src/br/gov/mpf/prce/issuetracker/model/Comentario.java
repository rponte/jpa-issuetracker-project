package br.gov.mpf.prce.issuetracker.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Comentario {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_COMENTARIO")
	@SequenceGenerator(name="SEQ_COMENTARIO", sequenceName="SEQ_COMENTARIO", allocationSize=1)
	private Long id;
	private String descricao;
	
	@ManyToOne
	private Usuario autor;
	
	private Date criadaEm;
	
	@ManyToOne
	@JoinTable(name="ISSUE_COMENTARIO", 
		joinColumns=@JoinColumn(name="COMENTARIO_ID"),
		inverseJoinColumns=@JoinColumn(name="ISSUE_ID", nullable=false))
	private Issue issue;
	
}








