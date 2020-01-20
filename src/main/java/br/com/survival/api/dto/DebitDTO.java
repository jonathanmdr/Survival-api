package br.com.survival.api.dto;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import br.com.survival.domain.model.RegistryType;
import br.com.survival.domain.model.Status;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "Débito", description = "Representação de um débito")
@Getter
@Setter
public class DebitDTO {
	
	@ApiModelProperty(example = "dc383456-a8ab-4325-bdf2-f4939c2df61a", position = 10)
	private String code;
	
	@ApiModelProperty(example = "Empresa survival SA", position = 20)
	private String corporateName;
	
	@ApiModelProperty(example = "00000000000191", position = 30)
	private String cnpj;
	
	@ApiModelProperty(example = "A78B9C", position = 40)
	private String contractNumber;
	
	@ApiModelProperty(example = "2018-01-17T00:00:00Z", position = 50)
	private OffsetDateTime dueDate;
	
	@ApiModelProperty(position = 60)
	private RegistryType registryType;
	
	@ApiModelProperty(position = 70)
	private Status status;
	
	@ApiModelProperty(example = "623.55", position = 80)
	private BigDecimal debitAmount;

}
