package br.com.survival.domain.exception;

public class AssetNotFoundException extends EntityNotFoundException {
	
	private static final long serialVersionUID = 1L;
	
	public AssetNotFoundException(String message) {
		super(message);
	}
	
	public AssetNotFoundException(Long assetCode) {
		this(String.format("Ativo de código: %d não existe!", assetCode));
	}

}
