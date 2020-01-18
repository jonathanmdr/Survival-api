package br.com.survival.domain.exception;

public class PersonNotFoundException extends EntityNotFoundException {
	
	private static final long serialVersionUID = 1L;
	
	public PersonNotFoundException(String message) {
		super(message);
	}

}
