package br.com.survival.api.event;

import org.springframework.context.ApplicationEvent;

import br.com.survival.domain.model.Person;
import lombok.Getter;

@Getter
public class CpfQueryEvent extends ApplicationEvent {

	private static final long serialVersionUID = 1L;
	
	private Person person;
	
	public CpfQueryEvent(Object source, Person person) {
		super(source);
		
		this.person = person;
	}		

}
