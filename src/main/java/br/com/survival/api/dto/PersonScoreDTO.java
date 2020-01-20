package br.com.survival.api.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "Insumos do score de crédito", description = "Representação de dados utilizados para cálculo de score de crédito (idade, endereço, ativos e fontes de renda)")
@Getter
@Setter
@Builder
public class PersonScoreDTO {
	
	@ApiModelProperty(example = "35", position = 10)
	private int age;
	
	@ApiModelProperty(example = "Rua XV de abril, 1722 - Centro - São Paulo", position = 20)
	private String address;
	
	@ApiModelProperty(position = 30)
	private List<AssetDTO> assets;
	
	@ApiModelProperty(position = 40)
	private List<IncomeDTO> incomes;

}
