package br.com.triadworks.issuetracker.model.heranca;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Professor extends Pessoa {

	private String departamento;
}
