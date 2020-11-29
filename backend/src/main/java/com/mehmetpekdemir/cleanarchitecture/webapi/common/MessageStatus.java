package com.mehmetpekdemir.cleanarchitecture.webapi.common;

import lombok.Getter;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Getter
public class MessageStatus extends BaseStatus {

	private String message;

	public MessageStatus(boolean success, String message) {
		super(success);
		this.message = message;
	}

	public static MessageStatus withSuccess(String message) {
		return new MessageStatus(true, message);
	}

	public static MessageStatus withFailure(String message) {
		return new MessageStatus(false, message);
	}

}
