package br.com.survival.domain.exception;

import java.util.UUID;

public class DebitNotFoundException extends EntityNotFoundException {
	
	private static final long serialVersionUID = 1L;
	
	public DebitNotFoundException(String message) {
		super(message);
	}
	
	public DebitNotFoundException(UUID debitCode) {
		this(String.format("Debito de código: %d não existe!", debitCode));
	}

}
