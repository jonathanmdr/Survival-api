package br.com.survival.api.dto;

import java.time.OffsetDateTime;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "Consulta CPF", description = "Representação da última consulta realizada à um CPF por um estabelecimento")
@Getter
@Setter
@Builder
public class LastSearchDTO {
	
	@ApiModelProperty(example = "dc383456-a8ab-4325-bdf2-f4939c2df61a", position = 10)
	private String code;
	
	@ApiModelProperty(example = "2020-01-20T19:50:00Z", position = 20)
	private OffsetDateTime consultationDate;
	
	@ApiModelProperty(position = 30)
	private EstablishmentDTO establishment;

}
