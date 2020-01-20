package br.com.survival.api.dto;

import java.math.BigDecimal;

import br.com.survival.domain.model.AssetType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "Ativo", description = "Representação de um ativo (Imóvel, poupança, ações...)")
@Getter
@Setter
public class AssetDTO {
	
	@ApiModelProperty(example = "dc383456-a8ab-4325-bdf2-f4939c2df61a", position = 10)
	private String code;
	
	@ApiModelProperty(example = "Apartamento de luxo com 200 m2 de construção", position = 20)
	private String description;
	
	@ApiModelProperty(position = 30)
	private AssetType assetType;
	
	@ApiModelProperty(example = "562000.01", position = 40)
	private BigDecimal amount;

}
