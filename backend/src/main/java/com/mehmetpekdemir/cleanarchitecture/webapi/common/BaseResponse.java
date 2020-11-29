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
public class BaseResponse {
	
	private final BaseStatus status;
	
}
