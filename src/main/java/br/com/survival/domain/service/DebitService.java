package br.com.survival.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.survival.domain.exception.DebitNotFoundException;
import br.com.survival.domain.model.Debit;
import br.com.survival.domain.repository.DebitRepository;

@Service
public class DebitService {
	
	@Autowired
	private DebitRepository debitRepository;
	
	@Transactional(readOnly = true)
	public Page<Debit> findAll(Pageable pageable) {
		return debitRepository.findAll(pageable);
	}
	
	@Transactional(readOnly = true)
	public Debit findByCode(String code) {
		return debitRepository.findByCode(code)
				.orElseThrow(() -> new DebitNotFoundException(code));
	}
	
	@Transactional
	public Debit save(Debit debit) {
		return debitRepository.save(debit);
	}

}
