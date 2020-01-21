package br.com.survival.domain.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.survival.domain.model.Income;
import br.com.survival.domain.model.Person;

@Repository
public interface IncomeRepository extends JpaRepository<Income, UUID> {
	
	List<Income> findByPerson(Person person);

}
