package br.com.survival.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "Estabelecimento", description = "Representação de um estabelecimento")
@Getter
@Setter
@Builder
public class EstablishmentDTO {
	
	@ApiModelProperty(example = "dc383456-a8ab-4325-bdf2-f4939c2df61a", position = 10)
	private String code;
	
	@ApiModelProperty(example = "São Paulo", position = 20)
	private String city;
	
	@ApiModelProperty(example = "Survival credit financial SA", position = 30)
	private String name;

}
