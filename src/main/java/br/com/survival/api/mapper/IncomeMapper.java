package br.com.survival.api.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.survival.api.dto.IncomeDTO;
import br.com.survival.domain.model.Income;

@Component
public class IncomeMapper {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public IncomeDTO toDto(Income income) {
		return modelMapper.map(income, IncomeDTO.class);
	}
	
	public List<IncomeDTO> toCollectionDto(List<Income> incomes) {
		return incomes.stream().map(income -> toDto(income)).collect(Collectors.toList());
	}

}
