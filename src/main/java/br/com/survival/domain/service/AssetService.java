package br.com.survival.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.survival.domain.model.Asset;
import br.com.survival.domain.model.Person;
import br.com.survival.domain.repository.AssetRepository;

@Service
public class AssetService {
	
	@Autowired
	private AssetRepository assetRepository;
	
	@Transactional(readOnly = true)
	public List<Asset> findByPerson(Person person) {
		return assetRepository.findByPerson(person);
	}

}
