package br.com.survival.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.survival.domain.exception.PersonNotFoundException;
import br.com.survival.domain.model.Person;
import br.com.survival.domain.repository.PersonRepository;

@Service
public class PersonService {	
	
	@Autowired
	private PersonRepository personRepository;
	
	@Transactional(readOnly = true)
	public List<Person> findAll() {
		return personRepository.findAll();
	}
	
	@Transactional(readOnly = true)
	public Person findById(String cpf) {
		return personRepository.findById(cpf)
				.orElseThrow(() -> new PersonNotFoundException(String.format("Pessoa de CPF: %s não existe!", cpf)));
	}

}
