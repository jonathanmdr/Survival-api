package br.com.survival.api.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonDTO {
	
	private String cpf;
	private String name;	
	private String address;
	private List<DebitDTO> debits;

}
