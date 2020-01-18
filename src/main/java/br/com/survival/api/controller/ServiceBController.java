package br.com.survival.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.survival.api.dto.AssetDTO;
import br.com.survival.api.dto.IncomeDTO;
import br.com.survival.api.dto.PersonScoreDTO;
import br.com.survival.api.mapper.AssetMapper;
import br.com.survival.api.mapper.IncomeMapper;
import br.com.survival.api.mapper.PersonMapper;
import br.com.survival.domain.model.Person;
import br.com.survival.domain.service.AssetService;
import br.com.survival.domain.service.IncomeService;
import br.com.survival.domain.service.PersonService;

@RestController
@RequestMapping(path = "/serviceB", produces = MediaType.APPLICATION_JSON_VALUE)
public class ServiceBController {
	
	@Autowired
	private PersonService personService;
	
	@Autowired
	private AssetService assetService;
	
	@Autowired
	private IncomeService incomeService;
	
	@Autowired
	private AssetMapper assetMapper;
	
	@Autowired
	private IncomeMapper incomeMapper;
	
	@Autowired
	private PersonMapper personMapper;
	
	@GetMapping("/{cpf}")
	public PersonScoreDTO findCreditScoreByCpf(@PathVariable String cpf) {
		Person person = personService.findById(cpf);
		List<AssetDTO> assets = assetMapper.toCollectionDto(assetService.findByPerson(person));
		List<IncomeDTO> incomes = incomeMapper.toCollectionDto(incomeService.findByPerson(person));
		
		return personMapper.toPersonScoreDto(person, assets, incomes);
	}

}
