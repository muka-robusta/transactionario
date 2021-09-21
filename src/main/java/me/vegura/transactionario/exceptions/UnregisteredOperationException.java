package me.vegura.transactionario.exceptions;

public class UnregisteredOperationException extends RuntimeException {

	public UnregisteredOperationException() {
		super();
	}
	
	public UnregisteredOperationException(String message) {
		super(message);
	}
	public UnregisteredOperationException(String message, Throwable throwable) {
		super(message, throwable);
	}
	
}
