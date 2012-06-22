package br.com.triadworks.issuetracker.model.heranca;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Aluno extends Pessoa {

	private String curso;
	
}
