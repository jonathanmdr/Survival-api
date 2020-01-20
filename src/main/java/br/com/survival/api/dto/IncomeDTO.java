package br.com.survival.api.dto;

import java.math.BigDecimal;

import br.com.survival.domain.model.IncomeType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "Renda", description = "Representação de uma fonte de renda (Diária, Semanal, Mensal...)")
@Getter
@Setter
public class IncomeDTO {

	@ApiModelProperty(example = "dc383456-a8ab-4325-bdf2-f4939c2df61a", position = 10)
	private String code;
	
	@ApiModelProperty(example = "Honorários recebidos de serviço público", position = 20)
	private String description;
	
	@ApiModelProperty(position = 30)
	private IncomeType incomeType;
	
	@ApiModelProperty(example = "127.75", position = 40)
	private BigDecimal amount;
	
}
