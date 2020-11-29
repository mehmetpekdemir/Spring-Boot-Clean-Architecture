package com.mehmetpekdemir.cleanarchitecture.webapi.common;

import org.springframework.http.ResponseEntity;

import lombok.Getter;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Getter
public abstract class BasePresenter {

	protected ResponseEntity<?> viewModel;

}
