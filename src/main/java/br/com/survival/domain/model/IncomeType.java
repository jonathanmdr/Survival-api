package br.com.survival.domain.model;

import lombok.Getter;

@Getter
public enum IncomeType {
	
	DIARIA("Diária"),
	SEMANAL("Semanal"),
	QUINZENAL("Quinzenal"),
	MENSAL("Mensal"),
	ANUAL("Anual");
	
	private String description;
	
	private IncomeType(String description) {
		this.description = description;
	}

}
