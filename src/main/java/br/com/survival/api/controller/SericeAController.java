package br.com.survival.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.survival.api.dto.PersonDTO;
import br.com.survival.api.mapper.PersonMapper;
import br.com.survival.domain.service.PersonService;

@RestController
@RequestMapping(path = "/serviceA", produces = MediaType.APPLICATION_JSON_VALUE)
public class SericeAController {
	
	@Autowired
	private PersonService personService;
	
	@Autowired
	private PersonMapper personMapper;
	
	@GetMapping
	public List<PersonDTO> findAll() {
		return personMapper.toCollectionDto(personService.findAll());
	}
	
	@GetMapping("/{cpf}")
	public PersonDTO findByCpf(@PathVariable String cpf) {
		return personMapper.toDto(personService.findById(cpf));
	}

}
