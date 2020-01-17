package br.com.survival.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import br.com.survival.domain.exception.EntityInUseException;
import br.com.survival.domain.exception.PersonNotFoundException;
import br.com.survival.domain.model.Person;
import br.com.survival.domain.repository.PersonRepository;

@Service
public class PersonService {
	
	private static final String MESSAGE_PERSON_CONFLICT = "Pessoa de ID: %d não pode ser excluída, pois está em uso!";
	
	@Autowired
	private PersonRepository personRepository;
	
	@Transactional(readOnly = true)
	public List<Person> findAll() {
		return personRepository.findAll();
	}
	
	@Transactional(readOnly = true)
	public Person findById(Long id) {
		return personRepository.findById(id)
				.orElseThrow(() -> new PersonNotFoundException(id));
	}
	
	@Transactional
	public Person save(Person person) {
		return personRepository.save(person);
	}
	
	@Transactional
	public void delete(Long id) {
		try {
			personRepository.deleteById(id);
			personRepository.flush();
		} catch(EmptyResultDataAccessException ex) {
			throw new PersonNotFoundException(id);
		} catch(DataIntegrityViolationException ex) {
			throw new EntityInUseException(String.format(MESSAGE_PERSON_CONFLICT, id));
		}
	}

}
