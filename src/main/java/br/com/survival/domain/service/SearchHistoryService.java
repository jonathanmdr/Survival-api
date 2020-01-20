package br.com.survival.domain.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.survival.api.dto.CreditCardPurchaseDTO;
import br.com.survival.api.dto.EstablishmentDTO;
import br.com.survival.api.dto.EventsDTO;
import br.com.survival.api.dto.FinancialMovementDTO;
import br.com.survival.api.dto.LastSearchDTO;
import br.com.survival.domain.model.SearchHistory;
import br.com.survival.domain.repository.SearchHistoryRepository;
import br.com.survival.domain.service.mock.MockData;

@Service
public class SearchHistoryService {
	
	@Autowired
	private SearchHistoryRepository searchHistoryRepository;
	
	@Transactional
	public SearchHistory save(SearchHistory searchHistory) {
		return searchHistoryRepository.save(searchHistory);
	}
	
	public EventsDTO getEvents() {
        return EventsDTO.builder()
        		.lastSearch(getLastSearch())
        		.financialMovement(getFinancialMovement())
        		.credictCardPurchase(getLastCredictCardPurchase())
        		.build();       
    }

    private List<FinancialMovementDTO> getFinancialMovement() {
        List<FinancialMovementDTO> list = new ArrayList<>();
        
        for (int i = 0; i < 3; i++) {
            FinancialMovementDTO dto = FinancialMovementDTO.builder()
            		.code(MockData.getRandomCode())
            		.dateTime(MockData.getRandomDateTime())
            		.description("Envio de TED em conta corrente de mesma titularidade")
            		.value(MockData.getRandomBigDecimal())
            		.build();
            list.add(dto);
        }
        
        return list;
    }

    private List<CreditCardPurchaseDTO> getLastCredictCardPurchase() {
        List<CreditCardPurchaseDTO> list = new ArrayList<>();
        
    	CreditCardPurchaseDTO dto = CreditCardPurchaseDTO.builder()        			
	            .code(MockData.getRandomCode())
	            .dateTime(MockData.getRandomDateTime())
	            .value(MockData.getRandomBigDecimal())
	            .establishment(getEstablishment())
	            .build();            
        list.add(dto);
        
        return list;
    }

    private EstablishmentDTO getEstablishment() {
        return EstablishmentDTO.builder()
        		.code(MockData.getRandomCode())
        		.city("São Paulo")
        		.name("SBP Credit Financial SA")
        		.build();
    }

    private LastSearchDTO getLastSearch() {
        return LastSearchDTO.builder()
        		.code(MockData.getRandomCode())
        		.establishment(getEstablishment())
        		.consultationDate(MockData.getRandomDateTime())
        		.build();
    }

}
