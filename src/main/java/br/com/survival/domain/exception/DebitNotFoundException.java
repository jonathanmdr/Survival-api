package br.com.survival.domain.exception;

public class DebitNotFoundException extends EntityNotFoundException {
	
	private static final long serialVersionUID = 1L;
	
	public DebitNotFoundException(String message) {
		super(message);
	}
	
	public DebitNotFoundException(Long debitCode) {
		this(String.format("Debito de código: %d não existe!", debitCode));
	}

}
