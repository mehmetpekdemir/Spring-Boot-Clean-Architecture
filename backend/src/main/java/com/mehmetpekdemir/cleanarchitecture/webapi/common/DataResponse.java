package com.mehmetpekdemir.cleanarchitecture.webapi.common;

import lombok.Getter;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Getter
public class DataResponse<T> extends BaseResponse {

	private final T data;

	public DataResponse(BaseStatus status, T data) {
		super(status);
		this.data = data;
	}

}
