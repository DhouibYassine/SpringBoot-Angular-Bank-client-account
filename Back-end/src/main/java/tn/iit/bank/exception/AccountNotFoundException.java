package tn.iit.bank.exception;

public class AccountNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public AccountNotFoundException(Long rib) {
		super(Long.toString(rib));
	}
}
