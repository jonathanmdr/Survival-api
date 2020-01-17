package br.com.survival.domain.exception;

public class PersonNotFoundException extends EntityNotFoundException {
	
	private static final long serialVersionUID = 1L;
	
	public PersonNotFoundException(String message) {
		super(message);
	}
	
	public PersonNotFoundException(Long personId) {
		this(String.format("Pessoa de ID: %d não existe!", personId));
	}

}
