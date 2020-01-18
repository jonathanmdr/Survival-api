package br.com.survival.domain.exception;

public class SearchHistoryNotFoundException extends EntityNotFoundException {
	
	private static final long serialVersionUID = 1L;
	
	public SearchHistoryNotFoundException(String message) {
		super(message);
	}
	
	public SearchHistoryNotFoundException(Long searchHistoryCode) {
		this(String.format("Histórico de busca de código: %d não existe!", searchHistoryCode));
	}

}
