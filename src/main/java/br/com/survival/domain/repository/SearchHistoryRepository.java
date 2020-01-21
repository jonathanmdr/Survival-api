package br.com.survival.domain.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.survival.domain.model.SearchHistory;

@Repository
public interface SearchHistoryRepository extends JpaRepository<SearchHistory, UUID> {
	
	Optional<SearchHistory> findByCode(UUID code);

}
