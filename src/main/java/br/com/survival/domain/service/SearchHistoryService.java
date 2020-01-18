package br.com.survival.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.survival.domain.exception.SearchHistoryNotFoundException;
import br.com.survival.domain.model.SearchHistory;
import br.com.survival.domain.repository.SearchHistoryRepository;

@Service
public class SearchHistoryService {
	
	@Autowired
	private SearchHistoryRepository searchHistoryRepository;
	
	@Transactional(readOnly = true)
	public List<SearchHistory> findAll() {
		return searchHistoryRepository.findAll();
	}
	
	@Transactional(readOnly = true)
	public SearchHistory findByCode(String code) {
		return searchHistoryRepository.findByCode(code)
				.orElseThrow(() -> new SearchHistoryNotFoundException(code));
	}
	
	@Transactional
	public SearchHistory save(SearchHistory searchHistory) {
		return searchHistoryRepository.save(searchHistory);
	}

}
