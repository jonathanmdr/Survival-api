package br.com.survival.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.survival.api.controller.openapi.ServiceCControllerOpenApi;
import br.com.survival.api.dto.EventsDTO;
import br.com.survival.api.event.CpfQueryEvent;
import br.com.survival.domain.model.Person;
import br.com.survival.domain.service.PersonService;
import br.com.survival.domain.service.SearchHistoryService;

@RestController
@RequestMapping(path = "/serviceC", produces = MediaType.APPLICATION_JSON_VALUE)
public class ServiceCController implements ServiceCControllerOpenApi {
	
	@Autowired
	private SearchHistoryService searchHistoryService;
	
	@Autowired
	private PersonService personService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping("/{cpf}")
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_EVENTO') and #oauth2.hasScope('read')")
	public EventsDTO findLastConsultationByCpf(@PathVariable String cpf) {
		Person person = personService.findById(cpf);
		EventsDTO events = searchHistoryService.getEvents();
		
		publisher.publishEvent(new CpfQueryEvent(this, person));
		
		return events;
	}

}
