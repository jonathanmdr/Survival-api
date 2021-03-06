package br.com.survival.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.survival.domain.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, String> {
	
	Optional<Person> findByCode(String code);

}
