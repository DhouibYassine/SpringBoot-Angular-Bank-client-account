package tn.iit.bank.exception;

public class ClienttNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ClienttNotFoundException(String message) {
		super(String.valueOf(message));
	}

}
