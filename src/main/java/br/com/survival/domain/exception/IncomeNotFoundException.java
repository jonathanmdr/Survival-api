package br.com.survival.domain.exception;

public class IncomeNotFoundException extends EntityNotFoundException {
	
	private static final long serialVersionUID = 1L;
	
	public IncomeNotFoundException(String message) {
		super(message);
	}
	
	public IncomeNotFoundException(Long incomeCode) {
		this(String.format("Renda de código: %d não existe!", incomeCode));
	}

}
