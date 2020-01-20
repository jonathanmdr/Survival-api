package br.com.survival.api.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "Eventos", description = "Representação de eventos financeiros registrados por CPF")
@Getter
@Setter
@Builder
public class EventsDTO {
	
	@ApiModelProperty(position = 10)
	private LastSearchDTO lastSearch;
	
	@ApiModelProperty(position = 20)
	private List<FinancialMovementDTO> financialMovement;
	
	@ApiModelProperty(position = 30)
	private List<CreditCardPurchaseDTO> credictCardPurchase;

}
