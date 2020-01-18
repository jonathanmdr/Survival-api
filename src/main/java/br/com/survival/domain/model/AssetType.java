package br.com.survival.domain.model;

import lombok.Getter;

@Getter
public enum AssetType {
	
	IMOVEL("Imóvel"),
	POUPANCA("Poupança"),
	ACOES("Ações"),
	TITULO_PUBLICO("Título público"),
	TITULO_PRIVADO("Título privado");
	
	private String description;
	
	private AssetType(String description) {
		this.description = description;
	}

}
