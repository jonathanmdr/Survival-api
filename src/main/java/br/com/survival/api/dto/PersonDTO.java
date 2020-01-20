package br.com.survival.api.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "Pessoa", description = "Representação de pessoa com a lista de débitos registrados para o CPF em questão")
@Getter
@Setter
public class PersonDTO {
	
	@ApiModelProperty(example = "dc383456-a8ab-4325-bdf2-f4939c2df61a", position = 10)
	private String code;
	
	@ApiModelProperty(example = "00000000191", position = 20)
	private String cpf;
	
	@ApiModelProperty(example = "Jenkins Benevoulart", position = 30)
	private String name;
	
	@ApiModelProperty(example = "Rua XV de abril, 1722 - Centro - São Paulo", position = 40)
	private String address;
	
	@ApiModelProperty(position = 50)
	private List<DebitDTO> debits;

}
