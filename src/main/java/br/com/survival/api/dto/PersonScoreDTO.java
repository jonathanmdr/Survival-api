package br.com.survival.api.dto;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PersonScoreDTO {
	
	private int age;
	private String address;
	private List<AssetDTO> assets;
	private List<IncomeDTO> incomes;

}
