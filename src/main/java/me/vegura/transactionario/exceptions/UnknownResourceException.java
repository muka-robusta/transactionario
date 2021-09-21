package me.vegura.transactionario.exceptions;

public class UnknownResourceException extends RuntimeException {
	
	public UnknownResourceException() {
		super();
	}
	
	public UnknownResourceException(String message) {
		super(message);
	}
	
	public UnknownResourceException(String message, Throwable throwable) {
		super(message, throwable);
	}
}
