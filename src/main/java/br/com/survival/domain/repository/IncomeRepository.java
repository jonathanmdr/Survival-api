package br.com.survival.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.survival.domain.model.Income;
import br.com.survival.domain.model.Person;

@Repository
public interface IncomeRepository extends JpaRepository<Income, String> {
	
	Optional<Income> findByCode(String code);
	
	List<Income> findByPerson(Person person);

}
