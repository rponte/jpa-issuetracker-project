package br.com.triadworks.issuetracker.model.heranca;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

//@Entity 
@MappedSuperclass
public class Pessoa {

	@Id
	private Long id;
	
	private String nome;
	
}
