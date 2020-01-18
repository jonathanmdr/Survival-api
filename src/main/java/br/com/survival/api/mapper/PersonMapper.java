package br.com.survival.api.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.survival.api.dto.AssetDTO;
import br.com.survival.api.dto.IncomeDTO;
import br.com.survival.api.dto.PersonDTO;
import br.com.survival.api.dto.PersonScoreDTO;
import br.com.survival.domain.model.Person;

@Component
public class PersonMapper {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public PersonDTO toDto(Person person) {
		return modelMapper.map(person, PersonDTO.class);
	}
	
	public List<PersonDTO> toCollectionDto(List<Person> persons) {
		return persons.stream().map(person -> toDto(person)).collect(Collectors.toList());
	}
	
	public PersonScoreDTO toPersonScoreDto(Person person, List<AssetDTO> assets, List<IncomeDTO> incomes) {
		return PersonScoreDTO.builder()
				.age(person.getAge())
				.address(person.getAddress())
				.assets(assets)
				.incomes(incomes)
				.build();
	}

}
