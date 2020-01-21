package br.com.survival.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.survival.api.controller.openapi.ServiceAControllerOpenApi;
import br.com.survival.api.dto.PersonDTO;
import br.com.survival.api.event.CpfQueryEvent;
import br.com.survival.api.mapper.PersonMapper;
import br.com.survival.domain.model.Person;
import br.com.survival.domain.service.PersonService;

@RestController
@RequestMapping(path = "/serviceA", produces = MediaType.APPLICATION_JSON_VALUE)
public class ServiceAController implements ServiceAControllerOpenApi {
	
	@Autowired
	private PersonService personService;
	
	@Autowired
	private PersonMapper personMapper;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping("/{cpf}")
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_DEBITO') and #oauth2.hasScope('read')")
	public PersonDTO findPersonAndDebtsByCpf(@PathVariable String cpf) {
		Person person = personService.findById(cpf);		
		publisher.publishEvent(new CpfQueryEvent(this, person));		
		return personMapper.toDto(person);
	}

}
