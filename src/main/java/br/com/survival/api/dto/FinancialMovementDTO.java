package br.com.survival.api.dto;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "Movimentação financeira", description = "Representação de movimentação financeira")
@Getter
@Setter
@Builder
public class FinancialMovementDTO {
	
	@ApiModelProperty(example = "dc383456-a8ab-4325-bdf2-f4939c2df61a", position = 10)
	private String code;
	
	@ApiModelProperty(example = "Crédito de transferência entre contas corrente de mesma titularidade", position = 20)
	private String description;
	
	@ApiModelProperty(example = "2020-01-20T19:50:00Z", position = 30)
	private OffsetDateTime dateTime;
	
	@ApiModelProperty(example = "987.52", position = 40)
	public BigDecimal value;

}
