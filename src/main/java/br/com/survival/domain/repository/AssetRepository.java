package br.com.survival.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.survival.domain.model.Asset;

@Repository
public interface AssetRepository extends JpaRepository<Asset, String> {
	
	Optional<Asset> findByCode(String code);

}
