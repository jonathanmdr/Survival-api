package br.com.survival.domain.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import br.com.survival.domain.model.Debit;

@Repository
public interface DebitRepository extends CustomJpaRepository<Debit, Long> {

	Optional<Debit> findByCode(String code);
	
}
