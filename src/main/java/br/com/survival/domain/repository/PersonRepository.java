package br.com.survival.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.survival.domain.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
