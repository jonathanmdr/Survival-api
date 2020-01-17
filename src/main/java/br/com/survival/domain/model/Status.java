package br.com.survival.domain.model;

import lombok.Getter;

@Getter
public enum Status {
	
	ATIVO("Ativo"),
	BAIXADO("Baixado");
	
	private String description;
	
	Status(String description) {
		this.description = description;
	}

}
