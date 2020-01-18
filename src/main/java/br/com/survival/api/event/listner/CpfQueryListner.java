package br.com.survival.api.event.listner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import br.com.survival.api.event.CpfQueryEvent;
import br.com.survival.domain.model.Person;
import br.com.survival.domain.model.SearchHistory;
import br.com.survival.domain.service.SearchHistoryService;

@Component
public class CpfQueryListner implements ApplicationListener<CpfQueryEvent> {
	
	@Autowired
	private SearchHistoryService searchHistoryService;

	@Override
	public void onApplicationEvent(CpfQueryEvent event) {
		var searchHistory = generateSeachHistory(event.getPerson());
		
		searchHistoryService.save(searchHistory);
	}
	
	private SearchHistory generateSeachHistory(Person person) {
		var searcheHistory = new SearchHistory();
		searcheHistory.setPerson(person);
		searcheHistory.setUserName("admin@survival.com.br"); // TODO: Buscar usuário logado que realizou a ação
		return searcheHistory;
	}

}
