package br.com.survival.api.dto;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CreditCardPurchaseDTO {
	
	private String code;
	private EstablishmentDTO establishment;
	private OffsetDateTime dateTime;
	private BigDecimal value;

}
