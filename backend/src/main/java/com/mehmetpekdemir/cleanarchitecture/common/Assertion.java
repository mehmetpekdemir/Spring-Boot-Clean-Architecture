package com.mehmetpekdemir.cleanarchitecture.common;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
public final class Assertion {

	private Assertion() {
		throw new IllegalArgumentException("Utility Class");
	}

	public static void assertNotNull(Object object, RuntimeException runtimeException) {
		if (object == null) {
			throw runtimeException;
		}
	}

}
