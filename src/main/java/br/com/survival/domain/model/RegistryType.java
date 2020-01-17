package br.com.survival.domain.model;

import lombok.Getter;

@Getter
public enum RegistryType {
	
	TITULAR("Titular"),
	AVALISTA("Avalista");
	
	private String description;
	
	RegistryType(String description) {
		this.description = description;
	}

}
