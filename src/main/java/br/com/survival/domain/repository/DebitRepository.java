package br.com.survival.domain.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.survival.domain.model.Debit;

@Repository
public interface DebitRepository extends JpaRepository<Debit, UUID> {

	Optional<Debit> findByCode(UUID code);
	
}
