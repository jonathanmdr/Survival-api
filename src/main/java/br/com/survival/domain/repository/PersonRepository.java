package br.com.survival.domain.repository;

import org.springframework.stereotype.Repository;

import br.com.survival.domain.model.Person;

@Repository
public interface PersonRepository extends CustomJpaRepository<Person, Long> {

}
