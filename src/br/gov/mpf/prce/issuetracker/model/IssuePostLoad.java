package br.gov.mpf.prce.issuetracker.model;

import javax.persistence.PostLoad;

public class IssuePostLoad {

	@PostLoad
	public void onPostLoad(Object object) {
//		System.out.println(">> IssuePostLoad.class");
	}
	
}
