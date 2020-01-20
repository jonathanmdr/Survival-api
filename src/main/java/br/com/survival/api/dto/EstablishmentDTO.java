package br.com.survival.api.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class EstablishmentDTO {
	
	private String code;
	private String city;
	private String name;

}
