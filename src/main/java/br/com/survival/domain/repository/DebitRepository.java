package br.com.survival.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.survival.domain.model.Debit;

@Repository
public interface DebitRepository extends JpaRepository<Debit, String> {

	Optional<Debit> findByCode(String code);
	
}
