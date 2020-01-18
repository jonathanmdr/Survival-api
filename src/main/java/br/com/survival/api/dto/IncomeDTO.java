package br.com.survival.api.dto;

import java.math.BigDecimal;

import br.com.survival.domain.model.IncomeType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IncomeDTO {

	private String code;
	private String description;
	private IncomeType incomeType;
	private BigDecimal amount;
	
}
