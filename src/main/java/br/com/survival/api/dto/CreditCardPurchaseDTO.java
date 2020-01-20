package br.com.survival.api.dto;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "Compra com cartão de crédito", description = "Representação da última compra realizada com cartão de crédito vinculada ao CPF")
@Getter
@Setter
@Builder
public class CreditCardPurchaseDTO {
	
	@ApiModelProperty(example = "dc383456-a8ab-4325-bdf2-f4939c2df61a", position = 10)
	private String code;
	
	@ApiModelProperty(position = 20)
	private EstablishmentDTO establishment;
	
	@ApiModelProperty(example = "2020-01-20T19:50:00Z", position = 30)
	private OffsetDateTime dateTime;
	
	@ApiModelProperty(example = "2572.10", position = 40)
	private BigDecimal value;

}
