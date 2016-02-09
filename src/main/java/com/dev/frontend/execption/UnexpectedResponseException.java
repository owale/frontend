package com.dev.frontend.execption;


public class UnexpectedResponseException extends Exception {

	private static final long serialVersionUID = 1L;

	public UnexpectedResponseException(Throwable cause) {
		super(cause);
	}


	public UnexpectedResponseException(String message, Throwable cause) {
		super(message, cause);
	}

	public UnexpectedResponseException(String message) {
		super(message);
	}

	public UnexpectedResponseException() {
		super();
	}
}