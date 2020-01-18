package br.com.survival.api.dto;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import br.com.survival.domain.model.RegistryType;
import br.com.survival.domain.model.Status;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DebitDTO {
		
	private String code;	
	private String corporateName;
	private String cnpj;
	private String contractNumber;
	private OffsetDateTime dueDate;
	private RegistryType registryType;
	private Status status;
	private BigDecimal debitAmount;

}
