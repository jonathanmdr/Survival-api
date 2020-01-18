package br.com.survival.api.dto;

import java.math.BigDecimal;

import br.com.survival.domain.model.AssetType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AssetDTO {
	
	private String code;
	private String description;
	private AssetType assetType;
	private BigDecimal amount;

}
