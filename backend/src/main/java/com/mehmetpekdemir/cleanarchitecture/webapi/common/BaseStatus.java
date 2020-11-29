package com.mehmetpekdemir.cleanarchitecture.webapi.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Getter
@RequiredArgsConstructor
public class BaseStatus {

	private final boolean success;

	public static BaseStatus successful() {
		return new BaseStatus(true);
	}

	public static BaseStatus failure() {
		return new BaseStatus(false);
	}

}
