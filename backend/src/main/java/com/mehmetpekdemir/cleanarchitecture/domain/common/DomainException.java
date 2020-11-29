package com.mehmetpekdemir.cleanarchitecture.domain.common;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
public class DomainException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DomainException() {
		super();
	}

	public DomainException(String message) {
		super(message);
	}

	public DomainException(Throwable cause) {
		super(cause);
	}

	public DomainException(String message, Throwable cause) {
		super(message, cause);
	}

	public DomainException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
