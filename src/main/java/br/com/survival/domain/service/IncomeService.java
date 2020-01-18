package br.com.survival.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.survival.domain.exception.IncomeNotFoundException;
import br.com.survival.domain.model.Income;
import br.com.survival.domain.repository.IncomeRepository;

@Service
public class IncomeService {
	
	@Autowired
	private IncomeRepository incomeRepository;
	
	@Transactional(readOnly = true)
	public List<Income> findAll() {
		return incomeRepository.findAll();
	}
	
	@Transactional(readOnly = true)
	public Income findById(String code) {
		return incomeRepository.findByCode(code)
				.orElseThrow(() -> new IncomeNotFoundException(code));
	}

}
