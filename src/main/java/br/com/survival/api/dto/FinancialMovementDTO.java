package br.com.survival.api.dto;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class FinancialMovementDTO {
	
	private String code;
	private String description;
	private OffsetDateTime dateTime;
	public BigDecimal value;

}
