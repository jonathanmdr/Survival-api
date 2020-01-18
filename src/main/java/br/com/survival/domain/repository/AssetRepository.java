package br.com.survival.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.survival.domain.model.Asset;
import br.com.survival.domain.model.Person;

@Repository
public interface AssetRepository extends JpaRepository<Asset, String> {
	
	Optional<Asset> findByCode(String code);
	
	List<Asset> findByPerson(Person person);

}
